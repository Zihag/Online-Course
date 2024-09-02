package com.htn.pojo;

import com.htn.pojo.Course;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-02T17:09:33")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-02T16:49:22")
>>>>>>> 66935c6027fc8f2cf2617ee7ba897b782852d728
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> name;
    public static volatile CollectionAttribute<Category, Course> courseCollection;
    public static volatile SingularAttribute<Category, String> description;
    public static volatile SingularAttribute<Category, Integer> id;

}