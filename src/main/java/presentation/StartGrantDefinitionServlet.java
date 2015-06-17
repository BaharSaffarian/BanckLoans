package presentation;

import model.LoanType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class StartGrantDefinitionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        httpSession.setAttribute("grantConditions", null);
        LoanType loanType = new LoanType();
        loanType.setName(request.getParameter("TypeName"));
        loanType.setInterestRate(Integer.parseInt(request.getParameter("InterestRate")));
        httpSession.setAttribute("LoanType", loanType);
        request.getRequestDispatcher("GrantConditionsDefinition.jsp").forward(request, response);
    }
}
