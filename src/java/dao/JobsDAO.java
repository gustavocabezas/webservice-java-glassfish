/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Jobs;
import entity.Users;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gustavo
 */
public class JobsDAO {

    public static void insert(Jobs e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(e);
            tx.commit();
        } catch (Exception ex) {
            System.out.print(ex);
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

    public static Jobs getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Jobs) session.createQuery("FROM Jobs WHERE id = :id")
                    .setParameter("id", id)
                    .uniqueResult();
        } catch (Exception e) {
            // Aquí puedes manejar la excepción, por ejemplo, loggearla.
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void update(Jobs e) {
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
            Jobs jobToDelete = (Jobs) session.get(Jobs.class, id);
            if (jobToDelete != null) {
                session.delete(jobToDelete);
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

}
