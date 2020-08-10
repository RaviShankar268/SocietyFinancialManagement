package com.Society.family.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class IDfilter
 * 
 * FILTER FOR CHECKING APARTMENT ID
 * 
 */
public class IDfilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest) request;
		String id=req.getParameter("apt_id");
		String name=req.getParameter("uname");
		boolean status=false;
		HttpServletResponse res=(HttpServletResponse)response;
		PrintWriter out=res.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			PreparedStatement preparedstatement=connection.prepareStatement("select * from family where username=? or apt_id=?");
			preparedstatement.setString(1, name);
			preparedstatement.setString(2, id);
			ResultSet rs=preparedstatement.executeQuery();
			status=rs.next();
		}
		catch(Exception e)
		{
			
		}
		if(status)
		{
			out.println("Username or Apartment Id already exists");
		}
		else
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
