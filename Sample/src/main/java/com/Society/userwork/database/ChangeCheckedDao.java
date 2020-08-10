package com.Society.userwork.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.Society.userwork.bean.ChangeCheckedBean;

/*
 * THIS IS FOR CHECKED STATUS DATABASE
 */
public class ChangeCheckedDao {
	public boolean insert(ChangeCheckedBean changecheckedbean)
	{
		System.out.println("INSIDE INSERT");
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			String sql="update temp_db set checked=?,pay_status=?,date_paid=?,mail_sent=? where apt_id='"+changecheckedbean.getApt_id()+"'";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setString(1, changecheckedbean.getChecked());
			preparedstatement.setString(2, changecheckedbean.getPay_status());
			preparedstatement.setString(3, changecheckedbean.getDate());
			preparedstatement.setString(4, changecheckedbean.getMail_sent());
			preparedstatement.executeUpdate();
			PreparedStatement preparedstatement1=connection.prepareStatement("insert into payment(apt_id,date,time,amount) values(?,?,?,?)");
			preparedstatement1.setString(1, changecheckedbean.getApt_id());
			preparedstatement1.setString(2, changecheckedbean.getDate());
			preparedstatement1.setString(3, changecheckedbean.getTime());
			preparedstatement1.setString(4, changecheckedbean.getAmount());
			preparedstatement1.executeUpdate();
			status=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
		
	}
	public boolean insert1(ChangeCheckedBean changecheckedbean)
	{
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			String sql="update temp_db set checked=? where apt_id='"+changecheckedbean.getApt_id()+"'";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setString(1, changecheckedbean.getChecked());
			preparedstatement.executeUpdate();
			status=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

}
