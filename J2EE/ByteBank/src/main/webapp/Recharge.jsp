<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit | ByteBank</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<%@include file="common/head.jsp"%>

<style>
select, option {
	width: 100%;
	display: block;
	outline: none;
	border: none;
	color: #999;
	border-bottom: 1px solid #999;
	padding: 4px 28px;
	font-family: Poppins;
	box-sizing: border-box;
}
select:focus, option:focus {
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
	<%!String msg,m = null;%>
		<%
		if (!session.isNew()) {
			msg = (String) session.getAttribute("recharge");
			m = (String) session.getAttribute("rech");
			if(msg != null){
				%>
			<script type="text/javascript">
				alert("deposit Successful");
			</script>
			<%
			}
			
			else if(m != null){
				%>
			<script type="text/javascript">
				alert("Amount is greater than your existing balance...Plzz try again !");
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
		<div class="container">
			<div class="signup-content">
				<div class="signup-form">
					<h2 class="form-title">Mobile Deposit</h2>
					<form method="POST" class="register-form" id="register-form"
						action="RechargeController">
						<div class="form-group">
							<label for="mobile"><i class="zmdi zmdi-phone"></i></label> <input
								type="text" name="mobile" id="mobile"
								title="Must contain 10 digits"
								placeholder="Mobile Number" required />
						</div>
						<div class="form-group">
							<label for="amount"><i class="zmdi zmdi-balance-wallet"></i></label>
							<input type="number" name="amount" id="amount" pattern="[0-9]+"
								placeholder="Amount" required />
						</div>
						<div class="form-group">
							<%--@declare id="service"--%><label for="service"><i class="zmdi zmdi-balance-wallet"></i></label>
							<select name="service">
								<option selected disabled>Select Service Provider</option>
								<option value="Bell">Bell</option>
								<option value="Koodo">Koodo</option>
								<option value="Telus">Telus</option>
								<option value="Virgin">Virgin</option>
								<option value="Public Mobile">Public Mobile</option>
							</select>
						</div>
						<div class="form-group">
							<input type="checkbox" name="agree-term" id="agree-term"
								class="agree-term" />
							<label for="agree-term"
								class="label-agree-term"><span><span></span></span>
								I agree to the <a href="#" class="term-service">Terms of service</a></label>
						</div>
						<div class="form-group form-button">
							<input type="submit" name="recharge" id="recharge"
								class="form-submit" value="Recharge Now" />
						</div>
					</form>
				</div>
				<div class="signup-image">
					<figure>
						<img src="${pageContext.request.contextPath}images/rech.jpg" alt="deposit image">
					</figure>
				</div>
			</div>
		</div>
	</section>
	<%@include file="common/footer.jsp"%>
</body>
</html>
