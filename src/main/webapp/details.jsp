<%@ page import="sda.twitter2.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<%
    User selectedUser = (User)request.getAttribute("selectedUser");
    String currentUserId = null;
    for(Cookie c : request.getCookies()){
        if(c.getName().equals("userId")){
            currentUserId = c.getValue();
        }
    }
%>
<body>
<p><%=selectedUser.getUsername()%></p>
<p><%=selectedUser.getTweets().size()%></p>
<% if(Integer.parseInt(currentUserId) == selectedUser.getId()){%>
<form method="post" action="avatar" enctype="multipart/form-data">
    Wybierz avatar:
    <input type="file" name="dataFile" id="fileChooser"/>
    <input type="submit" value="Wyślij" />
</form>
<%}%>
</body>
</html>
