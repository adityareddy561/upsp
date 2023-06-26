package com.upspapp.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Category;
import com.upspapp.modal.User;
import com.upspapp.repository.CategoryRepository;
import com.upspapp.repository.UserRepository;
import com.upspapp.requestDto.CategoryDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.ICategoryService;
import com.upspapp.utility.Utility;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomMapper customMapper;

	@Override
	public void addCategory(ApiResponseDtoBuilder builder, CategoryDto dto) {
		User sessionUser = Utility.getSessionUser(userRepository);
		if (sessionUser == null || sessionUser.getRole() != 0) {
			builder.withMessage("UnAuthorize").withStatus(HttpStatus.UNAUTHORIZED);
		}
		Category category = customMapper.categoryDtoToCategory(dto);
		category.setCreatedAt(new Date());
		categoryRepository.save(category);
		builder.withData(category).withMessage("success").withStatus(HttpStatus.OK);
	}

	@Override
	public void getCategoryById(ApiResponseDtoBuilder builder, long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (category.isPresent()) {
			builder.withStatus(HttpStatus.OK).withMessage("success").withData(category.get());
		} else {
			builder.withMessage(Constants.CATEGORY_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void updateCategoryById(ApiResponseDtoBuilder builder, Category category) {
		Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
		if (optionalCategory.isPresent()) {
			Category cate = optionalCategory.get();
			cate.setUpdatedAt(new Date());
			cate.setCategoryName(category.getCategoryName());
			categoryRepository.save(cate);
			builder.withData(cate).withMessage(Constants.UPDATE_CATEGORY).withStatus(HttpStatus.OK);
		} else {
			builder.withMessage(Constants.CATEGORY_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteCategoryById(ApiResponseDtoBuilder builder, long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (category.isPresent()) {
			categoryRepository.deleteById(id);
			builder.withStatus(HttpStatus.OK).withMessage(Constants.DELETE_CATEGORY);
		} else {
			builder.withMessage(Constants.CATEGORY_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void getAllCategory(ApiResponseDtoBuilder builder) {
		List<Category> listOfCategory = categoryRepository.findAll();
		builder.withData(listOfCategory).withStatus(HttpStatus.OK).withMessage("success");
	}

	@Override
	public void getAllCategoryByLikeQuery(ApiResponseDtoBuilder builder, String query) {
		List<Category> listOfCategory = categoryRepository.findByCategoryNameContaining(query);
		builder.withData(listOfCategory).withStatus(HttpStatus.OK).withMessage("success");

	}

}
