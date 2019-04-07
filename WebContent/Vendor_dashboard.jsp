<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.tadigital.ecommerce.vendor.entity.Vendor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor Dashboard</title>
</head>
<body>
	<%
		Vendor vendor = new Vendor();
		String vendorfn = vendor.getVendor_fname();
		String vendorln = vendor.getVendor_lname();
	%>
	
	 <!-- CONTAINER STARTS -->
	 <div class="container-fluid">
		<!-- ROW 1 STARTS-->
			<%@ include file="Header1.jsp" %>
		<!-- ROW 1 ENDS -->
		
		<!-- ROW 2 STARTS-->
			<%@ include file="nav.jsp" %>
		<!-- ROW 2 ENDS -->
		<p>Welcome <%=vendorfn+" "+vendorln %><br>
		
		<form action="dashboard" method="post">
			<button type="submit" class="btn btn-default" id="ven_b1" name="add_button">Add a new Product</button><br><br>
			<button type="submit" class="btn btn-default" id="ven_b1" name="update_button">Update the existing Product</button><br><br>						
		</form>
		<!-- ROW6 STARTS -->
			<%@ include file = "Footer.jsp" %>
			<!-- ROW6 ENDS -->
	
	</div>
	<!-- CONTAINER CLASS ENDS -->

		<script src="js/jquery-3.3.1.js"></script> <!-- JQUERY JAVASCRIPT -->
		<script src="bootstrap/js/bootstrap.js"></script> <!-- BOOTSTRAP JAVASCRIPT  -->
	
</body>
</html>