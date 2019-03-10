<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    
    
    <%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/database_oop";%>
<%!String user = "root";%>
<%!String psw = "root";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	<%
	String id = request.getParameter("id");
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
	
	if(regNo != null )
	{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try
		{
		
	
	
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(url,user,psw);
	String sql ="Update Enroll set id=?,regNo=?,first_Name=?,last_name=?,address1=?,address2=?,city=?,dob=?,gender=?,ethnicity=?,pName=?,phone=?,email=?,grade=?,semester=? where id = "+id;
	ps = con.prepareStatement(sql);
	ps.setString(1, id);
	ps.setString(2,regNo);
	ps.setString(3, first_name);
	ps.setString(4, last_name);
	ps.setString(5, address1);
	ps.setString(6, address2);
	ps.setString(7,city);
	ps.setString(8,dob);
	ps.setString(9,gender);
	ps.setString(10,ethnicity);
	ps.setString(11,pName);
	ps.setString(12,phone);
	ps.setString(13,email);
	ps.setString(14,grade);
	ps.setString(15,semester);
	int z = ps.executeUpdate();
	if(z > 0){
		System.out.println("Records updated Successfully!!!");
	}
	else{
		System.out.println("There is a problem in updating Record.");
	}
		}
		catch(SQLException sql)
		{
			request.setAttribute("error",sql);
			System.out.println(sql);
		}
	}
	
	
	%>
	

</body>
</html>