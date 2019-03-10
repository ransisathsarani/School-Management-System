<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>add Attendance </title>
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
      <li><a href="ContactUs.html">Contact us</a></li>
	  <li style="float:right"><a href="#"><img src="images/profilepic.png" height="42" width="42"></a></li>
      <li style="float:right"><a href="Home.html">Logout</a></li>
    </ul>
    </div>
    <div id="tagline">
      <div style="background-color:#ffff66; width:400px ; height: 300px">
        
	<h3> Add Attendance</h3>
		<form action="AttendanceControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>year:</label></td>
						<td><select  name="year">
						<option value = 6 > 6 </option>
						<option value = 7 > 7 </option>
						<option value = 8 > 8 </option>
						<option value = 9 > 9 </option>
						<option value = 10> 10 </option>
						<option value = 11 > 11 </option>
						<option value = 12 > 12 </option>
						</select>
						</td>
					</tr>
					
					<tr>
						<td><label>class:</label></td>
						<td><select  name = "classroom">
						<option value = a > a </option>
						<option value = b > b </option>
						<option value = c > c </option>
						</select>
						</td>
					</tr>
					
					<tr>
						<td><label>date:</label></td>
						<td><input type=text name="date" /></td>
					</tr>
					<tr>
						<td><label>present:</label></td>
						<td><input type=number name="present" /></td>
					</tr>
					
					<tr>
						<td><label>absent:</label></td>
						<td><input type="number" name="absent" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				
				</tbody>
			</table>
		</form>
		
		 </div>
    </div>
  </div>
  
 
</div>
</body>
</html>

				