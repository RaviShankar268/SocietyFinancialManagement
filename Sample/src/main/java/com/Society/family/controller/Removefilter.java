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
 * Servlet Filter implementation class Removefilter
 */
public class Removefilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * 
	 * CONTENT CHECKING FILTER FOR REMOVING FAMILY
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		String nameId=req.getParameter("apt_id");
		nameId=nameId.replaceAll(" ", "");
		int len=nameId.length();
		boolean status=true;
		PrintWriter out=res.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
		if(len>4)
		{
			String[] s=nameId.split(",");
			for(int i=0;i<s.length;i++)
			{
				PreparedStatement preparedstatement=connection.prepareStatement("select * from family where apt_id=?");
				preparedstatement.setString(1, s[i]);
				ResultSet rs=preparedstatement.executeQuery();
				status=rs.next();
				if(!status)
				{
					out.println("Invalid APT ID");
					break;
				}
			}
			if(status)
			{
				chain.doFilter(request, response);
			}
			
		}
		else
		{
			PreparedStatement preparedstatement=connection.prepareStatement("select * from family where apt_id=?");
			preparedstatement.setString(1, nameId);
			ResultSet rs=preparedstatement.executeQuery();
			status=rs.next();
			if(status)
			{
				chain.doFilter(request, response);
			}
			else
			{
				out.println("INVALID APT ID");
			}
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
