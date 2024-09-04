/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository.implement;

import com.htn.pojo.Course;
import com.htn.pojo.Enrollment;
import com.htn.pojo.Submission;
import com.htn.pojo.User;
import com.htn.repository.CourseRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class CourseRepositoryImpl implements CourseRepository {

    private static final int PAGE_SIZE = 4;
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Course> getAllCourses() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Course");

        return q.getResultList();
    }

    @Override
    public List<com.htn.pojo.Course> getCourses(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<com.htn.pojo.Course> q = b.createQuery(com.htn.pojo.Course.class);
        Root root = q.from(com.htn.pojo.Course.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate titlePredicate = b.like(root.get("title"), String.format("%%%s%%", kw));
                Predicate teacherNamePredicate = b.like(root.get("teacher").get("fullName"), String.format("%%%s%%", kw));
                Predicate p1 = b.or(titlePredicate, teacherNamePredicate);
                predicates.add(p1);
            }

            String fromPrice = params.get("fromPrice");
            if (fromPrice != null && !fromPrice.isEmpty()) {
                Predicate p2 = b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice));
                predicates.add(p2);
            }

            String toPrice = params.get("toPrice");
            if (toPrice != null && !toPrice.isEmpty()) {
                Predicate p3 = b.lessThanOrEqualTo(root.get("price"), Double.parseDouble(toPrice));
                predicates.add(p3);
            }

            String cateId = params.get("cateId");
            if (cateId != null && !cateId.isEmpty()) {
                Predicate p4 = b.equal(root.get("category"), Integer.parseInt(cateId));
                predicates.add(p4);
            }

            //SORT
            String sortBy = params.get("sortBy");
            String sortOrder = params.get("sortOrder");

            if (sortBy != null && !sortBy.isEmpty()) {
                if ("asc".equalsIgnoreCase(sortOrder)) {
                    q.orderBy(b.asc(root.get(sortBy)));
                } else if ("desc".equalsIgnoreCase(sortOrder)) {
                    q.orderBy(b.desc(root.get(sortBy)));
                } else {
                    // Mặc định sắp xếp tăng dần theo trường sortBy
                    q.orderBy(b.asc(root.get(sortBy)));
                }
            } else {
                // Nếu không có tham số sortBy, mặc định sắp xếp giảm dần theo id
                q.orderBy(b.asc(root.get("id")));
            }
            //SORT   
            q.where(predicates.toArray(Predicate[]::new));
        }
        Query query = s.createQuery(q);

        if (params != null) {
            String p = params.get("page");
            if (p != null && !p.isEmpty()) {
                int page = Integer.parseInt(p);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                query.setMaxResults(pageSize);
                query.setFirstResult((page - 1) * pageSize);
            }
        }

        return query.getResultList();

    }

    @Override
    public int countCourse() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count (*) FROM Course");

        return Integer.parseInt(q.getSingleResult().toString());

    }

    @Override
    public void addOrUpdateCourse(Course c) {
        Session s = this.factory.getObject().getCurrentSession();
        if (c.getId() == null) {
            s.save(c);
        } else {
            s.update(c);
        }
    }

    @Override
    public Course getCourseById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Course.class, id);
    }

    @Override
    public boolean deleteCouse(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Course c = this.getCourseById(id);

        if (countEnrollmentByCourseId(id) > 0) {
            return false;
        } else {
            try {
                session.delete(c);
                return true;
            } catch (HibernateException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public int countEnrollmentByCourseId(int courseId) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Enrollment> root = query.from(Enrollment.class);
        query.select(builder.count(root))
                .where(builder.equal(root.get("courseId"), courseId));
        Long count = session.createQuery(query).getSingleResult();
        return count.intValue();

//Dưới đây là code join với bảng User để kiểm tra, nhưng có vẻ không cần thiết, 
//vì mặc định ở bảng Enrollment đã fix phải có user_id và course_id rồi, nên dùng cái trên =))).
//        Session session = this.factory.getObject().getCurrentSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Long> query = builder.createQuery(Long.class);
//        Root<Enrollment> root = query.from(Enrollment.class);
//
//        Join<Object, Object> userJoin = root.join("user");
//        query.select(builder.count(root))
//                .where(builder.equal(userJoin.get("course").get("id"), courseId));
//        
//        Long count = session.createQuery(query).getSingleResult();
//        return count.intValue();
    }

    @Override
    @Transactional
    public void assignTeacherToCourse(Course course, User teacher) {
        Session session = this.factory.getObject().getCurrentSession();
        Course c = session.get(Course.class, course.getId());

        if (c != null) {
            c.setTeacher(teacher);
            session.update(c);
        }
    }

    @Override
    public List<Course> getCoursesByUserId(int studentId) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();

        CriteriaQuery<Course> q = b.createQuery(Course.class);
        Root<Enrollment> root = q.from(Enrollment.class);
        Join<Enrollment, Course> courseJoin = root.join("courseId");
        q.select(courseJoin).where(b.equal(root.get("studentId").get("id"), studentId));
        return session.createQuery(q).getResultList();
    }

    @Override
    public List<Course> getCoursesByTeacherId(int teacherId) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Course> q = b.createQuery(Course.class);
        Root<Course> root = q.from(Course.class);
        Predicate p = b.equal(root.get("teacher").get("id"), teacherId);
        q.where(p);

        q.select(root).distinct(true);

        return session.createQuery(q).getResultList();
    }

}
