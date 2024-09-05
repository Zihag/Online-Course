package com.htn.pojo;

import com.htn.pojo.Course;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-05T17:28:37")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-09-05T16:07:47")
>>>>>>> 48d6082dec87d87def29924fdca5b03e403017fa
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> name;
    public static volatile CollectionAttribute<Category, Course> courseCollection;
    public static volatile SingularAttribute<Category, String> description;
    public static volatile SingularAttribute<Category, Integer> id;

}