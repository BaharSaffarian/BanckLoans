package presentation;


import model.GrantCondition;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GrantConditionsDefinitionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        GrantCondition grantCondition = new GrantCondition(request.getParameter("ConditionName"), Integer.parseInt(request.getParameter("MinDuration")),
                Integer.parseInt(request.getParameter("MaxDuration")), new BigDecimal(request.getParameter("MinAmount").toString()), new BigDecimal(request.getParameter("MaxAmount").toString()));
        HttpSession session = request.getSession(false);
        List<GrantCondition> grantConditions;
        if (session.getAttribute("grantConditions") == null) {
            grantConditions = new ArrayList<GrantCondition>();
        } else {
            grantConditions = (ArrayList<GrantCondition>) session.getAttribute("grantConditions");
        }
        grantConditions.add(grantCondition);
        session.setAttribute("grantConditions", grantConditions);
        request.getRequestDispatcher("GrantConditionsDefinition.jsp").forward(request, response);
    }
}
