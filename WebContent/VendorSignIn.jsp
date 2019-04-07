<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport" content="width-device-width, initial-scale=1">
<title>SignInForm</title>

<link rel="stylesheet" href="bootstrap/css/bootstrap.css">

<!-- INCLUDING EXTERNAL CSS -->
<link rel="stylesheet" href="css/custom.css">

<!-- STYLESHEET FOR ICONS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>

<!-- STYLESHEET FOR ICONS &BUTTONS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<%
	//READ COOKIES FROM REQUEST
		Cookie[] allCookies = request.getCookies();
		if(allCookies != null) {
			//SEARCH YOUR WEBSITE COOKIE
			for(Cookie cookie : allCookies) {
				String cName = cookie.getName();
				if(cName.equals("abc")) {
					String cValue = cookie.getValue();
					session.setAttribute("COOKIEVALUE", cValue);
					response.sendRedirect("login");
					break;
			}
		}
	}	
%>
	<div class="container-fluid">
		<!-- ROW 1 STARTS-->
			<%@ include file = "Header1.jsp" %>
		<!-- ROW 1 ENDS -->
	
		<!-- ROW 2 STARTS -->
			<%@ include file = "nav.jsp" %>
		<!-- ROW 2 ENDS -->
	
		<!-- ROW 3 STARTS -->
		<div class="row row3" style="background-image: url(images/texture-bw.png)"><br>

			<!-- COL1 STARTS -->
			<div class="col-md-4 cc">
				<b class="lbl1">NEW ACCOUNT / SIGN IN</b> <br>
			</div>
			<!-- COL1 ENDS -->


			<!-- COL2 STARTS -->
			<div class="col-md-4 ccrr">
				<h5>
					<a class="links">HOME</a> / SIGN IN
				</h5>
				<br>
			</div>
			<!-- COL2 ENDS -->
			<br> <br>
		</div>
		<!-- ROW 3 ENDS -->
		
		<!-- ROW 4 STARTS -->
		<!-- VENDOR LOGIN FORM STARTS-->
		<form action="login" method="post">
			<div class="row ven_r4">
				<div class="form-group">
					<label for="email" class="mrgrey">Email address:</label> 
					<input type="email" class="form-control" id="email" name="em">
				</div>
			</div>
			<div class="row ven_r4">
				<div class="form-group">
					<label for="pwd" class="mrgrey">Password:</label> 
					<input type="password" class="form-control" id="pwd" name="pwd">
				</div>
			</div>
			
			<button type="submit" class="btn btn-default" id="ven_b1"; color: green;">LOG IN</button><br><br>
			<input type="checkbox" name="ss" value="ss"> Stay Signed In <hr>
		</form>
		<!--VENDOR LOGIN FORM ENDS  -->
		
		<!-- VENDOR LOGIN STATUS CHECK -->
		<%	
						if(!session.isNew())
						{
							String loginsuccess = (String)session.getAttribute("SUCCESS");
							if(loginsuccess == "successlogin")
							{	
					%>
				<div class="alert alert-success" role="alert">Login Successful
				</div>
				<% 
							}
							else if(loginsuccess == "faillogin")
							{
					%>
				<div class="alert alert-danger" role="alert">
					INVALID CREDENTIALS !!!!!<br> Try Again

				</div>
				<% 
							}									
						}
					
					%>
	</div>
	<!-- ROW 4 ENDS -->
	
	<!-- FOOTER STARTS -->
		<%@ include file = "Footer.jsp" %>
	<!-- FOOTER ENDS -->
</body>
</html>