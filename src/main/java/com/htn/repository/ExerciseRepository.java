/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository;

import com.htn.pojo.Exercise;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface ExerciseRepository {
    List<Exercise> getExercises(Map<String, String> params);
    Exercise getExerciseById(int id);
    void deleteExercise(Exercise ex);
    void addOrUpdate(Exercise ex);
    List<Exercise> getAllExercises();
    Exercise addExercise(Exercise ex);
}
