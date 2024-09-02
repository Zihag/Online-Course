/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository.implement;

import com.htn.pojo.Document;
import com.htn.pojo.Lecture;
import com.htn.repository.LectureRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class LectureRepositoryImpl implements LectureRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Lecture> getLectures(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Lecture> q = b.createQuery(Lecture.class);
        Root root = q.from(Lecture.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");

            String courseId = params.get("courseId");
            if (courseId != null && !courseId.isEmpty()) {
                Predicate p1 = b.equal(root.get("courseId"), Integer.parseInt(courseId));
                predicates.add(p1);
            }

            if (kw != null && !kw.isEmpty()) {
                Predicate p2 = b.like(root.get("title"), String.format("%%%s%%", kw));
                predicates.add(p2);
            }

            q.where(predicates.toArray(Predicate[]::new));
        }
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Lecture getLectureById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Lecture.class, id);
    }

    @Override
    public boolean deleteLecture(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Lecture l = this.getLectureById(id);
        try {
            s.delete(l);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void addOrUpdate(Lecture lecture) {
        Session s = this.factory.getObject().getCurrentSession();
        if(lecture.getId() != null) {
            s.update(lecture);
        } else {
            s.save(lecture);
        }
    }

    @Override
    public List<Lecture> getAllLectures() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
