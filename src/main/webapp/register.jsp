<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
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
</body>
</html>
