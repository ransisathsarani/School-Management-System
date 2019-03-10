package com.oop.monarch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
public class AttendanceDbUtil {

	
	private DataSource dataSource;

	public AttendanceDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Attendance> getAttendances() throws Exception{
		
		List<Attendance> attendances = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from attendance order by date";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String year = myRs.getString("year");
				 String classroom = myRs.getString("classroom");
				 String date = myRs.getString("date");
				 String present = myRs.getString("present");
				 String absent = myRs.getString("absent");
				
				// create new level2 object
				 Attendance tempAttendance = new Attendance(id, year, classroom, date, present ,absent);
				
				// add it to the list of level2s
				 attendances.add(tempAttendance);
			}

			
			return attendances;
			
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

	public void addAttendance(Attendance theAttendance) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into attendance"
						+"(year, classroom, date, present, absent)"
						+"values (?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the level2
			myStmt.setString(1, theAttendance.getYear());
			myStmt.setString(2, theAttendance.getClassroom());
			myStmt.setString(3, theAttendance.getDate());
			myStmt.setString(4, theAttendance.getPresent());
			myStmt.setString(5, theAttendance.getAbsent());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public Attendance getAttendance(String theAttendanceId) throws Exception{

			Attendance theAttendance = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int attendanceId;
			
			try {
				//convert level2 id to int
				attendanceId = Integer.parseInt(theAttendanceId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected level2
				String sql = "select * from attendance where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, attendanceId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					String year = myRs.getString("year");
					String classroom = myRs.getString("classroom");
					String date = myRs.getString("date");
					String present = myRs.getString("present");
					String absent = myRs.getString("absent");
					
					//use the level2 id during construction
					theAttendance = new Attendance(year, classroom, date, present ,absent);
				}
				else {
					throw new Exception("Could not find attendance id: " + attendanceId);
				}
				
				return theAttendance;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public void updateAttendance(Attendance theAttendance) throws Exception {
		 
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update attendance "
					+ "set year=?, classroom=?, date=?, present=?, absent=? "
					+ "where id=?";
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theAttendance.getYear());
		myStmt.setString(2, theAttendance.getClassroom());
		myStmt.setString(3, theAttendance.getDate());
		myStmt.setString(4, theAttendance.getPresent());
		myStmt.setString(5, theAttendance.getAbsent());
		myStmt.setInt(6, theAttendance.getId());
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteAttendance(String theAttendanceId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert level2 id to int
			int attendanceId = Integer.parseInt(theAttendanceId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete level2
			String sql = "delete from attendance where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, attendanceId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		
}
