/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository.implement;

import com.htn.pojo.Document;
import com.htn.repository.DocumentRepository;
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

/**
 *
 * @author DELL
 */
public class DocumentRepositoryImpl implements DocumentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Document> getDocuments(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Document> q = b.createQuery(Document.class);
        Root root = q.from(Document.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");

            String courseId = params.get("courseId");
            if (courseId != null && !courseId.isEmpty()) {
                Predicate p1 = b.equal(root.get("course"), Integer.parseInt(courseId));
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
    public void addOrUpdate(Document docu) {
        Session s = this.factory.getObject().getCurrentSession();
        if(docu.getId() != null) {
            s.update(docu);
        } else {
            s.save(docu);
        }
    }

    @Override
    public Document getDocumentById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Document.class, id);
    }

    @Override
    public boolean deleteDocument(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Document d = this.getDocumentById(id);
        try {
            s.delete(d);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
