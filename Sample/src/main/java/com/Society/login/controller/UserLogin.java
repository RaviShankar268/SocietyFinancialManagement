package com.Society.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Society.login.bean.UserBean;
import com.Society.login.database.UserDao;

/**
 * Servlet implementation class UserLogin
 * 
 * THIS IS FOR USER LOGIN
 * 
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    UserDao userdao;
    
    public void init()
    {
    	userdao=new UserDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserBean userbean=new UserBean();
		userbean.setUsername(username);
		userbean.setPassword(password);
		if(userdao.validate(userbean))
		{
			HttpSession session=request.getSession();
			session.setAttribute("uname", username);
			String id=userdao.getId(username);
			session.setAttribute("id", id);
			response.sendRedirect("welcomeUser.jsp");
		}
		else
		{
			response.sendRedirect("userLogin.jsp");
		}
		
	}

}
