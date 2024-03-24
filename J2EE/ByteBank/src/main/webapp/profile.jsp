<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile | ByteBank</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<%@include file="common/head.jsp"%>

<style>
input {
	color: black;
}
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
h3 {
	color: white;
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
	<%!String msg = null;%>
		<%
		if (!session.isNew()) {
			msg = (String) session.getAttribute("profiles");
			if(msg != null){
				%>
			<script type="text/javascript">
				alert("Profile Updated");
			</script>
			<%
			}
		}
		
		%>
	<%@include file="common/header.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<section class="signup">
		<!-- Sign up form -->
		<div class="container">
			<div class="signup-content">
				<div class="signup-form">
					<h2 class="form-title">Profile</h2>
					<c:if test="${requestScope.message !=null}">
					NOTE : ${message}
					</c:if>
					<c:if
						test="${requestScope.cust !=null and
 					not empty requestScope.cust}">
						<c:forEach items="${requestScope.cust}" var="c">
							<form method="POST" class="register-form" id="register-form"
								action="EditController">
								<div class="form-group">
									<%--@declare id="name"--%><label for="name"><i
										class="zmdi zmdi-account material-icons-name"></i>
										<input
												type="text" name="name"
												pattern="^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$"
												value="<c:out value="${c.name}"/>"
										/>
									</label>
								</div>
								<div class="form-group">
									<%--@declare id="email"--%><label for="email">
										<i class="zmdi zmdi-email"></i>
									</label>
									<input type="email" name="email" value="<c:out value="${c.email}"/>" />
								</div>
								<div class="form-group">
									<label for="mobile">
										<i class="zmdi zmdi-phone"></i>
									</label>
									<input
										type="text" name="mobile" id="mobile"
										title="Must contain 10 digits and it starts from 7,8 or 9"
										pattern="[789][0-9]{9}" value="<c:out value="${c.mobno}"/> "
									/>
								</div>
								<div class="form-group">
									<label for="balance"><i
										class="zmdi zmdi-balance-wallet"></i></label> <input type="text"
										name="balance" id="balance" pattern="[0-9]+"
										value="<c:out value="${c.balance}"/> " />
								</div>
								<div class="form-group">
									<label for="username"><i
										class="zmdi zmdi-account material-icons-name"></i></label> <input disabled="disabled"
										type="text" name="username" id="username"
										value="<c:out value="${c.username}"/> " />
								</div>
								<div class="form-group">
									<label for="password">
										<i class="zmdi zmdi-lock"></i>
									</label> <input
										type="text" name="password" id="password"
										pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"
										title="Must Contain 1 Uppercase letter or lowercase letter and minimum 2 digits"  value="<c:out value="${c.password}"/> " />
								</div>
								<div class="form-group">
									<input type="checkbox" name="agree-term" id="agree-term"
										class="agree-term" /> <label for="agree-term"
										class="label-agree-term"><span><span></span></span>I
										agree all statements in <a href="#" class="term-service">Terms
											of service</a></label>
								</div>
								<div class="form-group form-button">
									<input type="submit" name="profileupdate" id="profileupdate"
										class="form-submit" value="Save Changes" />
								</div>
							</form>
						</c:forEach>
					</c:if>
				</div>
				<div class="signup-image">
					<figure>
						<img src="${pageContext.request.contextPath}/images/profile.jpg" alt="Profile image">
					</figure>
				</div>
			</div>
		</div>
	</section>
	<%@include file="common/footer.jsp"%>
</body>
</html>