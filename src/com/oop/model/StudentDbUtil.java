package com.oop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {

	private DataSource dataSource;

	public StudentDbUtil(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}
	
	public List<Student> getStudents() throws Exception{
		
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from student_001 order by studentNum  ";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				 int id = myRs.getInt("id");
				 String studentNum = myRs.getString("studentNum");
				 String fname = myRs.getString("fname");
				 String lname = myRs.getString("lname");
				 String BOD = myRs.getString("BOD");
				 String number = myRs.getString("number");
				 String grade = myRs.getString("grade");
				 String level = myRs.getString("level");
				 String address = myRs.getString("address");
				 String gender = myRs.getString("gender");
				
				// create new student object
				 Student tempStudent = new Student(id, studentNum, fname, lname, BOD, number, grade, level, address, gender);
				
				// add it to the list of students
				 students.add(tempStudent);
			}

			
			return students;
			
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

	public void addStudents(Student theStudent) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into student_001"
						+"(studentNum,fname,lname,BOD,number,grade,level,address,gender)"
						+"values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
		
			// set the param values for the student
			myStmt.setString(1, theStudent.getStudentNum());
			myStmt.setString(2, theStudent.getFname());
			myStmt.setString(3, theStudent.getLname());
			myStmt.setString(4, theStudent.getBOD());
			myStmt.setString(5, theStudent.getNumber());
			myStmt.setString(6, theStudent.getGrade());
			myStmt.setString(7, theStudent.getLevel());
			myStmt.setString(8, theStudent.getAddress());
			myStmt.setString(9, theStudent.getGender());
		
			//execute sql insert
			myStmt.execute();
		}
		finally {
			//clean up JDBC objects
			
		close(myConn, myStmt, null);
		}
		
		
	}

	public Student getStudents(String theStudentId) throws Exception{

			Student theStudent = null;
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			int studentId;
			
			try {
				//convert student id to int
				studentId = Integer.parseInt(theStudentId);
				
				//get connection to database
				myConn = dataSource.getConnection();
				
				//create sql to get selected student
				String sql = "select * from student_001 where id=?";
				
				//create prepared statement
				myStmt = myConn.prepareStatement(sql);
				
				//set params
				myStmt.setInt(1, studentId);
				
				//execute statement
				myRs = myStmt.executeQuery();
				
				//retrieve data from result row
				if (myRs.next()) {
					int id = myRs.getInt("id");
					String studentNum = myRs.getString("studentNum");
					 String fname = myRs.getString("fname");
					 String lname = myRs.getString("lname");
					 String BOD = myRs.getString("BOD");
					 String number = myRs.getString("number");
					 String grade = myRs.getString("grade");
					 String level = myRs.getString("level");
					 String address = myRs.getString("address");
					 String gender = myRs.getString("gender");
					
					//use the student id during construction
					theStudent = new Student(id,studentNum,fname,lname,BOD,number,grade,level,address,gender);
				}
				else {
					throw new Exception("Could not find student id: " + studentId);
				}
				
				return theStudent;
			}
			finally {
				// clean up JDBC ojects
				close(myConn, myStmt, myRs);
			}
	
	}

	public void updateStudents(Student theStudent) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		//get db connection
		myConn = dataSource.getConnection();
		
		//create sql update statement
		String sql = "update student_001 "
					+ "set studentNum=?, fname=?, lname=?, BOD=?, number=?, grade=?, level=?, address=?, gender=? "
					+ "where id=?";
		
		
		
		//prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		//set params
		
		
		
		myStmt.setString(1, theStudent.getStudentNum());
		myStmt.setString(2, theStudent.getFname());
		myStmt.setString(3, theStudent.getLname());
		myStmt.setString(4, theStudent.getBOD());
		myStmt.setString(5, theStudent.getNumber());
		myStmt.setString(6, theStudent.getGrade());
		myStmt.setString(7, theStudent.getLevel());
		myStmt.setString(8, theStudent.getAddress());
		myStmt.setString(9, theStudent.getGender());
		myStmt.setInt(10, theStudent.getId());
	
		
		//execute sql statement
		myStmt.execute();
	}
	finally {
		//clean up JDBC objects
		close(myConn, myStmt, null);
	}
}

	public void deleteStudents(String theStudentId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int studentId = Integer.parseInt(theStudentId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			//create sql to delete student
			String sql = "delete from student_001 where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, studentId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			
			// clean up JDBC code
			close(myConn, myStmt, null);
		}			
	}		
}
