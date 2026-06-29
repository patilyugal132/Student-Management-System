package com.student.servlet;

import com.student.dao.StudentDAO;
import com.student.model.Student;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/searchStudent")
public class SearchStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        try {

            int id =
                    Integer.parseInt(
                            request.getParameter("id"));

            StudentDAO dao =
                    new StudentDAO();

            Student student =
                    dao.getStudentById(id);

            response.setContentType("text/html");

            if(student != null) {

                response.getWriter().println(
                        "<h2>Student Found</h2>" +
                                "<p>ID: " + student.getId() + "</p>" +
                                "<p>Name: " + student.getName() + "</p>" +
                                "<p>Age: " + student.getAge() + "</p>"
                );

            } else {

                response.getWriter().println(
                        "<h2>Student Not Found</h2>"
                );
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}