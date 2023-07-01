package com.upspapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Report;
import com.upspapp.repository.AdvertisementRepository;
import com.upspapp.repository.BuyerRepository;
import com.upspapp.repository.ReportRepository;
import com.upspapp.repository.UserRepository;
import com.upspapp.requestDto.ReportDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@ExtendWith(MockitoExtension.class)
public class ReportServiceImplTest {

	@InjectMocks
	private ReportServiceImpl reportServiceImpl;
	@Mock
	private CustomMapper mapper;

	@Mock
	private ReportRepository reportRepository;

	@Mock
	private UserRepository userRepository;

	@Mock
	private AdvertisementRepository advertisementRepository;

	@Test
	public void addReport() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		ReportDto reportDto = new ReportDto();
		reportDto.setBuyerId(1L);
		reportDto.setProductId(1L);
		reportDto.setQuery("Test");
		Report report = new Report();
		report.setBuyerId(1L);
		report.setProductId(1L);
		report.setQuery("Test");
		report.setId(1L);
		report.setCreatedAt(new Date());
		when(advertisementRepository.existsById(reportDto.getProductId())).thenReturn(true);
		when(userRepository.existsById(reportDto.getBuyerId())).thenReturn(true);
		when(mapper.reportDtoToReport(reportDto)).thenReturn(report);
		when(reportRepository.save(report)).thenReturn(report);
		reportServiceImpl.addReport(apiResponseDtoBuilder, reportDto);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}

	@Test
	public void getAllReport() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Report report = new Report();
		report.setBuyerId(1L);
		report.setProductId(1L);
		report.setQuery("Test");
		report.setId(1L);
		report.setCreatedAt(new Date());
		List<Report> listOfReport = new ArrayList<Report>();
		listOfReport.add(report);
		when(reportRepository.findAll()).thenReturn(listOfReport);
		reportServiceImpl.getAllReport(apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
}
