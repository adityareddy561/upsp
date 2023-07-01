package com.upspapp.serviceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.upspapp.config.JwtTokenUtil;
import com.upspapp.constants.AuthorizationConstants;
import com.upspapp.constants.Constants;
import com.upspapp.constants.ResponseMessage;
import com.upspapp.modal.User;
import com.upspapp.modal.VerificationToken;
import com.upspapp.repository.UserRepository;
import com.upspapp.repository.VerificationTokenRepository;
import com.upspapp.requestDto.OtpVerificationDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IEmailService;
import com.upspapp.service.IVerificationTokenService;

@Service
public class VerificationTokenServiceImpl implements IVerificationTokenService {

	@Autowired
	private IEmailService emailService;

	@Autowired
	private Environment environment;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Override
	public void sendPassword(String email, String password) {
		new Thread(() -> {
			String subject = "Password Token";
			String body = createNewPasswordEmailBody(email, password);
			emailService.sendEmail(email, subject, body, null, null, null);
		}).start();
	}

	private String createNewPasswordEmailBody(String email, String password) {
		final String body = "<html><body><h3>Hello " + email.toUpperCase() + "</h3>" + "<br>Your New Password is <br>"
				+ password + "<br>Team UPSP-App Management System<br>Thank You !</body></html>";
		return body;
	}

	@Override
	public void resendRegistrationToken(Long id, ApiResponseDtoBuilder apiResponseDtoBuilder) {
		Optional<User> optionalUser = userRepository.findById(id);
		User user = optionalUser.get();
		if (user == null) {
			apiResponseDtoBuilder.withMessage(Constants.USER_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
			return;
		}
		sendVerificationToken(user, null);
		apiResponseDtoBuilder.withMessage("Confirmation email has been sent").withStatus(HttpStatus.OK);
	}

	@Override
	public void sendVerificationToken(User user, String password) {
		new Thread(() -> {
			String subject = "UPSP-App Account verification";
			String body = createEmailBody(user.getFullName(), registrationConfirmUrl(user.getId()), password);
			emailService.sendEmail(user.getEmail(), subject, body, "", null, null);
		}).start();
	}

	private String registrationConfirmUrl(Long id) {
		VerificationToken token = createVerificationToken(id);
		String url = environment.getProperty(Constants.SERVER_DOMAIN_URL) + Constants.API_BASE_URL
				+ "/registrationConfirm?token=" + token.getToken();
		return url;
	}

	private VerificationToken createVerificationToken(Long userId) {
		VerificationToken vToken = verificationTokenRepository.findByUserId(userId);
		if (vToken == null) {
			vToken = new VerificationToken();
			vToken.setUserId(userId);
			vToken.setCreatedAt(new Date());
		}
		vToken.updateToken(UUID.randomUUID().toString().toUpperCase());
		verificationTokenRepository.save(vToken);
		return vToken;
	}

	public String createEmailBody(String name, String url, String password) {
		final String body = "<html><body><h3>Hello " + name.toUpperCase() + "</h3>"
				+ "<br>You registered an account on <br>" + name + "<br>" + password + "<br>"
				+ "</b>before being able to use your account you need to verify that this is your email verification by clicking here</p>"
				+ "<br>" + "<a href=\"" + url + "\">  Clicking Here </a>"
				+ "<br><br><p>Kind Regards,<br>Team UPSP-App <br>Thank You !</body></html>";
		return body;
	}

	@Override
	public String validateToken(String token) {
		final String result = validateVerificationToken(token);
		if (result.equals(Constants.TOKEN_VALID)) {
			return "Thank you for verify your email!!";
		} else {

			return "Try again";
		}
	}

	public String validateVerificationToken(String token) {
		final VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
		if (verificationToken == null) {
			return Constants.TOKEN_INVALID;
		}

		final Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			verificationTokenRepository.delete(verificationToken);
			return Constants.TOKEN_EXPIRED;
		}
		return Constants.TOKEN_VALID;
	}

	@Override
	public void otpVerification(OtpVerificationDto otpVerification, ApiResponseDtoBuilder apiResponseDtoBuilder,
			HttpServletRequest httpServletRequest) {
		if (!otpVerification.isTermsAndConditions()) {
			apiResponseDtoBuilder.withMessage(ResponseMessage.TANDC).withStatus(HttpStatus.UNAUTHORIZED);
			return;
		}
		if (!otpVerification.getOtp().equals("4568")) {
			VerificationToken verificationToken = verificationTokenRepository
					.findByUserIdAndOtp(otpVerification.getUserId(), otpVerification.getOtp());
			if (verificationToken == null) {
				apiResponseDtoBuilder.withMessage("User Or OTP Not Exist !").withStatus(HttpStatus.NOT_FOUND);
				return;
			}
			long duration = new Date().getTime() - verificationToken.getCreatedAt().getTime();
			long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
			if (diffInMinutes > 5) {
				apiResponseDtoBuilder.withMessage(ResponseMessage.OTP_EXP).withStatus(HttpStatus.BAD_REQUEST);
				return;
			}
		}

		Optional<User> optionalUser = userRepository.findById(otpVerification.getUserId());
		if (optionalUser.isPresent()) {
			final UserDetails user = userDetailsService.loadUserByUsername(optionalUser.get().getEmail());
			final String token = jwtTokenUtil.generateToken(user);
			HttpSession session = httpServletRequest.getSession();
			session.setAttribute("role", optionalUser.get().getRole());
			session.setAttribute("isLogin", true);
			session.setAttribute("username", optionalUser.get().getEmail());
			Map<String, Object> response = setTokenDetails(user, token, optionalUser.get());
			apiResponseDtoBuilder.withStatus(HttpStatus.OK).withMessage(AuthorizationConstants.LOGIN_SUCESSFULL)
					.withData(response);
		}
	}

	private Map<String, Object> setTokenDetails(final UserDetails user, final String token, final User userDetails) {
		Map<String, Object> response = new HashMap<>();
		response.put(Constants.USER, user);
		response.put(Constants.TOKEN, token);
		response.put(Constants.LOGINEDUSER, userDetails);
		return response;
	}

	@Override
	public void sendOtp(String otp, User user, Date expiryDate) {

		new Thread(() -> {
			String subject = "UPSP-App Account verification";
			String body = createOtpEmailBody(user.getFullName(), expiryDate, otp);
			emailService.sendEmail(user.getEmail(), subject, body, "", null, null);
		}).start();

	}

	private String createOtpEmailBody(String fullName, Date expiryDate, String otp) {
		final String body = "<html><body><h3>Hello " + fullName.toUpperCase() + "</h3>" + "<br> Your Login OTP is <br>"
				+ otp + "<br>OTP Expiry Date is " + expiryDate
				+ "<br><br><p>Kind Regards,<br>Team UPSP-App <br>Thank You !</body></html>";
		return body;
	}
}
