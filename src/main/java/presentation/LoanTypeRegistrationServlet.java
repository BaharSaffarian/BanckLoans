package presentation;

import logic.LoanTypeLogic;
import model.GrantCondition;
import model.LoanType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

public class LoanTypeRegistrationServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        String[] names = request.getParameterValues("ConditionName");
        String[] minDurations = request.getParameterValues("MinDuration");
        String[] maxDuration = request.getParameterValues("MaxDuration");
        String[] minAmount = request.getParameterValues("MinAmount");
        String[] maxAmount = request.getParameterValues("MaxAmount");
        Set<GrantCondition> grantConditions = new LinkedHashSet<GrantCondition>();
        LoanType loanType = new LoanType();
        loanType.setName(request.getParameter("LoanTypeName"));
        loanType.setInterestRate(Integer.parseInt(request.getParameter("InterestRate")));
        for (int i = 0; i < names.length; i++) {
            grantConditions.add(new GrantCondition(names[i], Integer.parseInt(minDurations[i]),
                    Integer.parseInt(maxDuration[i]),
                    new BigDecimal(minAmount[i]), new BigDecimal(maxAmount[i])));
        }
        loanType.setGrantConditions(grantConditions);
        int insertResult = LoanTypeLogic.RegisterLoanType(loanType);
        String message = "خطا در ثبت نوع تسهیلات، مجددا تلاش کنید";
        if (insertResult != -1) {
            message = "نوع تسهیلات با موفقیت ثبت شد:" + insertResult;
        }
        request.getSession().setAttribute("message", message);
        request.getRequestDispatcher("Message.jsp").forward(request, response);
    }
}

