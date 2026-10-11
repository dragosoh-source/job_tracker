package com.dragos.jobtracker.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
 public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String companyName;
    String position;
    LocalDate applicationDate;
    String status;
    void setId(long new_id)
    {
        id=new_id;
    }
    void setCompanyName(String new_companyName)
    {
        companyName=new_companyName;
    }
    void setPosition(String new_setPosition)
    {
        position=new_setPosition;
    }
    void setApplicationDate(LocalDate new_applicationDate) {
        applicationDate = new_applicationDate;
    }
    void setStatus(String new_status)
    {
        status=new_status;
    }

    long getId()
    {
        return id;
    }
    String getCompanyName()
    {
        return companyName;
    }
    String getPosition()
    {
        return position;
    }
    LocalDate getApplicationDate()
    {
        return applicationDate;
    }
    String getStatus()
    {
        return status;
    }
    void compactSentence()
    {
        System.out.print("Applied at the company:"+companyName+" for the postion:"+position+" at the date:" +
                applicationDate+" with the status:"+status);
    }

}
