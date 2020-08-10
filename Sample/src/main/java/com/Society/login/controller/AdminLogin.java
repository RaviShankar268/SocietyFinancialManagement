package com.Society.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Society.automated.scheduler.MyJobs;
import com.Society.login.bean.AdminBean;
import com.Society.login.database.AdminDao;

/**
 * Servlet implementation class AdminLogin
 * 
 * THIS IS FOR ADMIN LOGIN PURPOSE
 * 
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger=LoggerFactory.getLogger(AdminLogin.class);  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	AdminDao admindao;
	public void init()
	{
		admindao=new AdminDao();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		AdminBean ad=new AdminBean();
		ad.setUsername(uname);
		ad.setPassword(pass);
		try {
		if(admindao.validate(ad))
		{
			HttpSession session=request.getSession();
			session.setAttribute("name", uname);
			MyJobs myjobs=new MyJobs();
			logger.info("ADMIN LOGGED IN");
			myjobs.schedule();
			System.out.println("SCHEDULER HAPPENING");
			response.sendRedirect("welcome.jsp");
		}
		else
		{
			response.sendRedirect("adminLogin.jsp");
		}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

}
