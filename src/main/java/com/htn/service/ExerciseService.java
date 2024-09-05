/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service;

import com.htn.dto.ExerciseDTO;
import com.htn.pojo.Exercise;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface ExerciseService {
    List<Exercise> getExercises(Map<String, String> params);
    Exercise getExerciseById(int id);
    boolean deleteExerciseById(int id);
    void addOrUpdate(Exercise ex);
    List<ExerciseDTO> getExercisesByCourseId(int courseId);
    public Exercise addExercise(ExerciseDTO exerciseDTO);
}
