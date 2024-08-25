/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository;

import com.htn.pojo.User;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface UserRepository {
    List<User> getUserByRole(String role);
    void addOrUpdateTeacher(User u);
    boolean deleteTeacher(int id);
    User getUserById(int id);
    User getUserByUsername(String username);
}

