/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository;

import com.htn.pojo.Course;
import com.htn.pojo.User;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface UserRepository {
    User getUserById(int id);
    User getUserByUsername(String username);
    User addUser(User user);
    void addOrUpdate(User u);
    boolean authUser(String username, String password);
    List<User> getUserByRole(String role);
    void addOrUpdateTeacher(User u);
    boolean deleteTeacher(int id);
    
}

