package com.upspapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upspapp.constants.Constants;
import com.upspapp.requestDto.MessageDto;
import com.upspapp.responseDto.ApiResponseDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IMessageService;

@CrossOrigin(origins = "*", maxAge = 360000000)
@RestController
@RequestMapping(Constants.API_BASE_URL)
public class MessageController {

	@Autowired
	private IMessageService service;

	@PostMapping(value = "/message/add")
	public ApiResponseDto addMessage(@RequestBody MessageDto dto,HttpServletRequest request) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		service.addMessage(builder, dto);
		return builder.build();
	}

	@GetMapping(value = "/messages/get/{username}/{currentuser}")
	public ApiResponseDto getMessage(@PathVariable(name = "username") String username,@PathVariable(name = "currentuser") String currentuser) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		service.getMessages(username,currentuser, builder);
		return builder.build();
	}
}
