package com.Society.adwork.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.Society.adwork.bean.GoOutwardBean;

/*
 * THIS CLASS IS FOR ADDING OUTWARD PAYMENT AND UPDATING THE PAYMENT TO PAYMENT DB
 */
public class GoOutwardDao {
	public boolean insert(GoOutwardBean gooutwardbean)
	{
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			PreparedStatement preparedstatement=connection.prepareStatement("insert into outward values(?,?,?,?)");
			preparedstatement.setString(1, gooutwardbean.getType());
			preparedstatement.setString(2, gooutwardbean.getAmount());
			preparedstatement.setString(3, gooutwardbean.getTo());
			preparedstatement.setString(4, gooutwardbean.getDate());
			preparedstatement.executeUpdate();
			PreparedStatement preparedstatement1=connection.prepareStatement("insert into payment values(?,?,?,?)");
			preparedstatement1.setString(1, gooutwardbean.getApt_id());
			preparedstatement1.setString(2, gooutwardbean.getDate());
			preparedstatement1.setString(3, gooutwardbean.getTime());
			preparedstatement1.setString(4, gooutwardbean.getAmount());
			preparedstatement1.executeUpdate();
			
			status=true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

}
