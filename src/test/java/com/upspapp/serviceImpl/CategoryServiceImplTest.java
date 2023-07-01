package com.upspapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Category;
import com.upspapp.modal.User;
import com.upspapp.repository.CategoryRepository;
import com.upspapp.repository.UserRepository;
import com.upspapp.requestDto.CategoryDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.utility.Utility;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

	@InjectMocks
	private CategoryServiceImpl categoryServiceImpl;

	@Mock
	private CategoryRepository categoryRepository;

	@Mock
	private CustomMapper customMapper;
	
	@Mock
	private UserRepository userRepository;
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		User user = new User();
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null);

		SecurityContextHolder.getContext().setAuthentication(auth);
	}
	@Test
	public void addCategory() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryName("test");
		Category category = new Category();
		category.setId(1L);
		category.setCategoryName("test");
		category.setCreatedAt(new Date());
		when(customMapper.categoryDtoToCategory(categoryDto)).thenReturn(category);
		when(categoryRepository.save(category)).thenReturn(category);
		User sessionUser = new User();
		sessionUser.setActive(true);
		sessionUser.setEmail("test");
		sessionUser.setFullName("test");
		sessionUser.setId(1l);
		sessionUser.setRole(0);
		when(Utility.getSessionUser(userRepository)).thenReturn(sessionUser);
		categoryServiceImpl.addCategory(apiResponseDtoBuilder, categoryDto);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}

	@Test
	public void getCategoryById() {
		long id = 1L;
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Category category = new Category();
		category.setId(1L);
		category.setCategoryName("test");
		Optional<Category> optionalCategory = Optional.of(category);
		when(categoryRepository.findById(id)).thenReturn(optionalCategory);
		categoryServiceImpl.getCategoryById(apiResponseDtoBuilder, id);
		assertTrue(optionalCategory.isPresent());
	}

	@Test
	public void updateCategoryById() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Category category = new Category();
		category.setId(1L);
		category.setCategoryName("test");
		Optional<Category> optional = Optional.of(category);
		when(categoryRepository.findById(category.getId())).thenReturn(optional);
		assertTrue(optional.isPresent());

		category.setUpdatedAt(new Date());
		category.setCategoryName("category");
		categoryServiceImpl.updateCategoryById(apiResponseDtoBuilder, category);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.UPDATE_CATEGORY));
	}

	@Test
	public void deleteCategoryById() {
		long id = 1L;
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Category category = new Category();
		category.setId(1L);
		category.setCategoryName("test");
		Optional<Category> optional = Optional.of(category);
		when(categoryRepository.findById(category.getId())).thenReturn(optional);
		assertTrue(optional.isPresent());
		categoryServiceImpl.deleteCategoryById(apiResponseDtoBuilder, id);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.DELETE_CATEGORY));
	}

	@Test
	public void getAllCategory() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Category category = new Category();
		category.setId(1L);
		category.setCreatedAt(new Date());
		category.setCategoryName("test");
		List<Category> listOfCategory = new ArrayList<>();
		listOfCategory.add(category);
		when(categoryRepository.findAll()).thenReturn(listOfCategory);
		categoryServiceImpl.getAllCategory(apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
	
	
	@Test
	public void getAllCategoryByLikeQuery() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		String query="test";
		Category category = new Category();
		category.setId(1L);
		category.setCreatedAt(new Date());
		category.setCategoryName("test");
		List<Category> listOfCategory = new ArrayList<>();
		listOfCategory.add(category);
		when(categoryRepository.findByCategoryNameContaining(query)).thenReturn(listOfCategory);
		categoryServiceImpl.getAllCategoryByLikeQuery(apiResponseDtoBuilder,query);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
	
	

	
}
