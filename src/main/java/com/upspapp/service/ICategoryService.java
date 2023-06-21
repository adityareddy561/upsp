package com.upspapp.service;

import org.springframework.stereotype.Service;

import com.upspapp.modal.Category;
import com.upspapp.requestDto.CategoryDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
@Service
public interface ICategoryService {

	void addCategory(ApiResponseDtoBuilder builder, CategoryDto dto);

	void getCategoryById(ApiResponseDtoBuilder builder, long id);

	void updateCategoryById(ApiResponseDtoBuilder builder, Category category);

	void deleteCategoryById(ApiResponseDtoBuilder builder, long id);

	void getAllCategory(ApiResponseDtoBuilder builder);
	void getAllCategoryByLikeQuery(ApiResponseDtoBuilder builder,String query);


}
