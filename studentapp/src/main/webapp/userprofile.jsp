<%-- 
    Document   : userprofile
    Created on : 26 Sep, 2019, 12:17:04 PM
    Author     : pennantstaff
--%>

<%@page import="com.vjya.studentapp.Dbcon"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>users</title>

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

<style>
    .buton{
        width:20%;
        margin:0 auto;
    }
    .bt1{
        margin-top: 11px;
        margin-left: 19px;
           color: #fff;
    margin: 0 auto;
    margin-top: 2em;
    padding: 9px 30px;
    font-size: 1.04em;
    cursor: pointer;
    border: 2px solid #00d2c9;
    outline: none;
    background: #00d2c9;
    font-weight: 500;
    font-family: 'Roboto', sans-serif;
    transition: 0.5s all ease;
       
    }
    .bt2{
           color: #fff;
    margin: 0 auto;
    margin-top: 2em;
    padding: 9px 30px;
    font-size: 1.04em;
    cursor: pointer;
    border: 2px solid #00d2c9;
    outline: none;
    background: #00d2c9;
    font-weight: 500;
    font-family: 'Roboto', sans-serif;
    transition: 0.5s all ease;
        margin-left: 30px;
    }
    
</style>
</head>
<body>
      <%  HttpSession hs=null;
            String ls=null;
            RequestDispatcher rd=null;
            Connection cn=null;
          
         
            int ns=0;
            String name="",gender="",bgroup="",age1="",apid="";
            String date="DD-MM-YYYY";
            String date2="DD-MM-YYYY";
          
           
        
            try{
              
            hs=request.getSession(true);
           ls=(String)hs.getAttribute("loginstatus");
          
               
           
          if(ls==null){
            response.sendRedirect("index.html");
          }else if(!ls.equals("yes")){
                rd=request.getRequestDispatcher("index.html");
               rd.forward(request,response);
               
           } 
           ns=(Integer)hs.getAttribute("PId");
            Dbcon dt=new Dbcon();
             
            Class.forName(dt.getDriver());
            cn=DriverManager.getConnection(dt.getUrl(),dt.getUsername(),dt.getPassword());	
            
            PreparedStatement ps=cn.prepareStatement("select patn_name,patn_age,patn_gender,patn_bgroup,patn_lastvisit,patn_lastapp_id,reg_date from Patients where patn_id="+ns);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                name=rs.getString("patn_name");
                age1=""+rs.getInt("patn_age");
                gender=rs.getString("patn_gender");
                bgroup=rs.getString("patn_bgroup");
               date=""+rs.getDate("patn_lastvisit");
                apid=""+rs.getInt("patn_lastapp_id");
                date2=""+rs.getDate("reg_date");
                if(name==null){
                    name="";
                }
               if(age1.equals("0")){
                   age1="";
               }
               if(bgroup==null){
                   bgroup="";
               }
                if(gender==null){
                    gender="";
                }
                if(date.equals("null")){
                    date="DD-MM-YYYY";
                }
                if(apid.equals("0")){
                    apid="";
                }
                 if(date2.equals("null")){
                    date2="DD-MM-YYYY";
                }
               
            }
                 rs.close();
             
            %>
<div class="container" style="width:100%">
	<div class="row">
		<div class="col-sm-3">
			 <div class="navbar-header">
			<h1><a  href="index.html">Health<span> Care </span></a></h1>
			<br>
			</div>
		</div>
		<div class="col-sm-9" align="right">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="float:right;">
				<ul class="nav navbar-nav navbar-right users-list" style="padding:10px;">
					<li><div class="dropdown">
							  <button class="dropbtn">Appointment</button>
							  <div class="dropdown-content">
							  <a href="completed_appointments.jsp">Completed appointments</a>
							  <a href="upcoming_appointments.jsp">Upcoming appointments</a>
							  <a href="new_appointment.jsp">New appointments</a>
							  </div>
							</div>
							</li>
							<li><div class="dropdown">
							  <button class="dropbtn">Diagnostic</button>
							  <div class="dropdown-content">
							  <a href="Book_diagonstic.jsp">Book diagnostic test</a>
							  <a href="CompletedDiagnosticTest.jsp">completed tests</a>
							  <a href="user_reports.jsp">Test reports/ details</a>
							  </div>
							</div>
							</li>
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
        <div class="book-appointment">
		
			<div class="left-agileits-w3layouts same">
                            <div class="gaps">
				<p>Patient Id</p>
					<input type="text" id="Pid" placeholder="" required="" value="<%=ns%>" readonly/>
			</div>	
			<div class="gaps">
				<p>Patient Name</p>
                                <input type="text" name="PatientName" id="pname"  required="" value="<%=name%>" readonly/>
			</div>	
				<div class="gaps">	
				<p>age</p>
					<input type="text" name="age" id="age" required="" value="<%=age1%>" readonly/>
				</div>
				<div class="gaps">
				<p>gender</p>
				<input type="text" name="gender" id="gend" required="" value="<%=gender%>" readonly/>
						
				</div>	
				
			</div>
			<div class="right-agileinfo same">
			<div class="gaps">
				<p>Blood group</p>		
						<input  id="blood" name="blood_group" type="text" value="<%=bgroup%>" readonly >
			</div>
			<div class="gaps">
				<p>Registration date</p>	
					<input id="datepicker1" type="text" style="color:white;" value="<%=date2%>" readonly >
			</div>
			<div class="gaps">
				<p>Last visit</p>	
				<input  id="last_visit" name="last_visit" type="text"  value="<%=date%>" readonly>	
			</div>   
			<div class="gaps">
				<p>Last_appointment_id</p>	
                                <input  id="last_appnt_id" name="last_appnt_id" type="text" value="<%=apid%>" readonly>
			</div>
			</div>
                    
                      <div class="buton"><button  class="bt1" onclick="makewrite()">Edit</button><button class="bt2" onclick="store()">Save</button></div>
                        
              
                
<table id="tblCustomers">
	                               <br><br>
 <h4 style="color:white;">Family Members Details</h4>
			
			
	<tr>	
    <th style="color:white;width:5%;">S.NO</th>
    <th style="color:white;width:40%;">Name</th>		
    <th style="color:white;width:15%;">Gender</th>
	<th style="color:white;width:10%;">Age</th>
    <th style="color:white;width:10%;">Relation</th>	
    <th style="color:white;width:15%;">Blood Group</th>
	<th style="color:white;width:5%;">Add Member</th>
        <th style="color:white;width:5%;">Del Member</th>
	
  </tr>
    <!--------------------patient 1 start------------------------>
<% 
    ps=cn.prepareStatement("Select pfmb_index,pfmb_name,pfmb_relation,pfmb_age,pfmb_gender,pfmb_bgroup from PatientFamilyMembers where patn_id="+ns+" order by PFMB_INDEX");
    ResultSet rs1=ps.executeQuery();
    int i=1;
    while(rs1.next()){
      
        int pin=rs1.getInt("pfmb_index");
        String pfname=rs1.getString("pfmb_name");
        String pfrel=rs1.getString("pfmb_relation");
        int pfage=rs1.getInt("pfmb_age");
        String pfgend=rs1.getString("pfmb_gender");
        String pfbgroup=rs1.getString("pfmb_bgroup");
        
    

%>
  <tr >
    <td style="color:white;"><label id="sno<%=i%>"><%=pin%></label></td>
    <td style="color:white;"><input type="text" id="name<%=i%>"  value="<%=pfname%>" readonly/></td>
	<td>
	
            <input type="text"  id="gender<%=i%>" value="<%=pfgend%>" readonly/>
	
	
	</td>
        <td><input type="text" id="age<%=i%>"  value="<%=pfage%>" readonly/></td>
	<td style="color:Black;">
             <input type="text"   id="relation<%=i%>" value="<%=pfrel%>" readonly/>
	</td>
        <td style="color:white;"><input type="text" id="blood<%=i%>" value="<%=pfbgroup%>" readonly/> </td>
        <td><button id="<%=i%>" class="btn" onclick="edit(this)" style="background-color: rgba(127, 178, 212, 0.31);color: white">EDIT</button></td>
        <td><button id="del<%=i%>" class="btn" onclick="rem(this)" style="background-color: rgba(127, 178, 212, 0.31);color:white">Remove</button></td>
	
  </tr>
          <% 
          i++;
            
    }
          rs1.close(); 
          
          if(i<6){
               %>

  <!--------------------patient 2 start------------------------>

  <tr >
    <td style="color:white;"><label id="sno<%=i%>"><%=i%></label></td>
    <td style="color:white;"><input type="text" id="name<%=i%>" name="name"/></td>
	<td>
	 <label style="color:white;">M</label>
		 <input type="radio"  name="gender<%=i%>" value="male"/>
	 <label style="color:white;">F</label>
		 <input type="radio"  name="gender<%=i%>" value="female"/>
	
	</td>
	<td><input type="text" id="age<%=i%>" name="age" value=""/></td>
	<td style="color:Black;">
	<select id="relation<%=i%>" name="Relation">
<option value="Other">Other</option>
<option value="Mother">Mother</option>
<option value="Father">Father</option>
<option value="Brother">Brother</option>
<option value="Sister">Sister</option>
<option value="Husband">Husband</option>
<option value="Wife">Wife</option>
<option value="Son">Son</option>
<option value="Daughter">Daughter</option>

</select>
	</td>
	<td style="color:white;"><input type="text" id="blood<%=i%>"/> </td>
	<td><button id="<%=i%>" class="btn" onclick="addmemb(this)">ADD</button></td>
	
  </tr>
 <%}%>
  

 
  </table>
                  
                      
  
  
  <!--------------------patient medical------------------------>
    <table id="tb2ParametersValues">
	                              
	   
	                              
			                      <h4 style="color:white;">Patient Parameters Details</h4>
<%  
            ps=cn.prepareStatement("select PATN_PARAMETER,PATN_PARAM_VALUE from PatientMedicalProfile where PATN_ID="+ns);
            ResultSet rs2=ps.executeQuery();
            if(rs2.next()){
                  String para=rs2.getString("PATN_PARAMETER");
                    String paravalue=rs2.getString("PATN_PARAM_VALUE");

                %> 
              
			
			
	<tr>	
  
        <th style="color:white;width:40%;">Parameter</th>		
        <th style="color:white;width:15%;">value</th>
	
	
  </tr>
  <tr >
    
    <td style="color:white;"><input type="text" id="parameter" name="parameter" value="<%=para%>"/></td>
	<td><input type="text" id="value" name="value" value="<%=paravalue%>"/></td>
  </tr>
  
  <%
            while(rs2.next()){
              para=rs2.getString("PATN_PARAMETER");
                paravalue=rs2.getString("PATN_PARAM_VALUE");



%>
  <tr >
    
    <td style="color:white;"><input type="text" id="parameter" name="parameter" value="<%=para%>"/></td>
	<td><input type="text" id="value" name="value" value="<%=paravalue%>"/></td>
  </tr>
 
 
  <%
            }
            }else{
                %>
                
                <span style="color:white;">**NO Available Parameters**</span>  
                
                
                <%
            }
  rs2.close();
        
                cn.close();

                }catch(Exception ex){
                    out.print(ex.getMessage());
                }
  
  
  %>

 
  </table>
			<div class="clear"></div>
						
			
	
		</div>

</div>
     <script src="js/sweetalert.js"></script>
  <script src="js/jquery.min.js"></script>
    <script>
        function makewrite(){
             document.getElementById("pname").readOnly = false;
                document.getElementById("age").readOnly = false;
                   document.getElementById("gend").readOnly = false;
                      document.getElementById("blood").readOnly = false;
        }
        
        function store(){
            var id=document.getElementById("Pid").value;
             var pn= document.getElementById("pname").value;
            var ag= document.getElementById("age").value;
            var ge=document.getElementById("gend").value;
             var bl=document.getElementById("blood").value;
             
            
               var req=new XMLHttpRequest();
             if(id==''||pn==''||ag==''||ge==''||bl==''){
                 alert("fill");
             }
             else{
                  req.onreadystatechange = function(){
                                  if(req.readyState=='4'&& req.status=='200'){
                                 var s=req.responseText;
                                 swal("Profile Updated!", "", "success")
                                   document.getElementById("pname").readOnly = true;
                document.getElementById("age").readOnly = true;
                   document.getElementById("gend").readOnly = true;
                      document.getElementById("blood").readOnly = true;
                                }
                                }
                                req.open("GET","http://localhost:8084/HealthCare/profile?personid="+id+"&personname="+pn+"&age="+ag+"&blood="+bl+"&gend="+ge,true);
                                                            req.send(null);
             }
                     
        }
        
        function addmemb(x){
            var j=x.id;
          
            var pid=document.getElementById("Pid").value;
            var name=document.getElementById("name"+j).value;
           
            var gender=document.getElementsByName('gender'+j);
           
            var age=document.getElementById("age"+j).value;
           
            var rel=document.getElementById("relation"+j).value; 
         
            var blood=document.getElementById("blood"+j).value;
           
            
            var genda;
for(var i = 0; i < gender.length; i++){
    if(gender[i].checked){
        genda = gender[i].value;
    }
}           
                if(name==''||age==''||blood==''){
                    document.getElementById("name"+j).setCustomValidity("Fill The Row");
                    document.getElementById("age"+j).setCustomValidity("Fill The Row");
                    document.getElementById("blood"+j).setCustomValidity("Fill The Row");
                  
                }else{
           var req=new XMLHttpRequest();
                    req.onreadystatechange = function()
                    {
                        if(req.readyState=='4'&& req.status=='200')
                        {
                            
                            var s=req.responseText;
                          
                        swal(s);
                            
                            window.location.href="userprofile.jsp";
                           
                         }
                    }
                    req.open("GET","http://localhost:8084/HealthCare/servletforpmemberadding?patid="+pid+"&ind="+j+"&name="+name+"&gender="+genda+"&ral="+rel+"&bgroup="+blood+"&age="+age,true);
                    req.send(null);
                    }
                
        }
        
       function edit(u){
           var j=u.id;
             var name=document.getElementById("name"+j).readOnly = false;
           
            var gender=document.getElementById('gender'+j).readOnly = false;
           
            var age=document.getElementById("age"+j).readOnly = false;
           
            var rel=document.getElementById("relation"+j).readOnly = false;
         
            var blood=document.getElementById("blood"+j).readOnly = false;
           
            
            var but=document.getElementById(j);
            but.innerHTML="save";
            but.setAttribute("onclick","updat(this)");
           
       } 
        
        function updat(z){
          var j=z.id;
                 var pid=document.getElementById("Pid").value;
          var name=document.getElementById("name"+j).value;
           
            var gender=document.getElementById('gender'+j).value;
           
            var age=document.getElementById("age"+j).value;
           
            var rel=document.getElementById("relation"+j).value; 
         
            var blood=document.getElementById("blood"+j).value;
            
               var req=new XMLHttpRequest();
                    req.onreadystatechange = function()
                    {
                        if(req.readyState=='4'&& req.status=='200')
                        {
                            
                            var s=req.responseText;
                          
                          swal(s);
                          var name=document.getElementById("name"+j).readOnly = true;
           
                           var gender=document.getElementById('gender'+j).readOnly = true;
           
                           var age=document.getElementById("age"+j).readOnly = true;
           
                           var rel=document.getElementById("relation"+j).readOnly =true;
         
                           var blood=document.getElementById("blood"+j).readOnly = true;
                            var but=document.getElementById(j);
            but.innerHTML="EDIT";
            but.setAttribute("onclick","edit(this)");
                           
                           
                         }
                    }
                    req.open("GET","http://localhost:8084/HealthCare/forupdatefamily?patid="+pid+"&ind="+j+"&name="+name+"&gender="+gender+"&ral="+rel+"&bgroup="+blood+"&age="+age,true);
                    req.send(null);
         
        }
        function rem(x){
            var id=x.id;
            var str=id.split("del");
            var i=str[1];
            var pid=document.getElementById("Pid").value;
            var name=document.getElementById("name"+i).value;
            var req=new XMLHttpRequest();
            var b=confirm("Are you sure you want to delete?");
            if(b==true){
                    req.onreadystatechange = function()
                    {
                        if(req.readyState=='4'&& req.status=='200')
                        {
                            
                            var s=req.responseText;
                          
                          swal("Member Deleted");
                               red();
                           
                           
                         }
                    }
                    req.open("GET","http://localhost:8084/HealthCare/delmember?index="+i+"&id="+pid,true);
                    req.send(null);
                }
         
        }
        
        function red(){
             window.location.href="userprofile.jsp";
        }
       
    </script>
</body>
</html>
