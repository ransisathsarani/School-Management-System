<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id= request.getParameter("id");
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

<%
try{
con = DriverManager.getConnection(connectionUrl+database, userid, password);
st=con.createStatement();
String sql ="select * from Enroll where id="+id;
r = st.executeQuery(sql);
while(r.next()){
%>

<h1>Update data from database</h1>
<form method="post" action="UpdateEnrollProcess.jsp">


  

                <table align="center">
                
                
                <tr>
              <td>  <input type="hidden" name="id" value="<%=r.getString("id") %>"></td>
				<td><input type="text" name="id" value="<%=r.getString("id") %>"></td>
</tr>
                	<tr>
                        <td>Registration Number :</td>
                        <td><input type="text" id="textArea1" name="regNo"  cols="45" rows="2" value="<%=r.getString("regNo") %>"></textarea></td>
                    </tr>
                    <tr>
                        <td>First name :</td>
                        <td><input type="text" id="textArea2" name="first_name"  cols="45" rows="2"value="<%=r.getString("first_name") %>"></textarea></td>
                    </tr>
                    <tr>
                        <td>Last name :</td>
                        <td><input type="text" id="textArea3" name="last_name" cols="45" rows="2" value="<%=r.getString("last_name") %>"></textarea></td>
                    </tr>
                    <tr>
                        <td>Address Line1:</td>
                        <td><input type="text"  id="textArea4" name="address1" cols="45" rows="2" value="<%=r.getString("address1") %>"></textarea></td>
                    </tr>
                    <tr>
                        <td>Address Line2:</td>
                        <td><input type="text"  id="textArea5" name="address2" cols="45" rows="2" value="<%=r.getString("address2") %>"></textarea></td>
                    </tr>
                    <tr>
                        <td>City:</td>
                     	<td><input type="text"  id="textArea6" name="city" cols="45" rows="2" value="<%=r.getString("city") %>"></textarea></td>
                    </tr>
                    <tr>
                        <td>Birth Date:</td>
                        <td><input id="date1" type="date" name="dob" value="<%=r.getString("dob") %>" style="width:333.5px; height:30px"/></td>

                    </tr>
                    <tr>
                        <td>Gender :</td>
                        <td><select name="gender" style="width: 335px; height: 30px">
                        	 <option value=""  value="<%=r.getString("gender") %>"></option>
                            <option value="male"  value="<%=r.getString("gender") %>">Male</option>
                            <option value="female"  value="<%=r.getString("gender") %>">Female</option>
                        </select></td>

                    </tr>
                    <tr>
                        <td>Ethnicity :</td>

                        <td><select name="ethnicity" style="width: 333.5px; height: 30px">
                        	 <option value=""  value="<%=r.getString("ethnicity") %>"></option>
                            <option value="sinhalese" value="<%=r.getString("ethnicity") %>"> Sinhalese</option>
                            <option value="tamils" value="<%=r.getString("ethnicity") %>">Tamils</option>
                            <option value="malays"  value="<%=r.getString("ethnicity") %>">Malays</option>
                            <option value="burghers" value="<%=r.getString("ethnicity") %>"> Burghers</option>
                            <option value="other" value="<%=r.getString("ethnicity") %>"> Other Groups</option>

                        </select></td>

                    </tr>
                    <tr>
                        <td>Parent/Guardian Name:</td>
                        <td><textarea id="textArea7" name="pName" cols="45" rows="2" value="<%=r.getString("pName") %>"></textarea></td>
                    </tr>
                    <tr>
                        <td>Contact Number</td>
                        <td><input id="pno" type="tel" name="phone" value="<%=r.getString("phone") %>" style="width:333.5px; height:30px"/></td>
                    </tr>
                    <tr>
                        <td>Email Address:</td>

                        <td><input type="text"  id="textArea8" name="email" cols="45" rows="2" value="<%=r.getString("email") %>"></textarea></td>
                    </tr>
                    <tr>
                        <td>Grade:</td>
                        <td><select name="grade" style="width: 333.5px; height:30px">
							 <option value=""  value="<%=r.getString("grade") %>"></option>
                            <option value="6"  value="<%=r.getString("grade") %>">6</option>
                            <option value="7"  value="<%=r.getString("grade") %>">7</option>
                            <option value="8"  value="<%=r.getString("grade") %>">8</option>
                            <option value="9"  value="<%=r.getString("grade") %>">9</option>
                            <option value="10"  value="<%=r.getString("grade") %>">10</option>
                            <option value="11"  value="<%=r.getString("grade") %>">11</option>
                            <option value="12"  value="<%=r.getString("grade") %>">12</option>
                            <option value="13"  value="<%=r.getString("grade") %>">13</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td>Semester:</td>
                        <td><select name="semester" style="width: 334px;height: 30px">
                        	 <option value=""  value="<%=r.getString("semester") %>"></option>
                            <option value="1"  value="<%=r.getString("semester") %>">1</option>
                            <option value="2"  value="<%=r.getString("semester") %>">2</option>
                            <option value="3"  value="<%=r.getString("semester") %>">3</option>
                        </select></td>
                    </tr>
            		 <tr>

                        <td> <input type="reset" value="Reset"></td>

                        <td><input type="submit" value="Submit"></td>
                    </tr>

                </table>
            </form>
<%
}
con.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

</body>
</html>