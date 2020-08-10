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
 * Servlet Filter implementation class EditFilter
 * 
 * FILTER FOR CHECKING CONTENTS FOR EDITING FAMILY
 * 
 */
public class EditFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EditFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		String id=req.getParameter("id");
		String str=req.getParameter("data");
		id=id.toUpperCase();
		PrintWriter out=res.getWriter();
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			PreparedStatement preparedstatement=connection.prepareStatement("select * from family where apt_id=?");
			preparedstatement.setString(1, id);
			ResultSet rs=preparedstatement.executeQuery();
			status=rs.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(status)
		{
			status=false;
			if(str.equalsIgnoreCase("apt id"))
			{
				status=true;
			}
			else if(str.equalsIgnoreCase("first man"))
			{
				status=true;
			}
			else if(str.equalsIgnoreCase("first woman"))
			{
				status=true;
			}
			else if(str.equalsIgnoreCase("persons"))
			{	
				status=true;
			}
			else if(str.equalsIgnoreCase("doj"))
			{
				status=true;
			}
			else if(str.equalsIgnoreCase("phone"))
			{
				status=true;
			}
			else if(str.equalsIgnoreCase("mail id"))
			{
				status=true;
			}
			if(status)
			{	
				chain.doFilter(request, response);
			}
			else
			{
				out.println("DATA FIELD DOES NOT EXIST");
			}
			
		}
		else
		{	
			out.println("APT ID IS WRONG");
		}
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
