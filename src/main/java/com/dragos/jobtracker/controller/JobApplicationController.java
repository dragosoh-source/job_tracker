package com.dragos.jobtracker.controller;
import org.springframework.ui.Model;

import com.dragos.jobtracker.service.JobApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
