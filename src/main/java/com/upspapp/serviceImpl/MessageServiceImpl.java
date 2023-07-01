package com.upspapp.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Message;
import com.upspapp.repository.MessageRepository;
import com.upspapp.repository.UserRepository;
import com.upspapp.requestDto.MessageDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private CustomMapper customMapper;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	SimpMessagingTemplate template;

	@Override
	public void addMessage(ApiResponseDtoBuilder builder, MessageDto dto) {
		//User sessionUser = Utility.getSessionUser(userRepository);
		Message message = customMapper.messageDtoToMessage(dto);
		message.setCreatedAt(new Date());
		messageRepository.save(message);
		template.convertAndSend("/topic/greetings", message);
		//template.convertAndSendToUser(message.getSender(), "/topic/greetings", message);
		builder.withMessage("message Send successfully").withStatus(HttpStatus.OK);
	}

	@Override
	public void getMessages(String username, String currentuser, ApiResponseDtoBuilder builder) {
		List<Message> listOfMessage = messageRepository.findBySenderAndReceiverOrReceiverAndSender(
				currentuser, username, username, currentuser);
		builder.withMessage("message Send successfully").withStatus(HttpStatus.OK).withData(listOfMessage);
		
	}
}
