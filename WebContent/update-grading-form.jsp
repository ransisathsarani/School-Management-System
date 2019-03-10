<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Add Grading</title>
<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#274F75;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>
      <div style="color:#ffffff;align:center"><h1>Student Grading - Information System</h1></div>
      <span>www.MonarchCollege.lk <br />
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
	<div id="wrapper">
		<div id="header">
			<h2>Monarch College</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Grading</h3>
		
		<form action="GradingControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			
			<input type="hidden" name="gradingId" value="${THE_GRADING.id}" />
			
				
    <table style="background-color:#ffff66;width:600px;height:300px">
        <tr>
						<td><label>studentID:</label></td>
						<td><input type="text" name="SID" 
									value="${THE_GRADING.SID}"/></td>
					</tr>
       <tr>
						<td><label>level:</label></td>
						<td><input type="text" name="level" 
									value="${THE_GRADING.level}"/></td>
					</tr>
		<tr>
						<td><label>examID:</label></td>
						<td><input type="text" name="examID" 
									value="${THE_GRADING.examID}"/></td>
					</tr>
    
   
        <tr>
            <th>Subject</th>
            <th>Obtained Marks</th>
           
        </tr>
        <tr>
						<td><label>subject 1:</label></td>
						<td><input type="text" name="sub1" 
									value="${THE_GRADING.sub1}"/></td>
					</tr>
        <tr>
						<td><label>subject 2:</label></td>
						<td><input type="text" name="sub2" 
									value="${THE_GRADING.sub2}"/></td>
					</tr>
       <tr>
						<td><label>subject 3:</label></td>
						<td><input type="text" name="sub3" 
									value="${THE_GRADING.sub3}"/></td>
					</tr>
        <tr>
						<td><label>subject 4:</label></td>
						<td><input type="text" name="sub4" 
									value="${THE_GRADING.sub4}"/></td>
					</tr>
        <tr>
						<td><label>subject 5:</label></td>
						<td><input type="text" name="sub5" 
									value="${THE_GRADING.sub5}"/></td>
					</tr>
       
        
        
        
        <tr>
            <td></td>
        </tr>
        <tr>
            <td></td>
        </tr>
        <tr><td></td><td align="center"><input type="submit" value="submit"/></td></tr>
       
    </table>
		 </form>
		<div style="clear: both;"></div>
		
		<p>
			<a href="GradingControllerServlet">Back to List</a>
		</p>
		
	</div>


</body>
</html>