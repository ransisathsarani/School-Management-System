<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import=" java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration2</title>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style_1.css" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" href="style_2.css" /><![endif]-->

<!--  
    <script type="text/javascript">
        function formValidate() {
            var firstname = document.forms["Reg"]["first_name"].value;
            var email = document.forms["Reg"]["email"].value;

            if (isAlphabetic(firstname))
                if(emailValidation(email))
                        return false;
                    else
                       return false;


        }

        function isEmpty(elemValue, field) {
            if (elemValue == "" || elemValue == null) {
                alert("You can't have "  +  field  +  " filled empty");
                return true;
            }
            else
                return false;
        }

        function isAlphabetic(elemValue) {
            var exp = /^[a-zA-Z]+$/;
            if (!isEmpty(elemValue, "firstname")) {
                if (elemValue.match(exp))
                {
                    return true;
                }
                else {
                    alert("Enter only text for your  name");
                    return false;
                }
            }
            return false;

        }



        function emailValidation(elemValue) {
            if (!isEmpty(elemValue, "email")) {
                var atops = elemValue.indexOf("@");
                var dotops = elemValue.indexOf(".");

                if (atops < 1 || dotops + 2 >= elemValue.length || atops + 2 > dotops) {
                    alert("Enter a valid email address ");
                    return false;
                }
                else
                    return true;
            }
            else
                return false;
        }

    </script>
    -->


</head>
<body>

	<div id="page">
		<div id="header">
			<div id="section" style="background-color: #274F75; width: 100%">
				<div>
					<a href="index.html"><img src="images/logo (3).png" alt="" /></a>
				</div>
				<span>www.MonarchCollege.lk <br /> <br /> +9411 2596334
				</span>
			</div>
			
			<div style="background-color: #ffff66;margin-bottom:10px">
			
				<ul>
					<li class="current"><a href="Home.jsp">Home</a></li>
      <li><a href="SchoolProfile.html">School Profile</a></li>
      <li><a href="UserLogin.jsp">Log in</a></li>
      <li><a href="RegisterNow.jsp">Join us</a></li>
      <li><a href="ContactUs.html">Contact us</a></li>
				</ul>
			</div>
			<div class="container" style="background-color: #ffff66">
				<div class="row">
					<h3 align="center" style="color: black">

						<b>Register Form For New Students</b>

					</h3>
				</div>
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<div class="well">

							<h2 align="left" style="color: #002a80">
								<b>Additional documents for registration</b>
							</h2>
							<h4 align="left" style="color: #002a80">Bring the following
								documentation to the school office.</h4>
							<div align="left" ul type="disc">

								<li style="color: crimson">Original Certified Birth
									Certificate</li>
								<li style="color: crimson">Current Immunization Form</li>
								<li style="color: crimson">Current Proofs of Residence (ex.
									power, water or gas bill)</li>

								</ul>
							</div>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<form method="post" action="AddStudentEnroll.jsp" style="background-color: #ffff66"
							name="Reg" onsubmit="return formValidate()">
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">Registration Number</span><input
										class="form-control zform-control:focus"
										placeholder="Enter Registration Number" type="text"
										name="regNo" />
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">First name</span><input
										class="form-control zform-control:focus"
										placeholder="Enter Registration First name" type="text"
										name="first_name" />
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">Last name</span><input
										class="form-control zform-control:focus"
										placeholder="Enter Registration Last name" type="text"
										name="last_name" />
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">Address Line 1</span>
									<textarea class="form-control zform-control:focus"
										placeholder="Enter Registration Address" type="text"
										name="address1"></textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">Address Line 2</span>
									<textarea class="form-control zform-control:focus"
										placeholder="Enter Registration Address" type="text"
										name="address2"></textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">City</span><input
										class="form-control zform-control:focus"
										placeholder="Enter Registration City" type="text" name="city" />
								</div>
							</div>
							<div class="form-group" style="width: 300px">

								<div class="input-group">
									<span class="input-group-addon">Birth Date</span><input
										class="form-control zform-control:focus"
										placeholder="Enter Registration Birth Date" type="date"
										name="dob" />
								</div>


							</div>
							<div class="row">
								<div class="col-md-3">
									<div class="form-group" style="width: 300px">

								<div class="input-group">
									<span class="input-group-addon">Ethnicity</span> <select
										class="form-control" title="Select Your Ethnicity"
										name="ethnicity">

										<option selected disabled>Select Your Ethnicity</option>
										<option value="sinhalese">Sinhalese</option>
										<option value="tamils">Tamils</option>
										<option value="malays">Malays</option>
										<option value="burghers">Burghers</option>
										<option value="other">Other Groups</option>

									</select>
								</div>


							</div>
								</div>
								<div class="col-md-5" style="margin-left: 150px">
									<div class="form-group">

										<div class="input-group">
											<span class="input-group-addon">Gender</span> <select
												class="form-control" title="Select Your Gender"
												name="gender">
												<option selected disabled>Select Your Gender</option>
												<option value="male">Male</option>
												<option value="female">Female</option>
											</select>
										</div>


									</div>
								</div>

							</div>
							
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">Parent/Guardian Name</span><input
										class="form-control zform-control:focus"
										placeholder="Enter Parent/Guardian Name" type="text"
										name="pName" />
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">Contact Number</span><input
										class="form-control zform-control:focus"
										placeholder="Enter Contact Number" type="text" name="phone" />
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">Email Address</span><input
										class="form-control zform-control:focus"
										placeholder="Enter Email Address" type="text" name="email" />
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">

									<span class="input-group-addon">Grade</span> <select
										class="form-control" title="Select Your Grade" name="grade">
										<option selected disabled>Select Your Grade</option>

										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon">Semester</span> <select
										class="form-control" title="Select Your Semester"
										name="semester">
										<option selected disabled>Select Your Semester</option>

										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
									</select>
								</div>
							</div>

							<div class="modal-footer">
								<button id="registerBtn" class="btn btn-success" type="submit">Submit</button>
								
								<button class="btn btn-danger" type="reset">Reset</button>
							</div>
						</form>
						<form method="POST" action="ListStudentEnroll.jsp">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="List Students" class="list-button" />
				</td>
			</tr>
		</table>
		
	</form>
					</div>
				</div>
			</div>


		</div>
	</div>


	
	</div>
	</div>

</body>
</html>