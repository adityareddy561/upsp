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
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.upspapp.UPSPApplication;
import com.upspapp.modal.Advertisement;
import com.upspapp.requestDto.AdvertisementDto;
import com.upspapp.requestDto.PostLikeDto;
import com.upspapp.requestDto.PostSaveDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = UPSPApplication.class)
public class AdvertisementControllerTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private final String URL = "http://localhost:";
	
	@Test
	public void addProduct() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		AdvertisementDto advertisementDto = new AdvertisementDto();
		advertisementDto.setDescription("test");
		//advertisementDto.setOwner("Test");
		advertisementDto.setPrice(10L);
		advertisementDto.setProductName("Case");
		String url = URL + port + "/api/add/product";
		HttpEntity<AdvertisementDto> request = new HttpEntity<>(advertisementDto, headers);

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void updateProduct() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Advertisement advertisement = new Advertisement();
		advertisement.setDescription("test");
		advertisement.setOwner("Test");
		advertisement.setPrice(10L);
		advertisement.setProductName("Case");
		advertisement.setId(1L);
		String url = URL + port + "/api/update/product";
		HttpEntity<Advertisement> request = new HttpEntity<>(advertisement, headers);
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getProduct() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = URL + port + "/api/get/product/" + 1;
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void deleteProduct() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = URL + port + "/api/delete/product/" + 1;
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(url).encode().toUriString();
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.exchange(urlTemplate, HttpMethod.DELETE,
				null, ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getAllProduct() throws Exception {
		String url = URL + port + "/api/getAll/product";

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void addLike() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		PostLikeDto dto = new PostLikeDto();
		dto.setBuyerId(1L);
		dto.setProductId(1L);
		String url = URL + port + "/api/add/like";
		HttpEntity<PostLikeDto> request = new HttpEntity<>(dto, headers);

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void deleteLike() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		PostLikeDto dto = new PostLikeDto();
		dto.setBuyerId(1L);
		dto.setProductId(1L);
		String url = URL + port + "/api/delete/like";
		HttpEntity<PostLikeDto> request = new HttpEntity<>(dto, headers);

		String urlTemplate = UriComponentsBuilder.fromHttpUrl(url).encode().toUriString();
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.exchange(urlTemplate, HttpMethod.DELETE,
				request, ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void savePost() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		PostSaveDto dto = new PostSaveDto();
		dto.setBuyerId(1L);
		dto.setProductId(1L);
		String url = URL + port + "/api/save/product";
		HttpEntity<PostSaveDto> request = new HttpEntity<>(dto, headers);
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void unsaveProduct() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		PostSaveDto dto = new PostSaveDto();
		dto.setBuyerId(1L);
		dto.setProductId(1L);
		String url = URL + port + "/api/unsave/product";
		HttpEntity<PostSaveDto> request = new HttpEntity<>(dto, headers);
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(url).encode().toUriString();
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.exchange(urlTemplate, HttpMethod.DELETE,
				request, ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void getAllProductbyOrder() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		int byOrder=1;
		String url = URL + port + "/api/search/Product/"+byOrder;
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
}
