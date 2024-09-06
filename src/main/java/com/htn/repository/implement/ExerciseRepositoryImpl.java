/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository.implement;

import com.htn.pojo.Exercise;
import com.htn.repository.ExerciseRepository;
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
 * @author DELL
 */
@Repository
@Transactional
public class ExerciseRepositoryImpl implements ExerciseRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Exercise> getExercises(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Exercise> q = b.createQuery(Exercise.class);
        Root root = q.from(Exercise.class);
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
    public Exercise getExerciseById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Exercise.class, id);
    }

    @Override
    public void deleteExercise(Exercise ex) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(ex);
    }

    @Override
    public void addOrUpdate(Exercise ex) {
        Session s = this.factory.getObject().getCurrentSession();
        if (ex.getId() != null) {
            s.update(ex);
        } else {
            s.save(ex);
        }
    }

    @Override
    public List<Exercise> getAllExercises() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Exercise addExercise(Exercise ex) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(ex);
        return ex;
    }

    @Override
    public int countExercisesByCourseId(int courseId) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();

        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Exercise> root = query.from(Exercise.class);

        query.select(builder.count(root)).where(builder.equal(root.get("courseId").get("id"), courseId));

        Long result = s.createQuery(query).getSingleResult();
        return result != null ? result.intValue() : 0;
    }

}
