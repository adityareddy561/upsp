package com.upspapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upspapp.constants.Constants;
import com.upspapp.requestDto.FeedbackDto;
import com.upspapp.responseDto.ApiResponseDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IFeedbackService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = Constants.API_BASE_URL)
@Api(tags = "FeedbackController")
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;

	@PostMapping(value = "/add/feedback", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto addFeedback(@RequestBody FeedbackDto dto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		feedbackService.addFeedback(builder, dto);
		return builder.build();
	}

	@GetMapping(value = "/getAll/feedback")
	public ApiResponseDto getAllFeedback() {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		feedbackService.getAllFeedback(builder);
		return builder.build();
	}
}
