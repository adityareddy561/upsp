package com.upspapp.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Advertisement;
import com.upspapp.modal.Feedback;
import com.upspapp.modal.User;
import com.upspapp.repository.FeedbackRepository;
import com.upspapp.repository.UserRepository;
import com.upspapp.requestDto.FeedbackDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.responseDto.FeedbackResponseDto;
import com.upspapp.service.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	private CustomMapper mapper;

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private UserRepository buyerRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void addFeedback(ApiResponseDtoBuilder builder, FeedbackDto dto) {
		if (buyerRepository.existsById(dto.getUserId())) {
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

	@Override
	public void getFeedbacksByProductId(long productId, ApiResponseDtoBuilder builder) {
		List<Feedback> listOfFeedback = feedbackRepository.findByProductId(productId);
		List<FeedbackResponseDto> dataList = new ArrayList<>();
		for (Feedback report : listOfFeedback) {
			FeedbackResponseDto reportResponseDto = new FeedbackResponseDto();
			reportResponseDto.setReview(report.getReview());
			reportResponseDto.setRating(report.getRating());
			Optional<User> user = userRepository.findById(report.getUserId());
			reportResponseDto.setUsername(user.get().getFullName());
			reportResponseDto.setUserImage(user.get().getProfileImage());
			dataList.add(reportResponseDto);
		}
		builder.withData(dataList).withMessage("success").withStatus(HttpStatus.OK);
	}
}
