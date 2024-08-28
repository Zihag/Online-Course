/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service.impl;

import com.htn.pojo.Lecture;
import com.htn.repository.LectureRepository;
import com.htn.service.LectureService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Admin
 */
public class LectureServiceImpl implements LectureService{
    @Autowired
    private LectureRepository lectureRepository;

    @Override
    public List<Lecture> getLectures(Map<String, String> params) {
        return this.lectureRepository.getLectures(params);
    }
}
