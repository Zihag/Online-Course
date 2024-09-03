/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository;

import com.htn.pojo.Enrollment;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface EnrollmentRepository {
    void enrollToCourse(int userId, int courseId);
    Enrollment findEnrollmentByUserIdandCourseId(int userId, int courseId);
}
