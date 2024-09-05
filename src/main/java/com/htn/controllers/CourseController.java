/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.controllers;

import com.htn.pojo.Course;
import com.htn.pojo.User;
import com.htn.service.CourseService;
import com.htn.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;

    @GetMapping("/courses")
    public String list(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("teachers", this.userService.getAllTeachers());
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
        List<User> teachers = userService.getUsersByRole("ROLE_TEACHER");
        model.addAttribute("teachers", teachers);
        return "courses";
    }
    
    @GetMapping("/courses/assign-teacher/{id}")
    public String showAssignTeacherForm(@PathVariable("id") int courseId, Model model) {
        Course course = courseService.getCourseById(courseId);
        List<User> teachers = userService.getUsersByRole("ROLE_TEACHER");
        model.addAttribute("assignedCourse", course);
        model.addAttribute("teachers", teachers);
        return "assign-teacher";
    }

    @PostMapping("/courses/assign-teacher")
    public String assignTeacherToCourse(@ModelAttribute(value = "course") @Valid Course c,
                                        @RequestParam("teacher") User teacher,
                                        BindingResult result,
                                        Model model) {
        if (result.hasErrors()) {
            return "assign-teacher";
        }
        this.courseService.assignTeacherToCourse(c, teacher);
        return "redirect:/";
    }
    
    @PostMapping("/courses/delete")
    public String deleteCourse(@RequestParam("courseId") int courseId, RedirectAttributes redirectAttributes) {
        boolean deleted = this.courseService.deleteCouse(courseId);
        if(deleted) {
            redirectAttributes.addFlashAttribute("message", "Success! Course is deleted successfully.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: Course have student (in enrollment)");
        }
        return "redirect:/";
    }
    
}
