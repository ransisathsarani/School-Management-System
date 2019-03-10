<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html>

<head>
	<title>Monarch College Level2</title>
	 <link rel="stylesheet" type="text/css" href="style.css" />
    <!--[if IE 6]><link rel="stylesheet" type="text/css" href="styles/ie6.css" /><![endif]-->
</head>



<body>

<div id="page">
    <div id="header">
        <div id="section">
            <div><a href="index.html"><img src="images/logo%20(3).png" alt="" /></a></div>
            <span>monarchCollege@google.com <br />
      <br />
      +11 22 34537 000</span> </div>
        <ul>
      <li class="current"><a href="SIMS_interface.jsp">Home</a></li>
      <li><a href="add-student-form.jsp">Add Student</a></li>
      <li><a href="add-teacher-form.jsp">Add Teacher</a></li>
      <li><a href="add-timetable-form.jsp">Timetables</a></li>
      <li><a href="add-subject-form.jsp">Add Subject</a></li>
      <li><a href="admissionsAdmin.jsp">Level functions</a></li>
        </ul>
    </div>
    <div id="content" style=" color: white; background-color: #041633">
        <div style="background-color: #041633">
            <h3 style="color: gold">Level 2</h3>
            <p>Grade 10,Grade 11 are included in Level 2</p>
            <div class="section" style="background-color: #041633">
                <div id="aside1" style="background-color: orange">
                    <h5>List the Student who registered for level 2</h5>
                    <p>Six subjects are compulsory in this level and 3 are optional subjects</p>
            <p>Sinhala,Religion,Mathematics,Science,History,English are compulsory subjects</p>


		
	<form class="form-inline" method="post" action="searchLevel2.jsp">
	<input id="student_reg_num" type="text" name="student_reg_num" />
	<button type="submit" name="save" class="btn btn-primary">Search</button>
	</form>
		
			<table>
				<tr>
					<th>student_reg_num</th>
					<th>option1</th>
					<th>option2</th>
					<th>option3</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempLevel2" items="${LEVEL2_LIST}">

					<!-- set up a link for each record -->
					<c:url var="tempLink" value="Level2ControllerServlet" >
						<c:param name="command" value="LOAD" />
						<c:param name="level2Id" value="${tempLevel2.id}" />
					</c:url>
					
					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="Level2ControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="level2Id" value="${tempLevel2.id}" />					
					</c:url>

					<tr>
						<td> ${tempLevel2.student_reg_num} </td>
						<td> ${tempLevel2.option1} </td>
						<td> ${tempLevel2.option2} </td>
						<td> ${tempLevel2.option3} </td>
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
		
		</div>
		  


</body>


</html>