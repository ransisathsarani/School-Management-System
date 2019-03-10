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
            <li class="current"><a href="Home.jsp">Home</a></li>
      <li><a href="SchoolProfile.html">School Profile</a></li>
      <li><a href="UserLogin.jsp">Log in</a></li>
      <li><a href="RegisterNow.jsp">Join us</a></li>
      <li><a href="ContactUs.html">Contact us</a></li>
        </ul>
    </div>
    <div id="content" style=" color: white; background-color: #041633">
        <div style="background-color: #041633">
            <h3 style="color: gold">Level 3</h3>
           
            <div class="section" style="background-color: #041633">
                <div id="aside1" style="background-color: orange">
                    <p>List the Students who registed for level 3</p>
                    
                     <form class="form-inline" method="post" action="searchLevel3.jsp">
	<input id="student_reg_num" type="text" name="student_reg_num" />
	<button type="submit" name="save" class="btn btn-primary">Search</button>
	</form>
	


		
		
			<table>
				<tr>
					<th>student_reg_num</th>
					<th>stream</th>
					<th>subject1</th>
					<th>subject2</th>
					<th>subject3</th>
				</tr>
				
				<c:forEach var="tempLevel3" items="${LEVEL3_LIST}">

					<tr>
						<td> ${tempLevel3.student_reg_num} </td>
						<td> ${tempLevel3.stream} </td>
						<td> ${tempLevel3.subject1} </td>
						<td> ${tempLevel3.subject2} </td>
						<td> ${tempLevel3.subject3} </td>
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