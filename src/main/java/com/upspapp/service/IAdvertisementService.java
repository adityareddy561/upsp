package com.upspapp.service;

import org.springframework.stereotype.Service;

import com.upspapp.modal.Advertisement;
import com.upspapp.requestDto.AdvertisementDto;
import com.upspapp.requestDto.PostLikeDto;
import com.upspapp.requestDto.PostSaveDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@Service
public interface IAdvertisementService {

	void addProduct(ApiResponseDtoBuilder builder, AdvertisementDto advertisementDto);

	void getProductById(long id, ApiResponseDtoBuilder builder);

	void updateProductById(ApiResponseDtoBuilder builder, Advertisement advertisement);

	void deleteProductById(ApiResponseDtoBuilder builder, long id);

	void getAllProduct(ApiResponseDtoBuilder builder);

	void getAllProducts(ApiResponseDtoBuilder builder, String query);

	void likeAndDislike(PostLikeDto dto, ApiResponseDtoBuilder builder);

	void saveAndUnSavePost(PostSaveDto dto, ApiResponseDtoBuilder builder);

	void getAllProductbyOrder(int byOrder, ApiResponseDtoBuilder builder);

	void getAllProductBySellerId(ApiResponseDtoBuilder builder, long sellerId);

	void getAllProductbyLocation(String location, ApiResponseDtoBuilder builder);

	void getAllProductsWithLikeAndSaveStatus(ApiResponseDtoBuilder builder);

}
