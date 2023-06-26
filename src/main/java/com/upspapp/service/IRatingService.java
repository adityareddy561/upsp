package com.upspapp.service;

import org.springframework.stereotype.Service;

import com.upspapp.requestDto.RatingDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@Service
public interface IRatingService {

	void addRating(ApiResponseDtoBuilder builder, RatingDto dto);

	void getAllRating(ApiResponseDtoBuilder builder);

}
