<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	 <title>Monarch College | Level2</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
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
      <li><a href="ContactUs.html">Contact us</a></li>
        </ul>
    </div>
    <div id="content" style=" color: white; background-color: #041633">
        <div style="background-color: #041633">
            <h3 style="color: gold">Level 2</h3>
            <p>Grade 10,Grade 11 are included in Level 2</p>
            <p>Six subjects are compulsory in this level and 3 are optional subjects</p>
            <p>Sinhala,Religion,Mathematics,Science,History,English are compulsory subjects</p>

            <div class="section" style="background-color: #041633">
                <div id="aside1" style="background-color: orange">
                   
                    <p>Students can change the optional subjects during first month of selecting subjects by informing it by a written representation to the Sectional Head </p>

		
		<form action="Level2StudentControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>student_reg_num:</label></td>
						<td><input type="text" name="student_reg_num" /></td>
					</tr>
					
					<tr style="background-color: gold">
                                    <td style="color: white">option1 :</td>
                                    <td><input list="option1" name="option1">
                                        <datalist id="option1" >
                                            <option value="Commerce">
                                            <option value="Geography">
                                            <option value="Civics">
                                            <option value="Tamil">
                                            <option value="Japanese">
                                            <option value="Hindi">
                                        </datalist>
                                    </td>
                     </tr>
					
					 <tr style="background-color: gold">
                                    <td style="color: white">option2 :</td>
                                    <td><input list="option2" name="option2">
                                        <datalist id="option2" >
                                            <option value="English Literature">
                                            <option value="Sinhala Literature">
                                            <option value="Western Music">
                                            <option value="Eastern Music">
                                            <option value="Dancing">
                                            <option value="Drama">
                                        </datalist>
                                    </td>
                    </tr>
					
					<tr style="background-color: gold">
                                    <td style="color: white">option3 :</td>
                                    <td><input list="option3" name="option3">
                                        <datalist id="option3" >
                                            <option value="Health Science">
                                            <option value="Information Technology">
                                            <option value="Home Science">
                                            <option value="Agriculture">
                                            <option value="Media Studies">
                                            <option value="Design Technology">
                                        </datalist>
                                    </td>
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
			<a href="Level2StudentControllerServlet">Back to List</a>
		</p>
		
	</div>

    </div>

   </div>
    </div>
    </div>
    

</body>
</html>