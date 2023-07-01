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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.upspapp.constants.Constants;
import com.upspapp.customMapper.CustomMapper;
import com.upspapp.modal.Buyer;
import com.upspapp.modal.Seller;
import com.upspapp.modal.User;
import com.upspapp.repository.BuyerRepository;
import com.upspapp.repository.SellerRepository;
import com.upspapp.repository.UserRepository;
import com.upspapp.requestDto.ChangePasswordDto;
import com.upspapp.requestDto.UserDto;
import com.upspapp.responseDto.ApiResponseDto.ApiResponseDtoBuilder;
import com.upspapp.service.IEmailService;
import com.upspapp.service.IVerificationTokenService;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	@Mock
	CustomMapper customMapper;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Mock
	private UserRepository userRepository;

	@Mock
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Mock
	private SellerRepository sellerRepository;

	@Mock
	private BuyerRepository buyerRepository;
	
	@Mock
	private IEmailService emailService;
	
	@Mock
	private IVerificationTokenService verificationTokenService;
	

	@Test
	public void addAdmin() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		
		UserDto userDto=new UserDto();
		userDto.setActive(true);
		userDto.setEmail("testadmin@gmail.com");
		userDto.setFullName("Test Admin");
		userDto.setMobileNumber("11111111");
		userDto.setPassword("12345");
		
		User user=new User();
		user.setId(1L);
		user.setRole(0);
		user.setActive(true);
		user.setEmail("testadmin@gmail.com");
		user.setFullName("Test Admin");
		user.setMobileNumber("11111111");
		user.setPassword("12345");
		user.setCreatedAt(new Date());
		when(customMapper.userDtoToUser(userDto)).thenReturn(user);
		when(userRepository.save(user)).thenReturn(user);
		userServiceImpl.addAdmin(apiResponseDtoBuilder, userDto);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.ADD_ADMIN));
		
	}

	@Test
	public void addUser() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		
		UserDto userDto=new UserDto();
		userDto.setActive(true);
		userDto.setEmail("testadmin@gmail.com");
		userDto.setFullName("Test Admin");
		userDto.setMobileNumber("11111111");
		userDto.setPassword("12345");
		userDto.setProfileImage("profile");
		userDto.setUserType("user");
		Buyer buyer=new Buyer();
		buyer.setId(2L);
		buyer.setRole(2);
		buyer.setActive(true);
		buyer.setEmail("testbuyer@gmail.com");
		buyer.setFullName("Test buyer");
		buyer.setMobileNumber("22222222");
		buyer.setPassword("12345");
		buyer.setCreatedAt(new Date());
		userServiceImpl.addUser(apiResponseDtoBuilder, userDto);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("Wrong user type"));
		
	}
	

	
	@Test
	public void updateSellerById() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();

		Seller seller = new Seller();
		seller.setFullName("Test seller");
		seller.setEmail("testseller@gmail.com");
		seller.setMobileNumber("9999999999");
		seller.setPassword(bCryptPasswordEncoder.encode("12345678"));
		seller.setId(3L);
		seller.setCreatedAt(new Date());
		Optional<Seller> optional = Optional.of(seller);
		when(sellerRepository.findById(seller.getId())).thenReturn(optional);
		assertTrue(optional.isPresent());
		when(sellerRepository.save(seller)).thenReturn(seller);
		userServiceImpl.updateSellerById(seller, apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.UPDATE_SELLER));
	}
	
	@Test
	public void deleteSellerById() {
		long id = 3L;
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();

		Seller seller = new Seller();
		seller.setFullName("Test seller");
		seller.setEmail("testseller@gmail.com");
		seller.setMobileNumber("9999999999");
		seller.setPassword(bCryptPasswordEncoder.encode("12345678"));
		seller.setId(id);
		Optional<Seller> optional = Optional.of(seller);
		when(sellerRepository.findById(id)).thenReturn(optional);
		assertTrue(optional.isPresent());
		userServiceImpl.deleteSellerById(apiResponseDtoBuilder, id);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.DELETE_SELLER));
	}
	
	
	@Test
	public void getSellerById() {
		long id = 3L;
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Seller seller = new Seller();
		seller.setFullName("Test seller");
		seller.setEmail("testseller@gmail.com");
		seller.setMobileNumber("9999999999");
		seller.setPassword(bCryptPasswordEncoder.encode("12345678"));
		seller.setId(id);
		Optional<Seller> optional = Optional.of(seller);
		when(sellerRepository.findById(id)).thenReturn(optional);
		assertTrue(optional.isPresent());
		userServiceImpl.getSellerById(apiResponseDtoBuilder, id);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
	
	@Test
	public void getAllSeller() {
		long id = 3L;
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Seller seller = new Seller();
		seller.setFullName("Test seller");
		seller.setEmail("testseller@gmail.com");
		seller.setMobileNumber("9999999999");
		seller.setPassword(bCryptPasswordEncoder.encode("12345678"));
		seller.setId(id);
		List<Seller> listOfSeller = new ArrayList<>();
		listOfSeller.add(seller);
		when(sellerRepository.findAll()).thenReturn(listOfSeller);
		userServiceImpl.getAllSeller(apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
	
	
	@Test
	public void updateBuyerById() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();

		Buyer buyer = new Buyer();
		buyer.setFullName("Test buyer");
		buyer.setEmail("testbuyer@gmail.com");
		buyer.setMobileNumber("9999999999");
		buyer.setPassword(bCryptPasswordEncoder.encode("12345678"));
		buyer.setId(2L);
		buyer.setUpdatedAt(new Date());
		Optional<Buyer> optional = Optional.of(buyer);
		when(buyerRepository.findById(buyer.getId())).thenReturn(optional);
		assertTrue(optional.isPresent());
		when(buyerRepository.save(buyer)).thenReturn(buyer);
		userServiceImpl.updateBuyerById(buyer, apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.UPDATE_BUYER));
	}
	
	
	@Test
	public void updateUser() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();

		User user = new User();
		user.setFullName("Test buyer");
		user.setEmail("testbuyer@gmail.com");
		user.setMobileNumber("9999999999");
		user.setPassword(bCryptPasswordEncoder.encode("12345678"));
		user.setId(2L);
		user.setUpdatedAt(new Date());
		Optional<User> optional = Optional.of(user);
		when(userRepository.findById(user.getId())).thenReturn(optional);
		assertTrue(optional.isPresent());
		when(userRepository.save(user)).thenReturn(user);
		userServiceImpl.updateUser (apiResponseDtoBuilder,user);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
	
	@Test
	public void getUserById() {
		long id = 1L;
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		User user = new User();
		user.setFullName("Test buyer");
		user.setEmail("testbuyer@gmail.com");
		user.setMobileNumber("9999999999");
		user.setPassword(bCryptPasswordEncoder.encode("12345678"));
		user.setId(1L);
		user.setUpdatedAt(new Date());
		Optional<User> optional = Optional.of(user);
		when(userRepository.findById(user.getId())).thenReturn(optional);
		assertTrue(optional.isPresent());
		userServiceImpl.getUserById(apiResponseDtoBuilder, id);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
	
	@Test
	public void deleteBuyerById() {
		long id = 3L;
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();

		Buyer buyer = new Buyer();
		buyer.setFullName("Test buyer");
		buyer.setEmail("testbuyer@gmail.com");
		buyer.setMobileNumber("9999999999");
		buyer.setPassword(bCryptPasswordEncoder.encode("12345678"));
		buyer.setId(2L);
		Optional<Buyer> optional = Optional.of(buyer);
		when(buyerRepository.findById(id)).thenReturn(optional);
		assertTrue(optional.isPresent());
		userServiceImpl.deleteBuyerById(apiResponseDtoBuilder, id);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.DELETE_BUYER));
	}
	
	@Test
	public void getBuyerById() {
		long id = 3L;
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Buyer buyer = new Buyer();
		buyer.setFullName("Test seller");
		buyer.setEmail("testbuyer@gmail.com");
		buyer.setMobileNumber("9999999999");
		buyer.setPassword(bCryptPasswordEncoder.encode("12345678"));
		buyer.setId(id);
		Optional<Buyer> optional = Optional.of(buyer);
		when(buyerRepository.findById(id)).thenReturn(optional);
		assertTrue(optional.isPresent());
		userServiceImpl.getBuyerById(apiResponseDtoBuilder, id);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
	
	
	@Test
	public void getAllBuyer() {
		long id = 3L;
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		Buyer buyer = new Buyer();
		buyer.setFullName("Test seller");
		buyer.setEmail("testbuyer@gmail.com");
		buyer.setMobileNumber("9999999999");
		buyer.setPassword(bCryptPasswordEncoder.encode("12345678"));
		buyer.setId(id);
		List<Buyer> listOfBuyer = new ArrayList<>();
		listOfBuyer.add(buyer);
		when(buyerRepository.findAll()).thenReturn(listOfBuyer);
		userServiceImpl.getAllBuyer(apiResponseDtoBuilder);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("success"));
	}
	
	@Test
	public void updatePasswordById() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		ChangePasswordDto passwordDto=new ChangePasswordDto();
		passwordDto.setId(1L);
		passwordDto.setNewPassword("test");
		User user = new User();
		user.setFullName("Test seller");
		user.setEmail("testseller@gmail.com");
		user.setMobileNumber("9999999999");
		user.setPassword(bCryptPasswordEncoder.encode("12345678"));
		user.setId(1L);
		Optional<User> optional = Optional.of(user);
		when(userRepository.findById(passwordDto.getId())).thenReturn(optional);
		userServiceImpl.updatePasswordById(apiResponseDtoBuilder, passwordDto);
		assertTrue(apiResponseDtoBuilder.getMessage().equals(Constants.PASSWORD_CHANGED));
	}
	
	@Test
	public void addFriend() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		String email="teamupspapp@gmail.com";
		long id =2L;
		when(sellerRepository.existsById(id)||buyerRepository.existsById(id)).thenReturn(true);
		userServiceImpl.addFriend(apiResponseDtoBuilder, email);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("Refer your Friend Successfully"));
	}
	
	@Test
	public void forgotPassword() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		String email="testadmin@gmail.com";
		userServiceImpl.forgotPassword(apiResponseDtoBuilder, email);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("User Not Found !"));
	}
	
	@Test
	public void sharePost() {
		ApiResponseDtoBuilder apiResponseDtoBuilder = new ApiResponseDtoBuilder();
		String email="teamupspapp@gmail.com";
		long id =0L;
		long pId=0l;
		userServiceImpl.sharePost(apiResponseDtoBuilder, email, id, pId);
		assertTrue(apiResponseDtoBuilder.getMessage().equals("User Not Found !"));
	}
}
