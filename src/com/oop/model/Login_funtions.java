package com.oop.model;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.oop.model.Login;
import com.oop.util.dbcon;


public class Login_funtions {

	public String validateUser(Login lg) throws ClassNotFoundException {
		
		String username = lg.getUsername();
		String password = lg.getPassword();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String unDB="";
		String pwDB = "";
		String type = "";
		
		try {
			
			conn = dbcon.createConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select email,password,type from user_validation");
			
			
			while(rs.next()) {
				
				
				unDB = rs.getString("email");
				pwDB = rs.getString("password");
				type = rs.getString("type");
				
						if(username.equals(unDB) && password.equals(pwDB) && type.equals("admin"))
								return "Admin";
						else if(username.equals(unDB) && password.equals(pwDB) && type.equals("teacher"))
								return "Academic_Staff";
						else if(username.equals(unDB) && password.equals(pwDB) && type.equals("level1"))
								return "Level_1";
						else if(username.equals(unDB) && password.equals(pwDB) && type.equals("level2"))
							return "Level_2";
						else if(username.equals(unDB) && password.equals(pwDB) && type.equals("level3"))
							return "Level_3";
						
				}
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
		return "Invalid Username and password";
		}
	}

