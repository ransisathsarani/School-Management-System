<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	 <title>Monarch College | Level2</title>
<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
</head>
<body>
<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#274F75;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>
      <div style="color:#ffffff;align:center"><h1>Add Teacher - Information System</h1></div>
      <span>www.MonarchCollege.lk <br />
       <span>welcome <%=request.getAttribute("username") %>
<a href="<%=request.getContextPath() %>/logoutServlet">Logout</a></span>
      <br />
      +9411 2596334</span> </div>
      <div style="background-color:#ffff66">
    <ul>
       <li class="current"><a href="Home.jsp">Home</a></li>
      <li><a href="add-student-form.jsp">Add Student</a></li>
      <li><a href="add-teacher-form.jsp">Add Teacher</a></li>
      <li><a href="add-timetable-form.jsp">Timetables</a></li>
      <li><a href="add-subject-form.jsp">Add Subject</a></li>
    </ul>
    </div>
    </div>
    </div>
    <br><br><br><br>
   <div align="center">
		<form action="TeacherControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table style="background-color:#ffff66;width:600px;height:300px">
					<tr>
						<td><label>Staff Id:</label></td>
						<td><input type="text" name="staffid" /></td>
					</tr>
					
					<tr>
						<td><label>name:</label></td>
						<td><input type="text" name="name" /></td>
					</tr>
					
					<tr>
						<td><label>subject number:</label></td>
						<td><input type="text" name="subjectNum" /></td>
					</tr>
						
					<tr>
						<td><label>email:</label></td>
						<td><input type="text" name="email" /></td>
					</tr>
					
					<tr>
						<td><label>password:</label></td>
						<td><input type="text" name="password" /></td>
					</tr>	
					
					<tr>
						<td><label>number:</label></td>
						<td><input type="text" name="number" /></td>
					</tr>			
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="TeacherControllerServlet">Back to List</a>
		</p>
		
	</div>

    

</body>
</html>