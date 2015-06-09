package logic;

import model.LegalCustomer;
import model.LegalCustomerCRUD;

public class LegalCustomerLogic {
    public static int registerCustomer(LegalCustomer legalCustomer){
        if(!LegalCustomerCRUD.doesEconomicCodeExists(legalCustomer.getEconomicCode())){
            return LegalCustomerCRUD.insertLegalCustomer(legalCustomer);
        }
        return -1;
    }
}
