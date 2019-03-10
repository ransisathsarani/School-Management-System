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
	String id = request.getParameter("id");
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_oop","root","root");
	Statement st = con.createStatement();

	
		int z = st.executeUpdate("DELETE FROM Enroll where id ="+id);
		System.out.println("Deleted Successfully!!!");
	}
	catch(Exception e)
	{
		System.out.print(e);
		e.printStackTrace();
		}
		%>
		
		
	
	
	
	

</body>
</html>