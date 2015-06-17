package model;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class LoanTypeCRUD {

    final static Logger logger = Logger.getLogger(LoanTypeCRUD.class);
    static SessionFactory sessionFactory;

    static {
        Configuration cfg = new Configuration().addResource("hibernate.cfg.xml").configure();
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        try {
            sessionFactory = cfg.buildSessionFactory(ssrb.build());
            logger.info("session successfully created");
        } catch (Throwable e) {
            logger.error("Failed to create session factory");
            e.printStackTrace();
        }
    }

    public static int insertLoanType(LoanType loanType) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int loanTypeId = -1;
        try {
            transaction = session.beginTransaction();
            loanTypeId = Integer.parseInt(session.save(loanType).toString());
            Iterator<GrantCondition> iterator = loanType.getGrantConditions().iterator();
            while (iterator.hasNext()) {
                GrantCondition grantCondition = iterator.next();
                grantCondition.setLoanType(loanType);
                session.save(grantCondition);
            }
                transaction.commit();
                logger.info("loan type is added successfully:" + loanType.getId());


        } catch (HibernateException e) {
            logger.error("Could not add the loan type");
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return loanTypeId;
    }

    public static List<LoanType> selectLoanType() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<LoanType> loanTypes = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from LoanType");
            loanTypes = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                logger.error("transaction is rolled back");
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return loanTypes;
    }

    public static LoanType selectLoanTypeById(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        LoanType loanType = null;
        try {
            transaction = session.beginTransaction();
            loanType = (LoanType) session.get(LoanType.class, id);
            Iterator iterator = loanType.getGrantConditions().iterator();
            while (iterator.hasNext()) {
                GrantCondition grantCondition = (GrantCondition) iterator.next();
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                logger.error("select Loan Type by id transaction is rolled back");
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return loanType;
    }

}
