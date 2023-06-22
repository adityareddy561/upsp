package com.upspapp.customMapper;

import org.mapstruct.Mapper;

import com.upspapp.modal.Buyer;
import com.upspapp.modal.Category;
import com.upspapp.modal.Seller;
import com.upspapp.modal.SubCategory;
import com.upspapp.modal.User;
import com.upspapp.requestDto.CategoryDto;
import com.upspapp.requestDto.SubCategoryDto;
import com.upspapp.requestDto.UserDto;

@Mapper(componentModel = "spring")
public interface CustomMapper {


	User userDtoToUser(UserDto dto);

	Category categoryDtoToCategory(CategoryDto dto);

	SubCategory subCategoryDtoToSubCategory(SubCategoryDto dto);

	Buyer userDtoToBuyer(UserDto userDto);

	Seller userDtoToSeller(UserDto dto);

}
