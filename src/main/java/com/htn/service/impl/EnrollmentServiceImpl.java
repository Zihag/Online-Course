/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service.impl;

import com.htn.pojo.Enrollment;
import com.htn.repository.EnrollmentRepository;
import com.htn.service.EnrollmentService;
import java.math.BigDecimal;
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
        BigDecimal progress =  enrollment.getProgress();
        return progress.intValue();
    }

    
    
}
