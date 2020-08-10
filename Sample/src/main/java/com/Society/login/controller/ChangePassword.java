package com.Society.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Society.login.bean.ChangePasswordBean;
import com.Society.login.database.ChangePasswordDao;

/**
 * Servlet implementation class ChangePassword
 * 
 * THIS IS FOR CHANGING PASSWORD FOR USERS
 * 
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("password1");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("name");
		ChangePasswordBean changepasswordbean=new ChangePasswordBean();
		changepasswordbean.setUsername(username);
		changepasswordbean.setPassword(password);
		ChangePasswordDao changepassworddao=new ChangePasswordDao();
		if(changepassworddao.change(changepasswordbean))
		{
			session.removeAttribute("name");
			response.sendRedirect("userLogin.jsp");
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.println("ERROR UPDATING");
		}
	}

}
