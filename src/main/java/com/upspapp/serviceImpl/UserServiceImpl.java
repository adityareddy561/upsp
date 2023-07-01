package com.upspapp.serviceImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
import com.upspapp.service.IUserService;
import com.upspapp.service.IVerificationTokenService;
import com.upspapp.utility.Utility;

@Service("userService")
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private SellerRepository sellerRepository;

	@Autowired
	private BuyerRepository buyerRepository;

	@Autowired
	private CustomMapper mapper;

	@Autowired
	private IEmailService emailService;

	@Autowired
	private IVerificationTokenService verificationTokenService;

	@Override
	public void addAdmin(ApiResponseDtoBuilder builder, UserDto dto) {
		if (repository.existsByMobileNumber(dto.getMobileNumber())) {
			builder.withMessage(Constants.MOBLIE_NUMBERALREADY_EXISTS).withStatus(HttpStatus.ALREADY_REPORTED);
		} else if (repository.existsByEmail(dto.getEmail())) {
			builder.withMessage(Constants.EMAIL_ALREADY_EXISTS).withStatus(HttpStatus.ALREADY_REPORTED);
		} else {
			User userDtoToUser = mapper.userDtoToUser(dto);
			String newPasswordEncodedString = bCryptPasswordEncoder.encode(dto.getPassword());
			userDtoToUser.setPassword(newPasswordEncodedString);
			userDtoToUser.setRole(0);
			userDtoToUser.setCreatedAt(new Date());
			repository.save(userDtoToUser);
			builder.withMessage(Constants.ADD_ADMIN).withStatus(HttpStatus.OK).withData(userDtoToUser);
			verificationTokenService.sendVerificationToken(userDtoToUser, dto.getPassword());
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByMobileNumberOrEmail(username, username);
		if (user == null) {
			throw new UsernameNotFoundException(Constants.INVALID_USERNAME_OR_PASSWORD);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public void addUser(ApiResponseDtoBuilder builder, UserDto dto) {
		if (dto.getUserType().equalsIgnoreCase("seller")) {
			if (sellerRepository.existsByMobileNumber(dto.getMobileNumber())
					|| repository.existsByMobileNumber(dto.getMobileNumber())) {
				builder.withMessage(Constants.MOBLIE_NUMBERALREADY_EXISTS).withStatus(HttpStatus.ALREADY_REPORTED);
				return;
			} else if (sellerRepository.existsByEmail(dto.getEmail()) || repository.existsByEmail(dto.getEmail())) {
				builder.withMessage(Constants.EMAIL_ALREADY_EXISTS).withStatus(HttpStatus.ALREADY_REPORTED);
				return;
			}
			Seller seller = mapper.userDtoToSeller(dto);
			seller.setRole(1);
			String newPasswordEncodedString = bCryptPasswordEncoder.encode(dto.getPassword());
			seller.setPassword(newPasswordEncodedString);
			sellerRepository.save(seller);
			builder.withData(seller).withMessage("success").withStatus(HttpStatus.OK);
			verificationTokenService.sendVerificationToken(seller, dto.getPassword());
			return;
		}

		if (dto.getUserType().equalsIgnoreCase("buyer")) {
			if (buyerRepository.existsByMobileNumber(dto.getMobileNumber())
					|| repository.existsByMobileNumber(dto.getMobileNumber())) {
				builder.withMessage(Constants.MOBLIE_NUMBERALREADY_EXISTS).withStatus(HttpStatus.ALREADY_REPORTED);
				return;
			} else if (buyerRepository.existsByEmail(dto.getEmail()) || repository.existsByEmail(dto.getEmail())) {
				builder.withMessage(Constants.EMAIL_ALREADY_EXISTS).withStatus(HttpStatus.ALREADY_REPORTED);
				return;
			}
			Buyer userDtoToBuyer = mapper.userDtoToBuyer(dto);
			userDtoToBuyer.setRole(2);
			String newPasswordEncodedString = bCryptPasswordEncoder.encode(dto.getPassword());
			userDtoToBuyer.setPassword(newPasswordEncodedString);
			buyerRepository.save(userDtoToBuyer);
			builder.withData(userDtoToBuyer).withMessage("success").withStatus(HttpStatus.OK);
			verificationTokenService.sendVerificationToken(userDtoToBuyer, dto.getPassword());
			return;
		}
		builder.withMessage("Wrong user type").withStatus(HttpStatus.OK);
	}

	@Override
	public void updateSellerById(Seller seller, ApiResponseDtoBuilder builder) {
		Optional<Seller> optionalSeller = sellerRepository.findById(seller.getId());
		if (optionalSeller.isPresent()) {
			Seller sellerEntity = optionalSeller.get();
			sellerEntity.setEmail(seller.getEmail());
			sellerEntity.setFullName(seller.getFullName());
			sellerEntity.setMobileNumber(seller.getMobileNumber());
			String newPasswordEncodedString = bCryptPasswordEncoder.encode(seller.getPassword());
			sellerEntity.setPassword(newPasswordEncodedString);
			sellerEntity.setUpdatedAt(new Date());
			sellerRepository.save(sellerEntity);
			builder.withMessage(Constants.UPDATE_SELLER).withStatus(HttpStatus.OK).withData(sellerEntity);
		} else {
			builder.withMessage(Constants.SELLER_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteSellerById(ApiResponseDtoBuilder builder, long id) {
		Optional<Seller> seller = sellerRepository.findById(id);
		if (seller.isPresent()) {
			sellerRepository.deleteById(id);
			builder.withMessage(Constants.DELETE_SELLER).withStatus(HttpStatus.OK);
		} else {
			builder.withMessage(Constants.SELLER_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void getSellerById(ApiResponseDtoBuilder builder, long id) {
		Optional<Seller> seller = sellerRepository.findById(id);
		if (seller.isPresent()) {
			builder.withMessage("success").withStatus(HttpStatus.OK).withData(seller.get());
		} else {
			builder.withMessage(Constants.SELLER_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void getAllSeller(ApiResponseDtoBuilder builder) {
		List<Seller> listOfSeller = sellerRepository.findAll();
		if (!listOfSeller.isEmpty()) {
			builder.withMessage("success").withStatus(HttpStatus.OK).withData(listOfSeller);
		} else {
			builder.withMessage(Constants.DATA_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void updatePasswordById(ApiResponseDtoBuilder builder, ChangePasswordDto changePasswordDto) {
		Optional<User> optionalUser = repository.findById(changePasswordDto.getId());
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setPassword(bCryptPasswordEncoder.encode(changePasswordDto.getNewPassword()));
			repository.save(user);
			builder.withMessage(Constants.PASSWORD_CHANGED).withStatus(HttpStatus.OK);
		} else {
			builder.withMessage(Constants.USER_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void addFriend(ApiResponseDtoBuilder apiResponseDtoBuilder, String email) {
		String link = "http://localhost:8080/homepage";
		emailService.sendEmail(email, "one of your friends refers you this website",
				"<html><body><a href=\"" + link + "\">Click here to visit the homepage</a></body></html>", "upsp", null,
				null);
		apiResponseDtoBuilder.withMessage("success").withStatus(HttpStatus.OK);
	}

	@Override
	public void addBuyer(ApiResponseDtoBuilder builder, UserDto userDto) {
		if (buyerRepository.existsByMobileNumber(userDto.getMobileNumber())
				|| repository.existsByMobileNumber(userDto.getMobileNumber())) {
			builder.withMessage(Constants.MOBLIE_NUMBERALREADY_EXISTS).withStatus(HttpStatus.ALREADY_REPORTED);
			return;
		} else if (buyerRepository.existsByEmail(userDto.getEmail()) || repository.existsByEmail(userDto.getEmail())) {
			builder.withMessage(Constants.EMAIL_ALREADY_EXISTS).withStatus(HttpStatus.ALREADY_REPORTED);
			return;
		}
		Buyer userDtoToBuyer = mapper.userDtoToBuyer(userDto);
		userDtoToBuyer.setRole(2);
		String newPasswordEncodedString = bCryptPasswordEncoder.encode(userDto.getPassword());
		userDtoToBuyer.setPassword(newPasswordEncodedString);
		buyerRepository.save(userDtoToBuyer);
		builder.withData(userDtoToBuyer).withMessage(Constants.ADD_BUYER).withStatus(HttpStatus.OK);
		verificationTokenService.sendVerificationToken(userDtoToBuyer, userDto.getPassword());

	}

	@Override
	public void updateBuyerById(Buyer buyer, ApiResponseDtoBuilder builder) {
		Optional<Buyer> optionalBuyer = buyerRepository.findById(buyer.getId());
		if (optionalBuyer.isPresent()) {
			Buyer buyerObj = optionalBuyer.get();
			buyerObj.setEmail(buyer.getEmail());
			buyerObj.setFullName(buyer.getFullName());
			buyerObj.setMobileNumber(buyer.getMobileNumber());
			String newPasswordEncodedString = bCryptPasswordEncoder.encode(buyer.getPassword());
			buyerObj.setPassword(newPasswordEncodedString);
			buyerObj.setUpdatedAt(new Date());
			buyerRepository.save(buyerObj);
			builder.withMessage(Constants.UPDATE_BUYER).withStatus(HttpStatus.OK).withData(buyerObj);
		} else {
			builder.withMessage(Constants.BUYER_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteBuyerById(ApiResponseDtoBuilder builder, long id) {
		Optional<Buyer> buyer = buyerRepository.findById(id);
		if (buyer.isPresent()) {
			buyerRepository.deleteById(id);
			builder.withMessage(Constants.DELETE_BUYER).withStatus(HttpStatus.OK);
		} else {
			builder.withMessage(Constants.BUYER_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void getBuyerById(ApiResponseDtoBuilder builder, long id) {
		Optional<Buyer> buyer = buyerRepository.findById(id);
		if (buyer.isPresent()) {
			builder.withMessage("success").withStatus(HttpStatus.OK).withData(buyer.get());
		} else {
			builder.withMessage(Constants.BUYER_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void getAllBuyer(ApiResponseDtoBuilder builder) {
		List<Buyer> listOfBuyer = buyerRepository.findAll();
		if (!listOfBuyer.isEmpty()) {
			builder.withMessage("success").withStatus(HttpStatus.OK).withData(listOfBuyer);
		} else {
			builder.withMessage(Constants.DATA_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void forgotPassword(ApiResponseDtoBuilder apiResponseDtoBuilder, String email) {
		if (repository.findByEmail(email) != null) {
			String password = Utility.generateRandomPassword(8);
			System.out.println(password);
			repository.findByEmail(email).setPassword(password);
			sendPass(apiResponseDtoBuilder, email, password);
		} else if (sellerRepository.findByEmail(email) != null) {
			String password = Utility.generateRandomPassword(8);
			System.out.println(password);
			sellerRepository.findByEmail(email).setPassword(password);
			sendPass(apiResponseDtoBuilder, email, password);
		} else if (buyerRepository.findByEmail(email) != null) {
			String password = Utility.generateRandomPassword(8);
			buyerRepository.findByEmail(email).setPassword(password);
			sendPass(apiResponseDtoBuilder, email, password);
		} else {
			apiResponseDtoBuilder.withMessage(Constants.USER_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}

	private void sendPass(ApiResponseDtoBuilder apiResponseDtoBuilder, String email, String password) {
		verificationTokenService.sendPassword(email, password);
		apiResponseDtoBuilder.withMessage(Constants.SUCCESSFULLY).withStatus(HttpStatus.OK);
	}

	@Override
	public void sharePost(ApiResponseDtoBuilder apiResponseDtoBuilder, String email, long id, long pid) {
		if (repository.existsById(id) || repository.existsById(id)) {
			new Thread(() -> {
				emailService.sendEmail(email, "Share Post With Friends", "http://localhost:8080/home",
						"UPSP-App-product.com", null, null);
			}).start();
			apiResponseDtoBuilder.withMessage("success").withStatus(HttpStatus.OK);
		} else {
			apiResponseDtoBuilder.withMessage(Constants.USER_NOT_FOUND).withStatus(HttpStatus.OK);
		}
	}

	@Override
	public void getUserById(ApiResponseDtoBuilder builder, long id) {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			builder.withMessage("success").withStatus(HttpStatus.OK).withData(user.get());
		} else {
			builder.withMessage(Constants.BUYER_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void updateUser(ApiResponseDtoBuilder builder, User user) {
		Optional<User> optionalUser = repository.findById(user.getId());
		if (optionalUser.isPresent()) {
			User userObj = optionalUser.get();
			userObj.setEmail(user.getEmail());
			userObj.setFullName(user.getFullName());
			userObj.setMobileNumber(user.getMobileNumber());
			// String newPasswordEncodedString =
			// bCryptPasswordEncoder.encode(user.getPassword());
			// userObj.setPassword(newPasswordEncodedString);
			userObj.setUpdatedAt(new Date());
			repository.save(userObj);
			builder.withMessage("success").withStatus(HttpStatus.OK).withData(userObj);
		} else {
			builder.withMessage(Constants.USER_NOT_FOUND).withStatus(HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public void getAllRoleBase(ApiResponseDtoBuilder builder, HttpServletRequest request) {
		User currentUser = repository.findByEmail(request.getSession().getAttribute("username").toString());
		if(currentUser.getRole()==1) {
			List<User> listOfBuyer = repository.findByRole(2);
			builder.withMessage("success").withStatus(HttpStatus.OK).withData(listOfBuyer);
			return ;
		}else if(currentUser.getRole()==2) {
			List<User> listOfBuyer = repository.findByRole(1);
			builder.withMessage("success").withStatus(HttpStatus.OK).withData(listOfBuyer);
			return ;
		}
		builder.withMessage("not found").withStatus(HttpStatus.OK);
		
	}
}
