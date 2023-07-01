package com.upspapp.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Advertisement;
import com.upspapp.modal.Report;
import com.upspapp.modal.User;
import com.upspapp.repository.AdvertisementRepository;
import com.upspapp.repository.BuyerRepository;
import com.upspapp.repository.ReportRepository;
import com.upspapp.repository.UserRepository;
import com.upspapp.requestDto.ReportDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.responseDto.ReportResponseDto;
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
	private AdvertisementRepository productRepository;

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
		List<ReportResponseDto> dataList = new ArrayList<>();
		for (Report report : listOfReport) {
			ReportResponseDto reportResponseDto = new ReportResponseDto();
			reportResponseDto.setQuery(report.getQuery());
			Optional<User> user = userRepository.findById(report.getBuyerId());
			reportResponseDto.setUsername(user.get().getFullName());
			Optional<Advertisement> product = productRepository.findById(report.getProductId());
			reportResponseDto.setProductName(product.get().getProductName());
			dataList.add(reportResponseDto);
		}
		builder.withData(dataList).withMessage("success").withStatus(HttpStatus.OK);
	}

}
