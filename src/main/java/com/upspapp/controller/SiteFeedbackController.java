package com.upspapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upspapp.constants.Constants;
import com.upspapp.requestDto.SiteFeedbackDto;
import com.upspapp.responseDto.ApiResponseDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.ISiteFeedbackService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = Constants.API_BASE_URL)
@Api(tags = "SiteFeedbackController")
public class SiteFeedbackController {

	@Autowired
	private ISiteFeedbackService siteFeedbackService;

	@PostMapping(value = "/add/site/feedback", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto addSiteFeedback(@RequestBody SiteFeedbackDto dto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		siteFeedbackService.addSiteFeedback(builder, dto);
		return builder.build();
	}

	@GetMapping(value = "/getAll/site/feedback")
	public ApiResponseDto getAllSiteFeedback() {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		siteFeedbackService.getAllSiteFeedback(builder);
		return builder.build();
	}
}
