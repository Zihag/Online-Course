/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service.impl;

import com.htn.dto.SubmissionDTO;
import com.htn.pojo.Exercise;
import com.htn.pojo.Submission;
import com.htn.pojo.User;
import com.htn.repository.ExerciseRepository;
import com.htn.repository.SubmissionRepository;
import com.htn.repository.UserRepository;
import com.htn.repository.implement.SubmissionRepositoryImpl;
import com.htn.service.EnrollmentService;
import com.htn.service.SubmissionService;
import java.util.List;
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

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EnrollmentService enrollmentService;

    @Override
    public void updateSubmission(int id, int score, String feedback) {
        Submission submission = this.subRepository.findSubmissionById(id);
        submission.setScore(score);
        submission.setFeedback(feedback);
        this.subRepository.updateSubmission(submission);
    }

    @Override
    public boolean existSubmissionByExerciseId(int exerciseId) {
        List<Submission> submissionList = this.subRepository.findSubmissionByExerciseId(exerciseId);
        if (submissionList.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void addSubmissionWithExerciseIdStudentId(SubmissionDTO submissionDTO) {
        Submission s = new Submission();
        s.setContent(submissionDTO.getContent());

        Exercise exercise = this.exerciseRepository.getExerciseById(submissionDTO.getExerciseId());

        User student = this.userRepository.getUserById(submissionDTO.getStudentId());

        s.setExerciseId(exercise);
        s.setStudentId(student);

        this.subRepository.addSubmission(s);

        this.enrollmentService.updateProgress(student.getId(), exercise.getId());
    }
}
