package logic;


import model.LoanType;
import model.LoanTypeCRUD;
import org.apache.log4j.Logger;

import java.util.List;

public class LoanTypeLogic {
    final static Logger logger = Logger.getLogger(LoanType.class);

    public static int RegisterLoanType(LoanType loanType) {
        int result = LoanTypeCRUD.insertLoanType(loanType);
        logger.info("Requested loan type is added and its id is:" + result);
        return result;
    }

    public static List<LoanType> getLoanTypes() {
        List<LoanType> loanTypes = LoanTypeCRUD.selectLoanType();
        logger.info("Loan types retrieved, total:" + loanTypes.size());
        return loanTypes;
    }
}
