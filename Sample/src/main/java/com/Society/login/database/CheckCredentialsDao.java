package com.Society.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Society.login.bean.CheckCredentialsBean;

/*
 * THIS IS AIDING DATABASE SUPPORT FOR CHECKING CREDENTIALS
 */
public class CheckCredentialsDao {
	public boolean check(CheckCredentialsBean checkcredentialsbean)
	{
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			String sql="select * from family where username='"+checkcredentialsbean.getUsername()+"' and dateofjoin='"+checkcredentialsbean.getDoj()+"'";
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			status=rs.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

}
