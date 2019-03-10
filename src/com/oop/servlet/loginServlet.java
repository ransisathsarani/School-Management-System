package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.model.Login;
import com.oop.model.Login_funtions;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("email");
		String password = request.getParameter("pw");
		
		Login lg = new Login();
		lg.setUsername(username);
		lg.setPassword(password);
		
		Login_funtions lgf = new Login_funtions();
		
		try {
			
			String validate = lgf.validateUser(lg);
			if(validate.equals("Admin")) {
				
				System.out.println("Admin's home");
				HttpSession session = request.getSession();
				session.setAttribute("Admin", username);
				request.setAttribute("username", username);
				
				request.getRequestDispatcher("/SIMS_interface.jsp").forward(request, response);
				
				
			}
			else if(validate.equals("Academic_Staff")) {
				
				System.out.println("Teacher's home");
				HttpSession session = request.getSession();
				session.setAttribute("Academic_Staff", username);
				request.setAttribute("username", username);
				
				request.getRequestDispatcher("/Teacher_home.jsp").forward(request, response);
			}
			else if(validate.equals("Level_1")) {
				
				System.out.println("Level 1 home");
				HttpSession session = request.getSession();
				session.setAttribute("Login_1", username);
				request.setAttribute("username", username);
				
				request.getRequestDispatcher("/StudentAffair_L1.jsp").forward(request, response);
			}
			else if(validate.equals("Level_2")) {
				
				System.out.println("Level 2 home");
				HttpSession session = request.getSession();
				session.setAttribute("Level_2", username);
				request.setAttribute("username", username);
				
				request.getRequestDispatcher("/StudentAffair.jsp").forward(request, response);
			}
			else if(validate.equals("Level_3")) {
				
				System.out.println("Level 3 home");
				HttpSession session = request.getSession();
				session.setAttribute("Level_3", username);
				request.setAttribute("username", username);
				
				request.getRequestDispatcher("/StudentAffair_L3.jsp").forward(request, response);
			}

			else {
				
				System.out.println("Error:" + validate);
				request.setAttribute("errMessage", validate);
			}
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		
		
		
	}

}
