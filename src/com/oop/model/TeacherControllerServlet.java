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
 * Servlet implementation class TeacherControllerServlet
 */
@WebServlet("/TeacherControllerServlet")
public class TeacherControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TeacherDbUtil teacherDbUtil;
	
	@Resource(name="jdbc/monarch")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create teacher db util ... and pass in the conn pool / datasource
		try {
			teacherDbUtil = new TeacherDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}

    public TeacherControllerServlet() {
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
			
			//if the command is missing, then default to listing teachers
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listTeachers(request,response);
				break;
				
			case "ADD":
				addTeachers(request,response);
				break;
				
			case "LOAD":
				loadTeachers(request,response);
				break;
				
			case "UPDATE":
				updateTeachers(request,response);
				break;
				
			case "DELETE" :
				deleteTeachers(request,response);
				break;
				
			default:
				listTeachers(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteTeachers(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read teacher id from the form data
				String theTeacherId = request.getParameter("teacherId");
				
				// delete teacher from database
				teacherDbUtil.deleteTeachers(theTeacherId);
				
				//send them back to the list teachers page
				listTeachers(request,response);
	}


	private void updateTeachers(HttpServletRequest request, HttpServletResponse response){

		//read teacher info from form data
		String ids = request.getParameter("teacherId");
		int id = Integer.parseInt(ids);
		String staffid = request.getParameter("staffid");
		String name = request.getParameter("name");
		String subjectNum = request.getParameter("subjectNum");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String number = request.getParameter("number");
		
		//create a new teacher object
		Teacher theTeacher = new Teacher(id, staffid, name, subjectNum, email, password, number);
		
		
		try {
			
			//perform update on database
			teacherDbUtil.updateTeachers(theTeacher);
			
			//send them back to the "list teachers" page
			listTeachers(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadTeachers(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read teacher id from form data
		String theTeacherId = request.getParameter("teacherId");
		
		//get teacher from database (db util)
		Teacher theTeacher = teacherDbUtil.getTeachers(theTeacherId);
		
		//place teacher in the request atrribute
		request.setAttribute("THE_TEACHER", theTeacher);
		
		// send to jsp page: update-teacher-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-teacher-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addTeachers(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read teacher info from form data
		String staffid = request.getParameter("staffid");
		String name = request.getParameter("name");
		String subjectNum = request.getParameter("subjectNum");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String number = request.getParameter("number");		
		
		// create a new teacher object
		Teacher theTeacher = new Teacher(staffid,name,subjectNum,email,password,number);
		
		// add the teacher to the database
		teacherDbUtil.addTeachers(theTeacher);
		
		//send back to main page (teacher list)
		listTeachers(request,response);
	}

	private void listTeachers(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get teachers from db util
		List<Teacher> teacher = teacherDbUtil.getTeachers();
		
		//add teachers to the request
		request.setAttribute("TEACHER_LIST", teacher);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-teachers.jsp");
		dispatcher.forward(request, response);
	}
	

}
