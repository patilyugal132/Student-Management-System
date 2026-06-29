package com.student.servlet;

import com.student.dao.StudentDAO;
import com.student.model.Student;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewStudents")
public class ViewStudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        try {

            StudentDAO dao = new StudentDAO();

            List<Student> students =
                    dao.getAllStudents();

            request.setAttribute(
                    "students",
                    students);

            String msg = request.getParameter("msg");
            request.setAttribute("msg", msg);

            request.getRequestDispatcher(
                            "viewStudents.jsp")
                    .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
