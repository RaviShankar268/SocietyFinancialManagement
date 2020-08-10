package com.Society.family.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class RemoveFilter1
 * 
 * CONTENT CHECKING FOR FAMILY REMOVAL
 * 
 */
public class RemoveFilter1 implements Filter {

    /**
     * Default constructor. 
     */
    public RemoveFilter1() {
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
		String value=req.getParameter("data1");
		HttpSession session=req.getSession();
		String syntax=(String)session.getAttribute("syn");
		boolean status=true;
		if(syntax.equalsIgnoreCase("no_people"))
		{
			status=false;
			int num=Integer.parseInt(value);
			if(num>0 && num<9)
			{
				System.out.println("TRUE");
				status=true;
			}
		}
		else if(syntax.equalsIgnoreCase("phone_num"))
		{
			status=false;
			long num1=Long.parseLong(value);
			long min=5656565656L;
			long max=9999999999L;
			if(num1>min && num1<max)
			{
				status=true;
			}
			
		}
		else
		{
			
		}
		if(status)
			chain.doFilter(request, response);
		else
		{
			PrintWriter out=res.getWriter();
			out.println("THE VALUES ARE NOT IN THE RANGE");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
