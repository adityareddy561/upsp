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
import com.upspapp.requestDto.ReportDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = UPSPApplication.class)
public class ReportControllerTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private final String URL = "http://localhost:";

	@Test
	public void addReport() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ReportDto reportDto = new ReportDto();
		reportDto.setBuyerId(2L);
		reportDto.setProductId(1L);
		reportDto.setQuery("Test");
		String url = URL + port + "/api/add/report";
		HttpEntity<ReportDto> request = new HttpEntity<>(reportDto, headers);

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getAllReport() throws Exception {
		String url = URL + port + "/api/getAll/report";
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
}
