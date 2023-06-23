package com.upspapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upspapp.constants.Constants;
import com.upspapp.modal.Advertisement;
import com.upspapp.requestDto.AdvertisementDto;
import com.upspapp.requestDto.PostLikeDto;
import com.upspapp.requestDto.PostSaveDto;
import com.upspapp.responseDto.ApiResponseDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IAdvertisementService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = Constants.API_BASE_URL)
@Api(tags = "AdvertisementController")
public class AdvertisementController {

	@Autowired
	private IAdvertisementService advertisementService;

	@PostMapping(value = "/add/product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto addProduct(@RequestBody AdvertisementDto advertisementDto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		advertisementService.addProduct(builder, advertisementDto);
		return builder.build();
	}
	
	@GetMapping(value = "/get/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getProduct(@PathVariable(name = "id") long id) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		advertisementService.getProductById(id, builder);
		return builder.build();
	}

	@PostMapping(value = "/update/product", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto updateProduct(@RequestBody Advertisement advertisement) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		advertisementService.updateProductById(builder, advertisement);
		return builder.build();
	}
	
	@DeleteMapping("/delete/product/{id}")
	public ApiResponseDto deleteProduct(@PathVariable(name = "id") long id) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		advertisementService.deleteProductById(builder, id);
		return builder.build();
	}

	@GetMapping("/getAll/productByQuery/{query}")
	public ApiResponseDto getAllProducts(@PathVariable String query) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		advertisementService.getAllProducts(builder,query);
		return builder.build();
	}
	
	@GetMapping("/getAll/product")
	public ApiResponseDto getAllProduct() {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		advertisementService.getAllProduct(builder);
		return builder.build();
	}
	
	@GetMapping("/getAll/product/{sellerId}")
	public ApiResponseDto getAllProduct(@PathVariable(name = "sellerId") long sellerId) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		advertisementService.getAllProductBySellerId(builder,sellerId);
		return builder.build();
	}

	@PostMapping(value = "/add/like", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto addLike(@RequestBody PostLikeDto dto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		advertisementService.addLike(dto, builder);
		return builder.build();
	}

	@DeleteMapping(value = "/delete/like", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto disLike(@RequestBody PostLikeDto dto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		advertisementService.deleteLike(dto, builder);
		return builder.build();
	}

	@PostMapping(value = "/save/product", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto savePost(@RequestBody PostSaveDto dto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		advertisementService.savePost(dto, builder);
		return builder.build();
	}

	@DeleteMapping(value = "/unsave/product", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto unsavePost(@RequestBody PostSaveDto dto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		advertisementService.unsaveProduct(dto, builder);
		return builder.build();
	}

	@GetMapping(value = "/search/Product/{byOrder}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getAllProductbyOrder(@PathVariable(name = "byOrder") int byOrder) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		advertisementService.getAllProductbyOrder(byOrder, builder);
		return builder.build();
	}
}
