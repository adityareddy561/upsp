package com.upspapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upspapp.modal.Advertisement;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

	List<Advertisement> findByOrderByPriceAsc();

	List<Advertisement> findByOrderByPriceDesc();

	boolean existsBySellerId(long sellerId);

	List<Advertisement> findAllBySellerId(long sellerId);

	List<Advertisement> findByCategoryNameContaining(String query);

	List<Advertisement> findByAddressContaining(String location);

	List<Advertisement> findBySellerId(Long id);

}
