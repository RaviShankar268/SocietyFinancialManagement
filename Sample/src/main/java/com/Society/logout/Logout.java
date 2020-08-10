package com.Society.logout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servlet implementation class Logout
 * 
 * THIS IS AIDING DATABASE SUPPORT FOR ADMIN LOGOUT
 * 
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	final static Logger logger=LoggerFactory.getLogger(Logout.class); 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.removeAttribute("name");
		session.removeAttribute("sql1");
		session.removeAttribute("sql2");
		session.removeAttribute("sql3");
		session.removeAttribute("resultset");
		session.invalidate();
		logger.info("ADMIN LOGGED OUT");
		response.sendRedirect("adminLogin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
