package com.htn.pojo;

import com.htn.pojo.Course;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-04T22:51:35")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-03T23:21:39")
>>>>>>> 6d10d264148fc6acd9dbe117568ae120582bf321
@StaticMetamodel(Lecture.class)
public class Lecture_ { 

    public static volatile SingularAttribute<Lecture, Date> createdAt;
    public static volatile SingularAttribute<Lecture, Integer> id;
    public static volatile SingularAttribute<Lecture, String> title;
    public static volatile SingularAttribute<Lecture, String> lecturecol;
    public static volatile SingularAttribute<Lecture, Course> courseId;
    public static volatile SingularAttribute<Lecture, String> content;
    public static volatile SingularAttribute<Lecture, String> url;
    public static volatile SingularAttribute<Lecture, Date> updatedAt;

}