/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.htn.service;

import com.htn.controllers.CourseDTO;
import com.htn.pojo.Course;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface CourseService {
    List<Course> getCourses(Map<String, String> params);
    int countCourse();
    void addOrUpdateCourse(Course c);
    Course getCourseById(int id);
    boolean deleteCouse(int id);
    CourseDTO getCourseDTOById(Integer courseId);
}
