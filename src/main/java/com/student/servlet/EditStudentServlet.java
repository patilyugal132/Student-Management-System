package com.student.servlet;

import com.student.dao.StudentDAO;
import com.student.model.Student;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id"));

        StudentDAO dao =
                new StudentDAO();

        Student student =
                dao.getStudentById(id);

        response.setContentType("text/html");

        response.getWriter().println(
                "<h2>Update Student</h2>" +

                        "<form action='updateStudent' method='post'>" +

                        "<input type='hidden' name='id' value='"
                        + student.getId() + "'>" +

                        "Name: <input type='text' name='name' value='"
                        + student.getName() + "'><br><br>" +

                        "Age: <input type='number' name='age' value='"
                        + student.getAge() + "'><br><br>" +

                        "<input type='submit' value='Update'>" +

                        "</form>"
        );
    }
}