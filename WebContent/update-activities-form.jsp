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
		
		<form action="ActivitiesControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			
			<input type="hidden" name="activitiesId" value="${THE_ACTIVITIES.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>student_reg_num:</label></td>
						<td><input type="text" name="student_reg_num" 
									value="${THE_ACTIVITIES.student_reg_num}"/></td>
					</tr>
					
					<tr>
						<td><label>sports:</label></td>
						<td><input type="text" name="sports" 
									value="${THE_ACTIVITIES.sports}"/></td>
					</tr>
					
					<tr>
						<td><label>clubs:</label></td>
						<td><input type="text" name="clubs" 
									value="${THE_ACTIVITIES.clubs}"/></td>
					</tr>
					
					<tr>
						<td><label>organizations:</label></td>
						<td><input type="text" name="organizations" 
									value="${THE_ACTIVITIES.organizations}"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
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