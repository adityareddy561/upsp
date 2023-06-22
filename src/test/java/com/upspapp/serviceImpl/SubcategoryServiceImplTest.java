package com.upspapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.SubCategory;
import com.upspapp.repository.CategoryRepository;
import com.upspapp.repository.SubCategoryRepository;
import com.upspapp.requestDto.SubCategoryDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@ExtendWith(MockitoExtension.class)
public class SubcategoryServiceImplTest {

	@InjectMocks
	private SubcategoryServiceImpl subcategoryServiceImpl;

	@Mock
	private SubCategoryRepository subCategoryRepository;

	@Mock
	private CustomMapper mapper;

	@Mock
	private CategoryRepository categoryRepository;

	@Test
	public void addSubCategory() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		SubCategoryDto subCategoryDto = new SubCategoryDto();
		subCategoryDto.setSubCategoryName("test");
		SubCategory subCategory = new SubCategory();
		subCategory.setCreatedAt(new Date());
		subCategory.setId(1L);
		subCategory.setSubCategoryName("test");
		subCategory.setCategoryId(1L);
		when(mapper.subCategoryDtoToSubCategory(subCategoryDto)).thenReturn(subCategory);
		when(subCategoryRepository.save(subCategory)).thenReturn(subCategory);
		subcategoryServiceImpl.addSubCategory(apiResponseDtoBuilder, subCategoryDto);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.ADD_SUB_CATEGORY));
	}

	@Test
	public void getSubCategoryById() {

		long id = 1L;
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		SubCategory subCategory = new SubCategory();
		subCategory.setCreatedAt(new Date());
		subCategory.setId(1L);
		subCategory.setSubCategoryName("test");
		subCategory.setCategoryId(1L);
		Optional<SubCategory> optionalSubCategory = Optional.of(subCategory);
		when(subCategoryRepository.findById(id)).thenReturn(optionalSubCategory);
		subcategoryServiceImpl.getSubCategoryById(apiResponseDtoBuilder, id);
		assertTrue(optionalSubCategory.isPresent());
	}

	@Test
	public void updateSubCategoryById() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		SubCategory subCategory = new SubCategory();
		subCategory.setCreatedAt(new Date());
		subCategory.setId(1L);
		subCategory.setSubCategoryName("test");
		subCategory.setCategoryId(1L);
		Optional<SubCategory> optional = Optional.of(subCategory);
		when(subCategoryRepository.findById(subCategory.getId())).thenReturn(optional);
		when(categoryRepository.existsById(subCategory.getCategoryId())).thenReturn(true);

		assertTrue(optional.isPresent());

		subCategory.setUpdatedAt(new Date());
		subcategoryServiceImpl.updateSubCategoryById(apiResponseDtoBuilder, subCategory);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.UPDATE_SUB_CATEGORY));

	}
	
	@Test
	public void deleteSubCategoryById() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		SubCategory subCategory = new SubCategory();
		subCategory.setCreatedAt(new Date());
		subCategory.setId(1L);
		subCategory.setSubCategoryName("test");
		subCategory.setCategoryId(1L);
		Optional<SubCategory> optional = Optional.of(subCategory);
		when(subCategoryRepository.findById(subCategory.getId())).thenReturn(optional);
		assertTrue(optional.isPresent());
		subcategoryServiceImpl.deleteSubCategoryById(apiResponseDtoBuilder, subCategory.getId());
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.DELETE_SUB_CATEGORY));
	}

	@Test
	public void getAllSubCategory() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		SubCategory subCategory = new SubCategory();
		subCategory.setCreatedAt(new Date());
		subCategory.setId(1L);
		subCategory.setSubCategoryName("test");
		subCategory.setCategoryId(1L);
		List<SubCategory> listOfSubCategory = new ArrayList<SubCategory>();
		listOfSubCategory.add(subCategory);
		when(subCategoryRepository.findAll()).thenReturn(listOfSubCategory);
		subcategoryServiceImpl.getAllSubCategory(apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}

	@Test
	public void getAllSubCategoryByCategoryId() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		SubCategory subCategory = new SubCategory();
		subCategory.setCreatedAt(new Date());
		subCategory.setId(1L);
		subCategory.setSubCategoryName("test");
		subCategory.setCategoryId(1L);
		List<SubCategory> listOfSubCategory = new ArrayList<SubCategory>();
		listOfSubCategory.add(subCategory);
		when(subCategoryRepository.findAllByCategoryId(subCategory.getCategoryId())).thenReturn(listOfSubCategory);
		subcategoryServiceImpl.getAllSubCategoryByCategoryId(apiResponseDtoBuilder, subCategory.getCategoryId());
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
}
