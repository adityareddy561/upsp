package com.upspapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.upspapp.config.JwtTokenUtil;
import com.upspapp.modal.User;
import com.upspapp.repository.UserRepository;
import com.upspapp.repository.VerificationTokenRepository;
import com.upspapp.requestDto.OtpVerificationDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IEmailService;

@ExtendWith(MockitoExtension.class)
public class VerificationTokenServiceImplTest {
	
	@InjectMocks
	private VerificationTokenServiceImpl verificationTokenServiceImpl;

	@Mock
	private IEmailService emailService;

	@Mock
	private Environment environment;


	@Mock
	private JwtTokenUtil jwtTokenUtil;

	@Mock
	private UserDetailsService userDetailsService;

	@Mock
	private UserRepository userRepository;

	@Mock
	private VerificationTokenRepository verificationTokenRepository;
	
	
	@Test
	public void resendRegistrationToken() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		long id =1L;
		User user=new User();
		user.setId(1L);
		user.setRole(0);
		user.setActive(true);
		user.setEmail("testadmin@gmail.com");
		user.setFullName("Test Admin");
		user.setMobileNumber("11111111");
		user.setPassword("12345");
		user.setCreatedAt(new Date());
		Optional<User> optionalUser =Optional.of(user);
		when(userRepository.findById(id)).thenReturn(optionalUser);
		verificationTokenServiceImpl.resendRegistrationToken(id, apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("Confirmation email has been sent"));
	}
	
	
	@Test
	public void otpVerification() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		OtpVerificationDto otpVerificationDto=new OtpVerificationDto();
		otpVerificationDto.setOtp("Test");
		otpVerificationDto.setTermsAndConditions(true);
		otpVerificationDto.setUserId(1l);
		verificationTokenServiceImpl.otpVerification(otpVerificationDto, apiResponseDtoBuilder, null);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("User Or OTP Not Exist !"));
	}
}
