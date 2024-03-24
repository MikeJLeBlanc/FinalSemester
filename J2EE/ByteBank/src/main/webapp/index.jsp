<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>	
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	<%@include file="common/head.jsp"%>

<title>Home | ByteBank</title>
<style>
body
{
    background-image: url('bg1.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	background-position: center center;
}
@media only screen and (max-width: 720px) {
	body {
		background-image: url('bg1.jpg');
	}
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
	<%@include file="common/footer.jsp"%>
</body>

</html>