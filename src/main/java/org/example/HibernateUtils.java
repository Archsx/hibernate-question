package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sf;


    static {

        Configuration conf = new Configuration();
        conf.addAnnotatedClass(Post.class);
        conf.addAnnotatedClass(PostComment.class);
        conf.addAnnotatedClass(Post1.class);
        conf.addAnnotatedClass(PostComment1.class);
        conf.configure();

        sf = conf.buildSessionFactory();
    }


    public static Session openSession() {

        Session session = sf.openSession();

        return session;
    }


    public static Session getCurrentSession() {

        Session session = sf.getCurrentSession();

        return session;

    }

    public static void main(String[] args) {
        System.out.println(HibernateUtils.openSession());
    }


}
