<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>我的成长足迹</title>
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  
  <link rel="stylesheet" href="css/demo.css" />
  <link rel="stylesheet" href="css/templatemo-style.css">
  
  <script type="text/javascript" src="js/modernizr.custom.86080.js"></script>

		
	</head>

	<body>

			<div id="particles-js"></div>
		
			<ul class="cb-slideshow">
	            <li></li>
	            <li></li>
	            <li></li>
	            <li></li>
	            <li></li>
	            <li></li>
	        </ul>

			<div class="container-fluid">
				<div class="row cb-slideshow-text-container ">
					<div class= "tm-content col-xl-6 col-sm-8 col-xs-8 ml-auto section">
					<header class="mb-5"><h1></h1></header>
					
                    <form action="LoginServlet" method="post" class="subscribe-form">
               	    	<div class="row form-section">

							<div class="col-md-7 col-sm-7 col-xs-7">
			                      <input name="username" type="text" class="form-control" id="contact_username" value="${username }" placeholder="Your Name..." required/>
								  <input name="password" type="password" class="form-control" id="contact_password" placeholder="Your Password..." required/>
				  				<span style="color: red;font-size: 20px">${msg }</span>
				  			</div>
							<div class="col-md-5 col-sm-5 col-xs-5">
								<button type="submit" class="tm-btn-subscribe">Submit</button>
							</div>
						
						</div>
                    </form>
                    
					<div class="tm-social-icons-container text-xs-center">
	                    <a href="" class="tm-social-link"><i class="fa fa-facebook"></i></a>
	                    <a href="" class="tm-social-link"><i class="fa fa-google-plus"></i></a>
	                    <a href="" class="tm-social-link"><i class="fa fa-twitter"></i></a>
	                    <a href="" class="tm-social-link"><i class="fa fa-linkedin"></i></a>
	                </div>

					</div>
				</div>	
				<div class="footer-link">
					<p>Copyright © 2018 我的成长足迹
                    
                    - Design: <a target="_parent">SRAM</a></p>
				</div>
			</div>	
	</body>
  <script type="text/javascript" src="js/particles.js"></script>
  <script type="text/javascript" src="js/app.js"></script>
	
</html>