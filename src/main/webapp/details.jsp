<%@ page import="sda.twitter2.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <link rel="stylesheet" href="static/bootstrap.css">
</head>
<%
    User selectedUser = (User)request.getAttribute("selectedUser");
    User currentUser = (User)request.getSession().getAttribute("user");
%>
<body>
<p><%=selectedUser.getUsername()%></p>
<p><%=selectedUser.getTweets().size()%></p>
<% if(currentUser.getId() == selectedUser.getId()){%>
<form method="post" action="avatar" enctype="multipart/form-data">
    Wybierz avatar:
    <input type="file" name="dataFile" id="fileChooser"/>
    <input type="submit" value="Wyślij" />
</form>
<%}%>
</body>
</html>
