package com.upspapp.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
import com.upspapp.service.IAdvertisementService;
import com.upspapp.utility.Utility;

@Service
public class AdvertisementServiceimpl implements IAdvertisementService {

	@Autowired
	private AdvertisementRepository advertisementRepository;

	@Autowired
	private SaveRepository saveRepository;

	@Autowired
	private UserRepository repository;

	@Autowired
	private LikeRepository likeRepository;

	@Autowired
	private CustomMapper mapper;

	@Override
	public void addProduct(ApiResponseDtoBuilder builder, AdvertisementDto advertisementDto) {
		User sessionUser = Utility.getSessionUser(repository);
		if (sessionUser == null) {
			builder.withStatus(HttpStatus.UNAUTHORIZED).withMessage("Unauthorized");
		}
		advertisementDto.setSellerId(sessionUser.getId());
		Advertisement advertisement = mapper.advertisementDtoToAdvertisement(advertisementDto);
		advertisement.setCreatedAt(new Date());
		advertisementRepository.save(advertisement);
		builder.withData(advertisement).withStatus(HttpStatus.OK).withMessage(Constants.ADD_PRODUCT);
	}

	@Override
	public void getProductById(long id, ApiResponseDtoBuilder builder) {
		Optional<Advertisement> Advertisement = advertisementRepository.findById(id);
		if (Advertisement.isPresent()) {
			builder.withData(Advertisement.get()).withMessage("success").withStatus(HttpStatus.OK);
		} else {
			builder.withMessage(Constants.PRODUCT_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void updateProductById(ApiResponseDtoBuilder builder, Advertisement advertisement) {
		Optional<Advertisement> optionalAdvertisement = advertisementRepository.findById(advertisement.getId());
		if (optionalAdvertisement.isPresent()) {
			Advertisement advertisement2 = optionalAdvertisement.get();
			advertisement2.setDescription(advertisement.getDescription());
			advertisement2.setImage(advertisement.getImage());
			advertisement2.setOwner(advertisement.getOwner());
			advertisement2.setPrice(advertisement.getPrice());
			advertisement2.setProductName(advertisement.getProductName());
			advertisement2.setUpdatedAt(new Date());
			advertisementRepository.save(advertisement2);
			builder.withMessage(Constants.UPDATE_PRODUCT).withStatus(HttpStatus.OK);
		} else {
			builder.withMessage(Constants.PRODUCT_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void getAllProduct(ApiResponseDtoBuilder builder) {
		List<Advertisement> listOfProduct = advertisementRepository.findAll();
		builder.withData(listOfProduct).withMessage("success").withStatus(HttpStatus.OK);
	}

	@Override
	public void likeAndDislike(PostLikeDto dto, ApiResponseDtoBuilder builder) {
		if (likeRepository.existsByBuyerIdAndProductId(dto.getBuyerId(), dto.getProductId())) {
			likeRepository.deleteByBuyerIdAndProductId(dto.getBuyerId(), dto.getProductId());
			builder.withMessage("success").withStatus(HttpStatus.OK);
			return;
		}
		PostLike likes = mapper.likeDtoToLikes(dto);
		likes.setCreatedAt(new Date());
		likeRepository.save(likes);
		builder.withMessage("success").withStatus(HttpStatus.OK);
	}

	@Override
	public void saveAndUnSavePost(PostSaveDto dto, ApiResponseDtoBuilder builder) {
		if (saveRepository.existsByBuyerIdAndProductId(dto.getBuyerId(), dto.getProductId())) {
			saveRepository.deleteByBuyerIdAndProductId(dto.getBuyerId(), dto.getProductId());
			builder.withMessage("success").withStatus(HttpStatus.OK);
			return;
		}
		PostSave savedDto = mapper.saveDtoToSaved(dto);
		savedDto.setCreatedAt(new Date());
		saveRepository.save(savedDto);
		builder.withMessage("success").withStatus(HttpStatus.OK);
	}

	@Override
	public void getAllProductbyOrder(int byOrder, ApiResponseDtoBuilder builder) {
		if (byOrder == 0) {
			List<Advertisement> listOfProduct = advertisementRepository.findByOrderByPriceAsc();
			builder.withData(listOfProduct).withStatus(HttpStatus.OK);
		}
		if (byOrder == 1) {
			List<Advertisement> listOfProduct = advertisementRepository.findByOrderByPriceDesc();
			builder.withData(listOfProduct).withStatus(HttpStatus.OK);
		}
	}

	@Override
	public void getAllProductBySellerId(ApiResponseDtoBuilder builder, long sellerId) {
		if (advertisementRepository.existsBySellerId(sellerId)) {
			List<Advertisement> listOfProduct = advertisementRepository.findAllBySellerId(sellerId);
			builder.withData(listOfProduct).withMessage("success").withStatus(HttpStatus.OK);
		} else {
			builder.withMessage(Constants.SELLER_NOT_FOUND).withStatus(HttpStatus.OK);
		}
	}

	@Override
	public void getAllProducts(ApiResponseDtoBuilder builder, String query) {
		List<Advertisement> listOfCategory = advertisementRepository.findByCategoryNameContaining(query);
		builder.withData(listOfCategory).withStatus(HttpStatus.OK).withMessage("success");

	}
}
