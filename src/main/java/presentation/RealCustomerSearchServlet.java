package presentation;

import logic.RealCustomerLogic;
import model.RealCustomer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class RealCustomerSearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        RealCustomer realCustomer = new RealCustomer();
        if (request.getParameter("CustomerId").length() != 0)
            realCustomer.setId(request.getParameter("CustomerId"));
        if (request.getParameter("FirstName").length() != 0)
            realCustomer.setFirstName(request.getParameter("FirstName"));
        if (request.getParameter("LastName").length() != 0)
            realCustomer.setLastName(request.getParameter("LastName"));
        if (request.getParameter("NationalCode").length() != 0)
            realCustomer.setNationalCode(request.getParameter("NationalCode"));
        List<RealCustomer> realCustomers = RealCustomerLogic.searchRealCustomer(realCustomer);

        request.setAttribute("realCustomers", realCustomers);
        request.getRequestDispatcher("RealCustomerSearch.jsp").forward(request, response);
    }
}
