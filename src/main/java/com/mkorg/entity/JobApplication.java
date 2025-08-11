package com.mkorg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class JobApplication {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateName;
    private String email;
    private String resumeLink;
    private String status; // e.g., Applied, Interviewing, Hired
}
