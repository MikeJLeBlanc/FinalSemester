<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@include file="common/head.jsp"%>
<style>
td
{
	color:black;
}
h4
{
	color:red;
}
</style>
	<title>ByteBank</title>
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
	<%!String msg = null;%>
		<%
		if (!session.isNew()) {
			msg = (String) session.getAttribute("reg2");
			if (msg != null) {
		%>
		<script type="text/javascript">
			alert("Username or Password already exists.");
		</script>
		<%
		}
		}
		
		%>
	<section class="signup">
        <!-- Sign up form -->
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <form method="POST" class="register-form" id="register-form" action="RegisterController">
                            <div class="form-group">
                                <label for="name">
									<i class="zmdi zmdi-account material-icons-name"></i>
								</label>
                                <input type="text" name="name" id="name" pattern="^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$"
                                placeholder="Your Name" required/>
                            </div>
                            <div class="form-group">
                                <label for="email">
									<i class="zmdi zmdi-email"></i>
								</label>
                                <input type="email" name="email" id="email" placeholder="Your Email" required/>
                            </div>
                            <div class="form-group">
                            	<label for="balance"><i class="zmdi zmdi-balance-wallet"></i></label>
                                <input type="number" name="balance" id="balance" pattern="[0-9]+"
                                placeholder="Your Balance" required/>
                            </div>
                            <div class="form-group">
                                <label for="username">
									<i class="zmdi zmdi-account material-icons-name"></i>
								</label>
                                <input type="text" name="username" id="username" pattern="^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$"
                                placeholder="Your UserName" required/>
                            </div>
                            <div class="form-group">
                                <label for="password">
									<i class="zmdi zmdi-lock"></i>
								</label>
                                <input type="password" name="password" id="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"
                                title="Must Contain 1 Uppercase letter or lowercase letter and minimum 2 digits" placeholder="Your Password" required/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                        <a href="Login.jsp" class="signup-image-link">I am already member</a>
                    </div>
                </div>
            </div>
            </section>
    <%@include file="common/footer.jsp"%>
</body>
</html>
