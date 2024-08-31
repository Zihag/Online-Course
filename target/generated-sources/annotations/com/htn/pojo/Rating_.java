package com.htn.pojo;

import com.htn.pojo.Course;
import com.htn.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-31T01:43:02")
@StaticMetamodel(Rating.class)
public class Rating_ { 

    public static volatile SingularAttribute<Rating, String> feedback;
    public static volatile SingularAttribute<Rating, Integer> score;
    public static volatile SingularAttribute<Rating, Date> createdDate;
    public static volatile SingularAttribute<Rating, Integer> id;
    public static volatile SingularAttribute<Rating, Course> courseId;
    public static volatile SingularAttribute<Rating, User> userId;

}