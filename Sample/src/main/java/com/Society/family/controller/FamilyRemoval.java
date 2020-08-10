package com.Society.family.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Society.family.bean.FamilyRemoveBean;
import com.Society.family.database.FamilyRemoveDao;

/**
 * Servlet implementation class FamilyRemoval
 * 
 * THIS CLASS IS DELETING FAMILY
 * 
 */
public class FamilyRemoval extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger=LoggerFactory.getLogger(FamilyRemoval.class); 
       
	FamilyRemoveDao familyremovedao;
	
	public void init()
	{
		familyremovedao=new FamilyRemoveDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String apt_id=request.getParameter("apt_id");
		apt_id=apt_id.replaceAll(" ", "");
		FamilyRemoveBean familyremovebean=new FamilyRemoveBean();
		familyremovebean.setApt_id(apt_id);
		PrintWriter out=response.getWriter();
		if(familyremovedao.remove(familyremovebean))
		{
			logger.info("Apartment {} is removed",apt_id);
			out.println("REMOVED");
		}
		else
		{
			logger.error("Apartment {} could not be removed",apt_id);
			out.println("Error removing");
		}
		

	}

}
