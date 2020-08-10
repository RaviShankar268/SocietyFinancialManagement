package com.Society.adwork.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Month;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Society.adwork.bean.AddPaymentBean;
import com.Society.adwork.database.AddPaymentDao;

/**
 * Servlet implementation class AddPayment
 * 
 * THIS CLASS IS FOR ADDING MONTHLY OUTWARD INWARD PAYMENT REQUEST
 * 
 */
public class AddPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger=LoggerFactory.getLogger(AddPayment.class); 
       
    AddPaymentDao addpaymentdao;
    public void init()
    {
    	addpaymentdao=new AddPaymentDao();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String date=request.getParameter("month");
		String monthlymain=request.getParameter("monthlymain");
		String seasoncharge=request.getParameter("seasoncharge");
		String addcharge=request.getParameter("addcharge");
		String total=request.getParameter("total");
		Month month=Month.of(02);
		String m=month.toString();
		AddPaymentBean addpaymentbean=new AddPaymentBean();
		addpaymentbean.setMonth(m);
		addpaymentbean.setYear(date.substring(0, 4));
		addpaymentbean.setMonthlymain(monthlymain);
		addpaymentbean.setSeasoncharge(seasoncharge);
		addpaymentbean.setAddcharge(addcharge);
		addpaymentbean.setTotal(total);
		PrintWriter out=response.getWriter();
		if(addpaymentdao.insert(addpaymentbean))
		{
			logger.info("Monthly payment amounting {} for the month {} added",total,month);
			out.println("INSERTED");
		}
		else
		{
			logger.error("Montly payment amounting {} for the month {} could not be added",total,month);
			out.println("ERROR INSERTING");	
		}
		
		
	}

}
