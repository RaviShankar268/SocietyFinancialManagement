package com.Society.family.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FamilyCheck
 * 
 * THIS CLASS IS FOR CHECKING CONTENT MATCHING FROM ADMIN
 */
public class FamilyCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String str=request.getParameter("data");
		String pvr="",tp="";
		if(str.equalsIgnoreCase("apt id"))
		{
			pvr="apt_id";
			tp="text";
		}
		else if(str.equalsIgnoreCase("first man"))
		{
			pvr="first_man";
			tp="text";
		}
		else if(str.equalsIgnoreCase("first woman"))
		{
			pvr="first_woman";
			tp="text";
		}
		else if(str.equalsIgnoreCase("persons"))
		{
			pvr="no_people";
			tp="number";
		}
		else if(str.equalsIgnoreCase("doj"))
		{
			pvr="dateofjoin";
			tp="date";
		}
		else if(str.equalsIgnoreCase("phone"))
		{
			pvr="phone_num";
			tp="number";
		}
		else if(str.equalsIgnoreCase("mail id"))
		{
			pvr="mail_id";
			tp="email";
		}
		HttpSession session=request.getSession();
		session.setAttribute("syn", pvr);
		session.setAttribute("type", tp);
		session.setAttribute("id", id);
		response.sendRedirect("editFamily1.jsp");
		
	}

}
