<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions | ByteBank</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@include file="common/head.jsp"%>
<style>
select, option {
	width: 100%;
	display: block;
	outline: none;
	border: none;	
	color:#999;
	border-bottom: 1px solid #999;
	padding: 4px 28px;
	font-family: Poppins;
	box-sizing: border-box;
}
select:focus,option:focus
{
	color:black;
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
			msg = (String) session.getAttribute("with");
			m = (String) session.getAttribute("with2");
			if(msg != null){
				%>
			<script type="text/javascript">
				alert("Transaction Successful");
			</script>
			<%
			}
			else if(m != null){
				%>
			<script type="text/javascript">
				alert("Insufficient funds!");
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
	<!-- codee -->
	<section class="signup">
		<!-- Sign up form -->
		<div class="container">
			<div class="signup-content">
				<div class="signup-form">
					<h2 class="form-title">Transactions</h2>
					<form method="get" class="register-form" id="register-form"
						action="TransactionController">
						<div class="form-group">
							<label for="amount"><i class="zmdi zmdi-balance-wallet"></i></label>
							<input type="number" name="amount" id="amount" pattern="[0-9]+"
								placeholder="Enter Amount " required />
						</div>
						<div class="form-group">
							<%--@declare id="choice"--%><label for="choice"><i class="zmdi zmdi-balance-wallet"></i></label>&nbsp&nbsp
							<select name="choice">
								<option selected disabled>Select Transaction Type</option>
								<option value="deposit">Deposit</option>
								<option value="withdrawl">Withdraw</option>
							</select>
						</div>
						<div class="form-group">
							<input type="checkbox" name="agree-term" id="agree-term"
								class="agree-term"/> <label for="agree-term"
								class="label-agree-term"><span><span></span></span>I
								agree all statements in <a href="#" class="term-service">Terms
									of service</a></label>
						</div>
						<div class="form-group form-button">
							<input type="submit" name="transact" id="tr"
								class="form-submit" value="Proceed"
							/>
						</div>
					</form>
				</div>
				<div class="signup-image">
					<figure>
						<img src="${pageContext.request.contextPath}/images/deposit.jpg" alt="deposit image">
					</figure>
				</div>
			</div>
		</div>
	</section>
	<%@include file="common/footer.jsp"%>
</body>
</html>