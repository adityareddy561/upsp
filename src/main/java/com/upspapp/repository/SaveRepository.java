package com.upspapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upspapp.modal.PostSave;


@Repository
@Transactional
public interface SaveRepository extends JpaRepository<PostSave, Long> {

	boolean existsByBuyerIdAndProductId(Long customerId, Long productId);

	void deleteByBuyerIdAndProductId(Long customerId, Long productId);

}
