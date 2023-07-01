package com.upspapp.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Message;
import com.upspapp.modal.User;
import com.upspapp.repository.MessageRepository;
import com.upspapp.repository.UserRepository;
import com.upspapp.requestDto.MessageDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.responseDto.MessageResponseDto;
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
		// User sessionUser = Utility.getSessionUser(userRepository);
		Message message = customMapper.messageDtoToMessage(dto);
		message.setCreatedAt(new Date());
		messageRepository.save(message);
		template.convertAndSend("/topic/greetings", message);
		// template.convertAndSendToUser(message.getSender(), "/topic/greetings",
		// message);
		builder.withMessage("message Send successfully").withStatus(HttpStatus.OK);
	}

	@Override
	public void getMessages(long receiver, long sender, ApiResponseDtoBuilder builder) {
		List<Message> listOfMessage = messageRepository.findBySenderAndReceiverOrReceiverAndSender(sender, receiver,
				receiver, sender);
		List<MessageResponseDto> dataList = new ArrayList<>();
		for (Message message : listOfMessage) {
			MessageResponseDto messageResponseDto = new MessageResponseDto();
			messageResponseDto.setCreatedAt(message.getCreatedAt());
			messageResponseDto.setMessage(message.getMessage());
			Optional<User> senderUser = userRepository.findById(message.getSender());
			messageResponseDto.setSender(senderUser.get().getFullName());
			messageResponseDto.setSenderId(message.getSender());
			Optional<User> receiverUser = userRepository.findById(message.getReceiver());
			messageResponseDto.setReceiverId(message.getReceiver());
			messageResponseDto.setReceiver(receiverUser.get().getFullName());
			dataList.add(messageResponseDto);
		}
		builder.withMessage("message Send successfully").withStatus(HttpStatus.OK).withData(dataList);

	}
}
