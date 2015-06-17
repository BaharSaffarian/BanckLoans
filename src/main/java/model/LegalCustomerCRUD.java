package model;


import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class LegalCustomerCRUD {
    final static Logger logger = Logger.getLogger(LegalCustomerCRUD.class);
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


    public static boolean doesEconomicCodeExists(String economicCode) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        LegalCustomer legalCustomer = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from LegalCustomer ls where ls.economicCode= :economicCode").setParameter("economicCode", economicCode);
            legalCustomer = (LegalCustomer) query.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return legalCustomer != null;
    }

    public static int insertLegalCustomer(LegalCustomer legalCustomer) {

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int customer_id = -1;
        try {
            transaction = session.beginTransaction();
            customer_id = Integer.parseInt(session.save(legalCustomer).toString());
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                logger.error("Cannot insert the customer");
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return customer_id;
    }

    public static List<LegalCustomer> selectLegalCustomer(LegalCustomer legalCustomer) {
        List<LegalCustomer> legalCustomers = new ArrayList<LegalCustomer>();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String queryStr = "SELECT lc FROM Customer c,LegalCustomer lc WHERE c.id = lc.id";
            if (legalCustomer.getId() != null) {
                queryStr = queryStr + "  AND lc.id = :id";
            }
            if (legalCustomer.getCompanyName() != null) {
                queryStr = queryStr + "  AND lc.companyName = :companyName";
            }
            if (legalCustomer.getEconomicCode() != null) {
                queryStr = queryStr + " AND lc.economicCode = :economicCode";
            }

            Query query = session.createQuery(queryStr);

            if (legalCustomer.getId() != null) {
                query.setParameter("id", legalCustomer.getId());
            }
            if (legalCustomer.getCompanyName() != null) {
                query.setParameter("companyName", legalCustomer.getCompanyName());
            }
            if (legalCustomer.getEconomicCode() != null) {
                query.setParameter("economicCode", legalCustomer.getEconomicCode());
            }

            legalCustomers = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                logger.error("cannot select the Legal customer");
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return legalCustomers;
    }

    public static boolean updateLegalCustomer(LegalCustomer legalCustomer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int result = 0;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update LegalCustomer lc set lc.companyName = :companyName , " +
                    "lc.registerDate = :registerDate , lc.economicCode = :economicCode  where lc.id = :id");
            query.setParameter("id", legalCustomer.getId());
            query.setParameter("companyName", legalCustomer.getCompanyName());
            query.setParameter("registerDate", legalCustomer.getRegisterDate());
            query.setParameter("economicCode", legalCustomer.getEconomicCode());
            result = query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                logger.error("cannot update the Legal customer");
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return result > 0;

    }

    public static boolean deleteLegalCustomerById(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int result = 0;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete LegalCustomer lc where lc.id = :id");
            query.setParameter("id", id);
            result = query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                logger.error("cannot delete the legal customer with the specified id");
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        if (result > 0)
            return true;
        return false;
    }
}

