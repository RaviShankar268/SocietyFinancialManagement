package com.Society.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Society.login.bean.AdminBean;

/*
 * THIS IS AIDING DATABASE SUPPORT FOR ADMIN LOGIN
 */
public class AdminDao {
	public boolean validate(AdminBean ad) throws ClassNotFoundException
	{
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			PreparedStatement preparedstatement=conn.prepareStatement("select * from adminlogin where username=? and password=?");
			preparedstatement.setString(1, ad.getUsername());
			preparedstatement.setString(2, ad.getPassword());
			ResultSet rs=preparedstatement.executeQuery();
			status=rs.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

}
