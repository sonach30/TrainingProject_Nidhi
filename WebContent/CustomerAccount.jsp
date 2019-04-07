<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport" content="width-device-width, initial-scale=1">
<title>CustomerAccount</title>

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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



<script> 

/* function checkPasswordMatch() {
    var password = $("#txtNewPassword").val();
    var confirmPassword = $("#txtConfirmPassword").val();

    if (password != confirmPassword)
        $("#divCheckPasswordMatch").html("Passwords do not match!");
    else
        $("#divCheckPasswordMatch").html("Passwords match.");
}

$(document).ready(function () {
   $("#txtConfirmPassword").keyup(checkPasswordMatch);
});
 */

/* // Function to check Whether both passwords 
// is same or not. 
function checkPassword(form) { 
    password1 = form.password1.value; 
    password2 = form.password2.value; 

    // If password not entered 
    if (f2 == '') 
        alert ("Please enter Password"); 
          
    // If confirm password not entered 
    else if(f3 == '') 
        alert ("Please enter confirm password"); 
          
    // If Not same return False.     
    else if (f2 != f3) { 
        alert ("\nPassword did not match: Please try again...") 
        return false; 
    } 

    // If same return True. 
    else{ 
        alert("Password match:) 
        return true; 
    } 
}  */
</script>


</head>
<body>
	<div class="container-fluid">
		<!-- Row 1 Starts -->
		<%@ include file = "Header1.jsp" %>
		<!-- Row 1 Ends -->


		<!-- Row 2 Starts -->
		<%@include file = "nav.jsp" %>
		<!-- Row 2 Ends -->

		<!-- Row 3 Starts -->
		<div class="row row3"
			style="background-image: url(images/texture-bw.png)">
			<br>

			<!-- COL1 STARTS -->
			<div class="col-md-7 mar" id="r3_c2">
				<strong>MY ACCOUNT</strong>
			</div>
			<!-- COL1 ENDS -->


			<!-- COL2 STARTS -->
			<!-- <div class="col-md-4 ccrr"> -->
			<div class="col-md-2 mar" id="r3_c4">
				<span id="r3_c4_s">HOME</span> / MY ACCOUNT
			</div>
			<br>
		</div>
		<!-- COL2 ENDS -->

		<br> <br>

	</div>
	<!-- Row 3 Ends -->




	<!-- ROW4 STARTS -->
	<div class="row">

		<!-- COL1 STARTS -->
		<div class="col-md-6 cc">
			<br>


			<!-- CHANGE PASSWORD FORM STARTS -->
			<div class="row">
				<form action="ChangePassword" method="Post">
					<h3 class="mrgrey">
						Change your personal details or your password here.
						</h2>
					</h3>
					<br> <br>
					<p class="lbl4">Pefenjnde fejnidewf ejfnjewfwef enfewieine
						jenjdiweod.
					<hr></hr>
					<h3>CHANGE PASSWORD</h3>
					<hr class="hrrule">
					<br> <br> <br>

					<!-- INNER ROW1 STARTS -->
					<div class="row">

						<!-- INNER COL1 STARTS -->
						<div class="col-md-6 mrgrey">
							Old Password<br> <input type="text" class="form-control"
								size="100" name="f1">
						</div>
						<!-- INNER COL1 ENDS -->

						<!-- INNER COL2 STARTS -->
						<div class="col-md-6 mrgrey">
							<p></p>
						</div>
						<br> <br>
						<!-- INNER COL2 ENDS -->
						<br> <br>
					</div>
					<!-- INNER ROW1 ENDS -->

					<!-- INNER ROW2 STARTS -->
					<div class="row">

						<!-- INNER COL1 STARTS -->
						<div class="col-md-6 mrgrey">
							New Password<br> <input type="password" class="form-control"
								size="100" name="f2" id="txtNewPassword">
						</div>
						<!-- INNER COL1 ENDS -->

						<!-- INNER COL2 STARTS -->
						<div class="col-md-6 mrgrey">
							Retype New Password<br> <input type="password"
								class="form-control" size="100" name="f3"  id="txtConfirmPassword" >
						</div>
						<!-- INNER COL2 ENDS -->

						<br> <br>
					</div>
					
					<!-- INNER ROW2 ENDS -->

					<!-- INNER ROW3 STARTS -->
					<div class="row">

						<!-- INNER COL1 STARTS -->
						<div class="col-md-12 cc">
							<br>
							<button type="submit" class="btn btn-default sub">
								<span class="glyphicon glyphicon-floppy-disk"></span>&nbsp;&nbsp;SAVE
								MY PASSWORD
							</button>
							<br>
							<hr>
						</div>

						<!-- INNER COL1 ENDS -->

					</div>
					<!-- INNER ROW3 ENDS -->
					<br> <br>
				</form>
				<%	
						if(!session.isNew())
						{
							 String i = (String)session.getAttribute("SUCCESS");
							if(i.equals("successpass"))
							{	
					%>
				<div class="alert alert-success" role="alert">Password Change
					Successful</div>
				<% 
							}
							else if(i=="failpass")
							{
					%>
				<div class="alert alert-danger" role="alert">
					INVALID CREDENTIALS !!!!!<br> Try Again

				</div>
				<% 
							}									
						}
					
					%>

				<!-- CHANGE PASSWORD FORM ENDS -->
			</div>




			<div class="row">
				<!-- CUSTOMER ACCOUNT FORM STARTS -->
				<form action="CustomerAccount" method="Post">
					<h3>PERSONAL DETAILS</h3>
					<hr class="hrrule"></hr>
					<br> <br> <br>

					<!-- INNER ROW1 STARTS -->
					<div class="row mrgrey">

						<!-- INNER COL1 STARTS -->
						<div class="col-md-6">
							First Name<br> <input type="text" class="form-control"
								size="100" name="f4">
						</div>
						<!-- INNER COL1 ENDS -->

						<!-- INNER COL2 STARTS -->
						<div class="col-md-6">
							Last Name<br> <input type="text" class="form-control"
								size="100" name="f5">
						</div>
						<!-- INNER COL2 ENDS -->
						<br> <br>
					</div>
					<!-- INNER ROW 1 ENDS -->

					<br>

					<!-- INNER ROW2 STARTS -->
					<div class="row mrgrey">

						<!-- INNER COL1 STARTS -->
						<div class="col-md-6">
							Gender<br>
							<div class="radio">
								<label><input type="radio" name="f6" value="Male">Male</label>
							</div>
							<div class="radio">
								<label><input type="radio" name="f6" value="Female">Female</label>
							</div>
							<div class="radio disabled">
								<label><input type="radio" name="f6" value="Transgender">Transgender</label>
							</div>
						</div>
						<!-- INNER COL1 ENDS -->
					</div>
					<!-- INNER ROW2 ENDS -->

					<br>

					<!-- INNER ROW3 STARTS -->
					<div class="row mrgrey">

						<!-- INNER COL1 STARTS -->
						<div class="col-md-12">
							Address<br>
							<textarea class="form-control" size="100" name="f7"></textarea>
							<br>
						</div>
						<!-- INNER COL1 ENDS -->


					</div>
					<!-- INNER ROW3 ENDS -->

					<br>

					<!-- INNER ROW4 STARTS -->
					<div class="row mrgrey">

						<!-- INNER COL1 STARTS -->
						<div class="col-md-3">
							CITY<br> <input type="text" class="form-control" size="100"
								name="f8">
						</div>
						<!-- INNER COL1 ENDS -->

						<!-- INNER COL2 STARTS -->
						<div class="col-md-3">
							ZIP<br> <input type="text" class="form-control" size="100"
								name="f9">
						</div>
						<!-- INNER COL2 ENDS -->


						<!-- INNER COL3 STARTS -->
						<div class="col-md-3">
							State<br> <select name="f10" id="dropdownMenu1">
								<option value="J&k">Jammu & Kashmir</option>
								<option value="Telengana">Telengana</option>
								<option value="Haryana">Haryana</option>
								<option value="Metro Droit">Metro Droit</option>
							</select>

							<!-- <div class="dropdown">
									<button class="btn btn-default dropdown-toggle" type="button"
										id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="true">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<span class="caret"></span>
									</button>
									<
								</div> -->
						</div>
						<!-- INNER COL3 ENDS -->

						<!-- INNER COL4 STARTS -->
						<div class="col-md-3">
							Country<br> <select name="f11" id="dropdownMenu1">
								<option value="India">India</option>
								<option value="U.S.">U.S.</option>
								<option value="U.K.">U.K.</option>
								<option value="Canada">Canada</option>
							</select>
							<!-- <div class="dropdown">
									<button class="btn btn-default dropdown-toggle" type="button"
										 data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="true">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<span class="caret"></span>
									</button>
								</div> -->
						</div>
						<!-- INNER COL4 ENDS -->
						<br> <br> <br>
					</div>
					<!-- INNER ROW 4 ENDS -->

					<br>

					<!-- INNER ROW5 STARTS -->
					<div class="row mrgrey">

						<!-- INNER COL1 STARTS -->
						<div class="col-md-6">
							Contact Number<br> <input type="text" class="form-control"
								size="100" name="f12">
						</div>
						<!-- INNER COL1 ENDS -->

						<!-- INNER COL2 STARTS -->
						<div class="col-md-6">
							Email<br> <input type="text" class="form-control" size="100">
						</div>
						<!-- INNER COL2 ENDS -->
						<br> <br>
					</div>
					<!-- INNER ROW 5 ENDS -->

					<!-- INNER ROW6 STARTS -->
					<div class="row">

						<!-- INNER COL1 STARTS -->
						<div class="col-md-12 cc">
							<br>
							<button type="submit" class="btn btn-default sub">
								<span class="glyphicon glyphicon-floppy-disk"></span>&nbsp;&nbsp;SAVE
								CHANGES
							</button>
							<br>
							<hr>
						</div>

						<!-- INNER COL1 ENDS -->

					</div>
					<!-- INNER ROW6 ENDS -->
				</form>
			</div>
			<!-- CUSTOMER ACCOUNT FORM ENDS -->

			<!-- CHECKING THE SUCCESS OF REGISTRATION PROCESS -->
			<%	
						//CHECKING IF SESSION ALREADY EXIST
						if(!session.isNew())
						{
							 String i = (String)session.getAttribute("SUCCESS");
							if(i.equals("successupdate"))
							{	
					%>
			<!-- IF REGITRATION SUCCESSFUL -->
			<div class="alert alert-success" role="alert">Updated
				Successful</div>
			<% 
							}
							else if(i.equals("failupdate"))
							{
					%>

			<!-- IF REGITRATION UNSUCCESSFUL -->
			<div class="alert alert-danger" role="alert">
				Updated Unsuccessful !!!!!<br> Try Again

			</div>
			<% 
							}									
						}
					
					%>
		</div>



		<!-- COL1 ENDS -->

		<!-- COL2 STARTS -->
		<div class="col-md-2 row4">
			<br> <br>

			<!-- INNER ROW1 STARTS -->
			<div class="row">
				<H4>
					<b>CUSTOMER SECTION</b>
				</H4>
			</div>
			<!-- INNER ROW1 STARTS -->

			<!-- INNER ROW2 STARTS -->
			<div class="row">
				<hr class="hrrule2">
			</div>
			<!-- INNER ROW2 ENDS -->

			<!-- INNER ROW3 STARTS -->
			<div class="row">
				<div class="vertical-menu">
					<a href="#" class="active"><span
						class="glyphicon glyphicon-list"></span>&nbsp;My Order</a> <a href="#"><span
						class="glyphicon glyphicon-heart"></span>&nbsp;My Wishlist</a> <a
						href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;My
						Account</a> <a href="logout"><span
						class="glyphicon glyphicon-log-out"></span>&nbsp;Logout</a>
				</div>
			</div>
			<!-- INNER ROW3 STARTS -->

		</div>
		<!-- COL2 ENDS -->

	</div>
	<!-- ROW4 ENDS -->

	<!-- ROW6 STARTS -->
	<%@ include file = "Footer.jsp" %>
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
