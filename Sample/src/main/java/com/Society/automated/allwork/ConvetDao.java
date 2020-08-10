package com.Society.automated.allwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * THIS CLASS IS RESPONSIBLE FOR AIDING SCHEDULER OPERATIONS AND SETTING DATE VALUES
 */

public class ConvetDao {
	public void copy()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			String sql="insert into perm_db select apt_id,month,year,monthlymain,seasoncharge,addcharge,latefee,total,checked,pay_status,date_paid,mail_sent from temp_db";
			int i=stmt.executeUpdate(sql);
			System.out.println(i+" rows affected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void changeStatus()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			
			String sql="update temp_db set mail_sent='no' where mail_sent='yes'";
			int i=stmt.executeUpdate(sql);
			System.out.println(i+" rows affected");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void monthToyear()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			String sql="insert into monthToyear select month,year,total from temp_db where checked='accepted'";
			int i=stmt.executeUpdate(sql);
			System.out.println(i+" rows affected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void umail()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			String date=java.time.LocalDate.now().toString();
			Statement stmt=connection.createStatement();
			int i=stmt.executeUpdate("insert into mail values('"+date+"')");
			System.out.println(i+" rows affected");
			System.out.println("MAIL DATE updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public boolean mc()
	{
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			String date=java.time.LocalDate.now().toString();
			Statement stmt=connection.createStatement();
			String sql="select * from mc where date='"+date+"'";
			ResultSet rs=stmt.executeQuery(sql);
			status=rs.next();
		}
		catch(Exception e)
		{
			
		}
		
		return status;
	}
	
	public void setmc()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			String date=java.time.LocalDate.now().toString();
			Statement stmt=connection.createStatement();
			String sql="insert into mc values('"+date+"')";
			stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void delete()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			String sql="delete from temp_db";
			stmt.executeUpdate(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean checkMailDate()
	{
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			String date=java.time.LocalDate.now().toString();
			Statement stmt=connection.createStatement();
			String sql="select * from mail where date='"+date+"'";
			ResultSet rs=stmt.executeQuery(sql);
			status=rs.next();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static void main(String args[])
	{
		//ConvetDao cd=new ConvetDao();
		//cd.changeStatus();
		//cd.monthToyear();
		//cd.copy();
		//cd.mail();
	}

}
