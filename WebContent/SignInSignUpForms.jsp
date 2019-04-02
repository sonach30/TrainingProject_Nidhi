<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<div class="container-fluid">
		<!-- Row 1 Starts -->
		<div class="row" id="row1">
			<!-- <div class="col-md-1"></div> -->
			<!-- Row 1 Column 2 -->
			<div class="col-md-6 mar" id="r1_c2">
				<p id="r1_c4">Contact Us on +91 4066217777</p>
			</div>

			<!-- Row 1 Column 4 -->
			<div class="col-md-1 mar" id="r1_c4">
				<span class="glyphicon glyphicon-log-in style="> SIGN IN</span>
			</div>
			<!-- Row 1 Column 5 -->
			<div class="col-md-1" id="r1_c5">
				<span class="glyphicon glyphicon-user"> SIGN UP</span>
			</div>
			<!-- Row 1 Column 6 Icons -->
			<div class="col-md-2" id="r1_c6_1">

				<span> <i class="fa fa-facebook"></i>
				</span> <span id="r1_c6_2"><i class="fa fa-google-plus"></i></span> <span
					id="r1_c6_2"><i class="fa fa-twitter"></i></span> <i
					style='font-size: 15px' class='fas'>&#xf0e0;</i>&nbsp;

			</div>
		</div>
		<!-- Row 1 Ends -->


		<!-- Row 2 Starts -->
		<div class="row">
			<!-- <div class="col-md-1"></div> -->
			<!-- Row 2 Column2 -->
			<div class="col-md-4 mar">
				<img src="images/logo.png" id="r2_c2">
			</div>
			<!-- <div class="col-md-3"></div> -->
			<!-- Row 2 Column4 -->
			<div class="col-md-6 mar">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle r2_c4" type="button"
						data-toggle="dropdown">
						ELECTRONICS <span class="caret"></span>
					</button>
					<button class="btn btn-primary dropdown-toggle r2_c4" type="button"
						data-toggle="dropdown">
						MEN <span class="caret"></span>
					</button>
					<button class="btn btn-primary dropdown-toggle r2_c4" type="button"
						data-toggle="dropdown">
						WOMEN <span class="caret"></span>
					</button>
					<button class="btn btn-primary dropdown-toggle r2_c4" type="button"
						data-toggle="dropdown">
						BABY & KIDS <span class="caret"></span>
					</button>
					<button class="btn btn-primary dropdown-toggle r2_c4" type="button"
						data-toggle="dropdown">HOME & FURNITURE</button>
					<span class="caret"></span>
				</div>
			</div>
		</div>
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
					contact us, out customer service is center is working 24/7</p>


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
							 int i = (int)session.getAttribute("SUCCESS");
							if(i==1)
							{	
					%>
					<!-- IF REGITRATION SUCCESSFUL -->
				<div class="alert alert-success" role="alert">Registration
					Successful</div>
				<% 
							}
							else if(i==-1)
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
					<hr>
				</form>
				<!-- LOGIN FORM ENDS -->
				<%	
						if(!session.isNew())
						{
							 int i = (int)session.getAttribute("SUCCESS");
							if(i==2)
							{	
					%>
				<div class="alert alert-success" role="alert">Login Successful
				</div>
				<% 
							}
							else if(i==-2)
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
		<!-- ROW 5 STARTS -->
		<div class="row row1">
			<br>
			<br>

			<!-- ROW 5 COL 1 STARTS -->
			<div class="col-md-3 cc">
				<b>About Us</b>
				<p class="mrsil">Pellentesque habitant morbi tristique senectus
					et netus malesuada fames ac turpis egestas.</p>
				<hr width="100%">
				<b>Join Our Monthly Newsletter</b><br> <input type="text"
					size="30">
				<button class="button2 send">
					<span class="glyphicon glyphicon-send"></span>
				</button>
				<br>
				<br>
			</div>
			<!-- ROW 5 COL 1 ENDS -->

			<!-- ROW 5 COL 2 STARTS -->
			<div class="col-md-3">
				<b>BLOG<br>
				<br> <img src="images/detailsquare1.jpg" height="40" width="40">&nbsp;&nbsp;
					BLOG POST NAME<br>
				<br> <img src="images/detailsquare2.jpg" height="40" width="40">&nbsp;&nbsp;
					BLOG POST NAME<br>
				<br> <img src="images/detailsquare3.jpg" height="40" width="40">&nbsp;&nbsp;
					VERY VERY LONG BLOG POST NAME<br>
				<br></b>
			</div>
			<!-- ROW 5 COL 2 ENDS -->

			<!-- ROW 5 COL 3 STARTS -->
			<div class="col-md-2">
				<b>Contact</b> <br>
				<p class="mrsil">
					TechAspect Solutions Pvt Ltd<br>3rd floor, N Heights, Plot no
					38, Hitech City Phase II,<br> Madhapur, Hyderabad, Telangana<br>India,
					Tel : +91 40 66217777
				</p>
				<br>
				<button class="button2 butt">GO TO CONTACT PAGE</button>
			</div>
			<!-- ROW 5 COL 3 ENDS -->

			<!-- ROW 5 COL 4 STARTS -->
			<div class="col-md-3">
				<img src="images/detailsquare1.jpg" height="75" width="75">
				&nbsp; <img src="images/detailsquare2.jpg" height="75" width="75">&nbsp;
				<img src="images/detailsquare3.jpg" height="75" width="75">
				&nbsp; <br>
				<br> <img src="images/detailsquare1.jpg" height="75" width="75">
				&nbsp; <img src="images/detailsquare2.jpg" height="75" width="75">&nbsp;
				<img src="images/detailsquare3.jpg" height="75" width="75">
				&nbsp;
			</div>
			<!-- ROW 5 COL 4 ENDS -->

		</div>
		<!-- ROW 5 ENDS -->



		<!-- ROW 6 STARTS -->
		<div class="row last">





			<!-- ROW 6 COL1 STARTS -->
			<div div class="col-md-3 cc">
				<br>
				<p style="color: white;">
					<span class="glyphicon glyphicon-copyright-mark"> 2018</span>
					TechAspect Solutions Private Limited
			</div>
			<!-- ROW 6 COL1 ENDS -->


		</div>
		<!-- ROW 6 ENDS -->

		<!-- FOOTER ENDS -->
	</div>

	<script src="js/jquery-3.3.1.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>