package com.upspapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Advertisement;
import com.upspapp.modal.Offer;
import com.upspapp.repository.AdvertisementRepository;
import com.upspapp.repository.OfferRepository;
import com.upspapp.requestDto.OfferDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@ExtendWith(MockitoExtension.class)
public class OfferServiceImplTest {

	@InjectMocks
	private OfferServiceimpl offerServiceimpl;

	@Mock
	private AdvertisementRepository advertisementRepository;

	@Mock
	private OfferRepository offerRepository;

	@Mock
	private CustomMapper customMapper;

	@Test
	public void addOffer() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		OfferDto dto = new OfferDto();
		dto.setOffer(10L);
		dto.setProductId(1L);
		Offer offer = new Offer();
		offer.setCreatedAt(new Date());
		offer.setId(1L);
		offer.setProductId(1L);
		offer.setOffer(10L);
		Advertisement advertisement = new Advertisement();
		advertisement.setId(1L);
		advertisement.setDescription("test");
		advertisement.setOwner("altaf");
		advertisement.setPrice(10L);
		advertisement.setProductName("test");
		Optional<Advertisement> optional = Optional.of(advertisement);
		when(advertisementRepository.findById(dto.getProductId())).thenReturn(optional);
		assertTrue(optional.isPresent());
		when(customMapper.offerDtoToOffer(dto)).thenReturn(offer);
		when(offerRepository.save(offer)).thenReturn(offer);
		offerServiceimpl.addOffer(dto, apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.ADD_OFFER));
	}

	@Test
	public void getOfferByProductId() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		long productId = 1L;
		Advertisement advertisement = new Advertisement();
		advertisement.setId(1L);
		advertisement.setDescription("test");
		advertisement.setOwner("altaf");
		advertisement.setPrice(10L);
		advertisement.setProductName("test");
		Optional<Advertisement> optional = Optional.of(advertisement);
		when(advertisementRepository.findById(productId)).thenReturn(optional);
		assertTrue(optional.isPresent());
		Offer offer = new Offer();
		offer.setCreatedAt(new Date());
		offer.setId(1L);
		offer.setProductId(1L);
		offer.setOffer(10L);
		when(offerRepository.findByProductId(productId)).thenReturn(offer);
		offerServiceimpl.getOfferByProductId(productId, apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("Success"));
	}
}
