package com.upspapp.customMapper;

import org.mapstruct.Mapper;

import com.upspapp.modal.Advertisement;
import com.upspapp.modal.Buyer;
import com.upspapp.modal.Category;
import com.upspapp.modal.Feedback;
import com.upspapp.modal.PostLike;
import com.upspapp.modal.PostSave;
import com.upspapp.modal.Seller;
import com.upspapp.modal.SubCategory;
import com.upspapp.modal.User;
import com.upspapp.requestDto.AdvertisementDto;
import com.upspapp.requestDto.CategoryDto;
import com.upspapp.requestDto.FeedbackDto;
import com.upspapp.requestDto.PostLikeDto;
import com.upspapp.requestDto.PostSaveDto;
import com.upspapp.requestDto.SubCategoryDto;
import com.upspapp.requestDto.UserDto;

@Mapper(componentModel = "spring")
public interface CustomMapper {


	User userDtoToUser(UserDto dto);

	Advertisement advertisementDtoToAdvertisement(AdvertisementDto advertisementDto);

	Category categoryDtoToCategory(CategoryDto dto);

	SubCategory subCategoryDtoToSubCategory(SubCategoryDto dto);

	Feedback feedbackDtoToFeedback(FeedbackDto dto);

	PostLike likeDtoToLikes(PostLikeDto dto);

	PostSave saveDtoToSaved(PostSaveDto dto);

	Buyer userDtoToBuyer(UserDto userDto);

	Seller userDtoToSeller(UserDto dto);

	

}
