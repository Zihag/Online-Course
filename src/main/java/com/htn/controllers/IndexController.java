/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.controllers;

import com.htn.service.CategoryService;
import com.htn.service.CourseService;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller

//gán commonAttr cho tat ca cac ctrler
@ControllerAdvice

@PropertySource("classpath:configs.properties")
public class IndexController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CategoryService cateService;
    @Autowired
    private Environment env;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("categories", this.cateService.getCates());
    }

    @RequestMapping("/")
    
    public String index(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("courses", this.courseService.getCourses(params));

        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int count = this.courseService.countCourse();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));

        return "index";
    }

   
}
