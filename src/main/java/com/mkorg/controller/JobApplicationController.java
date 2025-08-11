package com.mkorg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.mkorg.entity.JobApplication;
import com.mkorg.repo.JobApplicationRepository;

@RestController
@RequestMapping("/applications")
@Tag(name = "Job Application Tracker", description = "Component handling Job Applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationRepository repository;

    @Operation(summary = "Retrieve all job applications")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved applications"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }

    @Operation(summary = "Create a new job application")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Application created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public JobApplication createApplication(@RequestBody JobApplication application) {
        return repository.save(application);
    }

    @Operation(summary = "Update application status", description = "Update the status of an applicant based on ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Status updated successfully"),
        @ApiResponse(responseCode = "404", description = "Application not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping(value = "/{id}", consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public JobApplication updateStatus(@PathVariable Long id, @RequestBody JobApplication updated) {
        return repository.findById(id).map(app -> {
            app.setStatus(updated.getStatus());
            return repository.save(app);
        }).orElseThrow(() -> new RuntimeException("Application not found"));
    }

    @Operation(summary = "Delete an application", description = "Delete a job application based on ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Application deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Application not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
