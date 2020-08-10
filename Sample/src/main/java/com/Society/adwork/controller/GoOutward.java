package com.Society.adwork.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Society.adwork.bean.GoOutwardBean;
import com.Society.adwork.database.GoOutwardDao;


/**
 * Servlet implementation class GoOutward
 * 
 * THIS CLASS IS FOR ADDING OUTWARD PAYMENT TO OUTWARD DB
 * 
 */
public class GoOutward extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger=LoggerFactory.getLogger(GoOutward.class); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoOutward() {
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
		String type=request.getParameter("type");
		String amount=request.getParameter("amount");
		String to=request.getParameter("people");
		String date=request.getParameter("date");
		String time=java.time.LocalTime.now().toString();
		GoOutwardBean gb=new GoOutwardBean();
		gb.setAmount(amount);
		gb.setDate(date);
		gb.setTime(time);
		gb.setTo(to);
		gb.setType(type);
		GoOutwardDao gooutwarddao=new GoOutwardDao();
		PrintWriter out=response.getWriter();
		if(gooutwarddao.insert(gb))
		{
			logger.info("Outward Payment of {} for {} added",amount,to);
			out.println("INSERTED");
		}
		else
		{
			logger.error("Outward Payment of {} for {} could not be added",amount,to);
			out.println("ERROR");
		}
		
	}

}
