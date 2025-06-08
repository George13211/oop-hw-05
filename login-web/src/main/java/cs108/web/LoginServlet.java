package cs108.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountManager account = (AccountManager) getServletContext().getAttribute("accountManager");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String error = null;

        if (account.exists(name)) {
            if (!account.matchesPassword(name, password)) {
                error = "yes";
                request.setAttribute("error", error);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.setAttribute("name", name);
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            }
        } else if (!account.exists(name)){
            error = "yes";
            request.setAttribute("error", error);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}