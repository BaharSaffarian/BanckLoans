package logic;

import model.RealCustomer;
import model.RealCustomerCRUD;
import org.apache.log4j.Logger;

import java.util.List;

public class RealCustomerLogic {
    final static Logger logger = Logger.getLogger(RealCustomerLogic.class);

    public static int insertCustomer(RealCustomer realCustomer) {
        if (!RealCustomerCRUD.doesNationalCodeExists(realCustomer.getNationalCode())) {
            int result = RealCustomerCRUD.insertRealCustomer(realCustomer);
            logger.info("National code has been verified and the real customer is added");
            return result;
        }
        logger.error("National code exists");
        return -1;
    }

    public static List<RealCustomer> searchRealCustomer(RealCustomer realCustomer) {
        return RealCustomerCRUD.selectRealCustomer(realCustomer);
    }

    public static int updateCustomer(RealCustomer realCustomer, String oldNationalCode) {
        if (!realCustomer.getNationalCode().equals(oldNationalCode) && !RealCustomerCRUD.doesNationalCodeExists(realCustomer.getNationalCode())) {
            if (RealCustomerCRUD.updateRealCustomer(realCustomer)) {
                logger.info("RealCustomer by id : " + realCustomer.getId() + " is updated with new values");
                return 1;
            }
        } else if (realCustomer.getNationalCode().equals(oldNationalCode)) {
            if (RealCustomerCRUD.updateRealCustomer(realCustomer)) {
                logger.info("RealCustomer by id : " + realCustomer.getId() + " is updated with new values");
                return 1;
            }
        }
        logger.error("National code exists and RealCustomer by id : " + realCustomer.getId() + " could not be updated");
        return -1;
    }

    public static boolean deleteRealCustomerById(String id) {
        boolean result = RealCustomerCRUD.deleteRealCustomerById(id);
        logger.info("RealCustomer by id : " + id + " is deleted successfully");
        return result;

    }

    public static RealCustomer searchRealCustomerById(String id) {
        RealCustomer realCustomer = RealCustomerCRUD.selectRealCustomerById(id);
        if (realCustomer == null) {
            logger.error("Customer by id: " + id + " does not exists");
        } else {
            logger.info("Customer is retrieved successfully, firstName: " + realCustomer.getFirstName() + " lastName: " + realCustomer.getLastName());
        }
        return realCustomer;
    }
}
