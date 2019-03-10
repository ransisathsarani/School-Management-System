package com.oop.monarch;

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
 * Servlet implementation class AttendanceControllerServlet
 */
@WebServlet("/AttendanceControllerServlet")
public class AttendanceControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	
private AttendanceDbUtil attendanceDbUtil;
	
	@Resource(name="jdbc/monarch")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create attendance db util ... and pass in the conn pool / datasource
		try {
			attendanceDbUtil = new AttendanceDbUtil(dataSource);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}

    public AttendanceControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			try {
				
				//read the "command" parameter
				String theCommand = request.getParameter("command");
				
				//if the command is missing, then default to listing 
				if(theCommand == null) {
					theCommand = "LIST";
				}
				
				//route to the appropriate method
				switch(theCommand) {
				
				case "LIST":
					listAttendances(request,response);
					break;
					
				case "ADD":
					addAttendance(request,response);
					break;
					
				case "LOAD":
					loadAttendance(request,response);
					break;
					
				case "UPDATE":
					updateAttendance(request,response);
					break;
					
				case "DELETE" :
					deleteAttendance(request,response);
					break;
					
				default:
					listAttendances(request,response);
					
				}

			} 
			catch (Exception exc) {
				throw new ServletException(exc);
			}
			
		}


		private void deleteAttendance(HttpServletRequest request, HttpServletResponse response) throws Exception {

					//read level2 id from the form data
					String theAttendanceId = request.getParameter("attendanceId");
					
					// delete  from database
					attendanceDbUtil.deleteAttendance(theAttendanceId);
					
					//send them back to the list level2s page
					listAttendances(request,response);
		}


		private void updateAttendance(HttpServletRequest request, HttpServletResponse response) throws Exception{

			//read level2 info from form data
			String ids=request.getParameter("attendanceId");
			int id = Integer.parseInt(ids);
			String year = request.getParameter("year");
			String classroom = request.getParameter("classroom");
			String date = request.getParameter("date");
			String present = request.getParameter("present");
			String absent = request.getParameter("absent");
			
			//create a new level2 object
			Attendance theAttendance = new Attendance(id, year, classroom, date, present , absent);
			try {
			//perform update on database
			attendanceDbUtil.updateAttendance(theAttendance);
			
			//send them back to the "list level2s" page
			listAttendances(request,response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}


		private void loadAttendance(HttpServletRequest request, HttpServletResponse response) throws Exception {

			//read level2 id from form data
			String theAttendanceId = request.getParameter("attendanceId");
			
			//get level2 from database (db util)
			Attendance theAttendance= attendanceDbUtil.getAttendance(theAttendanceId);
			
			//place level2 in the request atrribute
			request.setAttribute("THE_ATTENDANCE", theAttendance);
			
			// send to jsp page: update-level2-form.jsp
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/update-attendance-form.jsp");
			dispatcher.forward(request, response);
			
		}


		private void addAttendance(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			// read level2 info from form data
			String year = request.getParameter("year");
			String classroom = request.getParameter("classroom");
			String date = request.getParameter("date");
			String present = request.getParameter("present");	
			String absent = request.getParameter("absent");		

			
			// create a new level2 object
			Attendance theAttendance = new Attendance(year, classroom,date ,present, absent);
			
			// add the level2 to the database
			attendanceDbUtil.addAttendance(theAttendance);
			
			//send back to main page (level2 list)
			listAttendances(request,response);
		}

		private void listAttendances(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			// get level2s from db util
			List<Attendance> attendances = attendanceDbUtil.getAttendances();
			
			//add level2s to the request
			request.setAttribute("ATTENDANCE_LIST", attendances);
			
			//send to JSP page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-attendances.jsp");
			dispatcher.forward(request, response);
		}
	}


