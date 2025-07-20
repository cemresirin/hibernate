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

            //CREATE
        //   Student student = new Student("Cemre" , "Şirin");;
        //   session.persist(student);

             //rollback deneme
        //   Student student2 =null;
        //    System.out.println(student2.getName());


            //READ
        //    Student student=session.get(Student.class,1);
        //    if (student !=null) {
        //        System.out.println("Öğrenci adı:"+ student.getName());
        //    }else {
        //        System.out.println("Öğrenci bulunamadı");
        //    }

            //UPDATE
        //    Student studentUpdate =session.get(Student.class,1);
        //    if (studentUpdate !=null) {
        //        studentUpdate.setName("Ceylin" );
        //        studentUpdate.setLastName("Bal");
        //        session.update(studentUpdate);
        //    }

            //DELETE
        //    Student studentDelete = session.get(Student.class,2);
        //    if (studentDelete !=null) {
        //        session.delete(studentDelete);
        //        System.out.println("Öğrenci silindi:" +studentDelete.getName());
        //    }else {
        //        System.out.println("Silinecek öğrenci bulunamadı");
        //    }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println("Rollback çalıştı");
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}