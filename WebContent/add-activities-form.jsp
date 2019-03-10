<!DOCTYPE html>
<html>
<head>
    <title>Monarch College</title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" type="text/css" href="style.css" />
    <!--[if IE 6]><link rel="stylesheet" type="text/css" href="ie6.css" /><![endif]-->
</head>
<body style="color: white">
<div id="page" style="background:url(images/cover_image.jpg) no-repeat center 180px;">
    <div id="header">
        <div id="section">
            <div><a href="index.html"><img src="images/logo%20(3).png" alt="" /></a></div>
            <span>monarchCollege@google.com <br />
      <br />
      +11 22 34537 000</span> </div>
        <ul>
            <li class="current"><a href="index.html">Home</a></li>
            <li><a href="about.html">School Profile</a></li>
            <li><a href="admissions.html">Admissions</a></li>
            <li><a href="training-courses.html">Prospective Students</a></li>
            <li><a href="blog.html">Staff</a></li>
            <li><a href="school-calendar.html">Students</a></li>
            <li><a href="contact-us.html">Join Us</a></li>
        </ul>
    </div>
    <div id="content" style="margin-top: 300px;">
        <div id="home">
            <div>
                <div id="aside">
                    <center>
                    <div>
                        <h1 style="margin-left: 300px">Extra Curricular activities Form</h1>
                        		
		<form action="ActivitiesStudentControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>student_reg_num:</label></td>
						<td><input type="text" name="student_reg_num" /></td>
					</tr>
					
					<tr>
                                    <td style="color: white">sports :</td>
                                    <td><input list="sports" name="sports">
                                        <datalist id="sports" >
                                            <option value="Football">
                                            <option value="Rugby">
                                            <option value="Netball">
                                            <option value="Hockey">
                                            <option value="Swimming">
                                            <option value="Athletics">
                                        </datalist>
                                    </td>
                     </tr>
					
					 <tr>
                                    <td style="color: white">clubs :</td>
                                    <td><input list="clubs" name="clubs">
                                        <datalist id="clubs" >
                                            <option value="Gavel">
                                            <option value="IT">
                                            <option value="ArtAndMusic">
                                            <option value="Rotaract">
                                            <option value="Media">
                                            <option value="Drama">
                                        </datalist>
                                    </td>
                    </tr>
					
					<tr>
                                    <td style="color: white">organizations :</td>
                                    <td><input list="organizations" name="organizations">
                                        <datalist id="organizations" >
                                            <option value="Scouts">
                                            <option value="RedCross">
                                            <option value="St.Johns">
                                            <option value="Cadet">
                                            <option value="WorldLink">
                                            <option value="FirstAid">
                                        </datalist>
                                    </td>
                                    </tr>
                                    <tr>
                                    	<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					</tbody>
					</table>
					</form>
					</div></center></div></div></div></div></div></body></html>