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
 * Servlet implementation class ActivitiesControllerServlet
 */
@WebServlet("/ActivitiesControllerServlet")
public class ActivitiesControllerServlet extends HttpServlet {
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

	
	
	
	
    public ActivitiesControllerServlet() {
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
				
			case "LOAD":
				loadActivities(request,response);
				break;
				
			case "UPDATE":
				updateActivities(request,response);
				break;
				
			case "DELETE" :
				deleteActivities(request,response);
				break;
				
			default:
				listActivitiess(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteActivities(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read activities id from the form data
				String theActivitiesId = request.getParameter("activitiesId");
				
				// delete activities from database
				activitiesDbUtil.deleteActivities(theActivitiesId);
				
				//send them back to the list activitiess page
				listActivitiess(request,response);
	}


	private void updateActivities(HttpServletRequest request, HttpServletResponse response){

		//read activities info from form data
		String ids = request.getParameter("activitiesId");
		int id = Integer.parseInt(ids);
		String student_reg_num = request.getParameter("student_reg_num");
		String sports = request.getParameter("sports");
		String clubs = request.getParameter("clubs");
		String organizations = request.getParameter("organizations");
		
		//create a new activities object
		Activities theActivities = new Activities(id, student_reg_num, sports, clubs, organizations);
		
		
		try {
			
			//perform update on database
			activitiesDbUtil.updateActivities(theActivities);
			
			//send them back to the "list activitiess" page
			listActivitiess(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadActivities(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read activities id from form data
		String theActivitiesId = request.getParameter("activitiesId");
		
		//get activities from database (db util)
		Activities theActivities = activitiesDbUtil.getActivities(theActivitiesId);
		
		//place activities in the request atrribute
		request.setAttribute("THE_ACTIVITIES", theActivities);
		
		// send to jsp page: update-activities-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-activities-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void listActivitiess(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get activitiess from db util
		List<Activities> activitiess = activitiesDbUtil.getActivitiess();
		
		//add activitiess to the request
		request.setAttribute("ACTIVITIES_LIST", activitiess);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-activitiess.jsp");
		dispatcher.forward(request, response);
	}

	

}
