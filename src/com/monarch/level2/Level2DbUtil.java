package com.monarch.level2;



	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import javax.sql.DataSource;

	public class Level2DbUtil {

			private DataSource dataSource;

			public Level2DbUtil(DataSource theDataSource) {
				this.dataSource = theDataSource;
			}
			
			public List<Level2> getLevel2s() throws Exception{
				
				List<Level2> level2s = new ArrayList<>();
				
				Connection myConn = null;
				Statement myStmt = null;
				ResultSet myRs = null;
				
				try {
					// get a connection
					myConn = dataSource.getConnection();
					
					// create sql statement
					String sql = "select * from level2 order by student_reg_num  ";
					
					myStmt = myConn.createStatement();
					
					//execute query
					myRs = myStmt.executeQuery(sql);
					
					//process result set
					while(myRs.next()) {
						
						//retrieve data from result set row
						 int id = myRs.getInt("id");
						 String student_reg_num = myRs.getString("student_reg_num");
						 String option1 = myRs.getString("option1");
						 String option2 = myRs.getString("option2");
						 String option3 = myRs.getString("option3");
						
						// create new level2 object
						 Level2 tempLevel2 = new Level2(id, student_reg_num, option1, option2, option3);
						
						// add it to the list of level2s
						 level2s.add(tempLevel2);
					}
		
					
					return level2s;
					
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

			public void addLevel2(Level2 theLevel2) throws Exception {
				
				Connection myConn = null;
				PreparedStatement myStmt = null;
				
				try {
					//get db connection
					myConn = dataSource.getConnection();
					
					// create sql for insert
					String sql = "insert into level2"
								+"(student_reg_num, option1, option2, option3)"
								+"values (?, ?, ?, ?)";
					
					myStmt = myConn.prepareStatement(sql);
				
					// set the param values for the level2
					myStmt.setString(1, theLevel2.getStudent_reg_num());
					myStmt.setString(2, theLevel2.getOption1());
					myStmt.setString(3, theLevel2.getOption2());
					myStmt.setString(4, theLevel2.getOption3());
					
				
					//execute sql insert
					myStmt.execute();
				}
				finally {
					//clean up JDBC objects
					
				close(myConn, myStmt, null);
				}
				
				
			}

			public Level2 getLevel2(String theLevel2Id) throws Exception{

					Level2 theLevel2 = null;
					
					Connection myConn = null;
					PreparedStatement myStmt = null;
					ResultSet myRs = null;
					int level2Id;
					
					try {
						//convert level2 id to int
						level2Id = Integer.parseInt(theLevel2Id);
						
						//get connection to database
						myConn = dataSource.getConnection();
						
						//create sql to get selected level2
						String sql = "select * from level2 where id=?";
						
						//create prepared statement
						myStmt = myConn.prepareStatement(sql);
						
						//set params
						myStmt.setInt(1, level2Id);
						
						//execute statement
						myRs = myStmt.executeQuery();
						
						//retrieve data from result row
						if (myRs.next()) {
							int id = myRs.getInt("id");
							String student_reg_num = myRs.getString("student_reg_num");
							String option1 = myRs.getString("option1");
							String option2 = myRs.getString("option2");
							String option3 = myRs.getString("option3");
							
							//use the level2 id during construction
							theLevel2 = new Level2(id,student_reg_num, option1, option2, option3);
						}
						else {
							throw new Exception("Could not find level2 id: " + level2Id);
						}
						
						return theLevel2;
					}
					finally {
						// clean up JDBC ojects
						close(myConn, myStmt, myRs);
					}
			
			}

			public void updateLevel2(Level2 theLevel2) throws Exception {
				
				Connection myConn = null;
				PreparedStatement myStmt = null;
				
				try {
				//get db connection
				myConn = dataSource.getConnection();
				
				//create sql update statement
				String sql = "update level2 "
							+ "set student_reg_num=?, option1=?, option2=?, option3=? "
							+ "where id=?";
				
				
				
				//prepare statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setString(1, theLevel2.getStudent_reg_num());
				myStmt.setString(2, theLevel2.getOption1());
				myStmt.setString(3, theLevel2.getOption2());
				myStmt.setString(4, theLevel2.getOption3());
				myStmt.setInt(5, theLevel2.getId());
				
			
				
				//execute sql statement
				myStmt.execute();
			}
			finally {
				//clean up JDBC objects
				close(myConn, myStmt, null);
			}
		}

			public void deleteLevel2(String theLevel2Id) throws Exception{
				Connection myConn = null;
				PreparedStatement myStmt = null;
				
				try {
					// convert level2 id to int
					int level2Id = Integer.parseInt(theLevel2Id);
					
					//get connection to database
					myConn = dataSource.getConnection();
					
					//create sql to delete level2
					String sql = "delete from level2 where id=?";
					
					// prepare statement
					myStmt = myConn.prepareStatement(sql);
					
					// set params
					myStmt.setInt(1, level2Id);
					
					// execute sql statement
					myStmt.execute();
				}
				finally {
					
					// clean up JDBC code
					close(myConn, myStmt, null);
				}			
			}		
	}



