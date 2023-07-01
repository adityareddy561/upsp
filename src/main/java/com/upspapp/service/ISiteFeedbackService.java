package com.upspapp.service;

import org.springframework.stereotype.Service;

import com.upspapp.requestDto.SiteFeedbackDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@Service
public interface ISiteFeedbackService {

	void addSiteFeedback(ApiResponseDtoBuilder builder, SiteFeedbackDto dto);

	void getAllSiteFeedback(ApiResponseDtoBuilder builder);

}
