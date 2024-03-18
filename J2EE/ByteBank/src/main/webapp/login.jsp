<%--
  Created by IntelliJ IDEA.
  User: Mike
  Date: 18/03/2024
  Time: 8:49 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title>ByteBank</title>
</head>
<body class="bg-dark">
<%@include file="/common/navbar.jsp"%>
<div class="container p-3">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-header">
                    <p class="text-center fs-3">Login Page</p>
                </div>
                <div class="card-body">
                    <form action="" method="">
                        <div class="mb-3">
                            <label>
                                Enter Email:
                                <input type="email" name="email" class="form-control">
                            </label>
                        </div>
                        <div class="mb-3">
                            <label>
                                Password:
                                <input type="password" name="password" class="form-control">
                            </label>
                        </div>
                        <button class="btn btn-success col-md-12 mb-3">Register</button>
                        Don't have an account? <a href="register.jsp">Create one</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <%@include file="/common/footer.jsp"%>
</footer>
</body>
</html>