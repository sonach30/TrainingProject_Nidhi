 <%@page import="com.tadigital.ecommerce.customer.entity.Customer"%>

<%
	String alreadylogin = (String)session.getAttribute("ALREADYlOGIN");

	Customer customer = new Customer();

	if (alreadylogin == null) {		
%>

	<div class="row" id="row1">
	
		<!-- Row 1 Column 2 -->
		<div class="col-md-5 mar" id="r1_c2">
			<p id="r1_c4">Contact Us on +91 4066217777</p>
		</div>
	
		<!-- Row 1 Column 4 -->
		<div class="col-md-1 mar" id="r1_c4">
			<a href="SignInSignUpForms.jsp"><span
				class="glyphicon glyphicon-log-in"> SIGNIN</span></a>
		</div>
		<!-- Row 1 Column 5 -->
		<div class="col-md-2" id="r1_c5">
			<a href="VendorSignIn.jsp"><span class="glyphicon glyphicon-user"> Vendors'sSignIn</span></a>
		</div>
		<!-- Row 1 Column 6 Icons -->
		<div class="col-md-2" id="r1_c6_1">
			<span> <i class="fa fa-facebook"></i></span>
			<span id="r1_c6_2"><i class="fa fa-google-plus"></i></span> 
			<span id="r1_c6_2"><i class="fa fa-twitter"></i></span> 
			<i style='font-size: 15px' class='fas'>&#xf0e0;</i>&nbsp;
	
		</div>
	</div>

<%
	} else {
		customer = (Customer)session.getAttribute("CUSTOMERDATA");
		String fn = customer.getCust_fname();
		String ln = customer.getCust_lname();
%>

	<div class="row" id="row1">
		<!-- <div class="col-md-1"></div> -->
		<!-- Row 1 Column 2 -->
		<div class="col-md-6 mar" id="r1_c2">
			<p id="r1_c4">Contact Us on +91 4066217777</p>
		</div>
		<!-- Row 1 Column 4 -->
		<div class="col-md-2 mar" id="r1_c4">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Welcome <%=fn + " " + ln %> <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="CustomerAccount">MyAccount</a></li>
					<li><a href="#"></a></li>
					<li><a href="#">Logout</a></li>
				</ul>
			</div>
		</div>
		<!-- Row 1 Column 6 Icons -->
		<div class="col-md-2" id="r1_c6_1">
			<span> <i class="fa fa-facebook"></i>
			</span> <span id="r1_c6_2"><i class="fa fa-google-plus"></i></span> <span
				id="r1_c6_2"><i class="fa fa-twitter"></i></span> <i
				style='font-size: 15px' class='fas'>&#xf0e0;</i>&nbsp;
	
		</div>
	</div>
<%
		}
%>