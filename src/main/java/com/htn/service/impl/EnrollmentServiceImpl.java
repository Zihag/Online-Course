/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service.impl;

import com.htn.pojo.Enrollment;
import com.htn.repository.EnrollmentRepository;
import com.htn.repository.ExerciseRepository;
import com.htn.repository.SubmissionRepository;
import com.htn.service.EnrollmentService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollRepo;

    @Autowired
    private ExerciseRepository exerciseRepositoryImpl;

    @Autowired
    private SubmissionRepository submissionRepositoryImpl;

    @Override
    public boolean enrollToCourses(int userId, List<Integer> courseIds) {
        boolean allEnroll = true;
        for (int c : courseIds) {
            Enrollment enrollment = this.enrollRepo.findEnrollmentByUserIdandCourseId(userId, c);
            if (enrollment == null) {
                this.enrollRepo.enrollToCourse(userId, c);
            } else {
                allEnroll = false;
            }
        }
        return allEnroll;
    }

    @Override
    public boolean isEnrolled(int userId, int courseId) {
        Enrollment enrollment = enrollRepo.findEnrollmentByUserIdandCourseId(userId, courseId);
        return enrollment != null;
    }

    @Override
    public Integer enrollProgress(int userId, int courseId) {
        Enrollment enrollment = enrollRepo.findEnrollmentByUserIdandCourseId(userId, courseId);
        BigDecimal progress = enrollment.getProgress();
        if (progress == null) {
            return 0;
        }

        // Chuyển đổi progress từ BigDecimal sang int
        return progress.intValue();
    }

    @Override
    public double calculateProgress(int studentId, int courseId) {
        int totalExercises = exerciseRepositoryImpl.countExercisesByCourseId(courseId);

        int completedExercises = submissionRepositoryImpl.countSubmissionsByStudentIdAndCourseId(studentId, courseId);

        if (totalExercises == 0) {
            return 0.0;
        }

        return (double) completedExercises / totalExercises * 100;
    }

    @Override
    public void updateProgress(int studentId, int courseId) {
        double progress = calculateProgress(studentId, courseId);

        Enrollment enrollment = enrollRepo.findEnrollmentByUserIdandCourseId(studentId, courseId);
        if (enrollment != null) {
            BigDecimal progressDecimal = BigDecimal.valueOf(progress).setScale(2, RoundingMode.HALF_UP); // 2 chữ số thập phân

            enrollment.setProgress(progressDecimal);
            enrollRepo.updateEnrollment(enrollment);
        }
    }

}
