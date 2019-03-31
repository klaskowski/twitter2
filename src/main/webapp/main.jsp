<%@ page import="sda.twitter2.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twitter 2</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%
    User currentUser = currentUser = (User)request.getAttribute("user");
%>
<nav class="navbar navbar-dark bg-dark">
    <p>Hello <%=currentUser.getUsername()%></p>
    <a href="details?id=<%=currentUser.getId()%>">
        <img alt="avatar" src="avatars/<%=currentUser.getId()%>.jpg">
    </a>
    <button class="btn btn-primary" id="add-tweet-button">+ Add tweet</button>
    <a href="/twitter2/logout" class="btn btn-secondary">Log out</a>
</nav>
<div id="add-tweet" class="d-none">
    <label>
        Content:
        <textarea class="form-control" name="content" id="new-tweet-content"></textarea>
    </label>
    <button id="post-tweet" class="btn btn-primary">Post tweet</button>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<script>
    $("#post-tweet").click(function(){
        fetch("tweet",
            {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                method: "POST",
                body: "content=" + $("#new-tweet-content").val()
            })
        .then(function (result) {
            //console.log(result)
            $("#add-tweet").toggleClass("d-none")
            $("#add-tweet-button").toggleClass("d-none")
        })
    })

    $("#add-tweet-button").click(function(){
        $("#add-tweet").removeClass("d-none")
        $("#add-tweet-button").addClass("d-none")
    })
</script>
</body>
</html>
