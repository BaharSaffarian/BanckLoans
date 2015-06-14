package logic;

import model.LegalCustomer;
import model.LegalCustomerCRUD;
import org.apache.log4j.Logger;

import java.util.List;

public class LegalCustomerLogic {
    final static Logger logger = Logger.getLogger(LegalCustomerLogic.class);
    public static int registerCustomer(LegalCustomer legalCustomer){
        if(!LegalCustomerCRUD.doesEconomicCodeExists(legalCustomer.getEconomicCode())){
            return LegalCustomerCRUD.insertLegalCustomer(legalCustomer);
        }
        return -1;
    }
    public static List<LegalCustomer> searchLegalCustomer(LegalCustomer legalCustomer) {
        return LegalCustomerCRUD.selectLegalCustomer(legalCustomer);
    }

    public static int updateCustomer(LegalCustomer legalCustomer, String oldEconomicCode) {
        if(!legalCustomer.getEconomicCode().equals(oldEconomicCode) && !LegalCustomerCRUD.doesEconomicCodeExists(legalCustomer.getEconomicCode())){
            if(LegalCustomerCRUD.updateLegalCustomer(legalCustomer)) {
                logger.info("LegalCustomer by id : " + legalCustomer.getId() + " is updated with new values");
                return 1;
            }
        }else if(legalCustomer.getEconomicCode().equals(oldEconomicCode)){
            if(LegalCustomerCRUD.updateLegalCustomer(legalCustomer)) {
                logger.info("LegalCustomer by id : " + legalCustomer.getId() + " is updated with new values");
                return 1;
            }
        }

        logger.error("Economic code exists and LegalCustomer by id : " + legalCustomer.getId() + " could not be updated");
        return -1;
    }

    public static boolean deleteLegalCustomerById(String id) {
        boolean result= LegalCustomerCRUD.deleteLegalCustomerById(id);
        logger.info("LegalCustomer by id : " + id + " is deleted successfully");
        return result;

    }
}
