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
 * Servlet implementation class SubjectControllerServlet
 */
@WebServlet("/SubjectControllerServlet")
public class SubjectControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SubjectDbUtil subjectDbUtil;
	
	@Resource(name="jdbc/monarch")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create subject db util ... and pass in the conn pool / datasource
		try {
			subjectDbUtil = new SubjectDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing subjects
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listSubjects(request,response);
				break;
				
			case "ADD":
				addSubject(request,response);
				break;
				
			case "LOAD":
				loadSubject(request,response);
				break;
				
			case "UPDATE":
				updateSubject(request,response);
				break;
				
			case "DELETE" :
				deleteSubject(request,response);
				break;
				
			default:
				listSubjects(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read subject id from the form data
				String theSubjectId = request.getParameter("subjectId");
				
				// delete subject from database
				subjectDbUtil.deleteSubject(theSubjectId);
				
				//send them back to the list subjects page
				listSubjects(request,response);
	}


	private void updateSubject(HttpServletRequest request, HttpServletResponse response){

		//read subject info from form data
		String ids = request.getParameter("subjectId");
		int id = Integer.parseInt(ids);
		String subjectNum = request.getParameter("subjectNum");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		//create a new subject object
		Subject theSubject = new Subject(id, subjectNum, name, content);
		
		
		try {
			
			//perform update on database
			subjectDbUtil.updateSubject(theSubject);
			
			//send them back to the "list subjects" page
			listSubjects(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read subject id from form data
		String theSubjectId = request.getParameter("subjectId");
		
		//get subject from database (db util)
		Subject theSubject = subjectDbUtil.getSubject(theSubjectId);
		
		//place subject in the request atrribute
		request.setAttribute("THE_SUBJECT", theSubject);
		
		// send to jsp page: update-subject-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-subject-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addSubject(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read subject info from form data
		String subjectNum = request.getParameter("subjectNum");
		String name = request.getParameter("name");
		String content = request.getParameter("content");		
		
		// create a new subject object
		Subject theSubject = new Subject(subjectNum, name, content);
		
		// add the subject to the database
		subjectDbUtil.addSubject(theSubject);
		
		//send back to main page (subject list)
		listSubjects(request,response);
	}

	private void listSubjects(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get subjects from db util
		List<Subject> subjects = subjectDbUtil.getSubjects();
		
		//add subjects to the request
		request.setAttribute("SUBJECT_LIST", subjects);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-subjects.jsp");
		dispatcher.forward(request, response);
	}


}
