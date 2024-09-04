/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository;

import com.htn.pojo.Rating;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface RatingRepository {
    List<Rating> getAllRating(Map<String, String> params);
    Rating getRatingById(int id);
    void addRating(Rating rating);
}
