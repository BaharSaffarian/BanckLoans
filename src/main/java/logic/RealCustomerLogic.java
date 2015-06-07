package logic;

import model.RealCustomer;
import model.RealCustomerCRUD;

public class RealCustomerLogic {
    public static int insertCustomer(RealCustomer realCustomer) {

        if (!RealCustomerCRUD.doesNationalCodeExists(realCustomer.getNationalCode())) {
            return RealCustomerCRUD.insertRealCustomer(realCustomer);
        }
        return -1;
    }
}
