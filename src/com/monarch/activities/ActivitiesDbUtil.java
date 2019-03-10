package com.monarch.activities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ActivitiesDbUtil {

	private DataSource dataSource;

	public ActivitiesDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public List<Activities> getActivitiess() throws Exception{
		
		List<Activities> activitiess = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from activities order by student_reg_num  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String student_reg_num = myRs.getString("student_reg_num");
				 String sports = myRs.getString("sports");
				 String clubs = myRs.getString("clubs");
				 String organizations = myRs.getString("organizations");
				
				// create new activities object
				 Activities tempActivities = new Activities(id, student_reg_num, sports, clubs, organizations);
				
				// add it to the list of activitiess
				 activitiess.add(tempActivities);
			}

			
			return activitiess;
			
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

	public void addActivities(Activities theActivities) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into activities"
						+"(student_reg_num, sports, clubs, organizations)"
						+"values (?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the activities
			myStmt.setString(1, theActivities.getStudent_reg_num());
			myStmt.setString(2, theActivities.getSports());
			myStmt.setString(3, theActivities.getClubs());
			myStmt.setString(4, theActivities.getOrganizations());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public Activities getActivities(String theActivitiesId) throws Exception{

			Activities theActivities = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int activitiesId;
			
			try {
				//convert activities id to int
				activitiesId = Integer.parseInt(theActivitiesId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected activities
				String sql = "select * from activities where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, activitiesId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String student_reg_num = myRs.getString("student_reg_num");
					String sports = myRs.getString("sports");
					String clubs = myRs.getString("clubs");
					String organizations = myRs.getString("organizations");
					
					//use the activities id during construction
					theActivities = new Activities(id,student_reg_num, sports, clubs, organizations);
				}
				else {
					throw new Exception("Could not find activities id: " + activitiesId);
				}
				
				return theActivities;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public void updateActivities(Activities theActivities) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update activities "
					+ "set student_reg_num=?, sports=?, clubs=?, organizations=? "
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theActivities.getStudent_reg_num());
		myStmt.setString(2, theActivities.getSports());
		myStmt.setString(3, theActivities.getClubs());
		myStmt.setString(4, theActivities.getOrganizations());
		myStmt.setInt(5, theActivities.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteActivities(String theActivitiesId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert activities id to int
			int activitiesId = Integer.parseInt(theActivitiesId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete activities
			String sql = "delete from activities where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, activitiesId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		
}
