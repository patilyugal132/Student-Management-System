package com.student.servlet;

import com.student.dao.StudentDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id"));

        StudentDAO dao =
                new StudentDAO();

        dao.deleteStudent(id);

        response.sendRedirect("viewStudents?msg=deleted");
    }
}