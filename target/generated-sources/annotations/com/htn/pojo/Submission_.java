package com.htn.pojo;

import com.htn.pojo.Exercise;
import com.htn.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-05T17:28:37")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-05T16:07:47")
>>>>>>> 48d6082dec87d87def29924fdca5b03e403017fa
@StaticMetamodel(Submission.class)
public class Submission_ { 

    public static volatile SingularAttribute<Submission, String> feedback;
    public static volatile SingularAttribute<Submission, User> studentId;
    public static volatile SingularAttribute<Submission, Integer> score;
    public static volatile SingularAttribute<Submission, Exercise> exerciseId;
    public static volatile SingularAttribute<Submission, Integer> id;
    public static volatile SingularAttribute<Submission, String> content;

}