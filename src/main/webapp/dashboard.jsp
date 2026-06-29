<%
    String username =
            (String) session.getAttribute("username");

    if(username == null){
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>

<title>Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

    <div class="container">

        <a class="navbar-brand"
           href="#">

            Student Management

        </a>

        <div>

            <a href="index.jsp"
               class="btn btn-success">

                Add Student

            </a>

            <a href="searchStudent.jsp"
               class="btn btn-warning">

                Search Student

            </a>

            <a href="viewStudents"
               class="btn btn-primary">

                View Students

            </a>

            <a href="logout"
               class="btn btn-danger">

                Logout

            </a>

        </div>

    </div>

</nav>

<div class="container mt-5">

    <div class="card shadow">

<div class="card-body">

    <h2>
        Welcome, <%= username %>
    </h2>

    <p>
        Student Management System Dashboard
    </p>

    <div class="row mt-4">

        <div class="col-md-4">

            <div class="card bg-primary text-white shadow">

                <div class="card-body text-center">

                    <h5>Total Students</h5>

                    <h1><%= request.getAttribute("totalStudents") %></h1>

                </div>

            </div>

        </div>

    </div>

</div>

    </div>

</div>

</body>
</html>