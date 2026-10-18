package com.dragos.jobtracker.controller;
import com.dragos.jobtracker.model.JobApplication;
import org.springframework.ui.Model;

import com.dragos.jobtracker.service.JobApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("application",new JobApplication());
        return "application-form";
    }
    @PostMapping("/applications")
    public String saveForm(@ModelAttribute JobApplication model)
    {
        service.save(model);
        return "redirect:/applications";
    }


}
