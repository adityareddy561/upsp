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
import com.upspapp.modal.Buyer;
import com.upspapp.modal.Seller;
import com.upspapp.modal.User;
import com.upspapp.requestDto.ChangePasswordDto;
import com.upspapp.requestDto.UserDto;
import com.upspapp.responseDto.ApiResponseDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IUserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = Constants.API_BASE_URL)
@Api(tags = "UserController")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping(value = "/admin/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto addAdmin(@RequestBody UserDto dto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		userService.addAdmin(builder, dto);
		return builder.build();
	}

	@PostMapping(value = "/user/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto addSeller(@RequestBody UserDto userDto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		userService.addUser(builder, userDto);
		return builder.build();
	}

	@PostMapping(value = "/seller/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto updateSeller(@RequestBody Seller seller) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		userService.updateSellerById(seller, builder);
		return builder.build();
	}

	@DeleteMapping(value = "/seller/delete/{id}")
	public ApiResponseDto deleteSeller(@PathVariable(name = "id") long id) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		userService.deleteSellerById(builder, id);
		return builder.build();
	}

	@GetMapping(value = "/seller/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getSeller(@PathVariable(name = "id") long id) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		userService.getSellerById(builder, id);
		return builder.build();
	}

	@GetMapping(value = "/seller/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getAllSeller() {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		userService.getAllSeller(builder);
		return builder.build();
	}

//	@PostMapping(value = "/buyer/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ApiResponseDto addBuyer(@RequestBody UserDto userDto) {
//		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
//		userService.addBuyer(builder, userDto);
//		return builder.build();
//	}

	@PostMapping(value = "/buyer/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto updateBuyer(@RequestBody Buyer buyer) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		userService.updateBuyerById(buyer, builder);
		return builder.build();
	}

	@DeleteMapping(value = "/buyer/delete/{id}")
	public ApiResponseDto deleteBuyer(@PathVariable(name = "id") long id) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		userService.deleteBuyerById(builder, id);
		return builder.build();
	}

	@GetMapping(value = "/buyer/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getBuyer(@PathVariable(name = "id") long id) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		userService.getBuyerById(builder, id);
		return builder.build();
	}

	@GetMapping(value = "/user/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getUser(@PathVariable(name = "id") long id) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		userService.getUserById(builder, id);
		return builder.build();
	}

	@GetMapping(value = "/buyer/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getAllBuyer() {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		userService.getAllBuyer(builder);
		return builder.build();
	}

	@PostMapping(value = "/change/password")
	public ApiResponseDto updatePassword(@RequestBody ChangePasswordDto changePasswordDto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		userService.updatePasswordById(builder, changePasswordDto);
		return builder.build();
	}

	@PostMapping(value = "/referFriend/{id}/{email}")
	public ApiResponseDto addFriend(@PathVariable(required = true) long id,
			@PathVariable(required = true) String email) {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		userService.addFriend(apiResponseDtoBuilder, email, id);
		return apiResponseDtoBuilder.build();
	}

	@PostMapping(value = "/sharePost/{id}/{email}")
	public ApiResponseDto sharePost(@PathVariable(required = true) long id,
			@PathVariable(required = true) String email) {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		userService.sharePost(apiResponseDtoBuilder, email, id);
		return apiResponseDtoBuilder.build();
	}

	@PostMapping(value = "/user/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto updateUser(@RequestBody User user) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		userService.updateUser(builder, user);
		return builder.build();
	}	

	@GetMapping(value = "/user/forgotPassword/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto forgotPassword(@PathVariable(required = true) String email) {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		userService.forgotPassword(apiResponseDtoBuilder, email);
		return apiResponseDtoBuilder.build();
	}
}
