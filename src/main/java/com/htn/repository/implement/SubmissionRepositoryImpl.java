/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository.implement;

import com.htn.pojo.Exercise;
import com.htn.pojo.Submission;
import com.htn.repository.SubmissionRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
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
public class SubmissionRepositoryImpl implements SubmissionRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Submission findSubmissionById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Submission.class, id);
    }

    @Override
    public void updateSubmission(Submission sub) {
        Session s = this.factory.getObject().getCurrentSession();
        s.update(sub);
    }

    @Override
    public List<Submission> findSubmissionByExerciseId(int exerciseId) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Submission> query = b.createQuery(Submission.class);
        Root<Submission> sub = query.from(Submission.class);
        query.select(sub).where(b.equal(sub.get("exerciseId").get("id"), exerciseId));

        return s.createQuery(query).getResultList();
    }

    @Override
    public void addSubmission(Submission sub) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(sub);
    }

    @Override
    public int countSubmissionsByStudentIdAndCourseId(int studentId, int courseId) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Submission> root = query.from(Submission.class);
        Join<Submission, Exercise> exerciseJoin = root.join("exerciseId");
        query.select(builder.count(root))
                .where(
                        builder.equal(root.get("studentId").get("id"), studentId),
                        builder.equal(exerciseJoin.get("courseId").get("id"), courseId)
                );
        Long result = s.createQuery(query).getSingleResult();
        return result != null ? result.intValue() : 0;
    }

}
