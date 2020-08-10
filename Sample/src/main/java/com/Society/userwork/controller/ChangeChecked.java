package com.Society.userwork.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Society.userwork.bean.ChangeCheckedBean;
import com.Society.userwork.database.ChangeCheckedDao;

/**
 * Servlet implementation class ChangeChecked
 * 
 * THIS IS FOR UPDATING ACCEPTED USER STATUS
 * 
 */
public class ChangeChecked extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ChangeCheckedDao changecheckeddao;
    
    public void init()
    {
    	changecheckeddao=new ChangeCheckedDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value=request.getParameter("c");
		String apt_id=request.getParameter("id");
		ChangeCheckedBean changecheckedbean=new ChangeCheckedBean();
		changecheckedbean.setChecked(value);
		changecheckedbean.setApt_id(apt_id);
		PrintWriter out=response.getWriter();
		if(value.equals("accepted"))
		{
			String amount=request.getParameter("a");
			String date=java.time.LocalDate.now().toString();
			String time=java.time.LocalTime.now().toString();
			changecheckedbean.setAmount(amount);
			changecheckedbean.setDate(date);
			changecheckedbean.setTime(time);
			changecheckedbean.setPay_status("paid");
			changecheckedbean.setMail_sent("noneed");
			if(changecheckeddao.insert(changecheckedbean))
			{
				out.println("DONE UPDATING");
			}
			else
			{
				out.println("ERROR");
			}
		}
		else if(value.equals("rejected"))
		{
			if(changecheckeddao.insert1(changecheckedbean))
			{
				out.println("DONE UPDATING");
			}
			else
			{
				out.println("ERROR");
			}
			
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
