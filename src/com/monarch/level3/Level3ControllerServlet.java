package com.monarch.level3;

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
 * Servlet implementation class level3ControllerServlet
 */
@WebServlet("/Level3ControllerServlet")
public class Level3ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Level3DbUtil level3DbUtil;
	
	@Resource(name="jdbc/monarch")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create level3 db util ... and pass in the conn pool / datasource
		try {
			level3DbUtil = new Level3DbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing level3s
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listLevel3s(request,response);
				break;
				
			case "ADD":
				addLevel3(request,response);
				break;
				
			case "LOAD":
				loadLevel3(request,response);
				break;
				
			case "UPDATE":
				updateLevel3(request,response);
				break;
				
			case "DELETE" :
				deleteLevel3(request,response);
				break;
				
			default:
				listLevel3s(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteLevel3(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read level3 id from the form data
				String theLevel3Id = request.getParameter("level3Id");
				
				// delete level3 from database
				level3DbUtil.deleteLevel3(theLevel3Id);
				
				//send them back to the list level3s page
				listLevel3s(request,response);
	}


	private void updateLevel3(HttpServletRequest request, HttpServletResponse response){

		//read level3 info from form data
		String ids = request.getParameter("level3Id");
		int id = Integer.parseInt(ids);
		String student_reg_num = request.getParameter("student_reg_num");
		String stream = request.getParameter("stream");
		String subject1 = request.getParameter("subject1");
		String subject2 = request.getParameter("subject2");	
		String subject3 = request.getParameter("subject3");	
		
		//create a new level3 object
		Level3 theLevel3 = new Level3(id, student_reg_num, stream, subject1, subject2, subject3);
		
		
		try {
			
			//perform update on database
			level3DbUtil.updateLevel3(theLevel3);
			
			//send them back to the "list level3" page
			listLevel3s(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadLevel3(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read level3 id from form data
		String theLevel3Id = request.getParameter("level3Id");
		
		//get level3 from database (db util)
		Level3 theLevel3 = level3DbUtil.getLevel3(theLevel3Id);
		
		//place level3 in the request atrribute
		request.setAttribute("THE_LEVEL3", theLevel3);
		
		// send to jsp page: update-level3-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-level3-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addLevel3(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read level3 info from form data
		String student_reg_num = request.getParameter("student_reg_num");
		String stream = request.getParameter("stream");
		String subject1 = request.getParameter("subject1");
		String subject2 = request.getParameter("subject2");	
		String subject3 = request.getParameter("subject3");			
		
		// create a new level3 object
		Level3 theLevel3 = new Level3(student_reg_num, stream, subject1, subject2, subject3);
		
		// add the level3 to the database
		level3DbUtil.addLevel3(theLevel3);
		
		//send back to main page (level3 list)
		listLevel3s(request,response);
	}

	private void listLevel3s(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get level3s from db util
		List<Level3> level3s = level3DbUtil.getLevel3s();
		
		//add level3s to the request
		request.setAttribute("LEVEL3_LIST", level3s);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-level3s.jsp");
		dispatcher.forward(request, response);
	}

}
