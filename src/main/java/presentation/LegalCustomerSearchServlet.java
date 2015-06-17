package presentation;

import logic.LegalCustomerLogic;
import model.LegalCustomer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class LegalCustomerSearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        LegalCustomer legalCustomer = new LegalCustomer();
        if (request.getParameter("CustomerId").length() != 0)
            legalCustomer.setId(request.getParameter("CustomerId"));
        if (request.getParameter("CompanyName").length() != 0)
            legalCustomer.setCompanyName(request.getParameter("CompanyName"));
        if (request.getParameter("EconomicCode").length() != 0)
            legalCustomer.setEconomicCode(request.getParameter("EconomicCode"));
        List<LegalCustomer> legalCustomers = LegalCustomerLogic.searchLegalCustomer(legalCustomer);
        //HttpSession session = request.getSession(false);
        request.setAttribute("legalCustomers", legalCustomers);
        request.getRequestDispatcher("LegalCustomerSearch.jsp").forward(request, response);
    }
}
