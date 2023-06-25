package com.upspapp.serviceImpl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Advertisement;
import com.upspapp.modal.Offer;
import com.upspapp.repository.AdvertisementRepository;
import com.upspapp.repository.OfferRepository;
import com.upspapp.requestDto.OfferDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IOfferService;

@Service
public class OfferServiceimpl implements IOfferService {

	@Autowired
	private AdvertisementRepository advertisementRepository;

	@Autowired
	private OfferRepository offerRepository;

	@Autowired
	private CustomMapper customMapper;

	@Override
	public void addOffer(OfferDto dto, ApiResponseDtoBuilder builder) {
		Optional<Advertisement> product = advertisementRepository.findById(dto.getProductId());
		if (product.isPresent()) {
			Offer offer = customMapper.offerDtoToOffer(dto);
			offer.setCreatedAt(new Date());
			offerRepository.save(offer);
			builder.withMessage(Constants.ADD_OFFER).withStatus(HttpStatus.OK).withData(offer);
		} else {
			builder.withMessage(Constants.NO_PRODUCT_EXISTS).withStatus(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void getOfferByProductId(long productId, ApiResponseDtoBuilder builder) {
		Optional<Advertisement> product = advertisementRepository.findById(productId);
		if (product.isPresent()) {
			Offer offer = offerRepository.findByProductId(productId);
			if (!(offer == null)) {
				builder.withData(offer).withMessage("Success").withStatus(HttpStatus.OK);
			} else {
				builder.withMessage(Constants.NO_OFFER_AVAILABLE).withStatus(HttpStatus.NOT_FOUND);
			}
		} else {
			builder.withMessage(Constants.NO_PRODUCT_EXISTS).withStatus(HttpStatus.NOT_FOUND);
		}
	}
}
