package com.student.servlet;

import com.student.dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        StudentDAO dao = new StudentDAO();

        int totalStudents = dao.getStudentCount();

        request.setAttribute("totalStudents", totalStudents);

        request.getRequestDispatcher("dashboard.jsp")
                .forward(request, response);
    }
}