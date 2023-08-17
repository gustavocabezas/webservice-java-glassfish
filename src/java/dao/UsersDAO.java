/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Users;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gustavo
 */
public class UsersDAO {

    public static void insert(Users e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(e);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex; // Puedes manejar la excepción o simplemente re-lanzarla.
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static Users getByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Users) session.createQuery("FROM Users WHERE PrimaryEmail = :email")
                    .setParameter("email", email)
                    .uniqueResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean emailExists(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("FROM Users WHERE PrimaryEmail = :email");
            query.setParameter("email", email);
            return (query.uniqueResult() != null);
        } catch (Exception e) {
            // Handle the exception or log it
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void update(Users e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(e);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Users userToDelete = (Users) session.get(Users.class, id);
            if (userToDelete != null) {
                session.delete(userToDelete);
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void main(String[] args) {
        Users e = new Users(0, 1, "hibernate2", "hibernate2@gmail.com", "123", 1, new Date(), 0);
        insert(e);
        System.out.println(e);
    }
}
