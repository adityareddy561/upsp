package com.upspapp.service;

import org.springframework.stereotype.Service;

import com.upspapp.modal.SubCategory;
import com.upspapp.requestDto.SubCategoryDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@Service
public interface ISubCategoryService {

	void addSubCategory(ApiResponseDtoBuilder builder, SubCategoryDto dto);

	void getSubCategoryById(ApiResponseDtoBuilder builder, long id);

	void updateSubCategoryById(ApiResponseDtoBuilder builder, SubCategory subCategory);

	void deleteSubCategoryById(ApiResponseDtoBuilder builder, long id);

	void getAllSubCategory(ApiResponseDtoBuilder builder);

	void getAllSubCategoryByCategoryId(ApiResponseDtoBuilder builder, long categoryId);

	void getAllCategoriesWithSubcategories(ApiResponseDtoBuilder builder);

}
