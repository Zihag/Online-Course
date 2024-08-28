package com.htn.pojo;

import com.htn.pojo.Course;
import com.htn.pojo.Enrollment;
import com.htn.pojo.Rating;
import com.htn.pojo.Submission;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-28T17:59:44")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> role;
    public static volatile SingularAttribute<User, String> gender;
    public static volatile CollectionAttribute<User, Enrollment> enrollmentCollection;
    public static volatile CollectionAttribute<User, Course> courseCollection;
    public static volatile SingularAttribute<User, String> fullName;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile CollectionAttribute<User, Rating> ratingCollection;
    public static volatile SingularAttribute<User, Date> createdAt;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, Date> dob;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, Date> updatedAt;
    public static volatile CollectionAttribute<User, Submission> submissionCollection;

}