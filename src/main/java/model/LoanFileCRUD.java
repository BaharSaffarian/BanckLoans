package model;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by DOTIN SCHOOL 3 on 6/15/2015.
 */
public class LoanFileCRUD {
    final static Logger logger = Logger.getLogger(LoanFileCRUD.class);
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

    public static int insertLoanFile(LoanFile loanFile) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int loanFileId = -1;
        try {
            transaction = session.beginTransaction();
            loanFileId = Integer.parseInt(session.save(loanFile).toString());
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                logger.error("Transaction for loan file insertion is rolled back");
            }
        } finally {
            session.close();
        }
        return loanFileId;
    }
}
