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
            <h3 style="color: gold">Level 2</h3>
            <p>Grade 10,Grade 11 are included in Level 2</p>
            
            <div class="section" style="background-color: #041633">
                <div id="aside1" style="background-color: orange">
                   <p>Six subjects are compulsory in this level and 3 are optional subjects</p>
            <p>Sinhala,Religion,Mathematics,Science,History,English are compulsory subjects</p>
            
            <form class="form-inline" method="post" action="searchLevel2.jsp">
	<input id="student_reg_num" type="text" name="student_reg_num" />
	<button type="submit" name="save" class="btn btn-primary">Search</button>
	</form>


		
		<!-- new button: add level2- -->
		
		<input type="button" value="Add Level2"
			onclick="window.location.href='add-level2-form.jsp'; return false;"
			class="add-level2-button"
		/>
		
			<table>
				<tr>
					<th>student_reg_num</th>
					<th>option1</th>
					<th>option2</th>
					<th>option3</th>
				</tr>
				
				<c:forEach var="tempLevel2" items="${LEVEL2_LIST}">

					<tr>
						<td> ${tempLevel2.student_reg_num} </td>
						<td> ${tempLevel2.option1} </td>
						<td> ${tempLevel2.option2} </td>
						<td> ${tempLevel2.option3} </td>
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