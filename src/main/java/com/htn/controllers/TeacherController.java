/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.controllers;

import com.htn.pojo.User;
import com.htn.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllTeachers(Model model) {
        List<User> teachers = userService.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @GetMapping("/add-teacher")
    public String showAddTeacherForm(Model model) {
        model.addAttribute("user", new User());
        return "add-teacher";
    }

    @PostMapping("add-teacher")
    public String addTeachers(Model model, @ModelAttribute(value = "user") @Valid User u,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "add-teacher";
        }
        this.userService.addOrUpdateTeacher(u);
        return "redirect:/teachers";
    }
}
