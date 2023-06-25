package com.upspapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upspapp.constants.Constants;
import com.upspapp.requestDto.RatingDto;
import com.upspapp.responseDto.ApiResponseDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IRatingService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = Constants.API_BASE_URL)
@Api(tags = "RatingController")
public class RatingController {

	@Autowired
	private IRatingService ratingService;

	@PostMapping(value = "/add/rating", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto addRating(@RequestBody RatingDto dto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		ratingService.addRating(builder, dto);
		return builder.build();
	}

	@GetMapping(value = "/getAll/rating", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getAllRating() {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		ratingService.getAllRating(builder);
		return builder.build();
	}
}
