package com.Society.family.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Society.family.bean.FamilyEditionBean;
import com.Society.family.database.FamilyEditionDao;

/**
 * Servlet implementation class FamilyEdition
 * 
 * THIS CLASS IS FOR EDITING FAMILY CONTENTS
 */
public class FamilyEdition extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger=LoggerFactory.getLogger(FamilyEdition.class); 
       
    FamilyEditionDao familyeditiondao;
    
    public void init()
    {
    	familyeditiondao=new FamilyEditionDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("INSIDE FAMILY EDITION");
		String value=request.getParameter("data1");
		HttpSession session=request.getSession();
		String syntax=(String)session.getAttribute("syn");
		String id=(String)session.getAttribute("id");
		FamilyEditionBean familyeditionbean=new FamilyEditionBean();
		familyeditionbean.setData(value);
		familyeditionbean.setId(id);
		familyeditionbean.setSyntax(syntax);
		PrintWriter out=response.getWriter();
		if(familyeditiondao.edit(familyeditionbean))
		{
			session.removeAttribute("syn");
			session.removeAttribute("type");
			session.removeAttribute("id");
			session.removeAttribute("place");
			logger.info("Apartment {} is updated",id);
			out.println("UPDATE SUCCESS");
		}
		else
		{
			logger.error("Apartment {} could not be updated",id);
			out.println("UPDATE FAILED");
			
		}
		
	}

}
