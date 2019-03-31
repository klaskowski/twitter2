<%@ page import="sda.twitter2.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<%
    User currentUser = (User)request.getAttribute("selectedUser");
%>
<body>
<p><%=currentUser.getUsername()%></p>
<p><%=currentUser.getTweets().size()%></p>
</body>
</html>
