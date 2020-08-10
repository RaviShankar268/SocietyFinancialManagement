package com.Society.adwork.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewOutward1
 * 
 * THIS CLASS IS FOR SENDING QUERY - SORTING DATA BETWEEN TWO DATES FROM OUTWARD DB
 * 
 */
public class ViewOutward1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOutward1() {
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
		String date1=request.getParameter("date1");
		String date2=request.getParameter("date2");
		String sql="select * from outward where date between '"+date1+"' and '"+date2+"'";
		HttpSession session=request.getSession();
		session.removeAttribute("sql2");
		session.setAttribute("sql2", sql);
		response.sendRedirect("viewOutward.jsp");
	}

}
