package com.oop.model;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
private StudentDbUtil studentDbUtil;
	
	@Resource(name="jdbc/monarch")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create student db util ... and pass in the conn pool / datasource
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}
	
	
	
	
	
    public StudentControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
try {
			
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing students
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listStudents(request,response);
				break;
				
			case "ADD":
				addStudents(request,response);
				break;
				
			case "LOAD":
				loadStudents(request,response);
				break;
				
			case "UPDATE":
				updateStudents(request,response);
				break;
				
			case "DELETE" :
				deleteStudents(request,response);
				break;
				
			default:
				listStudents(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read student id from the form data
				String theStudentId = request.getParameter("studentId");
				
				// delete student from database
				studentDbUtil.deleteStudents(theStudentId);
				
				//send them back to the list students page
				listStudents(request,response);
	}


	private void updateStudents(HttpServletRequest request, HttpServletResponse response){

		//read student info from form data
		String ids = request.getParameter("studentId");
		int id = Integer.parseInt(ids);
		String studentNum = request.getParameter("studentNum");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String BOD =request.getParameter("BOD");
		String number = request.getParameter("number");
		String grade = request.getParameter("grade");
		String level = request.getParameter("level");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		
		//create a new student object
		Student theStudent = new Student(id, studentNum,fname,lname,BOD,number,grade,level,address,gender);
		
		
		try {
			
			//perform update on database
			studentDbUtil.updateStudents(theStudent);
			
			//send them back to the "list students" page
			listStudents(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read student id from form data
		String theStudentId = request.getParameter("studentId");
		
		//get student from database (db util)
		Student theStudent = studentDbUtil.getStudents(theStudentId);
		
		//place student in the request atrribute
		request.setAttribute("THE_STUDENT", theStudent);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addStudents(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read student info from form data
		String studentNum = request.getParameter("studentNum");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String BOD =request.getParameter("BOD");
		String number = request.getParameter("number");
		String grade = request.getParameter("grade");
		String level = request.getParameter("level");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");		
		
		// create a new student object
		Student theStudent = new Student(studentNum,fname,lname,BOD,number,grade,level,address,gender);
		
		// add the student to the database
		studentDbUtil.addStudents(theStudent);
		
		//send back to main page (student list)
		listStudents(request,response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get students from db util
		List<Student> students = studentDbUtil.getStudents();
		
		//add students to the request
		request.setAttribute("STUDENT_LIST", students);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}

	}


