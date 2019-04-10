<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="static/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-4">
            <div class="card">
                <article class="card-body">
                    <h4 class="card-title mb-4 mt-1">Register</h4>
                <form action="register" method="post" class="form-group">
                    <p><label>
                        Username:
                        <input class="form-control" type="text" name="username" />
                    </label></p>
                    <p><label>
                        Password:
                        <input class="form-control"  type="password" name="password" />
                    </label></p>
                    <p><label>
                        Repeat password:
                        <input class="form-control" type="password" name="password2" />
                    </label></p>
                    <button type="submit" class="btn btn-primary">Register</button>
                </form>
                </article>
            </div>
        </div>
    </div>
</div>
</body>
</html>
