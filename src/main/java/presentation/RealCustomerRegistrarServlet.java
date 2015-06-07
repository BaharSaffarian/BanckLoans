package presentation;

import logic.RealCustomerLogic;
import model.RealCustomer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RealCustomerRegistrarServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        RealCustomer realCustomer = new RealCustomer(request.getParameter("FirstName"), request.getParameter("LastName"),
                request.getParameter("FatherName"), request.getParameter("DateOfBirth"),
                request.getParameter("NationalCode"));
        int customerId = RealCustomerLogic.insertCustomer(realCustomer);
        request.setAttribute("CustomerId",customerId);
        if (customerId != -1) {
            request.getRequestDispatcher("CustomerRegistered.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("RealCustomerRegistration.jsp").forward(request,response);
        }


    }


}
