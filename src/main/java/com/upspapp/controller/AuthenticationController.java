package com.upspapp.controller;

import java.util.Date;
import java.util.Random;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upspapp.constants.AuthorizationConstants;
import com.upspapp.constants.Constants;
import com.upspapp.modal.User;
import com.upspapp.modal.VerificationToken;
import com.upspapp.repository.UserRepository;
import com.upspapp.repository.VerificationTokenRepository;
import com.upspapp.requestDto.LoginUser;
import com.upspapp.responseDto.ApiResponseDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IVerificationTokenService;

/**
 * @author altaf
 *
 */
@CrossOrigin(origins = "*", maxAge = 360000000)
@RestController
@RequestMapping(Constants.API_BASE_URL + "/auth")
public class AuthenticationController {

	private static final int OTP_LENGTH = 6;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Autowired
	private IVerificationTokenService verificationTokenService;

	/**
	 * User Login
	 * 
	 * @param loginUser
	 * @return
	 * @throws AuthenticationException
	 */
	@PostMapping(value = "/login")
	public ApiResponseDto userlogin(@RequestBody LoginUser loginUser) throws AuthenticationException {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		User checkUser = userRepository.findByEmail(loginUser.getUsername());
		if (checkUser == null) {
			apiResponseDtoBuilder.withStatus(HttpStatus.UNAUTHORIZED).withMessage(Constants.NO_EMAIL_EXISTS);
			return apiResponseDtoBuilder.build();
		}

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));

		apiResponseDtoBuilder.withStatus(HttpStatus.OK).withMessage(AuthorizationConstants.LOGIN_SUCESSFULL)
				.withData(checkUser.getId());

		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setCreatedAt(new Date());
		verificationToken.setOtp(generateOTP());
		verificationToken.setUserId(checkUser.getId());
		verificationToken.setExpiryDate(new Date(new Date().getTime()));
		verificationTokenRepository.save(verificationToken);

		verificationTokenService.sendOtp(verificationToken.getOtp(), checkUser, verificationToken.getExpiryDate());
		return apiResponseDtoBuilder.build();
	}

	private String generateOTP() {
		Random random = new Random();
		StringBuilder otp = new StringBuilder();

		for (int i = 0; i < OTP_LENGTH; i++) {
			otp.append(random.nextInt(10));
		}

		return otp.toString();
	}
}
