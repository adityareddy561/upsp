package com.upspapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upspapp.modal.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

	Offer findByProductId(long productId);

	boolean existsByProductId(Long id);

}
