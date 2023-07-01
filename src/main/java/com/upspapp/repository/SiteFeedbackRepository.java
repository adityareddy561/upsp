package com.upspapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upspapp.modal.SiteFeedback;

@Repository
public interface SiteFeedbackRepository extends JpaRepository<SiteFeedback, Long> {


}
