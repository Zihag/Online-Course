/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.htn.controllers.CourseDTO;
import com.htn.pojo.Course;
import com.htn.pojo.Document;
import com.htn.pojo.Lecture;
import com.htn.pojo.Rating;
import com.htn.pojo.User;
import com.htn.repository.CourseRepository;
import com.htn.service.CourseService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
//Thêm transactional de mo Session duoc lau hon, lay duoc collection
@Transactional
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepo;

    //UPLOAD ANH
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Course> getCourses(Map<String, String> params) {
        return this.courseRepo.getCourses(params);
    }

    @Override
    public int countCourse() {
        return this.courseRepo.countCourse();
    }

    @Override
    public void addOrUpdateCourse(Course p) {
        if (!p.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(p.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                p.setCoverImg(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(CourseServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.courseRepo.addOrUpdateCourse(p);
    }

    @Override
    public Course getCourseById(int id) {
        return this.courseRepo.getCourseById(id);
    }

    @Override
    public boolean deleteCouse(int id) {
        return this.courseRepo.deleteCouse(id);
    }

    @Override
    public CourseDTO getCourseDTOById(Integer courseId) {
        Course course = courseRepo.getCourseById(courseId);

        // Chuyển Collection<Lecture> sang List<Lecture>
        List<Document> documents = course.getDocumentCollection().stream().collect(Collectors.toList());
        List<Lecture> lectures = course.getLectureCollection().stream().collect(Collectors.toList());
        List<Rating> ratings = course.getRatingCollection().stream().collect(Collectors.toList());

        // Tạo CourseDTO và set các giá trị cần thiết
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setTitle(course.getTitle());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setCoverImg(course.getCoverImg());
        courseDTO.setDocuments(documents);
        courseDTO.setLectures(lectures);
        courseDTO.setRatings(ratings);

        return courseDTO;
    }

    @Override
    public void assignTeacherToCourse(Course course, User teacher) {
        this.courseRepo.assignTeacherToCourse(course, teacher);
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courseRepo.getAllCourses();
    }

    @Override
    public int countEnrollmentByCourseId(int id) {
        return this.courseRepo.countEnrollmentByCourseId(id);
    }

    @Override
    public List<Course> getAllCoursesByUserId(int studentId) {
        return this.courseRepo.getCoursesByUserId(studentId);
    }

    @Override
    public List<Course> getAllCoursesByTeacherId(int teacherId) {
        return this.courseRepo.getCoursesByTeacherId(teacherId);
    }

}
