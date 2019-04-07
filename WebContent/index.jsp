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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>

<!-- STYLESHEET FOR ICONS &BUTTONS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
	
	<!-- BODY STARTS -->
	<body>
		<!-- CONTAINER STARTS -->
		<div class="container-fluid">
		
			<!-- ROW1 STARTS -->
				<%@ include file = "Header1.jsp" %>
		 	<!-- ROW 1 ENDS -->
		 	
		 	
		 	<!-- ROW 2 STARTS -->
	 			<%@include file = "nav.jsp" %>
			<!-- ROW2 ENDS -->
			
			
			<!-- ROW3 STARTS --><!-- NEW ROW -->
			<div class="row">
				
				<div class="container-fluid">
   
 					 <div id="myCarousel" class="carousel slide" data-ride="carousel">
    					<!-- Indicators -->
    					<ol class="carousel-indicators">
      						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      						<li data-target="#myCarousel" data-slide-to="1"></li>
      						<li data-target="#myCarousel" data-slide-to="2"></li>
      						<li data-target="#myCarousel" data-slide-to="3"></li>
    					</ol>

    					<!-- Wrapper for slides -->
    					<div class="carousel-inner">
      					<div class="item active">
        					<img src="images/6ba3efd52627f2af.jpg" alt="Los Angeles" style="width:100%;">
      					</div>
      					<div class="item">
       						 <img src="images/08d3e861b53705df.jpg" alt="Chicago" style="width:100%;">
      					</div>
    
      					<div class="item">
        					<img src="images/023d2d4a9cf86f42.jpg" alt="New york" style="width:100%;">
      					</div>
      					<div class="item">
        					<img src="images/54e55ddb877be152.jpg" alt="New york" style="width:100%;">
      					</div>
   				 		</div>

    					<!-- Left and right controls -->
    					<a class="left carousel-control" href="#myCarousel" data-slide="prev">
      					<span class="glyphicon glyphicon-chevron-left"></span>
      					<span class="sr-only">Previous</span>
    					</a>
    					<a class="right carousel-control" href="#myCarousel" data-slide="next">
      					<span class="glyphicon glyphicon-chevron-right"></span>
      					<span class="sr-only">Next</span>
    					</a>
  					</div>
				</div>
			</div>
			<!-- ROW 3 ENDS -->
			<br><br>	
			
			<!-- ROW4 STARTS -->
	 		<div class="row row_4">
	 		<br>
	 		
	 			<!-- ROW 4 COL1 STARTS -->
	 			<div class="col-md-10 cc mrwhite">		
	 				<h4>Deal of the day</h4>
	 			</div>
			 	<!-- ROW 4 COL1 ENDS -->
			 	
				<!-- ROW 4 COL2 STARTS -->
		 		<div class="col-md-1">
					<button type="button" class="btn btn-primary">VIEW ALL</button>
				</div>
				<!-- ROW 4 COL2 ENDS -->
	 			<br><br><br>
	 		</div>
	 		<!-- ROW 4 ENDS -->
	 		<br><br>
	 	
	 		<div class="row">
			 	<div class="col-md-2">
  					<div class="card">
	    				<div class="card-body text-center borman">
	    					<img src="images/helkin-3-m-ss18-9-adidas-mysink-cblack-reagol-original-imaf2yznwyqzdzmd.jpeg" class="pro1">
	         				<p class="card-text"><b>Men's Footwear</b></p>
	      					<p class="card-text mrgrey">Upto 60+ Extra 10% off</p>
	      					<button type="button" class="btn1">VIEW</button>
	     					<br><br>
	    				</div>
    				</div>
    			</div>
    
    	 		<div class="col-md-2">
  					<div class="card">
				    	<div class="card-body text-center borman">
						    <img src="images/rsc0274-10-red-tape-blue-original-imaextu5n84xxhsc.jpeg" class="pro1">
						    <p class="card-text"><b>Adidas,Rebook & Puma</b></p>
						    <p class="card-text mrgrey">Upto 50 + Extra 5% off</p>
						    <button type="button" class="btn1">VIEW</button>
						    <br><br>
    					</div>
    				</div>
    			</div>
    
    	 		<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman">
						    <img src="images/hp-entry-level-backpack-nec-hp-s-8-laptop-backpack-hp-original-imaet3zhgzfnd7tz.jpeg" class="pro1">
						    <p class="card-text"><b>Laptop Bag</b></p>
						    <p class="card-text mrgrey">₹249</p>
						    <button type="button" class="btn1">VIEW</button>
						    <br><br>
    					</div>
    				</div>
    			</div>
    
    	 		<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman">
						    <img src="images/samsung-mb-mc32ga-in-original-imaet6za3yhhdq4z.jpeg" class="pro2">
						    <p class="card-text"><b>Memory Cards...</b></p>
						    <p class="card-text mrgrey">Extra 5% off</p>
						    <button type="button" class="btn1">VIEW</button>
						    <br><br>
    					</div>
    				</div>
    			</div>
    
    	 	    <div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman">
    						<img src="images/tw00zr250-timex-original-imaf8wsejechwcfd.jpeg" class="pro1">
      						<p class="card-text"><b>Timex Maxima...</b></p>
      						<p class="card-text mrgrey">₹999+Extra 7% off</p>
      						<button type="button" class="btn1">VIEW</button>
     						<br><br>
    					</div> 
    				</div>
    			</div>
    
    	 		<div class="col-md-2">
  					<div class="card">
   		 				<div class="card-body text-center borman">
    						<img src="images/amt-scamp-daypck01-blu-yellow-fi4-0-01-001-backpack-american-original-imaf7e42eyyzx4hb.jpeg" class="pro1">
      						<p class="card-text"><b>Skybags American..</b></p>
      						<p class="card-text mrgrey">₹999+Extra 5% off</p>
      						<button type="button" class="btn1">VIEW</button>
     						<br><br>
    					</div> 
	    			</div>
		  		</div>
 			</div><br><br>
  
  			<!-- ROW4 STARTS -->
	 		<div class="row row_4"><br>
	 			<!-- COL1 STARTS -->
	 			<div class="col-md-10 cc mrwhite">
	 				<h4>Featured Brand</h4>
	 			</div>
			 	<!-- COL1 ENDS -->
			 	
				<!-- COL2 STARTS -->
		 		<div class="col-md-1">	 		
					<button type="button" class="btn btn-primary">VIEW ALL</button><br><br>
				</div>
				<!-- COL2 ENDS -->
	 	
	 		</div>
	 		<!-- ROW4 ENDS -->
	 		<br><br>
	 		
	 		<!-- ROW 5 STARTS -->	 	
	 		<div class="row">
	 			<div class="col-md-3">
  					<div class="card">
    					<div class="card-body text-center">
    						<img src="images/61b583.jpg" class="pro3"><br><br>
    					</div>
    				</div>
    			</div>
    			
    	 		<div class="col-md-3">
  					<div class="card">
    					<div class="card-body text-center">
    						<img src="images/7194c7.jpg" class="pro3"><br><br>
    					</div>
    				</div>
    			</div>
    
    	 		<div class="col-md-3">
  					<div class="card">
   	 					<div class="card-body text-center">
    						<img src="images/1ee6febf917059b2.jpg" class="pro3"><br><br>
    					</div>
    				</div>
    			</div>
    
    	 		<div class="col-md-3">
  					<div class="card">
    					<div class="card-body text-center">
    						<img src="images/5b570b8a9bd0b179.jpg" class="pro3"><br><br>
    					</div>
    				</div>
    			</div>
   			</div>
	 
  			<!-- ROW4 STARTS -->
	 		<div class="row row_4"><br>
	 		
	 			<!-- COL1 STARTS -->
	 			<div class="col-md-10 cc mrwhite">
	 				<h4>Mobile New Launches</h4>
	 			</div>
			 	<!-- COL1 ENDS -->
			 	
				<!-- COL2 STARTS -->
		 		<div class="col-md-1">
					<button type="button" class="btn btn-primary">VIEW ALL</button><br><br>		
				</div>
				<!-- COL2 ENDS -->
	 			<br><br>
	 		</div>
	 		<!-- ROW4 ENDS -->
	 		<br><br>	

		 	<div class="row">
	 			<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman"><br>
    						<img src="images/mi-redmi-e7t-na-original-imafazxdh2bd6hep.jpeg" class="pro4"><br><br>
         					<p class="card-text"><b>Redmi Note 6 Pro</b></p>
						    <p class="card-text mrgrey">12MP+5MP|20MP+2MP</p>
						    <button type="button" class="btn1" width="100%">VIEW</button><br><br>
						</div>    
    				</div>
    			</div>
    
    	 		<div class="col-md-2">
  					<div class="card">
	    				<div class="card-body text-center borman"><br>
	    					<img src="images/realme-2-rmx805-original-imaf9sn9szzvzsyu.jpeg" class="pro4"><br><br>
					        <p class="card-text"><b>Realme 2</b></p>
					      	<p class="card-text mrgrey">13MP+2MP|8MP Camera</p>
					      	<button type="button" class="btn1" width="100%">VIEW</button><br><br>
	    				</div>
    				</div>
    			</div>
    
        	 	<div class="col-md-2">
  					<div class="card">
					    <div class="card-body text-center borman"><br>
						    <img src="images/realme-c1-rmx1811-original-imaf9e7csexsdstd.jpeg" class="pro4"><br><br>
						    <p class="card-text"><b>Realme C1</b></p>
						    <p class="card-text mrgrey">13MP+2MP|5MP Camera</p>
						    <button type="button" class="btn1">VIEW</button><br><br>
					    </div>
    				</div>
   	 			</div>
    
        	 	<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman"><br>
					   	 	<img src="images/nokia-6-1-na-original-imaf892exbgttdpe.jpeg" class="pro4"><br><br>
					        <p class="card-text"><b>Nokia 6.1 plus</b></p>
					      	<p class="card-text mrgrey">15MP+5MP Camera</p>
					      	<button type="button" class="btn1" width="100%">VIEW</button><br><br>
					    </div>
    				</div>
    			</div>
    
            	<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman"><br>
						   	<img src="images/lenovo-a5-padj0040cn-original-imafaycjjekkx5fg.jpeg" class="pro4"><br><br>
						    <p class="card-text"><b>Lenovo A5</b></p>
						    <p class="card-text mrgrey">16MP|8MP Camera</p>
						    <button type="button" class="btn1" width="100%">VIEW</button><br><br>
						</div>					    
    				</div>
    			</div>
    
            	<div class="col-md-2">
  					<div class="card">
					    <div class="card-body text-center borman"><br>
					    	<img src="images/redmi-note-5-pro-na-original-imaf2ashnnbxxks5.jpeg" class="pro4"><br><br>
					         <p class="card-text"><b>Redmi Note 5 pro</b></p>
					     	 <p class="card-text mrgrey">12MP+5MP Camera</p>
					      	<button type="button" class="btn1" width="100%">VIEW</button><br><br>
					    </div>
    				</div>
    			</div> 
  			</div><br><br>
  			
 			 <!-- ROW4 STARTS -->
	 		<div class="row row_4"><br>
	 		
	 			<!-- COL1 STARTS -->
	 			<div class="col-md-10 cc mrwhite">	
	 				<h4>Home Decor Range</h4>
	 			</div>
			 	<!-- COL1 ENDS -->
			 	
				<!-- COL2 STARTS -->
		 		<div class="col-md-1">
					<button type="button" class="btn btn-primary">VIEW ALL</button><br><br>		
				</div>
				<!-- COL2 ENDS -->
	 			<br><br>
	 		</div>
	 		<!-- ROW4 ENDS -->
	 		<br><br>	
	 		
	 		<div class="row">
	 			<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman"><br>
					      	<img src="images/789546p-awesome-vstu-original-imaf7vtwezwbhuun.jpeg" class="pro5"><br><br>
					      	<p class="card-text"><b>Decorative Bottles</b></p>
					      	<p class="card-text mrgrey">From Rs199</p>
					      	<button type="button" class="btn1" width="100%">VIEW</button><br><br>
    					</div> 
    				</div>
    			</div>
    	 		<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman"><br>
						    <img src="images/handpainted-peacock-design-wwc5090-analog-craft-junction-original-imaeztzpekug2zq4.jpeg" class="pro5"><br><br>
						    <p class="card-text"><b>Wall Clocks</b></p>
						    <p class="card-text mrgrey">Mininum 50% off</p>
						    <button type="button" class="btn1" width="100%">VIEW</button><br><br>
    					</div>
    				</div>
    			</div>
    
        	 	<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman"><br>
						    <img src="images/kvm-cf-lb04-kraft-village-original-imaeg546agyjtzjx.jpeg" class="pro5"><br><br>
						    <p class="card-text"><b>Feng Shui Showpieces</b></p>
						    <p class="card-text mrgrey">Under Rs999</p>
						    <button type="button" class="btn1">VIEW</button><br><br>
    					</div>    
   		 			</div>
    			</div>
    
        	 	<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman"><br>
						    <img src="images/sscdr-89-decorhand-original-imaeft3kefhg3zcb.jpeg" class="pro5"><br><br>
						    <p class="card-text"><b>Wall Shelves</b></p>
						    <p class="card-text mrgrey">Upto 80% off</p>
						    <button type="button" class="btn1" width="100%">VIEW</button><br><br>
						</div>
    				</div>
    			</div>
    
            	<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman"><br>
    						<img src="images/123-lipax-original-imaf9e885guuzysg.jpeg" class="pro5"><br><br>
					        <p class="card-text"><b>Laser Lights</b></p>
					      	<p class="card-text mrgrey">Upto 60% off</p>
					      	<button type="button" class="btn1" width="100%">VIEW</button><br><br>
					    </div>					    
    				</div>
   				</div>
    			
            	<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman"><br>
						    <img src="images/mahi-blue-a-basement-bazaar-original-imaegbhc5cddn8ke.jpeg" class="pro5"><br><br>
						   	<p class="card-text"><b>Hookahs & Bongs</b></p>
						    <p class="card-text mrgrey">Under Rs599</p>
						    <button type="button" class="btn1" width="100%">VIEW</button><br><br>
						</div>
    				</div>
    			</div><br><br>
  			</div><br><br>
  			
  			<!-- ROW4 STARTS -->
	 		<div class="row row_4"><br>
	 			
	 			<!-- COL1 STARTS -->
	 			<div class="col-md-10 cc mrwhite">	
	 				<h4>Fashion Accessories</h4>
	 			</div>
			 	<!-- COL1 ENDS -->
			 	
				<!-- COL2 STARTS -->
		 		<div class="col-md-1">	 		
					<button type="button" class="btn btn-primary">VIEW ALL</button><br><br>		
				</div>
				<!-- COL2 ENDS -->
	 			<br><br>
	 		</div>
	 		<!-- ROW4 ENDS -->
	 		<br><br>
	 		<div class="row">
	 			<div class="col-md-2">
  					<div class="card">
					    <div class="card-body text-center borman"><br>
						    <img src="images/onesize-m155gr1-fastrack-original-imaexwzhgpaw5zqu.jpeg" class="pro5"><br><br>
						    <p class="card-text"><b>Ray-Ban,Fasttrack..</b></p>
						    <p class="card-text mrgrey">20-60% off</p>
						    <button type="button" class="btn1" width="100%">VIEW</button><br><br>
						</div>    
    				</div>
    			</div>
    	 		<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman"><br>
						    <img src="images/38-inches-leather-belt-bt-1059041-belt-woodland-original-imaf5jgt3y4tg5jm.jpeg" class="pro5"><br><br>
						    <p class="card-text"><b>Cross Woodland</b></p>
						   	<p class="card-text mrgrey">Top Rated</p>
						    <button type="button" class="btn1" width="100%">VIEW</button><br><br>
						</div>
					</div>
    			</div>
    			<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman"><br>
						    <img src="images/ad214-casio-original-imaer2c4hmdxkwqx.jpeg" class="pro5"><br><br>
						    <p class="card-text"><b>Casio Maxima</b></p>
						    <p class="card-text mrgrey">Upto 50%</p>
						    <button type="button" class="btn1">VIEW</button><br><br>
    					</div>
    				</div>
    			</div>  
        	 	<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman"><br>
						    <img src="images/ex099-casio-original-imaeymepcz4eu5zz.jpeg" class="pro5"><br><br>
						    <p class="card-text"><b>Casio, Fasttrack</b></p>
						    <p class="card-text mrgrey">10-50% off</p>
						   	<button type="button" class="btn1" width="100%">VIEW</button><br><br>
    					</div>
    				</div>
   	 			</div>
    			<div class="col-md-2">
					<div class="card">
						<div class="card-body text-center borman"><br>
							<img src="images/ng3039sp01c-fastrack-original-imaev2thd4f837wk.jpeg" class="pro5"><br><br>
     							<p class="card-text"><b>Titan, Fastrack</b></p>
  								<p class="card-text mrgrey">20-80% off</p>
  								<button type="button" class="btn1" width="100%">VIEW</button><br><br>
						</div>
					</div>
				</div>
				<div class="col-md-2">
  					<div class="card">
    					<div class="card-body text-center borman"><br>
    						<img src="images/ng38022pp06cj-fastrack-original-imaetxgteqwhggpc.jpeg" class="pro5"><br><br>
         					<p class="card-text"><b>Fastrack</b></p>
      						<p class="card-text mrgrey">Under Rs 999</p>
      						<button type="button" class="btn1" width="100%">VIEW</button><br><br>
    					</div>
    				</div>
    			</div><br><br>
  			</div><br><br>  
  
 			<!-- ROW6 STARTS -->
			<%@ include file = "Footer.jsp" %>
			<!-- ROW6 ENDS -->
		</div>
		<!-- CONTAINER CLASS ENDS -->

		<script src="js/jquery-3.3.1.js"></script> <!-- JQUERY JAVASCRIPT -->
		<script src="bootstrap/js/bootstrap.js"></script> <!-- BOOTSTRAP JAVASCRIPT  -->
	</body>
	<!-- BODY ENDS -->
</html>
