/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service;

import com.htn.pojo.Rating;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface RatingService {
    List<Rating> getAllRating();
    Rating getRatingByCourseId(int id);
    void addRating(Rating rating);
}
