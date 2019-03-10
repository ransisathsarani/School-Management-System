<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Add Grading</title>
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
      <li class="current"><a href="Home.jsp">Home</a></li>
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
	
		
		<form action="GradingControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
	<center>
    <table style="background-color:#ffff66;width:600px;height:300px">
        <tr>
            <td align="center">Student ID :</td>
            <td align="center"><input type="text" size="5" name="SID"/> </td>
        </tr>
        <tr>
            <td align="center">Select Level :</td>
            
            <td>
                <select name="level">
                <option value="select">select</option>
                <option value="Level1">Level-1</option>
                <option value="Level2">Level-2</option>
                <option value="Level3">Level-3</option>

            </select>
            </td>
        </tr>
		<tr>
			<td align="center">Examination ID :</td>
			<td>
				<select name="examID">
                <option value="select">select</option>
                <option value="G6S1">G6S1</option>
               	<option value="G6S2">G6S2</option>
               	<option value="G6S3">G6S3</option>
               	<option value="G7S1">G7S1</option>
               	<option value="G7S2">G7S2</option>
                <option value="G7S3">G7S3</option>
                <option value="G8S1">G8S1</option>
                <option value="G8S2">G8S2</option>
                <option value="G8S3">G8S3</option>
                <option value="G9S1">G9S1</option>
                <option value="G9S2">G9S2</option>
                <option value="G9S3">G9S3</option>
                <option value="G10S1">G10S1</option>
                <option value="G10S2">G10S2</option>
                <option value="G10S3">G10S3</option>
                <option value="G11S1">G11S1</option>
                <option value="G11S2">G11S2</option>
                <option value="G11S3">G11S3</option>
                <option value="G12S1">G12S1</option>
                <option value="G12S2">G12S2</option>
                <option value="G12S3">G12S3</option>
                <option value="G13S1">G13S1</option>
                <option value="G13S2">G13S2</option>
                <option value="G13S3">G13S3</option>
              </select>  
			</td>
			
		</tr>
    </table><br>
    <table style="background-color:#ffff66;width:600px;height:300px">
        <tr>
            <th>Subject</th>
            <th>Obtained Marks</th>
            <th>Total Marks</th>
        </tr>
        <tr>
            <td align="center">Subject1</td>
            <td align="center"><input type="text" size="5" name="sub1"/></td>
            <td align="center">100</td>
        </tr>
        <tr>
            <td align="center">Subject2</td>
            <td align="center"><input type="text" size="5" name="sub2"/></td>
            <td align="center">100</td>
        </tr>
        <tr>
            <td align="center">Subject3</td>
            <td align="center"><input type="text" size="5" name="sub3"/></td>
            <td align="center">100</td>
        </tr>
        <tr>
            <td align="center">Subject4</td>
            <td align="center"><input type="text" size="5" name="sub4"/></td>
            <td align="center">100</td>
        </tr>
        <tr>
            <td align="center">Subject5</td>
            <td align="center"><input type="text" size="5" name="sub5"/></td>
            <td align="center">100</td>
        </tr>
       
        
        
        
        <tr>
            <td></td>
        </tr>
        <tr>
            <td></td>
        </tr>
        <tr><td></td><td align="center"><input type="submit" value="submit"/></td></tr>
       
    </table>
    
    </center>
</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="GradingControllerServlet">Back to List</a>
		</p>
		
	</div>


</body>
</html>