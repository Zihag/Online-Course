package com.htn.pojo;

import com.htn.pojo.Course;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-02T17:09:33")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-02T16:49:22")
>>>>>>> 66935c6027fc8f2cf2617ee7ba897b782852d728
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, Date> createdAt;
    public static volatile SingularAttribute<Document, Integer> id;
    public static volatile SingularAttribute<Document, String> title;
    public static volatile SingularAttribute<Document, Course> courseId;
    public static volatile SingularAttribute<Document, String> url;
    public static volatile SingularAttribute<Document, Date> updatedAt;

}