package model;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class RealCustomerCRUD {
    final static Logger logger = Logger.getLogger(RealCustomerCRUD.class);
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
            Query query = session.createQuery("from RealCustomer rs where rs.nationalCode = :nationalCode").setParameter("nationalCode",nationalCode);
            realCustomer = (RealCustomer) query.uniqueResult();
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

    public static List<RealCustomer> selectRealCustomer(RealCustomer realCustomer) {
        List<RealCustomer> realCustomers = new ArrayList<RealCustomer>();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction=session.beginTransaction();
            //Query q = session.createQuery("FROM Customer c,RealCustomer rc WHERE c.id = rc.id  AND rc.id = :id  AND rc.firstName = :firstName  AND rc.lastName = :lastName  AND rc.nationalCode = :nationalCode");
            String queryStr = "SELECT rc FROM Customer c,RealCustomer rc WHERE c.id = rc.id";
            if (realCustomer.getId() != null) {
                queryStr = queryStr + "  AND rc.id = :id";
            }
            if (realCustomer.getFirstName() != null) {
                queryStr = queryStr + "  AND rc.firstName = :firstName";
            }
            if (realCustomer.getLastName() != null) {
                queryStr = queryStr+ " AND rc.lastName = :lastName";
            }
            if (realCustomer.getNationalCode() != null) {
                queryStr = queryStr + " AND rc.nationalCode = :nationalCode";
            }
            Query query=session.createQuery(queryStr);
            //int index = 1;
            if (realCustomer.getId() != null) {
                query.setParameter("id",realCustomer.getId());
            }
            if (realCustomer.getFirstName() != null) {
                query.setParameter("firstName", realCustomer.getFirstName());
            }
            if (realCustomer.getLastName() != null) {
                query.setParameter("lastName", realCustomer.getLastName());
            }
            if (realCustomer.getNationalCode() != null) {
                query.setParameter("nationalCode" , realCustomer.getNationalCode());
            }
            realCustomers = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return realCustomers;
    }

    public static boolean updateRealCustomer(RealCustomer realCustomer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int result=0;
        try {
            transaction=session.beginTransaction();
            Query query=session.createQuery("update RealCustomer rc set rc.firstName = :firstName , " +
                    "rc.lastName = :lastName , rc.fatherName = :fatherName , rc.dateOfBirth = :birthDate , " +
                    "rc.nationalCode = :nationalCode where rc.id = :id ");
            query.setParameter("id", realCustomer.getId());
            query.setParameter("firstName",realCustomer.getFirstName());
            query.setParameter("lastName",realCustomer.getLastName());
            query.setParameter("fatherName",realCustomer.getFatherName());
            query.setParameter("birthDate",realCustomer.getDateOfBirth());
            query.setParameter("nationalCode",realCustomer.getNationalCode());
            result=query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        if (result > 0)
            return true;
        return false;

    }

    public static boolean deleteRealCustomerById(String id) {
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        int result=0;
        try {
            transaction=session.beginTransaction();
            Query query=session.createQuery("delete RealCustomer rc where rc.id = :id");
            query.setParameter("id",id);
            result=query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        }finally {
            session.close();
        }
        if (result > 0)
            return true;
        return false;
    }

    public static RealCustomer selectRealCustomerById(String id){
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        RealCustomer realCustomer=null;
        try {
            transaction=session.beginTransaction();
            realCustomer=(RealCustomer) session.get(RealCustomer.class,id);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction!=null){
                transaction.rollback();
                logger.error("transaction is rolled back");
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
        return realCustomer;
    }

}
