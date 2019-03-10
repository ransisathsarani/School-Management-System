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
            <li class="current"><a href="Home.html">Home</a></li>
      
      <li><a href="SchoolProfile.html">School Profile</a></li>
      <li><a href="UserLogin.jsp">Log in</a></li>
      <li><a href="ContactUs.html">Contact us</a></li>
        </ul>
    </div>
    <div id="content" style=" color: white; background-color: #041633">
        <div style="background-color: #041633">
            <h3 style="color: gold">Level 3</h3>
            <p>Grade 12 and Grade 13 are included in the Level 3</p>
            <p>There are Three Streams,BioScience,Physical Science and Commerce</p>

            <div class="section" style="background-color: #041633">
                <div id="aside1" style="background-color: orange">
                    <h5>This is the subject selection page of Physical Science Stream</h5>
                    <p>Mathematics and Physics are compulsory subjects and students can either select IT or Chemistry</p>

		
		<form action="Level3StudentControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>student_reg_num:</label></td>
						<td><input type="text" name="student_reg_num" /></td>
					</tr>
					
					<tr>
						<td><label>stream:</label></td>
						<td><input type="text" name="stream" /></td>
					</tr>
					
					<tr style="background-color: gold">
                                    <td style="color: white">subject1 :</td>
                                    <td><input list="subject1" name="subject1">
                                        <datalist id="subject1" >
                                            <option value="Mathematics,">
                                        </datalist>
                                    </td>
                     </tr>
					
					 <tr style="background-color: gold">
                                    <td style="color: white">subject2 :</td>
                                    <td><input list="subject2" name="subject2">
                                        <datalist id="subject2" >
                                            <option value="Chemistry">
                                            <option value="IT">
                                        </datalist>
                                    </td>
                    </tr>
					
					<tr style="background-color: gold">
                                    <td style="color: white">subject3 :</td>
                                    <td><input list="subject3" name="subject3">
                                        <datalist id="subject3" >
                                            <option value="Physics">
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
			<a href="Level3StudentControllerServlet">Back to List</a>
		</p>
		
	</div>

    </div>

   </div>
    </div>
    </div>
    
</body>
</html>