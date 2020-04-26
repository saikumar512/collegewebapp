
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
<title>student</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Clinical Lab Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/user.css" rel="stylesheet" type="text/css" media="all" />

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- js -->

<!-- //js -->
<!--animate-->
<!--//end-animate-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=Poiret+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&display=swap" rel="stylesheet">




</head>
    <body>
         <%
           
            
            HttpSession hs=null;
            String ls=null;
            RequestDispatcher rd=null;
            try{
              
            //validating login status
           hs=request.getSession(true);
           ls=(String)hs.getAttribute("loginstatus");
           if (ls == null){
               response.sendRedirect("index.html");
           }else{
               if (!ls.equals("yes")){
                    rd=request.getRequestDispatcher("student_dashboard.html");
                    rd.forward(request,response);
               }
           }
              }catch(Exception ex){
                out.println(ex.getMessage());
            }  
           
            %>
            <div class="container" style="width:100%">
	<div class="row">
		<div class="col-sm-3">
			 <div class="navbar-header">
			<h1><a  href="student_dashboard.html">vijaya<span> College </span></a></h1>
			<br>
			</div>
		</div>
		<div class="col-sm-9" align="right">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="float:right;">
				<ul class="nav navbar-nav navbar-right users-list" style="padding:10px;">
							<li><div class="dropdown">
							  <button class="dropbtn" onclick="window.location.href='userprofile.jsp'">profile</button>
							</div>
							</li>
							<li><div class="dropdown">
							  <button class="dropbtn">Contact Us</button>
							  
							</div>
							</li>
							<li><div class="dropdown">
                                               <button class="dropbtn" onclick="window.location.href='http://localhost:8084/HealthCare/logoutserv'">Log Out</button>
							  
							</div>
							</li>
				</ul>	
				<div class="clearfix"> </div>	
			</div>
    </div>
</div>

</div>
    </body>
</html>
