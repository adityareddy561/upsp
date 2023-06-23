package com.upspapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Advertisement;
import com.upspapp.modal.PostLike;
import com.upspapp.modal.PostSave;
import com.upspapp.repository.AdvertisementRepository;
import com.upspapp.repository.LikeRepository;
import com.upspapp.repository.SaveRepository;
import com.upspapp.requestDto.AdvertisementDto;
import com.upspapp.requestDto.PostLikeDto;
import com.upspapp.requestDto.PostSaveDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@ExtendWith(MockitoExtension.class)
public class AdvertisementServiceimplTest {

	@InjectMocks
	AdvertisementServiceimpl advertisementServiceimpl;

	@Mock
	private AdvertisementRepository advertisementRepository;

	@Mock
	private SaveRepository saveRepository;

	@Mock
	private LikeRepository likeRepository;

	@Mock
	private CustomMapper mapper;
	
	@Test
	public void addProduct() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		AdvertisementDto advertisementDto = new AdvertisementDto();
		advertisementDto.setDescription("test");
		//advertisementDto.setOwner("altaf");
		advertisementDto.setPrice(10L);
		advertisementDto.setProductName("test");
		Advertisement advertisement = new Advertisement();
		advertisement.setId(1L);
		advertisement.setDescription("test");
		advertisement.setOwner("altaf");
		advertisement.setPrice(10L);
		advertisement.setProductName("test");
		when(mapper.advertisementDtoToAdvertisement(advertisementDto)).thenReturn(advertisement);
		when(advertisementRepository.save(advertisement)).thenReturn(advertisement);
		advertisementServiceimpl.addProduct(apiResponseDtoBuilder, advertisementDto);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.ADD_PRODUCT));
	}

	@Test
	public void getProductById() {
		long id = 1L;
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Advertisement advertisement = new Advertisement();
		advertisement.setId(1L);
		advertisement.setCreatedAt(new Date());
		advertisement.setDescription("test");
		advertisement.setOwner("altaf");
		advertisement.setPrice(10L);
		advertisement.setProductName("test");
		Optional<Advertisement> optionalAdvertisement = Optional.of(advertisement);
		when(advertisementRepository.findById(id)).thenReturn(optionalAdvertisement);
		advertisementServiceimpl.getProductById(id, apiResponseDtoBuilder);
		assertTrue(optionalAdvertisement.isPresent());
	}
	
	@Test
	public void updateProductById() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Advertisement advertisement = new Advertisement();
		advertisement.setId(1L);
		advertisement.setDescription("test");
		advertisement.setOwner("altaf");
		advertisement.setPrice(10L);
		advertisement.setProductName("test");
		Optional<Advertisement> optional = Optional.of(advertisement);
		when(advertisementRepository.findById(advertisement.getId())).thenReturn(optional);
		assertTrue(optional.isPresent());

		advertisement.setUpdatedAt(new Date());
		advertisement.setOwner("new test");
		advertisementServiceimpl.updateProductById(apiResponseDtoBuilder, advertisement);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.UPDATE_PRODUCT));

	}

	

	@Test
	public void addLike() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		PostLikeDto likeDto = new PostLikeDto();
		likeDto.setBuyerId(1L);
		likeDto.setProductId(1L);
		PostLike likes = new PostLike();
		likes.setId(1L);
		likes.setCreatedAt(new Date());
		likes.setBuyerId(1L);
		likes.setProductId(1L);
		when(mapper.likeDtoToLikes(likeDto)).thenReturn(likes);
		when(likeRepository.save(likes)).thenReturn(likes);
		advertisementServiceimpl.addLike(likeDto, apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.ADD_LIKES));
	}

	@Test
	public void deleteLike() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		PostLikeDto likeDto = new PostLikeDto();
		likeDto.setBuyerId(1L);
		likeDto.setProductId(1L);
		when(likeRepository.existsByBuyerIdAndProductId(likeDto.getBuyerId(), likeDto.getProductId())).thenReturn(true);
		advertisementServiceimpl.deleteLike(likeDto, apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.DISLIKE));
	}

}