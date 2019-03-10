<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String regNo = request.getParameter("regNo");
	String first_name = request.getParameter("first_name");
	String last_name = request.getParameter("last_name");
	String address1 = request.getParameter("address1");
	String address2 = request.getParameter("address2");
	String city = request.getParameter("city");
	String dob = request.getParameter("dob");
	String gender = request.getParameter("gender");
	String ethnicity = request.getParameter("ethnicity");
	String pName = request.getParameter("pName");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String grade = request.getParameter("grade");
	String semester = request.getParameter("semester");
	
	try{
		
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_oop","root","root");
	Statement st = con.createStatement();
	
	int z = st.executeUpdate("INSERT INTO Enroll(regNo,first_Name,last_name,address1,address2,city,dob,gender,ethnicity,pName,phone,email,grade,semester) VALUES('"+regNo+"','"+first_name+"','"+last_name+"','"+address1+"','"+address2+"','"+city+"','"+dob+"','"+gender+"','"+ethnicity+"','"+pName+"','"+phone+"','"+email+"','"+grade+"','"+semester+"')");
	System.out.println("Student added successfully");
	
	}catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
	}
	
	
	
%>

</body>
</html>