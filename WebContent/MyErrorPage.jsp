<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
 <%@ page import="java.lang.*"%> 
 <%@ page import="java.io.*"%>
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel='stylesheet'
	href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'
	integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
	crossorigin='anonymous'>

<!-- STYLESHEET FOR ICONS &BUTTONS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


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

		<ROW 4 STARTS>
		<div class="row ep_row4">

			<br /> <br />
			<hr>
			<span id="ep_box_p"><strong>Sorry for the inconvenience - The Page you are looking for have a Technical Error
			</strong></span> <br /> 
			<span class="ep_grey">Kindly proceed to the Home page or Report this issue to Website Administrator with the Description mentioned below:</span> <br /> <br />


			<!-- LOGGING THE EXCEPTION -->
			<%
			exception.getStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			exception.printStackTrace(pw);
			String sStackTrace = sw.toString(); // stack trace as a string
		/* System.out.println(sStackTrace); */
			session.setAttribute("CUSTOMEREXCEPTION",sStackTrace);
		%>

	
			<form action="index.jsp">
				<button type="submit" class="ep_sub6">
					<span class="glyphicon glyphicon-home"> Home</span>
				</button>
			</form>

			<form action="CustomerException" method="Post">
				<button type="submit" class="ep_sub7">
					<span class="glyphicon glyphicon-eye-close"> Report</span>
				</button>
			</form>

			<!--  -->
			
			<%	
				if(!session.isNew())
				{
			 		String i = (String)session.getAttribute("SUCCESS");
					if(i=="successerror")
					{	
			%>
						<div class="alert alert-success" role="alert">Report Send
							Successful</div>
			<% 
					}
			}									
		
	
	%>
	</div>		
			<!--  -->
			<br /> <br /> <div class="excep"><div class="alert alert-danger" role="alert"><%=session.getAttribute("CUSTOMEREXCEPTION")%></div></div>v
			<br /> <br />
		
		<!--  --> <%
			
			{
				
			}
	%> <!-- ROW 6 STARTS --> <br>
		<div class="row row1">
			<br>
			<br>

			<!-- COL1 STARTS -->
			<div class="col-md-3 cc">
				<b>About Us</b>
				<p class="mrsil">TechAspect empowers small and medium-sized
					businesses to reach millions of customers with a number of
					programmes that help boost their revenue,reach and productivity. By
					telling stories from a wide range of perpectives, we tell the
					larger story of who TechAspect is and how TechAspect's core
					business practices contribute to a better India</p>
				<hr width="100%">
				<b>Join Our Monthly Newsletter</b><br> <input type="text"
					size="30">
				<button class="button2 send">
					<span class="glyphicon glyphicon-send"></span>
				</button>
				<br>
				<br>
			</div>
			<!-- COL1 ENDS -->

			<!-- COL2 STARTS -->
			<div class="col-md-3" style="margin-left: 50px;">
				<b>BLOG<br>
				<br> <img src="images/detailsquare1.jpg" height="40" width="40">&nbsp;&nbsp;
					BLOG POST NAME<br>
				<br> <img src="images/detailsquare2.jpg" height="40" width="40">&nbsp;&nbsp;
					BLOG POST NAME<br>
				<br> <!-- <img src="images/detailsquare3.jpg" height="40" width="40">&nbsp;&nbsp;  VERY VERY LONG BLOG POST NAME<br><br></b>
			 -->
			</div>
			<!-- COL2 ENDS -->

			<!-- COL3 STARTS -->
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
			<!-- COL3 ENDS -->

		</div>
		<!-- ROW6 ENDS --> <!-- ROW7 STARTS -->
		<div class="row last">





			<!-- COL1 STARTS -->
			<div div class="col-md-3 cc">
				<br>
				<p style="color: white;">
					<span class="glyphicon glyphicon-copyright-mark"> 2018</span>
					TechAspect Solutions Private Limited
			</div>
			<!-- COL1 ENDS -->


		</div>
		<!-- ROW6 ENDS -->
	</div>
	<!-- CONTAINER CLASS ENDS -->

	<script src="js/jquery-3.3.1.js"></script>
	<!-- JQUERY JAVASCRIPT -->

	<script src="bootstrap/js/bootstrap.js"></script>
	<!-- BOOTSTRAP JAVASCRIPT  -->

</body>
<!-- BODY ENDS -->

</html>
</body>
</html>