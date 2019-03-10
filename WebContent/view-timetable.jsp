<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html>

<head>
	<title>Monarch College List Timetable</title>
	<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
</head>



<body>

<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#274F75;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>
      <div style="color:#ffffff;align:center"><h1>List Timetable - Information System</h1></div>
      <span>www.MonarchCollege.lk <br />
      <br />
      +9411 2596334</span> </div>
      <div style="background-color:#ffff66">
    <ul>
      <li class="current"><a href="Home.html">Home</a></li>
      <li><a href="add-student-form.jsp">Add Student</a></li>
      <li><a href="add-teacher-form.jsp">Add Teacher</a></li>
      <li><a href="add-timetable-form.jsp">Timetables</a></li>
      <li><a href="add-subject-form.jsp">Add Subject</a></li>
      <li><a href="#">Others</a></li>
    </ul>
    </div>
    </div>
    </div>
    <br><br><br><br>
   <div align="center">
		<!-- new button: add level2 -->
		
		<input type="button" value="Add Subject"
			onclick="window.location.href='add-timetable-form.jsp'; return false;"
			class="add-subject-button"/>
		<div style="background-color:#ffff66;width:1600px;align:center">
			<table align="center" cellpadding="5" cellspacing="5" border="1">
				<tr>
					<th>TimetableID</th>
					<th>subjectID</th>
					<th>time</th>
					<th>subjectID</th>
					<th>time</th>
					<th>subjectID</th>
					<th>time</th>
					<th>subjectID</th>
					<th>time</th>
					<th>subjectID</th>
					<th>time</th>
					<th>subjectID</th>
					<th>time</th>
					<th>subjectID</th>
					<th>time</th>
					<th>subjectID</th>
					<th>time</th>
					
					
					
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempTimetable" items="${TIMETABLE_LIST}">

					<!-- set up a link for each record -->
					<c:url var="tempLink" value="TimetableControllerServlet" >
						<c:param name="command" value="LOAD" />
						<c:param name="timetableId" value="${tempTimetable.id}" />
					</c:url>
					
					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="TimetableControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="timetableId" value="${tempTimetable.id}" />					
					</c:url>

					<tr>
						<td> ${tempTimetable.ttid} </td>
						<td> ${tempTimetable.subid_1} </td>
						<td> ${tempTimetable.time_1} </td>
						
						<td> ${tempTimetable.subid_2} </td>
						<td> ${tempTimetable.time_2} </td>
						
						<td> ${tempTimetable.subid_3} </td>
						<td> ${tempTimetable.time_3} </td>
						
						<td> ${tempTimetable.subid_4} </td>
						<td> ${tempTimetable.time_4} </td>
						
						<td> ${tempTimetable.subid_5} </td>
						<td> ${tempTimetable.time_5} </td>
						
						<td> ${tempTimetable.subid_6} </td>
						<td> ${tempTimetable.time_6} </td>
						
						<td> ${tempTimetable.subid_7} </td>
						<td> ${tempTimetable.time_7} </td>
						
						<td> ${tempTimetable.subid_8} </td>
						<td> ${tempTimetable.time_8} </td>
						
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

 
		


</body>


</html>