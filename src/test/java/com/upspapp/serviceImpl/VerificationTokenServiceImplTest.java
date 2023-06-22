package com.upspapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.upspapp.config.JwtTokenUtil;
import com.upspapp.repository.UserRepository;
import com.upspapp.repository.VerificationTokenRepository;
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
		verificationTokenServiceImpl.resendRegistrationToken(id, apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("Confirmation email has been sent"));
	}
}
