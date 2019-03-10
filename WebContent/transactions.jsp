<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ page import = "java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>transaction recording</title>
</head>
<body>


<%

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_oop","root","root");  

Statement 	state = con.createStatement();

ResultSet result=null;

String description = request.getParameter("description");
String type = request.getParameter("type");
String amount = request.getParameter("amount"); 





try
{
	Class.forName("com.mysql.jdbc.Driver");
		
	
	int x = state.executeUpdate("INSERT INTO Account_Monarch( description ,type ,amount ) VALUES('"+description+"','"+type+"','"+amount+"') ");  
	
	System.out.println("recorded successfully");
}
catch(Exception e)
{
	System.out.print("e");
	e.printStackTrace();
}

%>


</body>
</html>