package com.upspapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upspapp.constants.Constants;
import com.upspapp.requestDto.OtpVerificationDto;
import com.upspapp.responseDto.ApiResponseDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IVerificationTokenService;

@CrossOrigin(origins = "*", maxAge = 36000000)
@RestController
@RequestMapping(Constants.API_BASE_URL)
public class VerificationTokenController {

	@Autowired
	private IVerificationTokenService verificationTokenService;

	@GetMapping("/registrationConfirm")
	public String confirmRegistration(@RequestParam("token") final String token) throws IOException {
		return verificationTokenService.validateToken(token);

	}

	@PostMapping("/otpVerification")
	public ApiResponseDto login(@RequestBody OtpVerificationDto loginUser, HttpServletRequest httpServletRequest) {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		verificationTokenService.otpVerification(loginUser, apiResponseDtoBuilder, httpServletRequest);
		return apiResponseDtoBuilder.build();
	}

	@GetMapping(value = "/resendRegistrationToken", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto resendRegistrationToken(final HttpServletRequest request, @RequestParam Long id) {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		verificationTokenService.resendRegistrationToken(id, apiResponseDtoBuilder);
		return apiResponseDtoBuilder.build();
	}
}
