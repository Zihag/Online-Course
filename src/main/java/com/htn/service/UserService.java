/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service;

import com.htn.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */
public interface UserService extends UserDetailsService {
    List<User> getUsersByRole(String role);
    List<User> getAllTeachers();
    void addOrUpdateTeacher(User u);
    User getUserByUsername(String username);
    User addUser(Map<String, String> params, MultipartFile avatar);
    boolean authUser(String username, String password);
    User getUserById(int id);
    boolean deleteTeacher(int id);
    User register(Map<String, String> params, MultipartFile avatar);
}

