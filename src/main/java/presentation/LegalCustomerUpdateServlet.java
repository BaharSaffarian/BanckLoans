package presentation;

import logic.LegalCustomerLogic;
import model.LegalCustomer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LegalCustomerUpdateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        LegalCustomer legalCustomer = new LegalCustomer(request.getParameter("id"), request.getParameter("companyName"), request.getParameter("registerDate"),
                request.getParameter("economicCode"));
        HttpSession httpSession = request.getSession(false);
        if (LegalCustomerLogic.updateCustomer(legalCustomer, request.getParameter("oldEconomicCode")) != -1) {
            httpSession.setAttribute("message", "اطلاعات مشتری با موفقیت تغییر یافت");
        } else {
            httpSession.setAttribute("message", "کد اقتصادی تکراری است لطفا مجددا تلاش کنید");
        }
        request.getRequestDispatcher("Message.jsp").forward(request, response);
    }
}
