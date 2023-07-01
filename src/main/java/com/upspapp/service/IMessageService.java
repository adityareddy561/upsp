package com.upspapp.service;

import org.springframework.stereotype.Service;

import com.upspapp.requestDto.MessageDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@Service
public interface IMessageService {

	void addMessage(ApiResponseDtoBuilder builder, MessageDto dto);


	void getMessages(long receiver, long sender, ApiResponseDtoBuilder builder);

}
