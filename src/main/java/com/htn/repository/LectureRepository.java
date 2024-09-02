/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository;
import com.htn.pojo.Lecture;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface LectureRepository {
    List<Lecture> getLectures(Map<String, String> params);
    Lecture getLectureById(int id);
    boolean deleteLecture(int id);
    void addOrUpdate(Lecture lecture);
    List<Lecture> getAllLectures();
}