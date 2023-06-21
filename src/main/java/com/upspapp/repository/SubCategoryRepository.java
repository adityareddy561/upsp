package com.upspapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upspapp.modal.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory , Long> {

	 List<SubCategory> findAllByCategoryId(long categoryId);

}
