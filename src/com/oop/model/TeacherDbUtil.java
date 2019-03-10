package com.oop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class TeacherDbUtil {

	
	private DataSource dataSource;

	public TeacherDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public List<Teacher> getTeachers() throws Exception{
		
		List<Teacher> teacher = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from teacher order by staffid  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String staffid = myRs.getString("staffid");
				 String name = myRs.getString("name");
				 String subjectNum = myRs.getString("subjectNum");
				 String email = myRs.getString("email");
				 String password = myRs.getString("password");
				 String number = myRs.getString("number");
				
				// create new teacher object
				 Teacher tempTeacher = new Teacher(id, staffid,name,subjectNum,email,password,number);
				
				// add it to the list of teachers
				 teacher.add(tempTeacher);
			}

			
			return teacher;
			
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

	public void addTeachers(Teacher theTeacher) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into teacher"
						+"(staffid, name, subjectNum, email, password, number)"
						+"values (?, ?, ?,?,?,?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the teacher
			myStmt.setString(1, theTeacher.getStaffid());
			myStmt.setString(2, theTeacher.getName());
			myStmt.setString(3, theTeacher.getSubjectNum());
			myStmt.setString(4, theTeacher.getEmail());
			myStmt.setString(5, theTeacher.getPassword());
			myStmt.setString(6, theTeacher.getNumber());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public Teacher getTeachers(String theTeacherId) throws Exception{

			Teacher theTeacher = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int teacherId;
			
			try {
				//convert teacher id to int
				teacherId = Integer.parseInt(theTeacherId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected teacher
				String sql = "select * from teacher where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, teacherId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String staffid = myRs.getString("staffid");
					 String name = myRs.getString("name");
					 String subjectNum = myRs.getString("subjectNum");
					 String email = myRs.getString("email");
					 String password = myRs.getString("password");
					 String number = myRs.getString("number");
					
					//use the teacher id during construction
					theTeacher = new Teacher(id,staffid,name,subjectNum,email,password,number);
				}
				else {
					throw new Exception("Could not find teacher id: " + teacherId);
				}
				
				return theTeacher;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public void updateTeachers(Teacher theTeacher) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update teacher "
					+ "set staffid=?, name=?, subjectNum=?, email=?, password=?, number=?"
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theTeacher.getStaffid());
		myStmt.setString(2, theTeacher.getName());
		myStmt.setString(3, theTeacher.getSubjectNum());
		myStmt.setString(4, theTeacher.getEmail());
		myStmt.setString(5, theTeacher.getPassword());
		myStmt.setString(6, theTeacher.getNumber());
		myStmt.setInt(7, theTeacher.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteTeachers(String theTeacherId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert teacher id to int
			int teacherId = Integer.parseInt(theTeacherId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete teacher
			String sql = "delete from teacher where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, teacherId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		
}
