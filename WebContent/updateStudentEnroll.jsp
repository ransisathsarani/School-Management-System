<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>



<%
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "database_oop";
String userid = "root";
String password = "root";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection con = null;
Statement st = null;
ResultSet r = null;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Retrieve data from database</h1>
<table border="1">
<tr>
<td>Registration No</td>
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
</tr>


<%
try{
con = DriverManager.getConnection(connectionUrl+database, userid, password);
st=con.createStatement();
String sql ="select * from Enroll";
r = st.executeQuery(sql);
int i=0;
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
			 

<td><a href="delete.jsp?id=<%=r.getString("id") %>">
<button type="button" class="delete">Delete</button></a></td>
<td><a href="update.jsp?id=<%=r.getString("id")%>">update</a></td>
</tr>
<%
i++;
}
con.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

</table>
</body>
</html>