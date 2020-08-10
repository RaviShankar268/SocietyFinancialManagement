package com.Society.family.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Society.family.bean.FamilyBean;
import com.Society.family.database.FamilyRegisterDao;

/**
 * Servlet implementation class FamilyRegister
 * 
 * THIS CLASS IS FOR ADDING FAMILY
 * 
 */
public class FamilyRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	final static Logger logger=LoggerFactory.getLogger(FamilyRegister.class); 
	
	FamilyRegisterDao familyregisterdao;
	
	public void init()
	{
		familyregisterdao=new FamilyRegisterDao();
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
		String apt_id=request.getParameter("apt_id");
		String first_man=request.getParameter("first_man");
		String first_woman=request.getParameter("first_woman");
		String number_people=request.getParameter("no_people");
		String date_joining=request.getParameter("doj");
		String email_id=request.getParameter("email_id");
		String phone=request.getParameter("phone");
		String user=request.getParameter("uname");
		String pass=request.getParameter("pass");
		FamilyBean familybean=new FamilyBean();
		familybean.setApt_id(apt_id);
		familybean.setFirst_man(first_man);
		familybean.setFirst_woman(first_woman);
		familybean.setNumber_people(number_people);
		familybean.setDate_joining(date_joining);
		familybean.setEmail_id(email_id);
		familybean.setPhone(phone);
		familybean.setUser(user);
		familybean.setPass(pass);
		PrintWriter out=response.getWriter();
		try {
			if(familyregisterdao.insertion(familybean))
			{
				logger.info("Apartment {} is added",apt_id);
				out.println("success");
				
			}
			else
			{
				
				logger.error("Apartment {} could not be added",apt_id);
				out.println("Error Writing data into DB");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
