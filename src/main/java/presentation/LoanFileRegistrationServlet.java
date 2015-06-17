package presentation;

import logic.LoanFileLogic;
import model.LoanFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class LoanFileRegistrationServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        LoanFile loanFile = new LoanFile();
        loanFile.setLoanTypeId(request.getParameter("LoanType"));
        loanFile.setCustomerId(request.getParameter("CustomerId"));
        loanFile.setDuration(Integer.parseInt(request.getParameter("Duration")));
        loanFile.setAmount(new BigDecimal(request.getParameter("Amount")));
        int insertResult = LoanFileLogic.RegisterLoanFile(loanFile);
        String message = "درخواست با شروط اعطای نوع تسهیلات مطابقت ندارد";
        if (insertResult != -1) {
            message = "پرونده تسهیلاتی با موفقیت ثبت شد: " + insertResult;
        }
        request.getSession().setAttribute("message", message);
        request.getRequestDispatcher("Message.jsp").forward(request, response);
    }
}
