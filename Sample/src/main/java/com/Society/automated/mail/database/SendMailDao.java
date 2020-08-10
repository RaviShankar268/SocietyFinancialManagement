package com.Society.automated.mail.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * THIS CLASS AIDS IN DATABASE SUPPORT FOR SENDING MAIL
 */
public class SendMailDao {
	public int count()
	{
		int ct=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select count(*) from temp_db where checked='requested' and mail_sent='no'");
			if(rs.next())
				ct=rs.getInt(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ct;
	}
	public String IdnMail()
	{
		String name="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select apt_id,mail_id from temp_db where mail_sent='no' order by apt_id limit 1");
			if(rs.next())
			{
				String a=rs.getString(1);
				String b=rs.getString(2);
				name=a+" "+b;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return name;
	}
	public boolean Checkrequest(String apt_id)
	{
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			String sql="select * from temp_db where apt_id='"+apt_id+"' and checked='requested'";
			ResultSet rs=stmt.executeQuery(sql);
			status=rs.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public void setSent(String apt_id)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			String sql="update temp_db set mail_sent='yes' where apt_id='"+apt_id+"'";
			stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args)
	{
		//SendMailDao sd=new SendMailDao();
		
	
		
	}
}
