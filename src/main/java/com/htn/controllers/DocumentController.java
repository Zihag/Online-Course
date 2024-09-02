/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.controllers;

import com.htn.pojo.Document;
import com.htn.pojo.User;
import com.htn.service.CourseService;
import com.htn.service.DocumentService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/documents")
@ControllerAdvice
public class DocumentController {
    @Autowired
    private DocumentService docuService;
    @Autowired
    private CourseService courseSer;
    
    @GetMapping
    public String getAllDocuments(Model model, 
            @RequestParam(required = false) Integer courseId) {
        Map<String, String> params = new HashMap<>();
        if (courseId != null) {
            params.put("courseId", courseId.toString());
        }
        model.addAttribute("documents", this.docuService.getDocuments(params));
        model.addAttribute("courses", this.courseSer.getAllCourses());
        return "documents";
    }
    
    @GetMapping("/add-teacher")
    public String showAddDocumentForm(Model model) {
        model.addAttribute("document", new Document());
        return "add-document";
    }
    
    @PostMapping("/add-document")
    public String addDocument(Model m, @ModelAttribute(value = "document") @Valid Document d, BindingResult rs) {
        if (rs.hasErrors()) {
            return "documents";
        }
        this.docuService.addOrUpdate(d);
        return "redirect:/documents";
    }
}
