/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository;

import com.htn.pojo.Submission;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface SubmissionRepository {
    Submission findSubmissionById(int id);
    void updateSubmission(Submission sub);
    void addSubmission(Submission sub);
    List<Submission> findSubmissionByExerciseId(int exerciseId);
    int countSubmissionsByStudentIdAndCourseId(int studentId, int courseId);
}
