package com.student.servlet;

import com.student.dao.StudentDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id"));

        String name =
                request.getParameter("name");

        int age = Integer.parseInt(
                request.getParameter("age"));

        StudentDAO dao =
                new StudentDAO();

        boolean status =
                dao.updateStudent(id, name, age);

        if(status) {

            response.sendRedirect("viewStudents?msg=updated");

        } else {

            response.getWriter().println(
                    "<h2>Update Failed</h2>");
        }
    }
}