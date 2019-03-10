<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html>

<head>
	<title>Monarch College Grading</title>
	<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
</head>



<body>
<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#274F75;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>
      <div style="color:#ffffff;align:center"><h1>Student List - Information System</h1></div>
      <span>www.MonarchCollege.lk <br />
      <br />
      +9411 2596334</span> </div>
      <div style="background-color:#ffff66">
    <ul>
      <li class="current"><a href="Home.html">Home</a></li>
      <li><a href="SchoolProfile.html">School Profile</a></li>
      <li><a href="UserLogin.jsp">Log in</a></li>
      <li><a href="ContactUs.html">Contact us</a></li>
    </ul>
    </div>
    </div>
    </div>
    <br><br><br><br>

	<div id="wrapper">
		<div id="header">
			
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<!-- new button: add Grading -->
		
		<input type="button" value="Add Grading"
			onclick="window.location.href='add-grading-form.jsp'; return false;"
			class="add-grading-button"
		/>
		
			<table style="background-color:#ffff66;width:600px;height:300px">
				<tr>
					<th>sID</th>
					<th>level</th>
					<th>examID</th>
					<th>sub1</th>
					<th>sub2</th>
					<th>sub3</th>
					<th>sub4</th>
					<th>sub5</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempGrading" items="${GRADING_LIST}">

					<!-- set up a link for each record -->
					<c:url var="tempLink" value="GradingControllerServlet" >
						<c:param name="command" value="LOAD" />
						<c:param name="gradingId" value="${tempGrading.id}" />
					</c:url>
					
					<!-- set up a link to delete a record -->
					<c:url var="deleteLink" value="GradingControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="gradingId" value="${tempGrading.id}" />					
					</c:url>
					 

					<tr>
						<td> ${tempGrading.SID} </td>
						<td> ${tempGrading.level} </td>
						<td> ${tempGrading.examID} </td>
						<td> ${tempGrading.sub1} </td>
						<td> ${tempGrading.sub2} </td>
						<td> ${tempGrading.sub3} </td>
						<td> ${tempGrading.sub4} </td>
						<td> ${tempGrading.sub5} </td>
						<td> 
						<a href="${tempLink}">Update</a>
						<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this record?'))return false">
							Delete</a> 
						</td>
					</tr>
				</c:forEach>
			
			</table>
		
		</div>
	</div>

</body>


</html>