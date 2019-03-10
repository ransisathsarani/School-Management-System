<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in Here - Monarch College</title>
</head>
<body>
<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#274F75;width:100%">
      <div><a href="#"><img src="images/logo (3).png" alt="" /></a></div>
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
    <form name="login" action="<%=request.getContextPath()%>
/loginServlet" method="post">
    <div align="center">
    <table style="background-color:#ffff66;width:600px;height:300px" >
    
    <tr>
    <td>Username: </td>
    <td><input type="text" name="email"></td>
    </tr> 
    
    <tr>
    <td>Password: </td>
    <td><input type="password" name="pw"></td>
    </tr>
    
    <tr>
    <td><span><%=(request.getAttribute("errMessage") == null)? "": request.getAttribute("errMessage") %></span></td>
    
    </tr>
    <tr>
    
    <td><input type="submit"  value="login" > <input type="reset" value="reset"></td>
    </tr>
    </table>
    </div>
    </form>
    
    

</body>
</html>