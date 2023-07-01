package com.upspapp.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.SiteFeedback;
import com.upspapp.repository.SiteFeedbackRepository;
import com.upspapp.requestDto.SiteFeedbackDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.ISiteFeedbackService;

@Service
public class SiteFeedbackServiceImpl implements ISiteFeedbackService {

	@Autowired
	private CustomMapper mapper;

	@Autowired
	private SiteFeedbackRepository feedbackRepository;

	@Override
	public void addSiteFeedback(ApiResponseDtoBuilder builder, SiteFeedbackDto dto) {
		SiteFeedback feedback = mapper.siteFeedbackDtoToSiteFeedback(dto);
		feedback.setCreatedAt(new Date());
		feedbackRepository.save(feedback);
		builder.withMessage("success").withData(feedback).withStatus(HttpStatus.OK);
	}

	@Override
	public void getAllSiteFeedback(ApiResponseDtoBuilder builder) {
		List<SiteFeedback> listOfFeedback = feedbackRepository.findAll();
		builder.withData(listOfFeedback).withMessage("success").withStatus(HttpStatus.OK);
	}
}
