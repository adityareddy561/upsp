package com.upspapp.service;

import org.springframework.stereotype.Service;

import com.upspapp.requestDto.OfferDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@Service
public interface IOfferService {

	void addOffer(OfferDto dto, ApiResponseDtoBuilder builder);

	void getOfferByProductId(long productId, ApiResponseDtoBuilder builder);

}
