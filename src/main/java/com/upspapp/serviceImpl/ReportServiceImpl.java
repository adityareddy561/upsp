package com.upspapp.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Report;
import com.upspapp.repository.AdvertisementRepository;
import com.upspapp.repository.BuyerRepository;
import com.upspapp.repository.ReportRepository;
import com.upspapp.repository.UserRepository;
import com.upspapp.requestDto.ReportDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IReportService;

@Service
public class ReportServiceImpl implements IReportService {

	@Autowired
	private CustomMapper mapper;

	@Autowired
	private ReportRepository repository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BuyerRepository buyerRepository;

	@Autowired
	private AdvertisementRepository advertisementRepository;

	@Override
	public void addReport(ApiResponseDtoBuilder builder, ReportDto dto) {
		if (userRepository.existsById(dto.getBuyerId()) && advertisementRepository.existsById(dto.getProductId())) {
			Report report = mapper.reportDtoToReport(dto);
			report.setCreatedAt(new Date());
			repository.save(report);
			builder.withData(report).withStatus(HttpStatus.OK).withMessage("success");
		} else {
			builder.withMessage("Customer Or Product  Not Found").withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void getAllReport(ApiResponseDtoBuilder builder) {
		List<Report> listOfReport = repository.findAll();
		builder.withData(listOfReport).withMessage("success").withStatus(HttpStatus.OK);
	}

}
