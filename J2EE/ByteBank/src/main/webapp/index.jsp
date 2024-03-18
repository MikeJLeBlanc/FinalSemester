<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title>ByteBank</title>
</head>
<body class="bg-dark">
<%@include file="/common/navbar.jsp"%>
<div id="carouselExample" class="carousel slide">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="${pageContext.request.contextPath}/images/income.png" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/images/expense.png" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/images/loan.png" class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<footer>
    <%@include file="/common/footer.jsp"%>
</footer>
</body>
</html>