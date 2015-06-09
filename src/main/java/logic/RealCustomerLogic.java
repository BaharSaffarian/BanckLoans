package logic;

import model.RealCustomer;
import model.RealCustomerCRUD;
import org.apache.log4j.Logger;

public class RealCustomerLogic {
    final static Logger logger = Logger.getLogger(RealCustomerLogic.class);

    public static int insertCustomer(RealCustomer realCustomer) {
        if (!RealCustomerCRUD.doesNationalCodeExists(realCustomer.getNationalCode())) {
            int result=RealCustomerCRUD.insertRealCustomer(realCustomer);
            logger.info("National code has been verified and the real customer is added");
            return result;
        }
        logger.error("National code exists");
        return -1;
    }
}
