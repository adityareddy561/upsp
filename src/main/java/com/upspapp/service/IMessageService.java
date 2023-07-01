package com.upspapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.upspapp.modal.Message;
import com.upspapp.requestDto.MessageDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@Service
public interface IMessageService {

	void addMessage(ApiResponseDtoBuilder builder, MessageDto dto);


	void getMessages(String username, String currentuser, ApiResponseDtoBuilder builder);

}
