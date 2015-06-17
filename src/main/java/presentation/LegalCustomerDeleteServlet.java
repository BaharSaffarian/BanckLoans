package presentation;

import logic.LegalCustomerLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LegalCustomerDeleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        if (LegalCustomerLogic.deleteLegalCustomerById(request.getParameter("id"))) {
            HttpSession session = request.getSession(false);
            session.setAttribute("message", "مشتری با موفقیت حذف شد");
        }
        request.getRequestDispatcher("Message.jsp").forward(request, response);

    }
}
