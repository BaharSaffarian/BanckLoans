package logic;

import model.*;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.Set;

public class LoanFileLogic {
    final static Logger logger = Logger.getLogger(LoanFile.class);

    public static int RegisterLoanFile(LoanFile loanFile) {
        LoanType loanType = LoanTypeCRUD.selectLoanTypeById(loanFile.getLoanTypeId());
        Set<GrantCondition> grantConditions = loanType.getGrantConditions();
        Iterator<GrantCondition> iterator = grantConditions.iterator();
        boolean requestAcceptance = false;
        while (iterator.hasNext()) {
            GrantCondition grantCondition = iterator.next();
            if ((loanFile.getDuration() >= grantCondition.getMinDuration() && loanFile.getDuration() <= grantCondition.getMaxDuration()) &&
                    (loanFile.getAmount().compareTo(grantCondition.getMinAmount()) >= 0 &&
                            loanFile.getAmount().compareTo(grantCondition.getMaxAmount()) <= 0)) {
                requestAcceptance = true;
            }
        }
        int result = -1;
        if (requestAcceptance) {
            result = LoanFileCRUD.insertLoanFile(loanFile);
            logger.info("Requested loan file is added and its id is:" + result);
        } else {
            logger.error("Grant Conditions are violated for loan file insertion request");
        }

        return result;
    }
}
