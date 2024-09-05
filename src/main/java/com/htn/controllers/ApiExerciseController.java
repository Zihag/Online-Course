/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.controllers;

import com.htn.dto.ExerciseDTO;
import com.htn.pojo.Exercise;
import com.htn.service.ExerciseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiExerciseController {

    @Autowired
    private ExerciseService exerciseSer;

    @GetMapping("/exercises/{courseId}")
    public ResponseEntity<List<ExerciseDTO>> listExercisesByCourseId(@PathVariable("courseId") Integer courseId) {
        List<ExerciseDTO> exercises = exerciseSer.getExercisesByCourseId(courseId);
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

//    @PostMapping(path = "exercises/add-exercise", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<Exercise> addExercise () {
//        Exercise e = this.exerciseSer.addExercise();
//        return new ResponseEntity<>(e, HttpStatus.OK);
//    }
    @PostMapping("/exercises/add-exercise")
    public ResponseEntity<Exercise> addExercise(@RequestBody ExerciseDTO exerciseDTO) {
        Exercise newExercise = this.exerciseSer.addExercise(exerciseDTO);
        return ResponseEntity.ok(newExercise);
    }

    @DeleteMapping("/exercises/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExercise(@PathVariable(value = "id") int id) {
        boolean delete = this.exerciseSer.deleteExerciseById(id);
        if(!delete) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Student is doing exercises!!!!");
        }
    }

}
