///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.htn.repository.implement;
//
//import com.htn.pojo.Lecture;
//import com.htn.repository.LectureRepository;
//import java.util.List;
//import java.util.Map;
//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author Admin
// */
//@Repository
//@Transactional
//public class LectureRepositoryImpl implements LectureRepository {
//
//    @Autowired
//    private LocalSessionFactoryBean factory;
//
//    @Override
//    public List<Lecture> getLecturesByCourseId(int courseId) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createQuery("FROM Lecture WHERE courseId = :courseId", Lecture.class);
//
//        
//        q.setParameter("courseId", courseId);
//        return q.getResultList();
//    }
//}
