/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.controllers;

import com.htn.pojo.Course;
import com.htn.service.CourseService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String list(Model model) {
        model.addAttribute("course", new Course());
        return "courses";
    }

    @PostMapping("/courses")
    public String add(Model model, @ModelAttribute(value = "course") @Valid Course c,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "courses";
        }
        this.courseService.addOrUpdateCourse(c);
        return "redirect:/";
    }

    @GetMapping("/courses/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("course", this.courseService.getCourseById(id));
        return "courses";
    }
}
