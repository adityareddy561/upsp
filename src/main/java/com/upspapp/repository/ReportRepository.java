package com.upspapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upspapp.modal.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

}
