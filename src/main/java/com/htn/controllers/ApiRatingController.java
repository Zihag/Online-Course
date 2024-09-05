/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.controllers;

import com.htn.dto.RatingRequest;
import com.htn.pojo.Rating;
import com.htn.service.RatingService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@CrossOrigin
@RestController
@RequestMapping("/api/ratings")
public class ApiRatingController {
    @Autowired
    private RatingService ratingService;
    
    
    
   @PostMapping("/add")
    public ResponseEntity<Rating> addRating(@RequestBody RatingRequest ratingRequest) {
        Rating newRating = ratingService.addRating(ratingRequest);
        return new ResponseEntity<>(newRating, HttpStatus.CREATED);
    }
    
}

