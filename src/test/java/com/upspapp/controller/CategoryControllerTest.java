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
import com.upspapp.modal.Category;
import com.upspapp.modal.SubCategory;
import com.upspapp.requestDto.CategoryDto;
import com.upspapp.requestDto.SubCategoryDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = UPSPApplication.class)
public class CategoryControllerTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private final String URL = "http://localhost:";

	@Test
	public void addCategory() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryName("Test");
		String url = URL + port + "/api/add/category";
		HttpEntity<CategoryDto> request = new HttpEntity<>(categoryDto, headers);

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getProduct() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = URL + port + "/api/get/category/" + 1L;
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void updateCategory() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Category category = new Category();
		category.setId(1L);
		category.setCreatedAt(new Date());
		category.setCategoryName("Test");
		category.setUpdatedAt(new Date());
		String url = URL + port + "/api/update/category";
		HttpEntity<Category> request = new HttpEntity<>(category, headers);
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void deleteCategory() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = URL + port + "/api/delete/product/" + 1L;
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(url).encode().toUriString();
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.exchange(urlTemplate, HttpMethod.DELETE,
				null, ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getAllCategory() throws Exception {
		String url = URL + port + "/api/getAll/category";
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void addSubCategory() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		SubCategoryDto subCategoryDto = new SubCategoryDto();
		subCategoryDto.setCategoryId(1L);
		subCategoryDto.setSubCategoryName("Test");
		String url = URL + port + "/api/add/subCategory";
		HttpEntity<SubCategoryDto> request = new HttpEntity<>(subCategoryDto, headers);

		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getSubCategory() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = URL + port + "/api/get/subCategory/" + 1L;
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void updateSubCategory() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		SubCategory subCategory = new SubCategory();
		subCategory.setId(1L);
		subCategory.setCreatedAt(new Date());
		subCategory.setSubCategoryName("Test");
		subCategory.setUpdatedAt(new Date());
		subCategory.setCategoryId(1L);
		String url = URL + port + "/api/update/category";
		HttpEntity<SubCategory> request = new HttpEntity<>(subCategory, headers);
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.postForEntity(url, request,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void deleteSubCategory() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = URL + port + "/api/delete/subCategory/" + 1L;
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(url).encode().toUriString();
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.exchange(urlTemplate, HttpMethod.DELETE,
				null, ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getAllSubCategory() throws Exception {
		String url = URL + port + "/api/getAll/subCategory";
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getAllSubCategoryByCategoryId() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = URL + port + "/api/getAllSubCategory/" + 1L;
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void getAllCategoryByLikeQuery() throws Exception {
		String query="test";
		String url = URL + port + "/api/getAll/category/"+query;
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void getAllCategoriesWithSubcategories() throws Exception {
		String url = URL + port + "/api/getAll/categories/subcategories";
		ResponseEntity<ApiResponseDtoBuilder> responseEntity = restTemplate.getForEntity(url,
				ApiResponseDtoBuilder.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
}
