<!DOCTYPE html>
<html>
<head>

<title>Search Student</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-warning">

            <h3>Search Student</h3>

        </div>

        <div class="card-body">

            <form action="searchStudent"
                  method="get">

                <label>Student ID</label>

                <input type="number"
                       name="id"
                       class="form-control">

                <br>

                <button class="btn btn-primary">

                    Search

                </button>

            </form>

        </div>

    </div>

</div>

</body>
</html>