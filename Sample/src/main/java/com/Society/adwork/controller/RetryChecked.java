package com.Society.adwork.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Society.adwork.bean.RetryCheckedBean;
import com.Society.adwork.database.RetryCheckedDao;

/**
 * Servlet implementation class RetryChecked
 * 
 * THIS CLASS IS FOR SENDING RETRY REQUESTS TO REJECTED INWARD REQUESTS
 * 
 */
public class RetryChecked extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger=LoggerFactory.getLogger(RetryChecked.class); 
       
    RetryCheckedDao retrycheckeddao;
    public void init()
    {
    	retrycheckeddao=new RetryCheckedDao();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String apt_id=request.getParameter("a");
		RetryCheckedBean retrycheckedbean=new RetryCheckedBean();
		retrycheckedbean.setApt_id(apt_id);
		PrintWriter out=response.getWriter();
		if(retrycheckeddao.change(retrycheckedbean))
		{
			logger.info("Inward request for {} sent again",apt_id);
			out.println("SENT");
			
		}
		else
		{
			logger.error("Inward request for {} could not be sent",apt_id);
			out.println("ERROR");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
