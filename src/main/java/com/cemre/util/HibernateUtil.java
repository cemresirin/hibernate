package com.cemre.util;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory =new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        }catch (Throwable ex) {
            System.out.println("SessionFactory oluşturulmadı." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}