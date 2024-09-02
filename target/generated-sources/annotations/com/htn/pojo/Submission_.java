package com.htn.pojo;

import com.htn.pojo.Exercise;
import com.htn.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-02T17:09:33")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-02T16:49:22")
>>>>>>> 66935c6027fc8f2cf2617ee7ba897b782852d728
@StaticMetamodel(Submission.class)
public class Submission_ { 

    public static volatile SingularAttribute<Submission, String> feedback;
    public static volatile SingularAttribute<Submission, User> studentId;
    public static volatile SingularAttribute<Submission, Integer> score;
    public static volatile SingularAttribute<Submission, Exercise> exerciseId;
    public static volatile SingularAttribute<Submission, Integer> id;
    public static volatile SingularAttribute<Submission, String> content;

}