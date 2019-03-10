<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html>

<head>
	<title>Monarch College List Subject</title>
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
      
<a href="<%=request.getContextPath() %>/logoutServlet">Logout</a></span>
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
   <div align="center">
		
		<input type="button" value="Add Subject"
			onclick="window.location.href='add-subject-form.jsp'; return false;"
			class="add-subject-button"/>
		
			<div style="background-color:#ffff66;width:1000px;align:center">
			<table align="center" cellpadding="5" cellspacing="5" border="1">
				<tr>
					<th>subjectNum</th>
					<th>name</th>
					<th>content</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempSubject" items="${SUBJECT_LIST}">

					<!-- set up a link for each record -->
					<c:url var="tempLink" value="SubjectControllerServlet" >
						<c:param name="command" value="LOAD" />
						<c:param name="subjectId" value="${tempSubject.id}" />
					</c:url>
					
					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="SubjectControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="subjectId" value="${tempSubject.id}" />					
					</c:url>

					<tr>
						<td> ${tempSubject.subjectNum} </td>
						<td> ${tempSubject.name} </td>
						<td> ${tempSubject.content} </td>
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
		  
    </div>


</body>


</html>