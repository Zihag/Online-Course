package com.htn.pojo;

import com.htn.pojo.Course;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-31T14:33:03")
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, Date> createdAt;
    public static volatile SingularAttribute<Document, Integer> id;
    public static volatile SingularAttribute<Document, String> title;
    public static volatile SingularAttribute<Document, Course> courseId;
    public static volatile SingularAttribute<Document, String> url;
    public static volatile SingularAttribute<Document, Date> updatedAt;

}