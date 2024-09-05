/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service;

import com.htn.pojo.Course;
import com.htn.pojo.Lecture;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface LectureService {
    List<Lecture> getLectures(Map<String, String> params);
    Lecture getLectureById(int id);
    boolean deleteLectureById(int id);
    void addOrUpdate(Lecture lecture);
}
