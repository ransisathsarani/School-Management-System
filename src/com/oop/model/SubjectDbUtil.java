package com.oop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class SubjectDbUtil {

	private DataSource dataSource;

	public SubjectDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public List<Subject> getSubjects() throws Exception{
		
		List<Subject> subjects = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from subject order by subjectNum  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String subjectNum = myRs.getString("subjectNum");
				 String name = myRs.getString("name");
				 String content = myRs.getString("content");
				
				// create new subject object
				 Subject tempSubject = new Subject(id, subjectNum, name, content);
				
				// add it to the list of subjects
				 subjects.add(tempSubject);
			}

			
			return subjects;
			
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

	public void addSubject(Subject theSubject) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into subject"
						+"(subjectNum, name, content)"
						+"values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the subject
			myStmt.setString(1, theSubject.getSubjectNum());
			myStmt.setString(2, theSubject.getName());
			myStmt.setString(3, theSubject.getContent());
			
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public Subject getSubject(String theSubjectId) throws Exception{

			Subject theSubject = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int subjectId;
			
			try {
				//convert subject id to int
				subjectId = Integer.parseInt(theSubjectId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected subject
				String sql = "select * from subject where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, subjectId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String subjectNum = myRs.getString("subjectNum");
					String name = myRs.getString("name");
					String content = myRs.getString("content");
					
					//use the subject id during construction
					theSubject = new Subject(id,subjectNum, name, content);
				}
				else {
					throw new Exception("Could not find subject id: " + subjectId);
				}
				
				return theSubject;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public void updateSubject(Subject theSubject) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update subject "
					+ "set subjectNum=?, name=?, content=? "
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		myStmt.setString(1, theSubject.getSubjectNum());
		myStmt.setString(2, theSubject.getName());
		myStmt.setString(3, theSubject.getContent());
		myStmt.setInt(4, theSubject.getId());
		
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteSubject(String theSubjectId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert subject id to int
			int subjectId = Integer.parseInt(theSubjectId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete subject
			String sql = "delete from subject where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, subjectId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		
}
