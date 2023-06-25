package com.upspapp.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Rating;
import com.upspapp.repository.AdvertisementRepository;
import com.upspapp.repository.BuyerRepository;
import com.upspapp.repository.RatingRepository;
import com.upspapp.requestDto.RatingDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IRatingService;

@Service
public class RatingServiceImpl implements IRatingService {

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private AdvertisementRepository advertisementRepository;

	@Autowired
	private BuyerRepository buyerRepository;

	@Autowired
	private CustomMapper customMapper;

	@Override
	public void addRating(ApiResponseDtoBuilder builder, RatingDto dto) {
		if (advertisementRepository.existsById(dto.getProductId()) && buyerRepository.existsById(dto.getBuyerId())) {
			Rating rating = customMapper.ratingDtoToRating(dto);
			rating.setCreatedAt(new Date());
			ratingRepository.save(rating);
			builder.withData(rating).withStatus(HttpStatus.OK).withMessage(Constants.ADD_RATING);
		}else {
			builder.withMessage(Constants.PRODUCT_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void getAllRating(ApiResponseDtoBuilder builder) {
		List<Rating> listOfRating = ratingRepository.findAll();
		builder.withData(listOfRating).withStatus(HttpStatus.OK).withMessage("success");
	}

}
