/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository.implement;

import com.htn.pojo.Lecture;
import com.htn.repository.LectureRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author Admin
 */
public class LectureRepositoryImpl implements LectureRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Lecture> getLectures(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Lecture> q = b.createQuery(Lecture.class);
        Root<Lecture> root = q.from(Lecture.class);
        q.select(root);

        if (params != null) {
            String courseId = params.get("courseId");
            if (courseId != null && !courseId.isEmpty()) {
                Predicate p1 = b.equal(root.get("course"), Integer.parseInt(courseId));
                q.where(p1);
            }
        }

        q.orderBy(b.asc(root.get("id")));
        Query query = s.createQuery(q);
        return query.getResultList();
    }

}
