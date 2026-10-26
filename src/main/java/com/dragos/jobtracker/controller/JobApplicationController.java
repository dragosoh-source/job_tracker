package com.dragos.jobtracker.controller;
import com.dragos.jobtracker.model.ApplicationStatus;
import com.dragos.jobtracker.model.JobApplication;
import jakarta.validation.Valid;
import org.springframework.ui.Model;

import com.dragos.jobtracker.service.JobApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.NoSuchElementException;

@Controller
public class JobApplicationController {
    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }
    @GetMapping("/applications")
    public String list(Model model)
    {
        model.addAttribute("applications",service.getAll());
        return "applications";
    }

    @GetMapping("/applications/new")
    public String showCreateForm(Model model)
    {
        model.addAttribute("jobApplication",new JobApplication());
        return "application-form";
    }
    @PostMapping("/applications")
    public String saveForm(@Valid @ModelAttribute JobApplication jobApplication, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "application-form";
        }
        service.save(jobApplication);
        return "redirect:/applications";
    }
    @PostMapping("/applications/{id}/delete")
    public String deleteApplication(@PathVariable Long id)
    {
        try {
            service.delete(id);
        }catch (NoSuchElementException e) {

        }
        return "redirect:/applications";
    }
    @GetMapping("/applications/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model)
    {
                model.addAttribute("jobApplication",service.getById(id));
                return "application-form";
    }
    @PostMapping("/applications/{id}/update")
    public String updateApplication(@PathVariable Long id,@Valid @ModelAttribute JobApplication jobApplication,BindingResult result)
    {

        jobApplication.setId(id);
        if(result.hasErrors())
        {
            return "application-form";
        }
        service.save(jobApplication);
        return "redirect:/applications";
    }

    @ModelAttribute("statuses")
    public ApplicationStatus[] statuses()
    {
        return ApplicationStatus.values();
    }

}
