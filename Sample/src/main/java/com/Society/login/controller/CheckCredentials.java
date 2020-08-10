package com.Society.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Society.login.bean.CheckCredentialsBean;
import com.Society.login.database.CheckCredentialsDao;

/**
 * Servlet implementation class CheckCredentials
 * 
 * THIS IS FOR CHECKING SECURITY FOR PASSWORD CHANGE
 * 
 */
public class CheckCredentials extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCredentials() {
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
		String username=request.getParameter("username");
		String doj=request.getParameter("doj");
		System.out.println(doj);
		CheckCredentialsBean checkcredentialsbean=new CheckCredentialsBean();
		checkcredentialsbean.setUsername(username);
		checkcredentialsbean.setDoj(doj);
		CheckCredentialsDao checkcredentialsdao=new CheckCredentialsDao();
		if(checkcredentialsdao.check(checkcredentialsbean))
		{
			HttpSession session=request.getSession();
			session.setAttribute("name", username);
			response.sendRedirect("changePassword.jsp");
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.println("CREDENTIALS MISMATCH");
		}
	}

}
