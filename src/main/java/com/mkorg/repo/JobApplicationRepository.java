package com.mkorg.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkorg.entity.JobApplication;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Serializable> {

}
