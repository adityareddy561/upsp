package com.upspapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upspapp.constants.Constants;
import com.upspapp.requestDto.OfferDto;
import com.upspapp.responseDto.ApiResponseDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IOfferService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = Constants.API_BASE_URL)
@Api(tags = "OfferController")
public class OfferController {

	@Autowired
	private IOfferService offerService;

	@PostMapping(value = "/add/offer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponseDto addOffer(@RequestBody OfferDto dto) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		offerService.addOffer(dto, builder);
		return builder.build();
	}

	@GetMapping(value = "/get/offer/{productId}")
	public ApiResponseDto getOffer(@PathVariable(name = "productId") long productId) {
		ApiResponseDtoBuilder builder = new ApiResponseDtoBuilder();
		offerService.getOfferByProductId(productId, builder);
		return builder.build();
	}
}
