/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.controllers;

import com.htn.pojo.Course;
import com.htn.pojo.Lecture;
import com.htn.service.CourseService;
import com.htn.service.LectureService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/lectures")
@ControllerAdvice
public class LectureController {
    @Autowired
    private LectureService lectureService;
    @Autowired
    private CourseService courseService;
    
    @GetMapping
    public String getAllLectures(Model model, @RequestParam(required = false) Integer courseId){
        Map<String, String> params = new HashMap<>();
        if(courseId != null){
            params.put("courseId", courseId.toString());
        }
        model.addAttribute("lectures", this.lectureService.getLectures(params));
        model.addAttribute("courses", this.courseService.getAllCourses());
        return "lectures";
    }
    
    @GetMapping("/add-lecture")
    public String showAddLectureForm(Model model){
        model.addAttribute("courses", this.courseService.getAllCourses());
        model.addAttribute("lecture", new Lecture());
        return "add-lecture";
    }
    
    @PostMapping("/add-lecture")
    public String add(Model model, @ModelAttribute(value = "lecture") @Valid Lecture l,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "add-lecture";
        }
        this.lectureService.addOrUpdate(l);
        return "redirect:/lectures";
    }
    
    @GetMapping("/lectures/{id}/edit")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("lecture", this.lectureService.getLectureById(id));
        model.addAttribute("courses", this.courseService.getAllCourses());
        return "courses";
    }
    
}
