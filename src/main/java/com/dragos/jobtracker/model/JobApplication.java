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
    public void setId(long new_id)
    {
        id=new_id;
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
    public void setStatus(String new_status)
    {
        status=new_status;
    }

    public long getId()
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
    public String getStatus()
    {
        return status;
    }
    public void compactSentence()
    {
        System.out.print("Applied at the company:"+companyName+" for the postion:"+position+" at the date:" +
                applicationDate+" with the status:"+status);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
