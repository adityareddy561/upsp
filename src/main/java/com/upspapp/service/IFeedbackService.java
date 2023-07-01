package com.upspapp.service;

import org.springframework.stereotype.Service;

import com.upspapp.requestDto.FeedbackDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@Service
public interface IFeedbackService {

	void addFeedback(ApiResponseDtoBuilder builder, FeedbackDto dto);

	void getAllFeedback(ApiResponseDtoBuilder builder);

	void getFeedbacksByProductId(long productId, ApiResponseDtoBuilder builder);

}
