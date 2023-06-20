package com.upspapp.customMapper;

import org.mapstruct.Mapper;

import com.upspapp.modal.User;
import com.upspapp.requestDto.UserDto;

@Mapper(componentModel = "spring")
public interface CustomMapper {


	User userDtoToUser(UserDto dto);

}
