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
import com.upspapp.modal.Category;
import com.upspapp.modal.SubCategory;
import com.upspapp.modal.User;
import com.upspapp.repository.UserRepository;
import com.upspapp.requestDto.CategoryDto;
import com.upspapp.requestDto.SubCategoryDto;
import com.upspapp.responseDto.ApiResponseDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.ICategoryService;
import com.upspapp.service.ISubCategoryService;
import com.upspapp.utility.Utility;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = Constants.API_BASE_URL)
@Api(tags = "CategoryController")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private ISubCategoryService subCategoryService;
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping(value = "/add/category", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto addCategory(@RequestBody CategoryDto dto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		categoryService.addCategory(builder, dto);
		return builder.build();
	}

	@GetMapping(value = "/get/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getCategory(@PathVariable(name = "id") long id) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		categoryService.getCategoryById(builder, id);
		return builder.build();
	}

	@PostMapping(value = "/update/category", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto updateCategory(@RequestBody Category category) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		categoryService.updateCategoryById(builder, category);
		return builder.build();
	}

	@DeleteMapping(value = "/delete/category/{id}")
	public ApiResponseDto deleteCategory(@PathVariable(name = "id") long id) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		categoryService.deleteCategoryById(builder, id);
		return builder.build();
	}

	@GetMapping(value = "/getAll/category", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getAllCategory() {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		categoryService.getAllCategory(builder);
		return builder.build();
	}

	@GetMapping(value = "/getAll/category/{query}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getAllCategory(@PathVariable String query) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		categoryService.getAllCategoryByLikeQuery(builder, query);
		return builder.build();
	}

	// SubCategory

	@PostMapping(value = "/add/subCategory", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto addSubCategory(@RequestBody SubCategoryDto dto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		subCategoryService.addSubCategory(builder, dto);
		return builder.build();
	}

	@GetMapping(value = "/get/subCategory/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getSubCategory(@PathVariable(name = "id") long id) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		subCategoryService.getSubCategoryById(builder, id);
		return builder.build();
	}

	@PostMapping(value = "/update/subCategory", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto updateSubCategory(@RequestBody SubCategory subCategory) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		subCategoryService.updateSubCategoryById(builder, subCategory);
		return builder.build();
	}

	@DeleteMapping(value = "/delete/subCategory/{id}")
	public ApiResponseDto deleteSubCategory(@PathVariable(name = "id") long id) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		subCategoryService.deleteSubCategoryById(builder, id);
		return builder.build();
	}

	@GetMapping(value = "/getAll/subCategory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getAllSubCategory() {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		subCategoryService.getAllSubCategory(builder);
		return builder.build();
	}

	@GetMapping(value = "/getAllSubCategory/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getAllSubCategoryByCategoryId(@PathVariable(name = "categoryId") long categoryId) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		subCategoryService.getAllSubCategoryByCategoryId(builder, categoryId);
		return builder.build();
	}

	@GetMapping(value = "/getAll/categories/subcategories", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getAllCategoriesWithSubcategories() {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		subCategoryService.getAllCategoriesWithSubcategories(builder);
		return builder.build();
	}
}
