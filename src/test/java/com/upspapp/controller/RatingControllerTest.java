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
import com.upspapp.requestDto.RatingDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = UPSPApplication.class)
public class RatingControllerTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private final String URL = "http://localhost:";

	@Test
	public void addRating() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		RatingDto ratingDto = new RatingDto();
		ratingDto.setBuyerId(2L);
		ratingDto.setProductId(1L);
		ratingDto.setRating(5);
		String url = URL + port + "/api/add/rating";
		HttpEntity<RatingDto> request = new HttpEntity<>(ratingDto, headers);

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getAllRating() throws Exception {
		String url = URL + port + "/api/getAll/rating";
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
}
