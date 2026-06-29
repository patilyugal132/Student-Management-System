<h1 style="color:red">JSP WORKING</h1>
<%@ page import="java.util.List" %>
<%@ page import="com.student.model.Student" %>

<!DOCTYPE html>
<html>
<head>

<title>View Students</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-primary text-white">

            <h3>Student List</h3>

        </div>

        <div class="card-body">
        <%
        String msg = (String) request.getAttribute("msg");

        if(msg != null) {

            if(msg.equals("added")) {
        %>

        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong>Success!</strong> Student Added Successfully.
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>

        <%
            } else if(msg.equals("updated")) {
        %>

        <div class="alert alert-primary alert-dismissible fade show" role="alert">
            <strong>Success!</strong> Student Updated Successfully.
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>

        <%
            } else if(msg.equals("deleted")) {
        %>

        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong>Success!</strong> Student Deleted Successfully.
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>

        <%
            } else if(msg.equals("error")) {
        %>

        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <strong>Error!</strong> Something went wrong.
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>

        <%
            }
        }
        %>

            <table class="table table-bordered table-striped">

                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Action</th>
                </tr>

                <%
                    List<Student> students =
                            (List<Student>) request.getAttribute("students");

                    for(Student s : students){
                %>

                <tr>

                    <td><%= s.getId() %></td>
                    <td><%= s.getName() %></td>
                    <td><%= s.getAge() %></td>

                    <td>

                        <a href="editStudent?id=<%= s.getId() %>"
                           class="btn btn-warning btn-sm">

                            Update

                        </a>

                        <a href="deleteStudent?id=<%= s.getId() %>"
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this student?')">
                            Delete
                        </a>

                    </td>

                </tr>

                <%
                    }
                %>

            </table>

            <a href="index.jsp"
               class="btn btn-success">

                Add Student

            </a>

        </div>

    </div>

</div>

</body>
</html>