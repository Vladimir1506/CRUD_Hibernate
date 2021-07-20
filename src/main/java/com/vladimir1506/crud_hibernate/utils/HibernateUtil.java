package com.vladimir1506.crud_hibernate.utils;

import com.vladimir1506.crud_hibernate.model.Post;
import com.vladimir1506.crud_hibernate.model.Region;
import com.vladimir1506.crud_hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            return new Configuration()
                    .addAnnotatedClass(Region.class)
                    .addAnnotatedClass(Post.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory()
                    .openSession();
        }
        return sessionFactory.openSession();
    }
}
