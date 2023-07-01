package com.upspapp.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Category;
import com.upspapp.modal.SubCategory;
import com.upspapp.modal.User;
import com.upspapp.repository.CategoryRepository;
import com.upspapp.repository.SubCategoryRepository;
import com.upspapp.repository.UserRepository;
import com.upspapp.requestDto.SubCategoryDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.responseDto.CategoriesAndSubcategories;
import com.upspapp.responseDto.SubCategoryResponseDto;
import com.upspapp.service.ISubCategoryService;
import com.upspapp.utility.Utility;

@Service
public class SubcategoryServiceImpl implements ISubCategoryService {

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Autowired
	private CustomMapper mapper;

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void addSubCategory(ApiResponseDtoBuilder builder, SubCategoryDto dto) {
		User sessionUser = Utility.getSessionUser(userRepository);
		if (sessionUser == null || sessionUser.getRole() != 0) {
			builder.withMessage("UnAuthorize").withStatus(HttpStatus.UNAUTHORIZED);
		}
		SubCategory subCategory = mapper.subCategoryDtoToSubCategory(dto);
		subCategory.setCreatedAt(new Date());
		subCategoryRepository.save(subCategory);
		builder.withData(subCategory).withMessage("success").withStatus(HttpStatus.OK);
	}

	@Override
	public void getSubCategoryById(ApiResponseDtoBuilder builder, long id) {
		Optional<SubCategory> subCategory = subCategoryRepository.findById(id);
		if (subCategory.isPresent()) {
			builder.withStatus(HttpStatus.OK).withMessage("success").withData(subCategory.get());
		} else {
			builder.withMessage(Constants.SUB_CATEGORY_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void updateSubCategoryById(ApiResponseDtoBuilder builder, SubCategory subCategory) {
		Optional<SubCategory> optionalSubCategory = subCategoryRepository.findById(subCategory.getId());
		if (optionalSubCategory.isPresent() && categoryRepository.existsById(subCategory.getCategoryId())) {
			SubCategory cate = optionalSubCategory.get();
			cate.setUpdatedAt(new Date());
			cate.setSubCategoryName(subCategory.getSubCategoryName());
			cate.setCategoryId(subCategory.getCategoryId());
			subCategoryRepository.save(cate);
			builder.withData(cate).withMessage(Constants.UPDATE_SUB_CATEGORY).withStatus(HttpStatus.OK);
		} else {
			builder.withMessage(Constants.SUB_CATEGORY_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteSubCategoryById(ApiResponseDtoBuilder builder, long id) {
		Optional<SubCategory> subCategory = subCategoryRepository.findById(id);
		if (subCategory.isPresent()) {
			subCategoryRepository.deleteById(id);
			builder.withStatus(HttpStatus.OK).withMessage(Constants.DELETE_SUB_CATEGORY);
		} else {
			builder.withMessage(Constants.SUB_CATEGORY_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void getAllSubCategory(ApiResponseDtoBuilder builder) {
		List<SubCategory> listOfSubCategory = subCategoryRepository.findAll();
		List<SubCategoryResponseDto> dataList = new ArrayList<>();
		for (SubCategory subCategory : listOfSubCategory) {
			SubCategoryResponseDto subCategoryResponseDto = mapper.subCategoryToSubCategoryResponseDto(subCategory);
			Optional<Category> category = categoryRepository.findById(subCategory.getCategoryId());
			if (category.isPresent()) {
				subCategoryResponseDto.setCategoryName(category.get().getCategoryName());
				dataList.add(subCategoryResponseDto);
			}
		}
		builder.withData(dataList).withStatus(HttpStatus.OK).withMessage("success");
	}

	@Override
	public void getAllSubCategoryByCategoryId(ApiResponseDtoBuilder builder, long categoryId) {
		List<SubCategory> listOfSubCategory = subCategoryRepository.findAllByCategoryId(categoryId);
		builder.withData(listOfSubCategory).withMessage("success").withStatus(HttpStatus.OK);
	}

	@Override
	public void getAllCategoriesWithSubcategories(ApiResponseDtoBuilder builder) {
		List<CategoriesAndSubcategories> listOfData = new ArrayList<>();
		List<Category> listOfCat = categoryRepository.findAll();
		listOfCat.stream().forEach(category -> {
			CategoriesAndSubcategories dto = new CategoriesAndSubcategories();
			List<SubCategory> allByCategoryId = subCategoryRepository.findAllByCategoryId(category.getId());
			dto.setCategory(category);
			dto.setSubCategories(allByCategoryId);
			listOfData.add(dto);
		});
		builder.withMessage("success").withStatus(HttpStatus.OK).withData(listOfData);
	}
}
