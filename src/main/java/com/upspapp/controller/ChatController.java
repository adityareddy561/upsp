package com.upspapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.upspapp.requestDto.MessageDto;
import com.upspapp.responseDto.ApiResponseDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IMessageService;

@RestController
public class ChatController {

	@Autowired
	SimpMessagingTemplate template;
	@Autowired
	private IMessageService service;

	@MessageMapping("/chat")
	@SendTo("/topic/greetings")
	public ApiResponseDto greet(MessageDto messageDto) throws InterruptedException {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		
		service.addMessage(builder, messageDto);
	    service.getMessages(messageDto.getReceiver(),messageDto.getSender(),builder);
		return builder.build();
	}
	//MessageDto messageDto=new MessageDto();
	//messageDto.setMessage(message.split("#@#")[0]);
	//messageDto.setReceiver(message.split("#@#")[1]);
}
