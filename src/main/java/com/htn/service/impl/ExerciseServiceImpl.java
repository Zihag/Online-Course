/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service.impl;

import com.htn.dto.ExerciseDTO;
import com.htn.dto.SubmissionDTO;
import com.htn.pojo.Course;
import com.htn.pojo.Exercise;
import com.htn.repository.ExerciseRepository;
import com.htn.service.ExerciseService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(readOnly = true)
    public List<ExerciseDTO> getExercisesByCourseId(int courseId) {
        Map<String, String> params = new HashMap<>();
        params.put("courseId", Integer.toString(courseId));
        List<Exercise> exercises = this.exerciseRepo.getExercises(params);

        return exercises.stream().map(exercise -> {
            ExerciseDTO dto = new ExerciseDTO();
            dto.setId(exercise.getId());
            dto.setTitle(exercise.getTitle());
            dto.setDescription(exercise.getDescription());
            dto.setStatus(exercise.getStatus());
            dto.setDueDate(exercise.getDueDate());
            dto.setCreatedAt(exercise.getCreatedAt());
            dto.setCourseId(exercise.getCourseId().getId());

            List<SubmissionDTO> submissionDTOs = exercise.getSubmissionCollection().stream().map(submission -> {
                SubmissionDTO subDto = new SubmissionDTO();
                subDto.setId(submission.getId());
                subDto.setContent(submission.getContent());
                subDto.setScore(submission.getScore());
                subDto.setFeedback(submission.getFeedback());
                subDto.setExerciseId(submission.getExerciseId().getId());
                subDto.setStudentId(submission.getStudentId().getId());
                return subDto;
            }).collect(Collectors.toList());

            dto.setSubmissionCollection(submissionDTOs);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public Exercise addExercise(ExerciseDTO exerciseDTO) {
        Exercise exercise = new Exercise();
        exercise.setTitle(exerciseDTO.getTitle());
        exercise.setDescription(exerciseDTO.getDescription());
        exercise.setCourseId(new Course(exerciseDTO.getCourseId()));
        
        return this.exerciseRepo.addExercise(exercise);
    }

}
