/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service.impl;

import com.htn.pojo.Exercise;
import com.htn.repository.ExerciseRepository;
import com.htn.service.ExerciseService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepo;

    @Override
    public List<Exercise> getExercises(Map<String, String> params) {
        return this.exerciseRepo.getExercises(params);
    }

    @Override
    public Exercise getExerciseById(int id) {
        return this.exerciseRepo.getExerciseById(id);
    }

    @Override
    public boolean deleteExercise(int id) {
        return this.exerciseRepo.deleteExercise(id);
    }

    @Override
    public void addOrUpdate(Exercise ex) {
        this.exerciseRepo.addOrUpdate(ex);
    }

}
