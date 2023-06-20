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
}
