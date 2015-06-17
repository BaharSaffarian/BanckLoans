package presentation;

import logic.LoanTypeLogic;
import logic.RealCustomerLogic;
import model.LoanType;
import model.RealCustomer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoanFileSearchCustomerByIdServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        RealCustomer realCustomer;
        realCustomer = RealCustomerLogic.searchRealCustomerById(request.getParameter("CustomerId"));
        List<LoanType> loanTypeList = LoanTypeLogic.getLoanTypes();
        if (realCustomer != null) {
            request.setAttribute("firstName", realCustomer.getFirstName());
            request.setAttribute("lastName", realCustomer.getLastName());
            request.setAttribute("id", realCustomer.getId());
            request.setAttribute("loanTypes", loanTypeList);
        } else {
            request.setAttribute("notExist", "مشتری مورد نظر موجود نیست");
        }
        request.getRequestDispatcher("loanFileRegistration.jsp").forward(request, response);
    }
}
