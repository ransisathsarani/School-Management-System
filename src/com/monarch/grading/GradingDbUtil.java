package com.monarch.grading;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



public class GradingDbUtil {

	private DataSource dataSource;

	public GradingDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public List<Grading> getGrading() throws Exception{
		
		List<Grading> gradings = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from grading order by SID  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String SID = myRs.getString("SID");
				 String level = myRs.getString("level");
				 String examID = myRs.getString("examID");
				 String sub1 = myRs.getString("sub1");
				 String sub2 = myRs.getString("sub2");
				 String sub3 = myRs.getString("sub3");
				 String sub4 = myRs.getString("sub4");
				 String sub5 = myRs.getString("sub5");
				
				// create new grading object
				 Grading tempGrading = new Grading(id, SID,level,examID,sub1,sub2,sub3,sub4,sub5);
				
				// add it to the list of gradings
				 gradings.add(tempGrading);
			}

			
			return gradings;
			
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

	public void addGrading(Grading theGrading) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into grading"
						+"(SID, level, examID,sub1,sub2,sub3,sub4,sub5)"
						+"values (?, ?, ?,?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the grading
			myStmt.setString(1, theGrading.getSID());
			myStmt.setString(2, theGrading.getLevel());
			myStmt.setString(3, theGrading.getExamID());
			myStmt.setString(4, theGrading.getSub1());
			myStmt.setString(5, theGrading.getSub2());
			myStmt.setString(6, theGrading.getSub3());
			myStmt.setString(7, theGrading.getSub4());
			myStmt.setString(8, theGrading.getSub5());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public Grading getGrading(String theGradingId) throws Exception{

			Grading theGrading = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int gradingId;
			
			try {
				//convert grading id to int
				gradingId = Integer.parseInt(theGradingId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected grading
				String sql = "select * from grading where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, gradingId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String SID = myRs.getString("SID");
					String level = myRs.getString("level");
					String examID = myRs.getString("examID");
					String sub1 = myRs.getString("sub1");
					String sub2 = myRs.getString("sub2");
					String sub3 = myRs.getString("sub3");
					String sub4 = myRs.getString("sub4");
					String sub5 = myRs.getString("sub5");
					
					//use the grading id during construction
					theGrading = new Grading(id,SID, level,examID,sub1,sub2,sub3,sub4,sub5);
				}
				else {
					throw new Exception("Could not find subject id: " + gradingId);
				}
				
				return theGrading;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public void updateGrading(Grading theGrading) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update grading "
					+ "set SID=?, level=?, examID=?, sub1=?, sub2=?, sub3=?, sub3=?, sub5=? "
					+ "where id=?";
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theGrading.getSID());
		myStmt.setString(2, theGrading.getLevel());
		myStmt.setString(3, theGrading.getExamID());
		myStmt.setString(4, theGrading.getSub1());
		myStmt.setString(5, theGrading.getSub2());
		myStmt.setString(6, theGrading.getSub3());
		myStmt.setString(7, theGrading.getSub4());
		myStmt.setString(8, theGrading.getSub5());
		myStmt.setInt(9, theGrading.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteGrading(String theGradingId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert grading id to int
			int gradingId = Integer.parseInt(theGradingId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete grading
			String sql = "delete from grading where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, gradingId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		


	
}
