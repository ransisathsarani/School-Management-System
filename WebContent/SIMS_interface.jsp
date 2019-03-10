<!DOCTYPE html>
<html>
<head>
<title>Home - Monarch College </title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
</head>
<body>
<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#274F75;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>
      <span>www.MonarchCollege.lk <br />
      <span>welcome <%=request.getAttribute("username") %>
		<a href="<%=request.getContextPath() %>/logoutServlet">Logout</a></span>
      <br />
      +9411 2596334</span> </div>
      <div style="background-color:#ffff66">
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
    </div>
    
</div>
</body>
</html>