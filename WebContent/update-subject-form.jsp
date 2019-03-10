<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Add Level2</title>
<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->

</head>
<body>
	<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#274F75;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>
      <div style="color:#ffffff;align:center"><h1>Add Teacher - Information System</h1></div>
      <span>www.MonarchCollege.lk <br />
       <span>welcome <%=request.getAttribute("username") %>
<a href="<%=request.getContextPath() %>/logoutServlet">Logout</a></span>
      <br />
      +9411 2596334</span> </div>
      <div style="background-color:#ffff66">
    <ul>
      <li class="current"><a href="Home.html">Home</a></li>
      <li><a href="add-student-form.jsp">Add Student</a></li>
      <li><a href="add-teacher-form.jsp">Add Teacher</a></li>
      <li><a href="add-timetable-form.jsp">Timetables</a></li>
      <li><a href="add-subject-form.jsp">Add Subject</a></li>
    </ul>
    </div>
    </div>
    </div>
    <br><br><br><br>
   <div align="center">
		
		<form action="SubjectControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			
			<input type="hidden" name="subjectId" value="${THE_SUBJECT.id}" />
			
			<table style="background-color:#ffff66;width:600px;height:300px">
				<tbody>
					<tr>
						<td><label>subjectNum:</label></td>
						<td><input type="text" name="subjectNum" 
									value="${THE_SUBJECT.subjectNum}"/></td>
					</tr>
					
					<tr>
						<td><label>name:</label></td>
						<td><input type="text" name="name" 
									value="${THE_SUBJECT.name}"/></td>
					</tr>
					
					<tr>
						<td><label>content:</label></td>
						<td><input type="text" name="content" 
									value="${THE_SUBJECT.content}"/></td>
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
			<a href="SubjectControllerServlet">Back to List</a>
		</p>
		 </div>


            </div>

            </div>
        </div>
    </div>

</body>
</html>