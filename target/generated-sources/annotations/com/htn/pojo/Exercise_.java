package com.htn.pojo;

import com.htn.pojo.Course;
import com.htn.pojo.Submission;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-04T22:51:35")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-03T23:21:39")
>>>>>>> 6d10d264148fc6acd9dbe117568ae120582bf321
@StaticMetamodel(Exercise.class)
public class Exercise_ { 

    public static volatile SingularAttribute<Exercise, Date> createdAt;
    public static volatile SingularAttribute<Exercise, Date> dueDate;
    public static volatile SingularAttribute<Exercise, String> description;
    public static volatile SingularAttribute<Exercise, Integer> id;
    public static volatile SingularAttribute<Exercise, String> title;
    public static volatile SingularAttribute<Exercise, Course> courseId;
    public static volatile SingularAttribute<Exercise, Short> status;
    public static volatile CollectionAttribute<Exercise, Submission> submissionCollection;

}