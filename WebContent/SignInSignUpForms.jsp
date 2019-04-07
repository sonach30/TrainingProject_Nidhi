<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport" content="width-device-width, initial-scale=1">
<title>SignInsignUp</title>

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
					response.sendRedirect("log");
					break;
			}
		}
	}	
	%>
	<div class="container-fluid">
		<!-- Row 1 Starts -->
		 <%@ include file= "Header1.jsp" %>
		<!-- Row 1 Ends -->
		
		<!-- Row 2 Starts -->
			<%@ include file = "nav.jsp" %>
		<!-- Row 2 Ends -->

		<!-- Row 3 Starts -->
		<div class="row row3"
			style="background-image: url(images/texture-bw.png)">
			<br>

			<!-- COL1 STARTS -->
			<div class="col-md-4 cc">
				<b class="lbl1">NEW ACCOUNT / SIGN IN</b> <br>
			</div>
			<!-- COL1 ENDS -->


			<!-- COL2 STARTS -->
			<div class="col-md-4 ccrr">
				<h5>
					<a class="links">HOME</a> / NEW ACCOUNT / SIGN IN
				</h5>
				<br>
			</div>
			<!-- COL2 ENDS -->

			<br> <br>

		</div>
		<!-- Row 3 Ends -->
		
		
		<!-- Row 4 Starts -->
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-4">
				<hr>
				<p style="text-align: left; font-size: 30px">
					<strong>NEW ACCOUNT</strong>
				</p>
				<br>
				<p style="text-align: left; font-size: 16px; color: gray">Not
					yet Registered</p>
				<p style="font-size: 16px;">With registration with us new world
					of fashion,fantastic discounts and much more is open to you!The
					whole process will not take more than a minute.</p>
				<br> <br>
				<p style="color: gray">If you have any queries feel free to
					<a href="contact.jsp">contact us</a>, out customer service is center is working 24/7</p>


				<!-- REGISTRATION FORM-->
				<form action="register" method="post">
					<div class="form-group">
						<label for="Name" style="color: gray">Name:</label> <input
							type="text" class="form-control" id="Name" name="name">
					</div>
					<div class="form-group">
						<label for="email" style="color: gray">Email address:</label> <input
							type="email" class="form-control" id="email" name="em">
					</div>
					<div class="form-group">
						<label for="pwd" style="color: gray">Password:</label> <input
							type="password" class="form-control" id="pwd" name="pwd">
					</div>
					<button type="submit" class="btn btn-default"
						style="margin-left: 200px; color: green;">Register</button>
					<hr>
				</form>
				<!-- REGISTRATION FORM ENDS -->
				
				<!-- CHECKING THE SUCCESS OF REGISTRATION PROCESS -->
				<%	
						//CHECKING IF SESSION ALREADY EXIST
						if(!session.isNew())
						{
							 String i = (String)session.getAttribute("SUCCESS");
							if(i=="successregister")
							{	
					%>
					<!-- IF REGITRATION SUCCESSFUL -->
					<div class="alert alert-success" role="alert">Registration
						Successful</div>
				<% 
					}
						else if(i=="failregister")
						{
				%>
					
					<!-- IF REGITRATION UNSUCCESSFUL -->
					<div class="alert alert-danger" role="alert">
						Registration Unsuccessful !!!!!<br> Try Again
					</div>
				<% 
							}									
						}
					
				%>
			</div>

			<div class="col-md-1"></div>
			<div class="col-md-4">
				<hr>
				<p style="text-align: left; font-size: 30px">
					<strong>SIGN IN</strong>
				</p>
				<br>
				<p style="text-align: left; font-size: 16px; color: gray">Already
					a Customer</p>
				<p style="font-size: 16px;">Get Access to your orders,whishlist
					and recommadations</p>


				<!--  LOGIN FORM STARTS -->
				<form action="log" method="post">
					<div class="form-group">
						<label for="email" class="mrgrey">Email address:</label> <input
							type="email" class="form-control" id="email" name="em">
					</div>
					<div class="form-group">
						<label for="pwd" class="mrgrey">Password:</label> <input
							type="password" class="form-control" id="pwd" name="pwd">
					</div>
					<button type="submit" class="btn btn-default"
						style="margin-left: 200px; color: green;">LOG IN</button>
						
					<br><br>
					
					<input type="checkbox" name="ss" value="ss"> Stay Signed In
					<hr>
				</form>
				<!-- LOGIN FORM ENDS -->
				<%	
						if(!session.isNew())
						{
							String i = (String)session.getAttribute("SUCCESS");
							if(i=="successlogin")
							{	
					%>
				<div class="alert alert-success" role="alert">Login Successful
				</div>
				<% 
							}
							else if(i=="faillogin")
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
		</div>
		<!-- Row 3 Ends -->


		<!-- FOOTER STARTS -->
			<%@ include file = "Footer.jsp"%>
		<!-- FOOTER ENDS -->
	</div>
	
	<script src="js/jquery-3.3.1.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	</body>
</html>