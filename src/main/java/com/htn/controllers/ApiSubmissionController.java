/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.controllers;

import com.htn.dto.SubmissionDTO;
import com.htn.service.SubmissionService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@CrossOrigin
@RequestMapping("/api/submissions")
public class ApiSubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<?> score( @PathVariable("id") int id, @RequestParam Map<String, String> params) {
        try {
            Integer score = Integer.parseInt(params.get("score"));
            String feedback = params.get("feedback");

            this.submissionService.updateSubmission(id, score, feedback);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/exercises/{exerciseId}/submit")
    public ResponseEntity<?> submitExercise(@PathVariable int exerciseId, @RequestBody SubmissionDTO submissionDTO) {
        try {
            submissionDTO.setExerciseId(exerciseId);
            submissionService.addSubmissionWithExerciseIdStudentId(submissionDTO);
            return new ResponseEntity<>("Submission successful", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
