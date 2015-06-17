package presentation;

import logic.RealCustomerLogic;
import model.RealCustomer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class RealCustomerUpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        RealCustomer realCustomer = new RealCustomer(request.getParameter("id"), request.getParameter("firstName"), request.getParameter("lastName"),
                request.getParameter("fatherName"), request.getParameter("birthDate"), request.getParameter("nationalCode"));
        HttpSession session = request.getSession(false);
        if (RealCustomerLogic.updateCustomer(realCustomer, request.getParameter("oldNationalCode")) != -1) {
            session.setAttribute("message", "اطلاعات مشتری با موفقیت تغییر یافت");
        } else {
            session.setAttribute("message", "کد ملی تکراریست، مجددا تلاش کنید");
        }
        request.getRequestDispatcher("Message.jsp").forward(request, response);
    }
}
