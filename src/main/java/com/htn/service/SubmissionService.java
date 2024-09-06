/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service;

import com.htn.dto.SubmissionDTO;

/**
 *
 * @author DELL
 */
public interface SubmissionService {
    void updateSubmission(int id, int score, String feedback);
    boolean existSubmissionByExerciseId(int exerciseId);
    void addSubmissionWithExerciseIdStudentId(SubmissionDTO submissionDTO);
}
