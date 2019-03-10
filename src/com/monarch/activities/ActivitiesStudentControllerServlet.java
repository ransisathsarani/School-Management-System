package com.monarch.activities;

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
 * Servlet implementation class ActivitiesStudentControllerServlet
 */
@WebServlet("/ActivitiesStudentControllerServlet")
public class ActivitiesStudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
private ActivitiesDbUtil activitiesDbUtil;
	
	@Resource(name="jdbc/monarch")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create activities db util ... and pass in the conn pool / datasource
		try {
			activitiesDbUtil = new ActivitiesDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}
	
	
    public ActivitiesStudentControllerServlet() {
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
			
			//if the command is missing, then default to listing activitiess
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listActivitiess(request,response);
				break;
				
			case "ADD":
				addActivities(request,response);
				break;
				
			default:
				listActivitiess(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void addActivities(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// read activities info from form data
				String student_reg_num = request.getParameter("student_reg_num");
				String sports = request.getParameter("sports");
				String clubs = request.getParameter("clubs");
				String organizations = request.getParameter("organizations");		
				
				// create a new activities object
				Activities theActivities = new Activities(student_reg_num, sports, clubs, organizations);
				
				// add the activities to the database
				activitiesDbUtil.addActivities(theActivities);
				
				//send back to main page (activities list)
				listActivitiess(request,response);
	}




private void listActivitiess(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get activitiess from db util
		List<Activities> activitiess = activitiesDbUtil.getActivitiess();
		
		//add activitiess to the request
		request.setAttribute("ACTIVITIES_LIST", activitiess);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-activitiess-student.jsp");
		dispatcher.forward(request, response);
	}
}
