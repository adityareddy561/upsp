package com.upspapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upspapp.modal.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer,Long> {

	boolean existsByMobileNumber(String mobileNumber);

	boolean existsByEmail(String email);

	Buyer findByEmail(String email);

}
