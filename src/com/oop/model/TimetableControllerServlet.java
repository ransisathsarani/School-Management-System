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
 * Servlet implementation class TimetableControllerServlet
 */
@WebServlet("/TimetableControllerServlet")
public class TimetableControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
private TimetableDbUtil timetableDbUtil;
	
	@Resource(name="jdbc/monarch")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create timetable db util ... and pass in the conn pool / datasource
		try {
			timetableDbUtil = new TimetableDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}
	
	
    public TimetableControllerServlet() {
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
			
			//if the command is missing, then default to listing timetables
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "LIST":
				listTimetable(request,response);
				break;
				
			case "ADD":
				addTimetable(request,response);
				break;
				
			case "LOAD":
				loadTimetable(request,response);
				break;
				
			case "UPDATE":
				updateTimetable(request,response);
				break;
				
			case "DELETE" :
				deleteTimetable(request,response);
				break;
				
			default:
				listTimetable(request,response);
				
			}

		} 
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}


	private void deleteTimetable(HttpServletRequest request, HttpServletResponse response) throws Exception {

				//read timetable id from the form data
				String theTimetableId = request.getParameter("timetableId");
				
				// delete timetable from database
				timetableDbUtil.deleteTimetable(theTimetableId);
				
				//send them back to the list timetables page
				listTimetable(request,response);
	}


	private void updateTimetable(HttpServletRequest request, HttpServletResponse response){

		//read timetable info from form data
		String ids = request.getParameter("timetableId");
		int id = Integer.parseInt(ids);
		String ttid = request.getParameter("ttid");
		String subid_1 = request.getParameter("subid_1");
		String time_1 = request.getParameter("time_1");
		
		String subid_2 = request.getParameter("subid_2");
		String time_2 = request.getParameter("time_2");
		
		String subid_3 = request.getParameter("subid_3");
		String time_3 = request.getParameter("time_3");
		
		String subid_4 = request.getParameter("subid_4");
		String time_4 = request.getParameter("time_4");
		
		String subid_5 = request.getParameter("subid_5");
		String time_5 = request.getParameter("time_5");
		
		String subid_6 = request.getParameter("subid_6");
		String time_6 = request.getParameter("time_6");
		
		String subid_7 = request.getParameter("subid_7");
		String time_7 = request.getParameter("time_7");
		
		String subid_8 = request.getParameter("subid_8");
		String time_8 = request.getParameter("time_8");
		
		
		//create a new timetable object
		Timetable theTimetable = new Timetable(id, ttid, subid_1, time_1,   subid_2, time_2,  subid_3, time_3,    subid_4, time_4,  subid_5,  time_5,  subid_6,  time_6,   subid_7,  time_7,  subid_8,  time_8);
		
		
		try {
			
			//perform update on database
			timetableDbUtil.updateTimetable(theTimetable);
			
			//send them back to the "list timetables" page
			listTimetable(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void loadTimetable(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//read timetable id from form data
		String theTimetableId = request.getParameter("timetableId");
		
		//get timetable from database (db util)
		Timetable theTimetable = timetableDbUtil.getTimetable(theTimetableId);
		
		//place timetable in the request atrribute
		request.setAttribute("THE_TIMETABLE", theTimetable);
		
		// send to jsp page: update-timetable-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-timetable.jsp");
		dispatcher.forward(request, response);
		
	}


	private void addTimetable(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read timetable info from form data
		String ttid = request.getParameter("ttid");
		String subid_1 = request.getParameter("subid_1");
		String time_1 = request.getParameter("time_1");
		
		String subid_2 = request.getParameter("subid_2");
		String time_2 = request.getParameter("time_2");
		
		String subid_3 = request.getParameter("subid_3");
		String time_3 = request.getParameter("time_3");
		
		String subid_4 = request.getParameter("subid_4");
		String time_4 = request.getParameter("time_4");
		
		String subid_5 = request.getParameter("subid_5");
		String time_5 = request.getParameter("time_5");
		
		String subid_6 = request.getParameter("subid_6");
		String time_6 = request.getParameter("time_6");
		
		String subid_7 = request.getParameter("subid_7");
		String time_7 = request.getParameter("time_7");
		
		String subid_8 = request.getParameter("subid_8");
		String time_8 = request.getParameter("time_8");
			
		
		// create a new timetable object
		Timetable theTimetable = new Timetable(ttid, subid_1, time_1,   subid_2, time_2,  subid_3, time_3,    subid_4, time_4,  subid_5,  time_5,   subid_6,  time_6,   subid_7,  time_7,  subid_8,  time_8);
		
		// add the timetable to the database
		timetableDbUtil.addTimetable(theTimetable);
		
		//send back to main page (timetable list)
		listTimetable(request,response);
	}

	private void listTimetable(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// get timetables from db util
		List<Timetable> timetable = timetableDbUtil.getTimetable();
		
		//add timetables to the request
		request.setAttribute("TIMETABLE_LIST", timetable);
		
		//send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view-timetable.jsp");
		dispatcher.forward(request, response);
	}
	
	
}


