<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="static/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-4">
            <div class="card">
                <article class="card-body">
                    <h4 class="card-title mb-4 mt-1">Login</h4>
                    <form action="login" method="post" class="form-group">
                        <p><label>
                            Login:
                            <input class="form-control" type="text" name="username" />
                        </label></p>
                        <p><label>
                            Password:
                            <input class="form-control"  type="password" name="password" />
                        </label></p>
                        <button type="submit" class="btn btn-primary">Log in</button>
                    </form>
                </article>
            </div>
        </div>
    </div>
</div>
</body>
</html>
