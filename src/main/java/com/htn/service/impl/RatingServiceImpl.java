/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service.impl;

import com.htn.dto.RatingRequest;
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
    public Rating addRating(RatingRequest ratingRequest) {
        // Tìm khóa học và người dùng theo ID
        Course course = courseRepository.getCourseById(ratingRequest.getCourseId());
        User user = userRepository.getUserById(ratingRequest.getUserId());

        // Tạo đối tượng Rating mới
        Rating rating = new Rating();
        rating.setCourseId(course);
        rating.setUserId(user);
        rating.setFeedback(ratingRequest.getFeedback());
        rating.setScore(ratingRequest.getScore());

        // Lưu vào cơ sở dữ liệu
        return ratingRepository.addRating(rating);
    }



}
