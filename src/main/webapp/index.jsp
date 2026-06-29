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

<title>Add Student</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-primary text-white">

            <h3>Student Management System</h3>

        </div>

        <div class="card-body">

            <form action="addStudent" method="post">

                <div class="mb-3">

                    <label class="form-label">
                        Student Name
                    </label>

                    <input type="text"
                           name="name"
                           class="form-control">

                </div>

                <div class="mb-3">

                    <label class="form-label">
                        Age
                    </label>

                    <input type="number"
                           name="age"
                           class="form-control">

                </div>

                <button class="btn btn-success">

                    Save Student

                </button>

                <a href="viewStudents"
                   class="btn btn-primary">

                    View Students

                </a>

            </form>

        </div>

    </div>

</div>

</body>
</html>