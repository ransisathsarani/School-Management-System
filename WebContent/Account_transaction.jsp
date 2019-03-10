<!DOCTYPE html>
<html>
<head>
<title>Accounting</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="style_1.css" />
</head>

<body>
<div id="page" >
  <div id="header">
    <div id="section" style="background-color:#274F75;width:100%">
      <div><a href="index.html"><img src="images/logo (3).png" alt="" /></a></div>
      <span>www.MonarchCollege.lk <br />
      <br />
      +9411 2596334</span> </div>
      <div style="background-color:#ffff66">
    <ul>
      <li><a href="SchoolProfile.html">School Profile</a></li>
      <li><a href="ContactUs.html">Contact us</a></li>
	  <li style="float:right"><a href="#"><img src="images/profilepic.png" height="42" width="42"></a></li>
      <li style="float:right"><a href="Home.html">Logout</a></li>
    </ul>
    </div>
    <div id="tagline">
      <div style="background-color:#ffff66; width:400px ; height: 300px">
        
	
	<form action="transactions.jsp" method="post">
	
	<table    style="background-color:#ffff66" > 
	    
   <h3> <th>Make Account Transactions</th> </h3>

<tr>
<td>Description </td>
<td> <input type = text name=description > </td>
</tr>

<tr>
<td>Type </td>
<td>
<select name="type">
  <option value="deposit" name="deposit">deposit</option>
  <option value="withdraw" name="withdraw">withdraw</option>
</select>

</tr>

<tr>
<td>Amount</td>
<td><input type = number  name ="amount"></td>
</tr>

   
   <tr> <td>
   <input type="submit" value= "submit">
   		</td>
    </tr>
    
    </table>
    </form>
      </div>
    </div>
  </div>
  
 
</div>
</body>
</html>
