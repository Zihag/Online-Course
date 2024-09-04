/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service.impl;

import com.htn.pojo.Rating;
import com.htn.repository.RatingRepository;
import com.htn.service.RatingService;
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

    @Override
    public List<Rating> getAllRating() {
        return this.ratingRepository.getAllRating();
    }

    @Override
    public Rating getRatingByCourseId(int id) {
        return this.ratingRepository.getRatingByCourseId(id);
    }

    @Override
    public void addRating(Rating rating) {
        this.ratingRepository.addRating(rating);
    }

}
