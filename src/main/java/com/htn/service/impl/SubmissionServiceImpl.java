/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service.impl;

import com.htn.pojo.Submission;
import com.htn.repository.SubmissionRepository;
import com.htn.repository.implement.SubmissionRepositoryImpl;
import com.htn.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class SubmissionServiceImpl implements SubmissionService {
    @Autowired
    private SubmissionRepository subRepository;

    @Override
    public void updateSubmission(int id, int score, String feedback) {
        Submission submission = this.subRepository.findSubmissionById(id);
        submission.setScore(score);
        submission.setFeedback(feedback);
        this.subRepository.updateSubmission(submission);
    }
}
