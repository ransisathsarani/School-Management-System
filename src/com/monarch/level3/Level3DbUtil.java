package com.monarch.level3;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class Level3DbUtil {

		private DataSource dataSource;

		public Level3DbUtil(DataSource theDataSource) {
			this.dataSource = theDataSource;
		}
		
		public List<Level3> getLevel3s() throws Exception{
			
			List<Level3> level3s = new ArrayList<>();
			
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;
			
			try {
				// get a connection
				myConn = dataSource.getConnection();
				
				// create sql statement
				String sql = "select * from level3 order by student_reg_num  ";
				
				myStmt = myConn.createStatement();
				
				//execute query
				myRs = myStmt.executeQuery(sql);
				
				//process result set
				while(myRs.next()) {
					
					//retrieve data from result set row
					 int id = myRs.getInt("id");
					 String student_reg_num = myRs.getString("student_reg_num");
					 String stream = myRs.getString("stream");
					 String subject1 = myRs.getString("subject1");
					 String subject2 = myRs.getString("subject2");	
					 String subject3 = myRs.getString("subject3");	
					
					// create new level3 object
					 Level3 tempLevel3 = new Level3(id, student_reg_num, stream, subject1, subject2, subject3);
					
					// add it to the list of level3s
					 level3s.add(tempLevel3);
				}
	
				
				return level3s;
				
			}
			finally {
				
				//close JDBC objects
				close(myConn, myStmt, myRs);
	
			}
			
		}

		private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
			
			try {
				if(myRs != null) {
					myRs.close();
				}
				
				if(myStmt != null) {
					myStmt.close();
				}
				
				if(myConn != null) {
					myConn.close();
				}
			}
			
			catch(Exception exc) {
				exc.printStackTrace();
			}
		}

		public void addLevel3(Level3 theLevel3) throws Exception {
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			try {
				//get db connection
				myConn = dataSource.getConnection();
				
				// create sql for insert
				String sql = "insert into level3"
							+"(student_reg_num, stream, subject1, subject2, subject3)"
							+"values (?, ?, ?, ?, ?)";
				
				myStmt = myConn.prepareStatement(sql);
			
				// set the param values for the level3
				myStmt.setString(1, theLevel3.getStudent_reg_num());
				myStmt.setString(2, theLevel3.getStream());
				myStmt.setString(3, theLevel3.getSubject1());
				myStmt.setString(4, theLevel3.getSubject2());
				myStmt.setString(5, theLevel3.getSubject3());
				
			
				//execute sql insert
				myStmt.execute();
			}
			finally {
				//clean up JDBC objects
				
			close(myConn, myStmt, null);
			}
			
			
		}

		public Level3 getLevel3(String theLevel3Id) throws Exception{

				Level3 theLevel3 = null;
				
				Connection myConn = null;
				PreparedStatement myStmt = null;
				ResultSet myRs = null;
				int level3Id;
				
				try {
					//convert level3 id to int
					level3Id = Integer.parseInt(theLevel3Id);
					
					//get connection to database
					myConn = dataSource.getConnection();
					
					//create sql to get selected level3
					String sql = "select * from level3 where id=?";
					
					//create prepared statement
					myStmt = myConn.prepareStatement(sql);
					
					//set params
					myStmt.setInt(1, level3Id);
					
					//execute statement
					myRs = myStmt.executeQuery();
					
					//retrieve data from result row
					if (myRs.next()) {
						int id = myRs.getInt("id");
						String student_reg_num = myRs.getString("student_reg_num");
						String stream = myRs.getString("stream");
						String subject1 = myRs.getString("subject1");
						String subject2 = myRs.getString("subject2");
						String subject3 = myRs.getString("subject3");
						
						//use the level3 id during construction
						theLevel3 = new Level3(id,student_reg_num,  stream, subject1, subject2, subject3);
					}
					else {
						throw new Exception("Could not find level3 id: " + level3Id);
					}
					
					return theLevel3;
				}
				finally {
					// clean up JDBC ojects
					close(myConn, myStmt, myRs);
				}
		
		}

		public void updateLevel3(Level3 theLevel3) throws Exception {
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			try {
			//get db connection
			myConn = dataSource.getConnection();
			
			//create sql update statement
			String sql = "update level3 "
						+ "set student_reg_num=?, stream=?, subject1=?, subject2=?, subject3=? "
						+ "where id=?";
			
			
			
			//prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setString(1, theLevel3.getStudent_reg_num());
			myStmt.setString(2, theLevel3.getStream());
			myStmt.setString(3, theLevel3.getSubject1());
			myStmt.setString(4, theLevel3.getSubject2());
			myStmt.setString(5, theLevel3.getSubject3());
			myStmt.setInt(6, theLevel3.getId());
			
		
			
			//execute sql statement
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

		public void deleteLevel3(String theLevel3Id) throws Exception{
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			try {
				// convert level3 id to int
				int level3Id = Integer.parseInt(theLevel3Id);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to delete level3
				String sql = "delete from level3 where id=?";
				
				// prepare statement
				myStmt = myConn.prepareStatement(sql);
				
				// set params
				myStmt.setInt(1, level3Id);
				
				// execute sql statement
				myStmt.execute();
			}
			finally {
				
				// clean up JDBC code
				close(myConn, myStmt, null);
			}			
		}		
}

