package com.dragos.jobtracker.repository;

import com.dragos.jobtracker.model.ApplicationStatus;
import com.dragos.jobtracker.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface JobApplicationRepository extends JpaRepository<JobApplication,Long> {
    List<JobApplication> findByStatus(ApplicationStatus status);
}
