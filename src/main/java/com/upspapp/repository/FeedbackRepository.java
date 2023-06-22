package com.upspapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upspapp.modal.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {


}
