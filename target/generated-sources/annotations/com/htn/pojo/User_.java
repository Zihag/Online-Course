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

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-05T17:28:37")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-05T16:07:47")
>>>>>>> 48d6082dec87d87def29924fdca5b03e403017fa
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> role;
    public static volatile SingularAttribute<User, String> gender;
    public static volatile CollectionAttribute<User, Enrollment> enrollmentCollection;
    public static volatile CollectionAttribute<User, Course> courseCollection;
    public static volatile SingularAttribute<User, String> fullName;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile CollectionAttribute<User, Rating> ratingCollection;
    public static volatile SingularAttribute<User, Date> createdAt;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, Date> dob;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, Date> updatedAt;
    public static volatile CollectionAttribute<User, Submission> submissionCollection;

}