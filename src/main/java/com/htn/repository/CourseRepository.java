/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository;

import com.htn.pojo.Course;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface CourseRepository {
    List<Course> getCourses(Map<String, String> params);
    int countCourse();
    
    void addOrUpdateCourse(Course c);
    Course getCourseById(int id);
    boolean deleteCouse(int id);
}
