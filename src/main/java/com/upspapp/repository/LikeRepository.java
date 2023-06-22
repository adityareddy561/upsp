package com.upspapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upspapp.modal.PostLike;

@Repository
@Transactional
public interface LikeRepository extends JpaRepository<PostLike, Long> {

	void deleteByBuyerIdAndProductId(Long customerId, Long productId);

	boolean existsByBuyerIdAndProductId(Long customerId, Long productId);

}
