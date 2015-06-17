package presentation;

import logic.LegalCustomerLogic;
import model.LegalCustomer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LegalCustomerRegistrationServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        LegalCustomer legalCustomer = new LegalCustomer(request.getParameter("CompanyName"), request.getParameter("RegisterDate"),
                request.getParameter("EconomicCode"));
        int customerId = LegalCustomerLogic.registerCustomer(legalCustomer);
        request.setAttribute("CustomerId", customerId);
        if (customerId != -1) {
            request.getRequestDispatcher("CustomerRegistered.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("LegalCustomerRegistration.jsp").forward(request, response);
        }

    }
}
