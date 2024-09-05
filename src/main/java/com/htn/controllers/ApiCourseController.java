/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.controllers;

import com.htn.pojo.Course;
import com.htn.service.CourseService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ApiCourseController {

    @Autowired
    private CourseService courseService;

    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        boolean deleted = this.courseService.deleteCouse(id);

        if (!deleted) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Course has students in enrollment");
        }
    }

    @GetMapping("/courses")
//    @CrossOrigin(origins = "")
    public ResponseEntity<List<Course>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.courseService.getCourses(params), HttpStatus.OK);
    }

    @GetMapping(path = "/courses/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<CourseDTO> details(@PathVariable(value = "courseId") Integer id) {
        return new ResponseEntity<>(this.courseService.getCourseDTOById(id), HttpStatus.OK);
    }

    @GetMapping("/courses/enrolled-courses/{userId}")
    public ResponseEntity<List<Course>> listCoursesByUserId(@PathVariable(value = "userId") Integer id) {
        return new ResponseEntity<>(this.courseService.getAllCoursesByUserId(id), HttpStatus.OK);
    }

    @GetMapping("courses/get-course-by-teacher/{teacherId}")
    public ResponseEntity<List<Course>> listCoursesByTeacherId(@PathVariable(value = "teacherId") Integer id) {
        return new ResponseEntity<>(this.courseService.getAllCoursesByTeacherId(id), HttpStatus.OK);
    }
}
