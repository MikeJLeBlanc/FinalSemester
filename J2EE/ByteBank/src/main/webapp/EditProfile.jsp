<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
					<a href="ProfileController">Show profile</a>
				</div>
				<div class="signup-image">
					<figure>
						<img src="images/profile.jpg" alt="Profile image">
					</figure>
				</div>
			</div>
		</div>
	</section>
	<%@include file="common/footer.jsp"%>
</body>
</html>