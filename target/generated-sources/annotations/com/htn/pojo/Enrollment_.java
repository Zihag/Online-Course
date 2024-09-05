package com.htn.pojo;

import com.htn.pojo.Course;
import com.htn.pojo.User;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-05T17:28:37")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-05T16:07:47")
>>>>>>> 48d6082dec87d87def29924fdca5b03e403017fa
@StaticMetamodel(Enrollment.class)
public class Enrollment_ { 

    public static volatile SingularAttribute<Enrollment, User> studentId;
    public static volatile SingularAttribute<Enrollment, Date> createdAt;
    public static volatile SingularAttribute<Enrollment, Date> completedAt;
    public static volatile SingularAttribute<Enrollment, BigDecimal> progress;
    public static volatile SingularAttribute<Enrollment, Integer> id;
    public static volatile SingularAttribute<Enrollment, Course> courseId;

}