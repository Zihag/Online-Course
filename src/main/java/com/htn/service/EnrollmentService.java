/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service;

import com.htn.pojo.Enrollment;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface EnrollmentService {

    boolean enrollToCourses(int userId, List<Integer> courseIds);

    boolean isEnrolled(int userId, int courseId);

}
