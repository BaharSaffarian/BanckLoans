package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class RealCustomerCRUD {
    static SessionFactory sessionFactory;
    static {
        Configuration cfg = new Configuration().addResource("hibernate.cfg.xml").configure();
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        try {
            sessionFactory = cfg.buildSessionFactory(ssrb.build());
        } catch (Throwable e) {
            System.err.println("Failed to create session factory");
            e.printStackTrace();
        }
    }


    public static boolean doesNationalCodeExists(String nationalCode) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        RealCustomer realCustomer = null;
        try {
            transaction = session.beginTransaction();
            realCustomer = (RealCustomer) session.get(RealCustomer.class, nationalCode);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        if (realCustomer == null)
            return false;
        return true;
    }

    public static int insertRealCustomer(RealCustomer realCustomer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int customer_id = -1;
        try {
            transaction = session.beginTransaction();
            customer_id = Integer.parseInt(session.save(realCustomer).toString());
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return customer_id;
    }


}
