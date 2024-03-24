<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History | ByteBank</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<%@include file="common/head.jsp"%>

<style>
body {
	background-image: url('pay1.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	background-position: center center;
}
@media only screen and (max-width: 720px) {
	body {
		background-image: url('pay1.jpg');
	}
}
table {
	font-size: 15px;
	border: 1px solid black;
}
th, td {
	font-size: 15px;
	width: 400%;
}
#h {
	color: black;
}
</style>
</head>
<body>
	<div class="site-mobile-menu">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close mt-3">
				<span class="icon-close2 js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>
	<%@include file="common/header.jsp"%>
	<br>
	<br>
	<br>
	<section class="signup">
		<!-- Sign up form -->
		<div class="container" align="">
			<div class="signup-content">
				<div class="signup-form">
					<h3 id="h" class="form-title"><strong>Recharge Transactions</strong></h3>
					<c:if test="${requestScope.message !=null}">
					NOTE : ${message}
					</c:if>
					<c:if
						test="${requestScope.rech !=null and
 					not empty requestScope.rech}">
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Username</th>
										<th>Mobile No</th>
										<th>Amount</th>
										<th>Service Provider</th>
										<th>Date</th>
									</tr>
								</thead>
								<c:forEach items="${requestScope.rech}" var="c">
									<tbody>
										<tr>
											<td><c:out value="${c.usrname }" /></td>
											<td><c:out value="${c.mobno }" /></td>
											<td><c:out value="${c.amt }" /></td>
											<td><c:out value="${c.operator }" /></td>
											<td><c:out value="${c.date}" /></td>
										</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	<section class="signup">
		<!-- Sign up form -->
		<div class="container">
			<div class="signup-content">
				<div class="signup-form">
					<h3 id="h" class="form-title"><strong>Deposit/Withdrawl Transactions</strong></h3>
					<c:if
						test="${requestScope.rech2 !=null and
 					not empty requestScope.rech2}">
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Username</th>
										<th>Amount</th>
										<th>Date</th>
										<th>Transaction Type</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${requestScope.rech2}" var="d">
										<tr>
											<td><c:out value="${d.username }" /></td>
											<td><c:out value="${d.amount }" /></td>
											<td><c:out value="${d.date1 }" /></td>
											<td><c:out value="${d.type }" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	<%@include file="common/footer.jsp"%>
</body>
</html>