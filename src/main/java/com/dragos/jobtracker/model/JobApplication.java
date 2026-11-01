package com.dragos.jobtracker.model;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;



@Entity
 public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Company is required")
    private String companyName;

    @NotBlank(message ="Position is required")
    private String position;

    @NotNull(message ="Date is required") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate applicationDate;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    public void setId(Long id) {
        this.id = id;
    }
    public void setCompanyName(String new_companyName)
    {
        companyName=new_companyName;
    }
    public void setPosition(String new_setPosition)
    {
        position=new_setPosition;
    }
    public void setApplicationDate(LocalDate new_applicationDate) {
        applicationDate = new_applicationDate;
    }
    public void setStatus(ApplicationStatus new_status)
    {
        status=new_status;
    }

    public Long getId()
    {
        return id;
    }
    public String getCompanyName()
    {
        return companyName;
    }
    public String getPosition()
    {
        return position;
    }
    public LocalDate getApplicationDate()
    {
        return applicationDate;
    }
    public ApplicationStatus getStatus()
    {
        return status;
    }



}
