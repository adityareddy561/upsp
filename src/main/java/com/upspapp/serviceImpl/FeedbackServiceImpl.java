package com.upspapp.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Feedback;
import com.upspapp.repository.BuyerRepository;
import com.upspapp.repository.FeedbackRepository;
import com.upspapp.repository.UserRepository;
import com.upspapp.requestDto.FeedbackDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	private CustomMapper mapper;

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private UserRepository buyerRepository;

	@Override
	public void addFeedback(ApiResponseDtoBuilder builder, FeedbackDto dto) {
		if (buyerRepository.existsById(dto.getBuyerId())) {
			Feedback feedback = mapper.feedbackDtoToFeedback(dto);
			feedback.setCreatedAt(new Date());
			feedbackRepository.save(feedback);
			builder.withMessage("success").withData(feedback).withStatus(HttpStatus.OK);
		} else {
			builder.withMessage(Constants.USER_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void getAllFeedback(ApiResponseDtoBuilder builder) {
		List<Feedback> listOfFeedback = feedbackRepository.findAll();
		builder.withData(listOfFeedback).withMessage("success").withStatus(HttpStatus.OK);
	}
}
