package com.upspapp.service;

import org.springframework.stereotype.Service;

import com.upspapp.modal.Buyer;
import com.upspapp.modal.Seller;
import com.upspapp.modal.User;
import com.upspapp.requestDto.ChangePasswordDto;
import com.upspapp.requestDto.UserDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@Service
public interface IUserService {


	void addAdmin(ApiResponseDtoBuilder builder, UserDto dto);

	void deleteSellerById(ApiResponseDtoBuilder builder, long id);

	void addFriend(ApiResponseDtoBuilder apiResponseDtoBuilder, String email, long id);

	void addUser(ApiResponseDtoBuilder builder, UserDto userDto);

	void updateSellerById(Seller seller, ApiResponseDtoBuilder builder);

	void getSellerById(ApiResponseDtoBuilder builder, long id);

	void getAllSeller(ApiResponseDtoBuilder builder);

	void addBuyer(ApiResponseDtoBuilder builder, UserDto userDto);

	void updateBuyerById(Buyer buyer, ApiResponseDtoBuilder builder);

	void deleteBuyerById(ApiResponseDtoBuilder builder, long id);

	void getBuyerById(ApiResponseDtoBuilder builder, long id);
	void getUserById(ApiResponseDtoBuilder builder, long id);

	void getAllBuyer(ApiResponseDtoBuilder builder);

	void forgotPassword(ApiResponseDtoBuilder apiResponseDtoBuilder, String email);

	void sharePost(ApiResponseDtoBuilder apiResponseDtoBuilder, String email, long id);

	void updatePasswordById(ApiResponseDtoBuilder builder, ChangePasswordDto changePasswordDto);

	void updateUser(ApiResponseDtoBuilder builder, User user);
}
