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

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Rating;
import com.upspapp.repository.AdvertisementRepository;
import com.upspapp.repository.BuyerRepository;
import com.upspapp.repository.RatingRepository;
import com.upspapp.requestDto.RatingDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@ExtendWith(MockitoExtension.class)
public class RatingServiceImplTest {

	@InjectMocks
	private RatingServiceImpl ratingServiceImpl;

	@Mock
	private RatingRepository ratingRepository;

	@Mock
	private AdvertisementRepository advertisementRepository;

	@Mock
	private BuyerRepository buyerRepository;

	@Mock
	private CustomMapper customMapper;
	
	@Test
	public void addRating() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		RatingDto ratingDto = new RatingDto();
		ratingDto.setBuyerId(1L);
		ratingDto.setProductId(1L);
		ratingDto.setRating(4);
		Rating rating = new Rating();
		rating.setCreatedAt(new Date());
		rating.setBuyerId(1L);
		rating.setProductId(1L);
		rating.setRating(4);
		rating.setId(1L);
		when(advertisementRepository.existsById(ratingDto.getProductId())).thenReturn(true);
		when(buyerRepository.existsById(ratingDto.getBuyerId())).thenReturn(true);
		when(customMapper.ratingDtoToRating(ratingDto)).thenReturn(rating);
		when(ratingRepository.save(rating)).thenReturn(rating);
		ratingServiceImpl.addRating(apiResponseDtoBuilder, ratingDto);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.ADD_RATING));
	}

	@Test
	public void getAllRating() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Rating rating = new Rating();
		rating.setCreatedAt(new Date());
		rating.setBuyerId(1L);
		rating.setProductId(1L);
		rating.setRating(4);
		rating.setId(1L);
		List<Rating> listOfRating = new ArrayList<Rating>();
		listOfRating.add(rating);
		when(ratingRepository.findAll()).thenReturn(listOfRating);
		ratingServiceImpl.getAllRating(apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
}
