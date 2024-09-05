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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/add-or-update-teacher")
    public String showAddTeacherForm(Model model) {
        model.addAttribute("user", new User());
        return "add-teacher";
    }

    @PostMapping("add-or-update-teacher")
    public String addTeachers(Model model, @ModelAttribute(value = "user") @Valid User u,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "add-or-update-teacher";
        }
        this.userService.addOrUpdateTeacher(u);
        return "redirect:/teachers";
    }

    @PostMapping("/delete")
    public String deleteTeacher(@RequestParam("teacherId") int teacherId, Model model, RedirectAttributes redirectAttributes) {
        boolean delete = this.userService.deleteTeacher(teacherId);
        if (!delete) {
            redirectAttributes.addFlashAttribute("errorMessage", "Can't delete this teacher. It may be associated with one or more courses.");
            return "redirect:/teachers";
        }
        return "redirect:/teachers";
    }
    
    @GetMapping("/add-or-update-teacher/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("user", this.userService.getUserById(id));
        return "add-teacher";
    }
}
