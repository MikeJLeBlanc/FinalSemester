<%@ page import="com.example.jdbcdemo.database.UserDatabase" %>
<%@ page import="static com.example.jdbcdemo.database.MySQLConnection.getConnection" %>
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Mike
  Date: 09/02/2024
  Time: 8:54 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String SQL_SELECT = "SELECT userId, userName, userCity FROM USER";
    ResultSet rs = null;
    Connection conn = null;
    PreparedStatement pStatement = null;
    try {
        conn = getConnection();
        pStatement = conn.prepareStatement(SQL_SELECT);

        rs = pStatement.executeQuery();
    %>
<table>
    <% while (rs.next())
    {
    %>
    <tr>
        <td><%=rs.getInt(1)%></td>
        <td><%=rs.getString(2)%></td>
        <td><%=rs.getString(3)%></td>
    </tr>

    <%
            }
    } catch(SQLSyntaxErrorException ex)
        {
        System.err.println("error: " + ex);
        }
        finally
        {
            pStatement.close();
            conn.close();
        }
    %>
</table>
</body>
</html>
