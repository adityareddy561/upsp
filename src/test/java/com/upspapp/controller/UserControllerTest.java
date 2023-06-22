package com.upspapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.upspapp.UPSPApplication;
import com.upspapp.modal.Buyer;
import com.upspapp.modal.Seller;
import com.upspapp.requestDto.ChangePasswordDto;
import com.upspapp.requestDto.UserDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = UPSPApplication.class)

public class UserControllerTest {
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	private final String URL = "http://localhost:";
	
	@Test
	public void addAdmin() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		UserDto userRequestDto = new UserDto();
		userRequestDto.setFullName("Test Admin");
		userRequestDto.setEmail("testadmin@gmail.com");
		userRequestDto.setMobileNumber("9999999999");
		userRequestDto.setPassword("123456");
		String url = URL + port + "/api/admin/add";
		HttpEntity<UserDto> request = new HttpEntity<>(userRequestDto, headers);

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void addSeller() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		UserDto userRequestDto = new UserDto();
		userRequestDto.setFullName("Test Seller");
		userRequestDto.setEmail("testseller@gmail.com");
		userRequestDto.setMobileNumber("9999999");
		userRequestDto.setPassword("123456");
		String url = URL + port + "/api/seller/add";
		HttpEntity<UserDto> request = new HttpEntity<>(userRequestDto, headers);

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

	}

	@Test
	public void updateSeller() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Seller seller = new Seller();
		seller.setFullName("Test seller");
		seller.setEmail("testseller@gmail.com");
		seller.setMobileNumber("8888888888");
		seller.setPassword("11111");
		seller.setId(2L);
		seller.setCreatedAt(new Date());
		seller.setUpdatedAt(new Date());
		seller.setRole(1);
		seller.setActive(true);

		String url = URL + port + "/api/seller/update";
		HttpEntity<Seller> request = new HttpEntity<>(seller, headers);
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void deleteSeller() throws Exception {
		String url = URL + port + "/api/seller/delete/" + 2;
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(url).encode().toUriString();
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.exchange(urlTemplate, HttpMethod.DELETE,
				null, ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getSeller() throws Exception {
		String url = URL + port + "/api/seller/get/" + 2;

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getAllSeller() throws Exception {
		String url = URL + port + "/api/seller/getAll";

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

	}

	@Test
	public void addBuyer() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		UserDto userRequestDto = new UserDto();
		userRequestDto.setFullName("Test Buyer");
		userRequestDto.setEmail("testbuyer@gmail.com");
		userRequestDto.setMobileNumber("999911999");
		userRequestDto.setPassword("123456");
		String url = URL + port + "/api/buyer/add";
		HttpEntity<UserDto> request = new HttpEntity<>(userRequestDto, headers);

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

	}

	@Test
	public void updateBuyer() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Buyer buyer = new Buyer();
		buyer.setFullName("Test Buyer");
		buyer.setEmail("testbuyer@gmail.com");
		buyer.setMobileNumber("8888881111");
		buyer.setPassword("11111");
		buyer.setId(2L);
		buyer.setCreatedAt(new Date());
		buyer.setUpdatedAt(new Date());
		buyer.setRole(2);
		buyer.setActive(true);

		String url = URL + port + "/api/buyer/update";
		HttpEntity<Buyer> request = new HttpEntity<>(buyer, headers);
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void deleteBuyer() throws Exception {
		String url = URL + port + "/api/buyer/delete/" + 3;
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(url).encode().toUriString();
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.exchange(urlTemplate, HttpMethod.DELETE,
				null, ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getBuyer() throws Exception {
		String url = URL + port + "/api/buyer/get/" + 2;

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getAllBuyer() throws Exception {
		String url = URL + port + "/api/buyer/getAll";

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void updatePassword() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ChangePasswordDto passwordDto = new ChangePasswordDto();
		passwordDto.setId(1L);
		passwordDto.setNewPassword("111111");
		String url = URL + port + "/api/change/password";
		HttpEntity<ChangePasswordDto> request = new HttpEntity<>(passwordDto, headers);
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void addFriend() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String email = "test123@test.com";
		String url = URL + port + "/api/referFriend/" + 1 + "/" + email;

		HttpEntity<?> entity = new HttpEntity<>(headers);
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(url).encode().toUriString();
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(urlTemplate, entity,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void sharePost() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String email = "test123@test.com";
		String url = URL + port + "/api/referFriend/" + 1 + "/" + email;

		HttpEntity<?> entity = new HttpEntity<>(headers);
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(url).encode().toUriString();
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(urlTemplate, entity,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void forgotPassword() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String email = "test123@test.com";
		String url = URL + port + "/api/user/forgotPassword/" + email;
		HttpEntity<?> entity = new HttpEntity<>(headers);
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(url).encode().toUriString();
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(urlTemplate, entity,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
}
