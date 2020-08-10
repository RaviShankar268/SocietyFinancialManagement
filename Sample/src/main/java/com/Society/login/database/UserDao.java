package com.Society.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Society.login.bean.UserBean;

/*
 * THIS IS AIDING DATABASE SUPPORT FOR USER LOGIN
 */
public class UserDao {
	
	public boolean validate(UserBean userbean)
	{
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			PreparedStatement preparedstatement=connection.prepareStatement("select * from family where username=? and password=?");
			preparedstatement.setString(1, userbean.getUsername());
			preparedstatement.setString(2, userbean.getPassword());
			ResultSet rs=preparedstatement.executeQuery();
			status=rs.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	public String getId(String uname)
	{
		String id="";
		String sql="select apt_id from family where username='"+uname+"'";
		//System.out.println("INSIDE GETID");
		//System.out.println(sql);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
				id=rs.getString("apt_id");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.println("APT ID :"+id);
		return id;
		
	}

}
