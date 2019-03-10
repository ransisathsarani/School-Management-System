<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Profile</title>

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
                <li class="current"><a href="Home.html">Home</a></li>
                
                <li><a href="SchoolProfile.html">School Profile</a></li>
                <li><a href="admissions.jsp">Register for levels</a></li>
                
                <li><a href="#">Join us</a></li>
                <li><a href="#">Contact us</a></li>
            </ul>
        </div>  <div id="content">

        <div style="background-color: #ffff66">
            <h3><p align="center" style="color: black"><b>MONARCH COLLEGE - Student Profile</b><p></h3>
            <br>
            <br>
            <h3><b>Student Affairs Devision</b></h3>
            <br>
            <br>
            <br>

            <img src="images/pic4.jpg"width ="600px" height ="400px">


            <a href ="Docume/FAQ.docx">FAQ</a><br> <br>
            <a href="Dresscode.jsp">Dress Code for MONARCH College Students</a><br> <br>
            <a href="Marks2.jsp">Results</a> <br> <br>
            <a href="OnlinePortal.jsp">Online Portal</a><br><br>
            <a href ="Docume/Mid exam Time table_2018 - semester 1.pdf">Exam Time Tables</a> <br> <br>
            <a href ="level2_home.jsp">Subject Registration</a> <br> <br>
            <a href ="viewTimetables.jsp">Semester Time Tables</a> <br> <br>
            <a href ="Docume/2018Sem1_ExmHalls.xlsx">Examination Hall Arrangements</a> <br> <br>
            <a href ="Docume/Rule Book.pdf">Student Rule Book 2018</a> <br> <br>
            <a href="ActivitiesStudentControllerServlet">Register for Extra Curricular</a><br><br>
           






        </div>
    </div>

    </div>
   
</div>
</div>

</body>
</html>