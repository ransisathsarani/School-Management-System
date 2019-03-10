<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
    <div style="background-color:#ffff66;width:1300px;align:center">
<h1>Student Enroll List</h1>
<table border="1">
<tr>
<td>ID</td>
<td>First Name</td>
<td>Last Name</td>
<td>Address1</td>
<td>Address2</td>
<td>City</td>
<td>Date</td>
<td>Gender</td>
<td>Ethnicity</td>
<td>Parent Name</td>
<td>phone</td>
<td>Email</td>
<td>Grade</td>
<td>Semester</td>
<td>Action</td>
<td>Action</td>
</tr>
</div>
	
<%
	String id = request.getParameter("id");
	String driver = "com.mysql.jdbc.Driver";
	String ConnectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "database_oop";
	String userid = "root";
	String password = "root";
	
	try{
	Class.forName(driver);
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	Connection con = null;
	Statement st = null;
	ResultSet r = null;
	
	try{
		con = DriverManager.getConnection(ConnectionUrl+database,userid,password);
		st=con.createStatement();
		String sql = "select* from Enroll";
		r = st.executeQuery(sql);
		while(r.next()){
			%>
			<tr>
			<td><%=r.getString("regNo") %></td>
			<td><%=r.getString("first_Name") %></td>
			<td><%=r.getString("last_Name") %></td>
			<td><%=r.getString("address1") %></td>
			<td><%=r.getString("address2") %></td>
			<td><%=r.getString("city") %></td>
			<td><%=r.getString("dob") %></td>
			<td><%=r.getString("gender") %></td>
			<td><%=r.getString("ethnicity") %></td>
			<td><%=r.getString("pName") %></td>
			<td><%=r.getString("phone") %></td>
			<td><%=r.getString("email") %></td>
			<td><%=r.getString("grade") %></td>
			<td><%=r.getString("semester") %></td>
			<td><a href="UpdateStudentEnroll1.jsp?id=<%=r.getString("id")%>">update</a></td>
			<td><a href="DeleteStudentEnroll.jsp?id=<%=r.getString("id") %>">Delete</a></td>
			</tr>
			<% 
		}
		con.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	
%>

</table>
</body>
</html>