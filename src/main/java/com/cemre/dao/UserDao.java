package com.cemre.dao;

import com.cemre.model.User;
import com.cemre.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

    public void createUser(User user) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
            System.out.println("Kullanıcı oluşturuldu:" + user.getName());
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Kullanıcı oluşturulamadı:" + e.getMessage());
        }
    }
    public User getUserById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            User user = session.get(User.class, id);
            if (user != null) {
                System.out.println("Kullanıcı bulundu:" + user.getId() + " , İsim: " + user.getName());
            } else {
                System.out.println("Kullanıcı bulunamadı");
            }
            return user;
        }
    }
    public void updateUser(User user) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(user);
            tx.commit();
            System.out.println("Kullanıcı güncellendi:" + user);
        } catch (Exception e) {
            if (tx !=null) tx.rollback();
            System.out.println("Kullanıcı güncellenemedi:" + e.getMessage());
        }
    }
    public void deleteUser(User user) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(user);
            tx.commit();
            System.out.println("Kullanıcı silindi:" + user.getName());
        }catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Kullanıcı silinemedi:" + e.getMessage());
        }
    }
}



