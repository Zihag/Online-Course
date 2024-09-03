/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.controllers;

import com.htn.dto.EnrollmentRequest;
import com.htn.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin
public class ApiEnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
    
    @PostMapping("/enroll-multiple")
    public ResponseEntity<String> enrollMultipleCourses(@RequestBody EnrollmentRequest enrollmentRequest) {
        boolean success = enrollmentService.enrollToCourses(enrollmentRequest.getUserId(), enrollmentRequest.getCourseIds());
        if (success) {
            return ResponseEntity.ok("Enrollment successful!");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Enrollment failed for some courses.");
        }
    }
    
}
