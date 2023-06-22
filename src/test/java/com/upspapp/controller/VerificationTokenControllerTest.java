package com.upspapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.upspapp.UPSPApplication;
import com.upspapp.requestDto.OtpVerificationDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = UPSPApplication.class)
public class VerificationTokenControllerTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private final String URL = "http://localhost:";

	@Test
	public void login() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		OtpVerificationDto otpVerificationDto=new OtpVerificationDto();
		otpVerificationDto.setOtp("12121");
		otpVerificationDto.setTermsAndConditions(true);
		otpVerificationDto.setUserId(1L);
		String url = URL + port + "/api/otpVerification";
		HttpEntity<OtpVerificationDto> request = new HttpEntity<>(otpVerificationDto, headers);
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
}
