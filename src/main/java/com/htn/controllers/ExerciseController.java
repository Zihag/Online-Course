/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.controllers;

import com.htn.pojo.Exercise;
import com.htn.service.CourseService;
import com.htn.service.ExerciseService;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/exercises")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private CourseService courseSer;
            
    @GetMapping
    public String getAllExercises(Model model, @RequestParam(required = false) Integer courseId) {
                                    Map<String, String> params = new HashMap<>();
        if (courseId != null) {
            params.put("courseId", courseId.toString());
        }
        model.addAttribute("exercises", this.exerciseService.getExercises(params));
        model.addAttribute("courses", this.courseSer.getAllCourses());
        return "exercises";
    }
    
    @PostMapping
    public String addOrUpdate(Model m, @ModelAttribute(value = "exercise") @Valid Exercise d, 
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "add-or-update-exercise";
        }
        this.exerciseService.addOrUpdate(d);
        return "redirect:/exercises";
    }
    
    @GetMapping("/add")
    public String showAddExerciseForm(Model model) {
        model.addAttribute("exercise", new Exercise());
        model.addAttribute("courses", this.courseSer.getAllCourses());
        return "add-or-update-exercise";
    }
    
    @GetMapping("/{id}")
    public String updateExercise(Model model, @PathVariable(value = "id") int id) {
        Exercise exercise = this.exerciseService.getExerciseById(id);
        model.addAttribute("exercise", exercise);
        model.addAttribute("courses", this.courseSer.getAllCourses());
        return "add-or-update-exercise";
    }
}
