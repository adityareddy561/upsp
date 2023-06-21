package com.upspapp.repository;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upspapp.modal.VerificationToken;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

	VerificationToken findByToken(String token);

	VerificationToken findByUserId(Long userId);

	Stream<VerificationToken> findAllByExpiryDateLessThan(Date now);

	void deleteByExpiryDateLessThan(Date now);

	VerificationToken findFirstByUserIdAndTokenOrderByCreatedAtDesc(Long id, String token);

	VerificationToken findFirstByUserIdAndOtpOrderByCreatedAtDesc(Long userId, String otp);

	VerificationToken findByUserIdAndOtp(Long userId, String otp);
}
