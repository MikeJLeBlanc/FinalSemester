<%@ page  contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="common/head.jsp"%>

	<style>
body {
	background-image: url('${pageContext.request.contextPath}/pay1.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	margin-top: 49px;
	background-position: center center;
}
@media only screen and (max-width: 720px) {
	body {
		background-image: url('${pageContext.request.contextPath}/pay1.jpg');
	}
}
h3 {
	color: white;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>DashBoard | ByteBank</title>
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
		msg = (String) session.getAttribute("login");
		if (msg != null) {
	%>
	<script type="text/javascript">
		alert("Login SuccessFully");
	</script>
	<%
	}
	}
	%>
	<%@include file="common/header.jsp"%>
	<%@include file="common/footer.jsp"%>
</body>
</html>