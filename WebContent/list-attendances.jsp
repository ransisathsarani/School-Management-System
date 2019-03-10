<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Update Attendance </title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="style_1.css" />
</head>

<body>
<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#274F75;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>
      <span>www.MonarchCollege.lk <br />
      <br />
      +9411 2596334</span> </div>
      <div style="background-color:#ffff66">
    <ul>
      <li class="current"><a href="Home.jsp">Home</a></li>
      <li><a href="SchoolProfile.html">School Profile</a></li>
      <li><a href="UserLogin.jsp">Log in</a></li>
      <li><a href="RegisterNow.jsp">Join us</a></li>
      <li><a href="ContactUs.html">Contact us</a></li>
	  <li style="float:right"><a href="#"><img src="images/profilepic.png" height="42" width="42"></a></li>
      <li style="float:right"><a href="Home.html">Logout</a></li>
    </ul>
    </div>
    <div id="tagline">
      <div style="background-color:#ffff66; width:500px ; height: 600px">
        


		<h3>List Attendance</h3>
		
		<!-- new button: add attendance -->
		
		<input type="button" value="Add Attendance"
			onclick="window.location.href='add-attendance-form.jsp'; return false;"
			class="add-attendance-button"
		/>
		
			<table align="center" cellpadding="5" cellspacing="5" border="1">
				<tr>
					
					<th>Year</th>
					<th>class</th>
					<th>date</th>
					<th>present</th>
					<th>absent</th>
					
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempAttendance" items="${ATTENDANCE_LIST}">

					<!-- set up a link for each record -->
					<c:url var="tempLink" value="AttendanceControllerServlet" >
						<c:param name="command" value="LOAD" />
						<c:param name="attendanceId" value="${tempAttendance.id}" />
					</c:url>
					
					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="AttendanceControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="attendanceId" value="${tempAttendance.id}" />					
					</c:url>

					<tr>
						
						<td> ${tempAttendance.year} </td>
						<td> ${tempAttendance.classroom} </td>
						<td> ${tempAttendance.date} </td>
						<td> ${tempAttendance.present} </td>
						<td> ${tempAttendance.absent} </td>
						<td> 
						<a href="${tempLink}">Update</a>
						<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this record?')))return false">
							Delete</a> 
						</td>
					</tr>
				</c:forEach>
			
			</table>
		
		 </div>
    </div>
  </div>
  
 
</div>
</body>
</html>


	