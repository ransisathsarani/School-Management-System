<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students Marks</title>
<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->
</head>
<body>

<%


String sID = request.getParameter("sID");
String level = request.getParameter("level");
String examID = request.getParameter("examID");
String sub1 = request.getParameter("sub1");
String sub2 = request.getParameter("sub2");
String sub3 = request.getParameter("sub3");
String sub4 = request.getParameter("sub4");
String sub5 = request.getParameter("sub5");
try{
	
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_oop","root","root");
	Statement st = con.createStatement();
	
	
	int z = st.executeUpdate("INSERT INTO grading(sID, level, examID, sub1, sub2, sub3, sub4, sub5) VALUES('"+sID+"','"+level+"','"+examID+"','"+sub1+"','"+sub2+"','"+sub3+"','"+sub4+"','"+sub5+"')");
	
	System.out.println("Added Successfully");
}catch(Exception e){
	System.out.println(e);
	e.printStackTrace();
}
if(!(sub1 == null || sub1.isEmpty()))
{
    int sub1Marks = Integer.parseInt(sub1);
    int sub2Marks = Integer.parseInt(sub2);
    int sub3Marks = Integer.parseInt(sub3);
    int sub4Marks = Integer.parseInt(sub4);
    int sub5Marks = Integer.parseInt(sub5);

    int total = sub1Marks+sub2Marks+sub3Marks+sub4Marks+sub5Marks;
    int avg = (total)/5;
    int percent = avg;
    String grade ="";

    if(percent < 40){
        grade = "E";
        //request.setAttribute("grade", grade);
    }
    else if(percent >= 40 && percent <=44){
        grade = "D";
    }
    else if(percent >=45 && percent <=49){
        grade = "D+";
    }
    else if(percent >=50 && percent <=54){
        grade = "C-";
    }
    else if(percent >=55 && percent<=59){
        grade = "C";
    }
    else if(percent >=60 && percent <=64){
        grade = "C+";
    }
    else if(percent >=65 && percent<=69){
        grade = "B-";
    }
    else if(percent >=70 && percent <=74){
        grade = "B";
    }
    else if(percent >=75 && percent <=79){
        grade = "B+";
    }
    else if(percent >=80 && percent <=84){
        grade = "A";
    }
    else if (percent >=85 && percent <=100){
        grade = "A+";
    }
    request.setAttribute("Grade", grade);
    %>    
    <table style="background-color:#ffff66;width:600px;height:300px">
    <tr>
    <td><b>Level</b></td><td></td>
    <td align="center"><%=request.getParameter("level") %>
    </tr>
    <tr>
    <td><b>Aggregate Marks</b></td><td></td>
    <td align="center"><%=total %></td>
    </tr>
    <tr>
    <td><b>Grade</b></td><td></td>
    <td align="center"><%=grade %></td>    
    </tr>
    </table>
    <%    
}
%>

</body>
</html>