<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.jdbcdemo.database.UserDatabase" %>
<%@ page import="com.example.jdbcdemo.model.User" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<%
    UserDatabase database = new UserDatabase();

    List<User> users = database.select();

    for (User user : users) {
        
    }
%>

</body>
</html>