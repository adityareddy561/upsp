package com.upspapp.service;

import java.util.Date;

import com.upspapp.modal.User;
import com.upspapp.requestDto.OtpVerificationDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

public interface IVerificationTokenService {

	void sendPassword(String email, String password);

	void resendRegistrationToken(Long id, ApiResponseDtoBuilder apiResponseDtoBuilder);

	void sendVerificationToken(User user, String password);
	
	String validateToken(String token);

	void otpVerification(OtpVerificationDto loginUser, ApiResponseDtoBuilder apiResponseDtoBuilder);

	void sendOtp(String otp, User user, Date expiryDate);

}
