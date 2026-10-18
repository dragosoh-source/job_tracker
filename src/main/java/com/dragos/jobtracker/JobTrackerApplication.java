package com.dragos.jobtracker;

import com.dragos.jobtracker.model.JobApplication;
import com.dragos.jobtracker.repository.JobApplicationRepository;
import com.dragos.jobtracker.service.JobApplicationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@SpringBootApplication
public class JobTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobTrackerApplication.class, args);
    }
    
}
