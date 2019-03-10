<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Monarch College</title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" type="text/css" href="style.css" />
    <!--[if IE 6]><link rel="stylesheet" type="text/css" href="ie6.css" /><![endif]-->
</head>
<body style="color: white">
<div id="page" style="background:url(images/cover_image.jpg) no-repeat center 180px;">
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
      <li><a href="Account_transaction.jsp">Accounting</a></li>
     <li><a href="ActivitiesControllerServlet">Extra Curricular Act</a></li>
        </ul>
    </div>
    <div id="content" style="margin-top: 300px;">
        <div id="home">
            <div>
                <div id="aside">
                    <center>
                    <div>
                        <h1 style="margin-left: 300px">Extra Curricular activities Form</h1>
                        
                        <form class="form-inline" method="post" action="searchActivities.jsp">
	<input id="student_reg_num" type="text" name="student_reg_num" />
	<button type="submit" name="save" class="btn btn-primary">Search</button>
	</form>
		
			<table>
				<tr>
					<th>student_reg_num</th>
					<th>sports</th>
					<th>clubs</th>
					<th>organizations</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempActivities" items="${ACTIVITIES_LIST}">

					<!-- set up a link for each record -->
					<c:url var="tempLink" value="ActivitiesControllerServlet" >
						<c:param name="command" value="LOAD" />
						<c:param name="activitiesId" value="${tempActivities.id}" />
					</c:url>
					
					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="ActivitiesControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="activitiesId" value="${tempActivities.id}" />					
					</c:url>

					<tr>
						<td> ${tempActivities.student_reg_num} </td>
						<td> ${tempActivities.sports} </td>
						<td> ${tempActivities.clubs} </td>
						<td> ${tempActivities.organizations} </td>
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
                    </center>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>