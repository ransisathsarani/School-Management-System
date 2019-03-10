<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
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
<%
try{
con = DriverManager.getConnection(connectionUrl+database, userid, password);
st=con.createStatement();
String sql ="select * from grading where id="+id;
r = st.executeQuery(sql);
while(r.next()){
%>
<!DOCTYPE html>
<html>
<body>
<h1>Update data from database</h1>
<form method="post" action="UpdateMarksProcess.jsp">
<input type="hidden" name="id" value="<%=r.getString("id") %>">
<input type="text" name="id" value="<%=r.getString("id") %>">
<br>

<form action="" method="post">
    <table>
        <tr>
            <td align="center">Student ID :</td>
            <td align="center"><input type="text" size="5" name="sID"  value="<%=r.getString("sID") %>"/> </td>
        </tr>
        <tr>
            <td align="center">Select Level :</td>
            
            <td>
                <select name="level" value="<%=r.getString("level") %>">
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
				<select name="examID"  value="<%=r.getString("examID") %>">
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
    <table>
        <tr>
            <th>Subject</th>
            <th>Obtained Marks</th>
            <th>Total Marks</th>
        </tr>
        <tr>
            <td align="center">Subject1</td>
            <td align="center"><input type="text" size="5" name="sub1"  value="<%=r.getString("sub1") %>"/></td>
            <td align="center">100</td>
        </tr>
        <tr>
            <td align="center">Subject2</td>
            <td align="center"><input type="text" size="5" name="sub2"  value="<%=r.getString("sub2") %>"/></td>
            <td align="center">100</td>
        </tr>
        <tr>
            <td align="center">Subject3</td>
            <td align="center"><input type="text" size="5" name="sub3"  value="<%=r.getString("sub3") %>"/></td>
            <td align="center">100</td>
        </tr>
        <tr>
            <td align="center">Subject4</td>
            <td align="center"><input type="text" size="5" name="sub4"  value="<%=r.getString("sub4") %>"/></td>
            <td align="center">100</td>
        </tr>
        <tr>
            <td align="center">Subject5</td>
            <td align="center"><input type="text" size="5" name="sub5"  value="<%=r.getString("sub5") %>"/></td>
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
</form>



<br><br>
<input type="submit" value="submit">
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