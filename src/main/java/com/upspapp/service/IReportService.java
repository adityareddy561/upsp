package com.upspapp.service;

import org.springframework.stereotype.Service;

import com.upspapp.requestDto.ReportDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@Service
public interface IReportService {

	void addReport(ApiResponseDtoBuilder builder, ReportDto dto);

	void getAllReport(ApiResponseDtoBuilder builder);

}
