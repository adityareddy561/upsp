package com.upspapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Advertisement;
import com.upspapp.modal.PostLike;
import com.upspapp.modal.PostSave;
import com.upspapp.modal.User;
import com.upspapp.repository.AdvertisementRepository;
import com.upspapp.repository.LikeRepository;
import com.upspapp.repository.SaveRepository;
import com.upspapp.repository.UserRepository;
import com.upspapp.requestDto.AdvertisementDto;
import com.upspapp.requestDto.PostLikeDto;
import com.upspapp.requestDto.PostSaveDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.utility.Utility;

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
	
	@Mock
	private UserRepository userRepository;
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		User user = new User();
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null);

		SecurityContextHolder.getContext().setAuthentication(auth);
	}
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
		User sessionUser = new User();
		sessionUser.setActive(true);
		sessionUser.setEmail("test");
		sessionUser.setFullName("test");
		sessionUser.setId(1l);
		sessionUser.setRole(0);
		sessionUser.setPassword("1221332131");
		sessionUser.setMobileNumber("121213231314234232");
		sessionUser.setActive(true);
		sessionUser.setProfileImage("test");
		when(Utility.getSessionUser(userRepository)).thenReturn(sessionUser);
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
	public void deleteProductById() {
		long id = 1L;
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Advertisement advertisement = new Advertisement();
		advertisement.setId(id);
		advertisement.setCreatedAt(new Date());
		advertisement.setDescription("test");
		advertisement.setOwner("altaf");
		advertisement.setPrice(10L);
		advertisement.setProductName("test");
		Optional<Advertisement> optionalAdvertisement = Optional.of(advertisement);
		when(advertisementRepository.findById(id)).thenReturn(optionalAdvertisement);
		assertTrue(optionalAdvertisement.isPresent());
		advertisementServiceimpl.deleteProductById(apiResponseDtoBuilder, id);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}

	@Test
	public void getAllProduct() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Advertisement advertisement = new Advertisement();
		advertisement.setId(1L);
		advertisement.setCreatedAt(new Date());
		advertisement.setDescription("test");
		advertisement.setOwner("altaf");
		advertisement.setPrice(10L);
		advertisement.setProductName("test");
		List<Advertisement> listOfAdvertisement = new ArrayList<>();
		listOfAdvertisement.add(advertisement);
		when(advertisementRepository.findAll()).thenReturn(listOfAdvertisement);
		advertisementServiceimpl.getAllProduct(apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
	
	
	@Test
	public void getAllProductsByQuery() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Advertisement advertisement = new Advertisement();
		String query="test";
		advertisement.setId(1L);
		advertisement.setCreatedAt(new Date());
		advertisement.setDescription("test");
		advertisement.setOwner("altaf");
		advertisement.setPrice(10L);
		advertisement.setProductName("test");
		List<Advertisement> listOfAdvertisement = new ArrayList<>();
		listOfAdvertisement.add(advertisement);
		when(advertisementRepository.findByCategoryNameContaining(query)).thenReturn(listOfAdvertisement);
		advertisementServiceimpl.getAllProducts(apiResponseDtoBuilder, query);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
	
	@Test
	public void getAllProductBySellerId() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		long sellerId=0;
		advertisementServiceimpl.getAllProductBySellerId(apiResponseDtoBuilder, sellerId);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("Seller Not Found !"));
	}
	
	@Test
	public void getAllProductsWithLikeAndSaveStatus() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		User sessionUser = new User();
		sessionUser.setActive(true);
		sessionUser.setEmail("test");
		sessionUser.setFullName("test");
		sessionUser.setId(1l);
		sessionUser.setRole(0);
		sessionUser.setPassword("1221332131");
		sessionUser.setMobileNumber("121213231314234232");
		sessionUser.setActive(true);
		sessionUser.setProfileImage("test");
		sessionUser.setCreatedAt(new Date());
		sessionUser.setUpdatedAt(new Date());
		when(Utility.getSessionUser(userRepository)).thenReturn(sessionUser);
		advertisementServiceimpl.getAllProductsWithLikeAndSaveStatus(apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
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
		advertisementServiceimpl.likeAndDislike(likeDto, apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}


	@Test
	public void savePost() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		PostSaveDto savedDto = new PostSaveDto();
		savedDto.setBuyerId(1L);
		savedDto.setProductId(1L);
		PostSave saved = new PostSave();
		saved.setId(1L);
		saved.setCreatedAt(new Date());
		saved.setBuyerId(1L);
		saved.setProductId(1L);
		when(mapper.saveDtoToSaved(savedDto)).thenReturn(saved);
		when(saveRepository.save(saved)).thenReturn(saved);
		advertisementServiceimpl.saveAndUnSavePost(savedDto, apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));

	}
	
	
	@Test
	public void getAllProductbyOrder() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		int byOrder=0;
		Advertisement advertisement = new Advertisement();
		advertisement.setId(1L);
		advertisement.setCreatedAt(new Date());
		advertisement.setDescription("test");
		advertisement.setOwner("altaf");
		advertisement.setPrice(10L);
		advertisement.setProductName("test");
		List<Advertisement> listOfAdvertisement = new ArrayList<>();
		listOfAdvertisement.add(advertisement);
		when(advertisementRepository.findByOrderByPriceAsc()).thenReturn(listOfAdvertisement);
		advertisementServiceimpl.getAllProductbyOrder(byOrder, apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
	
	
	@Test
	public void getAllProductbyLocation() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		String location="test";
		Advertisement advertisement = new Advertisement();
		advertisement.setId(1L);
		advertisement.setCreatedAt(new Date());
		advertisement.setDescription("test");
		advertisement.setOwner("altaf");
		advertisement.setPrice(10L);
		advertisement.setProductName("test");
		List<Advertisement> listOfAdvertisement = new ArrayList<>();
		listOfAdvertisement.add(advertisement);
		when(advertisementRepository.findByAddressContaining("test")).thenReturn(listOfAdvertisement);
		advertisementServiceimpl.getAllProductbyLocation(location, apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}

}