package com.oop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class TimetableDbUtil {

	
	private DataSource dataSource;

	public TimetableDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public List<Timetable> getTimetable() throws Exception{
		
		List<Timetable> timetable = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from timetable_001 order by ttid  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String ttid = myRs.getString("ttid");
				 String subid_1 = myRs.getString("subid_1");
				 String time_1 = myRs.getString("time_1");
				
				 String subid_2 = myRs.getString("subid_2");
				 String time_2 = myRs.getString("time_2");
				 
				 String subid_3 = myRs.getString("subid_3");
				 String time_3 = myRs.getString("time_3");
				 
				 String subid_4 = myRs.getString("subid_4");
				 String time_4 = myRs.getString("time_4");
				
				 String subid_5 = myRs.getString("subid_5");
				 String time_5 = myRs.getString("time_5");
				 
				 String subid_6 = myRs.getString("subid_6");
				 String time_6 = myRs.getString("time_6");
				 
				 String subid_7 = myRs.getString("subid_7");
				 String time_7 = myRs.getString("time_7");
				 
				 String subid_8 = myRs.getString("subid_8");
				 String time_8 = myRs.getString("time_8");
				 
				
				// create new timetable object
				 Timetable tempTimetable = new Timetable(id,ttid, subid_1, time_1,   subid_2, time_2,  subid_3, time_3,    subid_4, time_4,  subid_5,  time_5,   subid_6,  time_6,   subid_7,  time_7,  subid_8,  time_8);
				
				// add it to the list of timetables
				 timetable.add(tempTimetable);
			}

			
			return timetable;
			
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

	public void addTimetable(Timetable theTimetable) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into timetable_001"
						+"(ttid, subid_1, time_1,  subid_2, time_2,  subid_3, time_3,    subid_4, time_4, subid_5,  time_5,   subid_6,  time_6,   subid_7,  time_7, subid_8,  time_8)"
						+"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the timetable
			myStmt.setString(1, theTimetable.getTtid());
			myStmt.setString(2, theTimetable.getSubid_1());
			myStmt.setString(3, theTimetable.getTime_1());
			
			myStmt.setString(4, theTimetable.getSubid_2());
			myStmt.setString(5, theTimetable.getTime_2());
			
			myStmt.setString(6, theTimetable.getSubid_3());
			myStmt.setString(7, theTimetable.getTime_3());
			
			myStmt.setString(8, theTimetable.getSubid_4());
			myStmt.setString(9, theTimetable.getTime_4());
			
			myStmt.setString(10, theTimetable.getSubid_5());
			myStmt.setString(11, theTimetable.getTime_5());
			
			myStmt.setString(12, theTimetable.getSubid_6());
			myStmt.setString(13, theTimetable.getTime_6());
			
			myStmt.setString(14, theTimetable.getSubid_7());
			myStmt.setString(15, theTimetable.getTime_7());
			
			myStmt.setString(16, theTimetable.getSubid_8());
			myStmt.setString(17, theTimetable.getTime_8());
			
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public Timetable getTimetable(String theTimetableId) throws Exception{

			Timetable theTimetable = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int timetableId;
			
			try {
				//convert timetable id to int
				timetableId = Integer.parseInt(theTimetableId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected timetable
				String sql = "select * from timetable_001 where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, timetableId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String ttid = myRs.getString("ttid");
					 String subid_1 = myRs.getString("subid_1");
					 String time_1 = myRs.getString("time_1");
					 
					 String subid_2 = myRs.getString("subid_2");
					 String time_2 = myRs.getString("time_2");
					 
					 String subid_3 = myRs.getString("subid_3");
					 String time_3 = myRs.getString("time_3");
					 
					 String subid_4 = myRs.getString("subid_4");
					 String time_4 = myRs.getString("time_4");
					
					 String subid_5 = myRs.getString("subid_5");
					 String time_5 = myRs.getString("time_5");
					 
					 String subid_6 = myRs.getString("subid_6");
					 String time_6 = myRs.getString("time_6");
					
					 String subid_7 = myRs.getString("subid_7");
					 String time_7 = myRs.getString("time_7");
					
					 String subid_8 = myRs.getString("subid_8");
					 String time_8 = myRs.getString("time_8");
					
					
					//use the timetable id during construction
					theTimetable = new Timetable(id,ttid, subid_1, time_1,   subid_2, time_2,  subid_3, time_3,    subid_4, time_4,  subid_5,  time_5,  subid_6,  time_6,   subid_7,  time_7,  subid_8,  time_8);
				}
				else {
					throw new Exception("Could not find timetable id: " + timetableId);
				}
				
				return theTimetable;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public void updateTimetable(Timetable theTimetable) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update timetable_001 "
					+ "set ttid=?, subid_1=?, time_1=?,  subid_2=?, time_2=?, subid_3=?, time_3=?,   subid_4=?, time_4=?,  subid_5=?,  time_5=?,  subid_6=?,  time_6=?,   subid_=?,  time_7=?,  subid_8=?,  time_8=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theTimetable.getTtid());
		myStmt.setString(2, theTimetable.getSubid_1());
		myStmt.setString(3, theTimetable.getTime_1());
		
		myStmt.setString(4, theTimetable.getSubid_2());
		myStmt.setString(5, theTimetable.getTime_2());
		
		myStmt.setString(6, theTimetable.getSubid_3());
		myStmt.setString(7, theTimetable.getTime_3());
		
		myStmt.setString(8, theTimetable.getSubid_4());
		myStmt.setString(9, theTimetable.getTime_4());
		
		myStmt.setString(10, theTimetable.getSubid_5());
		myStmt.setString(11, theTimetable.getTime_5());
		
		myStmt.setString(12, theTimetable.getSubid_6());
		myStmt.setString(13, theTimetable.getTime_6());
		
		myStmt.setString(14, theTimetable.getSubid_7());
		myStmt.setString(15, theTimetable.getTime_7());
		
		myStmt.setString(16, theTimetable.getSubid_8());
		myStmt.setString(17, theTimetable.getTime_8());
		myStmt.setInt(18, theTimetable.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteTimetable(String theTimetableId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert timetable id to int
			int timetableId = Integer.parseInt(theTimetableId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete timetable
			String sql = "delete from timetable_001 where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, timetableId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		
}
