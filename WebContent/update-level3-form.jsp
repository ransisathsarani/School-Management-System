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
            <h3 style="color: gold">Level 3</h3>
          <p>Grade 12 and Grade 13 are included in the Level 3</p>
            <p>There are Three Streams,BioScience,Physical Science and Commerce</p>
            <div class="section" style="background-color: #041633">
                <div id="aside1" style="background-color: orange">
                    <p>Biology and Chemistry are compulsory subjects and students can either select Physics or Agriculture</p>
             <p>There are three subjects, Business Studies,Accounting and Economics and all are compulsory/p>
            <p>Mathematics and Physics are compulsory subjects and students can either select IT or Chemistry</p>

		
		<form action="Level3ControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			
			<input type="hidden" name="level3Id" value="${THE_LEVEL3.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>student_reg_num:</label></td>
						<td><input type="text" name="student_reg_num" 
									value="${THE_LEVEL3.student_reg_num}"/></td>
					</tr>
					
					<tr>
						<td><label>stream:</label></td>
						<td><input type="text" name="stream" 
									value="${THE_LEVEL3.stream}"/></td>
					</tr>
					
					<tr>
						<td><label>subject1:</label></td>
						<td><input type="text" name="subject1" 
									value="${THE_LEVEL3.subject1}"/></td>
					</tr>
					
					<tr>
						<td><label>subject2:</label></td>
						<td><input type="text" name="subject2" 
									value="${THE_LEVEL3.subject2}"/></td>
					</tr>
					
					<tr>
						<td><label>subject3:</label></td>
						<td><input type="text" name="subject3" 
									value="${THE_LEVEL3.subject3}"/></td>
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
			<a href="Level3ControllerServlet">Back to List</a>
		</p>
		 </div>


            </div>

            </div>
        </div>
    </div>

</body>
</html>