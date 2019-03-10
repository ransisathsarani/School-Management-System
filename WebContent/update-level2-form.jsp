<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Add Level2</title>
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
            <li class="current"><a href="Home.jsp">Home</a></li>
      <li><a href="add-student-form.jsp">Add Student</a></li>
      <li><a href="add-teacher-form.jsp">Add Teacher</a></li>
      <li><a href="add-timetable-form.jsp">Timetables</a></li>
      <li><a href="add-subject-form.jsp">Add Subject</a></li>
        </ul>
    </div>
    <div id="content" style=" color: white; background-color: #041633">
        <div style="background-color: #041633">
            <h3 style="color: gold">Level 2</h3>
           <p>Grade 10,Grade 11 are included in Level 2</p>
            

            <div class="section" style="background-color: #041633">
                <div id="aside1" style="background-color: orange">
                   <p>Six subjects are compulsory in this level and 3 are optional subjects</p>
            <p>Sinhala,Religion,Mathematics,Science,History,English are compulsory subjects</p>
		
		<form action="Level2ControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			
			<input type="hidden" name="level2Id" value="${THE_LEVEL2.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>student_reg_num:</label></td>
						<td><input type="text" name="student_reg_num" 
									value="${THE_LEVEL2.student_reg_num}"/></td>
					</tr>
					
					<tr>
						<td><label>option1:</label></td>
						<td><input type="text" name="option1" 
									value="${THE_LEVEL2.option1}"/></td>
					</tr>
					
					<tr>
						<td><label>option2:</label></td>
						<td><input type="text" name="option2" 
									value="${THE_LEVEL2.option2}"/></td>
					</tr>
					
					<tr>
						<td><label>option3:</label></td>
						<td><input type="text" name="option3" 
									value="${THE_LEVEL2.option3}"/></td>
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
			<a href="Level2ControllerServlet">Back to List</a>
		</p>
		 </div>


            </div>

            </div>
        </div>
    </div>

</body>
</html>