package com.Society.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.Society.login.bean.ChangePasswordBean;

/*
 * THIS IS AIDING DATABASE SUPPORT FOR CHANGING PASSWORD
 */
public class ChangePasswordDao {
	public boolean change(ChangePasswordBean changepasswordbean)
	{
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			String sql="update family set password='"+changepasswordbean.getPassword()+"' where username='"+changepasswordbean.getUsername()+"'";
			Statement stmt=connection.createStatement();
			stmt.executeUpdate(sql);
			status=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

}
