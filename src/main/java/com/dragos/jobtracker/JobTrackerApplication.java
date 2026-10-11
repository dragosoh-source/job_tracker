package com.dragos.jobtracker;

import com.dragos.jobtracker.model.JobApplication;
import com.dragos.jobtracker.repository.JobApplicationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class JobTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobTrackerApplication.class, args);
    }
    @Bean
    CommandLineRunner demo(JobApplicationRepository repo)
    {
        return args ->
        {
            JobApplication JobApplication1=new JobApplication();
            JobApplication1.setCompanyName("BRD");
            JobApplication1.setPosition("Intern");
            JobApplication1.setApplicationDate(LocalDate.now());
            JobApplication1.setStatus("Pending");
            repo.save(JobApplication1);
            for(JobApplication a : repo.findAll())
            {
                System.out.println(a.getCompanyName());
                System.out.println(a.getPosition());
                System.out.println(a.getApplicationDate());
                System.out.println(a.getStatus());
                System.out.println();
            }
        };
    }
}
