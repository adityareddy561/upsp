package com.upspapp.customMapper;

import org.mapstruct.Mapper;

import com.upspapp.modal.Buyer;
import com.upspapp.modal.Seller;
import com.upspapp.modal.User;
import com.upspapp.requestDto.UserDto;

@Mapper(componentModel = "spring")
public interface CustomMapper {


	User userDtoToUser(UserDto dto);

	Buyer userDtoToBuyer(UserDto userDto);

	Seller userDtoToSeller(UserDto dto);

}
