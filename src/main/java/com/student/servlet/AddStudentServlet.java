package com.student.servlet;

import com.student.dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(
                request.getParameter("age"));

        StudentDAO dao = new StudentDAO();

        boolean status =
                dao.saveStudent(name, age);

        if(status) {

            response.sendRedirect("viewStudents?msg=added");

        } else {

            response.sendRedirect("viewStudents?msg=error");
        }
    }
}