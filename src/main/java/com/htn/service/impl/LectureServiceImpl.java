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
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class LectureServiceImpl implements LectureService {

    @Autowired
    private LectureRepository lectureRepository;

    @Override
    public List<Lecture> getLectures(Map<String, String> params) {
        return this.lectureRepository.getLectures(params);

    }

    @Override
    public Lecture getLectureById(int id) {
        return this.lectureRepository.getLectureById(id);
    }

    @Override
    public boolean deleteLectureById(int id) {
        Lecture l = this.lectureRepository.getLectureById(id);
        if (l == null) {
            return false;
        } else {
            this.lectureRepository.deleteLecture(l);
            return true;
        }

    }

    @Override
    public void addOrUpdate(Lecture lecture) {
        this.lectureRepository.addOrUpdate(lecture);
    }

}
