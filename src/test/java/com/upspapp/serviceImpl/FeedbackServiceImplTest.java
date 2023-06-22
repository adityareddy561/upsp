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
import com.upspapp.modal.Feedback;
import com.upspapp.repository.BuyerRepository;
import com.upspapp.repository.FeedbackRepository;
import com.upspapp.requestDto.FeedbackDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;

@ExtendWith(MockitoExtension.class)
public class FeedbackServiceImplTest {

	@InjectMocks
	FeedbackServiceImpl feedbackServiceImpl;

	@Mock
	private CustomMapper mapper;

	@Mock
	private FeedbackRepository feedbackRepository;

	@Mock
	private BuyerRepository buyerRepository;
	
	@Test
	public void addFeedback() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		FeedbackDto feedbackDto = new FeedbackDto();
		feedbackDto.setBuyerId(1L);
		feedbackDto.setQuery("test");
		Feedback feedback = new Feedback();
		feedback.setBuyerId(1L);
		feedback.setQuery("test");
		feedback.setCreatedAt(new Date());
		feedback.setId(1L);
		when(buyerRepository.existsById(feedbackDto.getBuyerId())).thenReturn(true);
		when(mapper.feedbackDtoToFeedback(feedbackDto)).thenReturn(feedback);
		feedbackServiceImpl.addFeedback(apiResponseDtoBuilder, feedbackDto);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.ADD_FEEDBACK));
	}

	@Test
	public void getAllFeedback() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Feedback feedback = new Feedback();
		feedback.setCreatedAt(new Date());
		feedback.setBuyerId(1L);
		feedback.setId(1L);
		feedback.setQuery("test");
		List<Feedback> listOfFeedbacks = new ArrayList<Feedback>();
		listOfFeedbacks.add(feedback);
		when(feedbackRepository.findAll()).thenReturn(listOfFeedbacks);
		feedbackServiceImpl.getAllFeedback(apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
}
