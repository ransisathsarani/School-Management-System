<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
      <li><a href="SchoolProfile.html">School Profile</a></li>
	  <li style="float:right"><a href="#"><img src="images/profilepic.png" height="42" width="42"></a></li>
      <li style="float:right"><a href="Home.html">Logout</a></li>
    </ul>
    </div>
    <div id="tagline">
      <div style="background-color:#ffff66; width:400px ; height: 300px">
        


		<h3>Update Attendance</h3>
		
		<form action="AttendanceControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			
			<input type="hidden" name="attendanceId" value="${THE_ATTENDANCE.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>year:</label></td>
						<td><select name="year">
						<option value = "${THE_ATTENDANCE.year}"> 6 </option>
						<option value = "${THE_ATTENDANCE.year}" > 7 </option>
						<option value = "${THE_ATTENDANCE.year}"> 8 </option>
						<option value = "${THE_ATTENDANCE.year}"> 9 </option>
						<option value = "${THE_ATTENDANCE.year}"> 10 </option>
						<option value = "${THE_ATTENDANCE.year}" > 11 </option>
						<option value = "${THE_ATTENDANCE.year}" > 12 </option>
						</select>
						</td>
					</tr>
					
					<tr>
						<td><label>class:</label></td>
						<td><select name="classroom">
						<option value = "${THE_ATTENDANCE.classroom}" > a </option>
						<option value = "${THE_ATTENDANCE.classroom}" > b </option>
						<option value = "${THE_ATTENDANCE.classroom}"> c </option>
						</select>
						</td>
					</tr>
					<tr>
						<td><label>date:</label></td>
						<td><input type=text name="date" value="${THE_ATTENDANCE.date}"/></td>
					</tr>
					
					<tr>
						<td><label>present:</label></td>
						<td><input type=number name="option2" value="${THE_ATTENDANCE.present}"/></td>
					</tr>
					
					<tr>
						<td><label>absent:</label></td>
						<td><input type="number" name="option3" value="${THE_ATTENDANCE.absent}"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
			<a href="AttendanceControllerServlet">Back to List</a>
	
		 </div>
    </div>
  </div>
  
</div>
</body>
</html>


	