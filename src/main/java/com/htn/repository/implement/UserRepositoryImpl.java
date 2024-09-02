/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.repository.implement;

import com.htn.pojo.Course;
import com.htn.pojo.User;
import com.htn.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<User> getUserByRole(String role) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();

        CriteriaQuery<User> usersQuery = cb.createQuery(User.class);
        Root<User> root = usersQuery.from(User.class);

        usersQuery.select(root).where(cb.equal(root.get("role"), role));
        Query query = s.createQuery(usersQuery);

        return query.getResultList();
    }

    @Override
    public void addOrUpdateTeacher(User u) {
        Session s = this.factory.getObject().getCurrentSession();
        if (u.getId() == null) {
            if (u.getPassword() != null && !u.getPassword().isEmpty()) {
                String encodedPassword = passwordEncoder.encode(u.getPassword());
                u.setPassword(encodedPassword);
            }
            s.save(u);
        } else {
            s.update(u);
        }
    }

    @Override
    public boolean deleteTeacher(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        User teacher = this.getUserById(id);
        
        boolean teacherRole = false;
        if("ROLE_TEACHER".equals(teacher.getRole())) {
            teacherRole = true;
        }
        
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> root = cq.from(Course.class);
        cq.select(root).where(cb.equal(root.get("teacher"), teacher));
        List<Course> courses = session.createQuery(cq).getResultList();

        if(!courses.isEmpty()) {
            return false;
        }
        
        try {
            session.delete(teacher);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(User.class, id);
    }

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("User.findByUsername");
        q.setParameter("username", username);

        return (User) q.getSingleResult();
    }

    @Override
    public User addUser(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(user);
        return user;
    }

    @Override
    public boolean authUser(String username, String password) {
        User u = this.getUserByUsername(username);

        return this.passwordEncoder.matches(password, u.getPassword());
    }
}
