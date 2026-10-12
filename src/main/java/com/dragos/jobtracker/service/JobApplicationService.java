package com.dragos.jobtracker.service;

import com.dragos.jobtracker.model.JobApplication;
import com.dragos.jobtracker.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service

public class JobApplicationService {
    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }
    public List<JobApplication> getAll()
    {
        return repository.findAll();
    }
    public JobApplication getById(Long id)
    {
        return repository.findById(id).orElseThrow();
    }
    public JobApplication save(JobApplication application)
    {
        return repository.save(application);
    }
    public void delete(Long id)
    {
        if(!repository.existsById(id))//existsById returns true or false
        {
            throw new NoSuchElementException("Application not found:"+id);
        }
        repository.deleteById(id);
    }
}

