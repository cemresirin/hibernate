package com.cemre;

import com.cemre.user.Student;
import com.cemre.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Student student = new Student("Cemre" , "Şirin");;
            session.persist(student);

            transaction.commit();
            System.out.println("Veri başarıyla eklendi");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();

            HibernateUtil.shutdown();
        }
    }
}