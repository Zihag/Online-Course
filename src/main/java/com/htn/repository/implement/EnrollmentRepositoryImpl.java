/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository.implement;

import com.htn.pojo.Course;
import com.htn.pojo.Enrollment;
import com.htn.pojo.User;
import com.htn.repository.EnrollmentRepository;
import com.htn.service.CourseService;
import com.htn.service.UserService;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class EnrollmentRepositoryImpl implements EnrollmentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Override
    public void enrollToCourse(int userId, int courseId) {
        Session session = this.factory.getObject().getCurrentSession();

        User user = userService.getUserById(userId);
        Course course = courseService.getCourseById(courseId);

        if (user != null && course != null) {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudentId(user);
            enrollment.setCourseId(course);

            session.save(enrollment);
        } else {
            throw new IllegalArgumentException("User or Course not found");
        }
    }

    @Override
    public Enrollment findEnrollmentByUserIdandCourseId(int studentId, int courseId) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        
        CriteriaQuery<Enrollment> q = builder.createQuery(Enrollment.class);
        Root<Enrollment> r = q.from(Enrollment.class);
        
        Predicate course = builder.equal(r.get("courseId").get("id"), courseId);
        Predicate student = builder.equal(r.get("studentId").get("id"), studentId);
        
        q.select(r).where(builder.and(course, student));
        
        return session.createQuery(q).uniqueResult();
    }

    

}
