package com.upspapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upspapp.modal.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

	boolean existsByMobileNumber(String mobileNumber);

	boolean existsByEmail(String email);

	Seller findByEmail(String email);

}
