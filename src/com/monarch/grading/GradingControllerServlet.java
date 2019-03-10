package com.monarch.grading;

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
 * Servlet implementation class GradingControllerServlet
 */
@WebServlet("/GradingControllerServlet")
public class GradingControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private GradingDbUtil gradingDbUtil;
	
	@Resource(name="jdbc/monarch")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create grading db util ... and pass in the conn pool / datasource
		try {
			gradingDbUtil = new GradingDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}

 	
 	
    public GradingControllerServlet() {
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
			
			//if the command is missing, then default to listing gradings
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listGrading(request,response);
				break;
				
			case "ADD":
				addGrading(request,response);
				break;
				
			case "LOAD":
				loadGrading(request,response);
				break;
				
			case "UPDATE":
				updateGrading(request,response);
				break;
				
			case "DELETE" :
				deleteGrading(request,response);
				break;
				
			default:
				listGrading(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteGrading(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read grading id from the form data
				String theGradingId = request.getParameter("gradingId");
				
				// delete grading from database
				gradingDbUtil.deleteGrading(theGradingId);
				
				//send them back to the list gradings page
				listGrading(request,response);
	}


	private void updateGrading(HttpServletRequest request, HttpServletResponse response){

		//read grading info from form data
		String ids = request.getParameter("gradingId");
		int id = Integer.parseInt(ids);
		String SID = request.getParameter("SID");
		String level = request.getParameter("level");
		String examID = request.getParameter("examID");
		String sub1 = request.getParameter("sub1");
		String sub2 = request.getParameter("sub2");
		String sub3 = request.getParameter("sub3");
		String sub4 = request.getParameter("sub4");
		String sub5 = request.getParameter("sub5");
		
		
		//create a new grading object
		Grading theGrading = new Grading(id, SID, level, examID, sub1, sub2, sub3, sub4, sub5);		
		
		try {
			
			//perform update on database
			gradingDbUtil.updateGrading(theGrading);
			
			//send them back to the "list gradings" page
			listGrading(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadGrading(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read grading id from form data
		String theGradingId = request.getParameter("gradingId");
		
		//get grading from database (db util)
		Grading theGrading = gradingDbUtil.getGrading(theGradingId);
		
		//place grading in the request atrribute
		request.setAttribute("THE_GRADING", theGrading);
		
		// send to jsp page: update-grading-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-grading-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addGrading(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read grading info from form data
		String SID = request.getParameter("SID");
		String level = request.getParameter("level");
		String examID = request.getParameter("examID");
		String sub1 = request.getParameter("sub1");
		String sub2 = request.getParameter("sub2");
		String sub3 = request.getParameter("sub3");
		String sub4 = request.getParameter("sub4");
		String sub5 = request.getParameter("sub5");
		
		// create a new grading object
		Grading theGrading = new Grading(SID, level, examID, sub1, sub2, sub3, sub4, sub5);
		
		// add the grading to the database
		gradingDbUtil.addGrading(theGrading);
		
		//send back to main page (grading list)
		listGrading(request,response);
	}

	private void listGrading(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get gradings from db util
		List<Grading> gradings = gradingDbUtil.getGrading();
		
		//add gradings to the request
		request.setAttribute("GRADING_LIST", gradings);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-gradings.jsp");
		dispatcher.forward(request, response);
	}

}
		
		

