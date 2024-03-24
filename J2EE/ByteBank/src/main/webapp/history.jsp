<%@ page contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>History | ByteBank</title>
<%@include file="common/head.jsp"%>>
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
					<h4 class="form-title"><strong>History</strong></h4>
					<br>
					<a href="HistoryController">Show Transaction History</a>
				</div>
			</div>
		</div>
	</section>
	<%@include file="common/footer.jsp"%>
</body>
</html>