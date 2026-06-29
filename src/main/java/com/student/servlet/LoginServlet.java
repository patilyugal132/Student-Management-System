package com.student.servlet;

import com.student.dao.UserDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        UserDAO dao = new UserDAO();

        boolean status =
                dao.login(username, password);

        if(status) {

            HttpSession session =
                    request.getSession();

            session.setAttribute("username", username);

            response.sendRedirect("dashboard");

        } else {

            response.getWriter().println(
                    "<h2>Invalid Username or Password</h2>");
        }
    }
}