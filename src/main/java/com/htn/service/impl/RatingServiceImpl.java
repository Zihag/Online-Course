/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service.impl;

import com.htn.pojo.Course;
import com.htn.pojo.Rating;
import com.htn.pojo.User;
import com.htn.repository.CourseRepository;
import com.htn.repository.RatingRepository;
import com.htn.repository.UserRepository;
import com.htn.service.RatingService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Rating> getAllRating() {
        return this.ratingRepository.getAllRating();
    }

    @Override
    public Rating getRatingByCourseId(int id) {
        return this.ratingRepository.getRatingByCourseId(id);
    }


    @Override
    public Rating addRating(Map<String, String> params) {
        int courseId = Integer.parseInt(params.get("courseId"));
        int userId = Integer.parseInt(params.get("userId"));
        String feedback = params.get("feedback");
        int score = Integer.parseInt(params.get("score"));
        
        Course course = courseRepository.getCourseById(courseId);
        User user = userRepository.getUserById(userId);
        
        Rating rating = new Rating();
        rating.setCourseId(course);
        rating.setUserId(user);
        rating.setFeedback(feedback);
        rating.setScore(score);

        return ratingRepository.addRating(rating);
    }



}
