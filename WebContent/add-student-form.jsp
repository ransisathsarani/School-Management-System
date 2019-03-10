<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	 <title>Monarch College | Add Students</title>
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
      <span><a href="<%=request.getContextPath() %>/logoutServlet">Logout</a></span>
      <br />
      +9411 2596334</span> </div>
      <div style="background-color:#ffff66">
    <ul>
      <li class="current"><a href="SIMS_interface.jsp">Home</a></li>
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
		<form action="StudentControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table style="background-color:#ffff66;width:600px;height:300px">
				<tbody>
					<tr>
						<td><label>StudentNum:</label></td>
						<td><input type="text" name="studentNum" /></td>
					</tr>
					
					<tr>
						<td><label>fistname:</label></td>
						<td><input type="text" name="fname" /></td>
					</tr>
						
					<tr>
						<td><label>lastname:</label></td>
						<td><input type="text" name="lname" /></td>
					</tr>				
					
					<tr>
						<td><label>BOD:</label></td>
						<td><input type="text" name="BOD" /></td>
					</tr>
					
					<tr>
						<td><label>Number:</label></td>
						<td><input type="text" name="number" /></td>
					</tr>
					
					<tr>
						<td><label>Grade:</label></td>
						<td><input type="text" name="grade" /></td>
					</tr>
					
					<tr>
						<td><label>Level:</label></td>
						<td><input type="text" name="level" /></td>
					</tr>
					
					<tr>
						<td><label>Address:</label></td>
						<td><input type="text" name="address" /></td>
					</tr>
					
					<tr>
						<td><label>Gender:</label></td>
						<td><input type="text" name="gender" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="StudentControllerServlet">Back to List</a>
		</p>
		
	</div>

  

</body>
</html>