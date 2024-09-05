package com.htn.pojo;

import com.htn.pojo.Course;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-05T17:28:37")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-05T16:07:47")
>>>>>>> 48d6082dec87d87def29924fdca5b03e403017fa
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, Date> createdAt;
    public static volatile SingularAttribute<Document, Integer> id;
    public static volatile SingularAttribute<Document, String> title;
    public static volatile SingularAttribute<Document, Course> courseId;
    public static volatile SingularAttribute<Document, String> url;
    public static volatile SingularAttribute<Document, Date> updatedAt;

}