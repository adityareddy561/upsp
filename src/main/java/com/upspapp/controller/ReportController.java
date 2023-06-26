package com.upspapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upspapp.constants.Constants;
import com.upspapp.requestDto.ReportDto;
import com.upspapp.responseDto.ApiResponseDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IReportService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = Constants.API_BASE_URL)
@Api(tags = "ReportController")
public class ReportController {

	@Autowired
	private IReportService reportService;

	@PostMapping(value = "/add/report", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto addReport(@RequestBody ReportDto dto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		reportService.addReport(builder, dto);
		return builder.build();
	}

	@GetMapping(value = "/getAll/report", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto getAllReport() {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		reportService.getAllReport(builder);
		return builder.build();
	}
}
