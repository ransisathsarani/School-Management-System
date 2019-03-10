package com.monarch.level2;

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
 * Servlet implementation class Level2ControllerServlet
 */
@WebServlet("/Level2ControllerServlet")
public class Level2ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Level2DbUtil level2DbUtil;
	
	@Resource(name="jdbc/monarch")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create level2 db util ... and pass in the conn pool / datasource
		try {
			level2DbUtil = new Level2DbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if the command is missing, then default to listing level2s
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listLevel2s(request,response);
				break;
				
			case "ADD":
				addLevel2(request,response);
				break;
				
			case "LOAD":
				loadLevel2(request,response);
				break;
				
			case "UPDATE":
				updateLevel2(request,response);
				break;
				
			case "DELETE" :
				deleteLevel2(request,response);
				break;
				
			default:
				listLevel2s(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteLevel2(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read level2 id from the form data
				String theLevel2Id = request.getParameter("level2Id");
				
				// delete level2 from database
				level2DbUtil.deleteLevel2(theLevel2Id);
				
				//send them back to the list level2s page
				listLevel2s(request,response);
	}


	private void updateLevel2(HttpServletRequest request, HttpServletResponse response){

		//read level2 info from form data
		String ids = request.getParameter("level2Id");
		int id = Integer.parseInt(ids);
		String student_reg_num = request.getParameter("student_reg_num");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		
		//create a new level2 object
		Level2 theLevel2 = new Level2(id, student_reg_num, option1, option2, option3);
		
		
		try {
			
			//perform update on database
			level2DbUtil.updateLevel2(theLevel2);
			
			//send them back to the "list level2s" page
			listLevel2s(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadLevel2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read level2 id from form data
		String theLevel2Id = request.getParameter("level2Id");
		
		//get level2 from database (db util)
		Level2 theLevel2 = level2DbUtil.getLevel2(theLevel2Id);
		
		//place level2 in the request atrribute
		request.setAttribute("THE_LEVEL2", theLevel2);
		
		// send to jsp page: update-level2-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-level2-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addLevel2(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read level2 info from form data
		String student_reg_num = request.getParameter("student_reg_num");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");		
		
		// create a new level2 object
		Level2 theLevel2 = new Level2(student_reg_num, option1, option2, option3);
		
		// add the level2 to the database
		level2DbUtil.addLevel2(theLevel2);
		
		//send back to main page (level2 list)
		listLevel2s(request,response);
	}

	private void listLevel2s(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get level2s from db util
		List<Level2> level2s = level2DbUtil.getLevel2s();
		
		//add level2s to the request
		request.setAttribute("LEVEL2_LIST", level2s);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-level2s.jsp");
		dispatcher.forward(request, response);
	}
}
