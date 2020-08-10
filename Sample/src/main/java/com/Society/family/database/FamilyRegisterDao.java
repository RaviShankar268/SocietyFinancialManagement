package com.Society.family.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import com.Society.family.bean.FamilyBean;

/*
 * THIS AIDS IN DATABASE SUPPORT FOR ADDING FAMILY
 */
public class FamilyRegisterDao {
	public boolean insertion(FamilyBean familybean) throws ClassNotFoundException
	{
		boolean status=false;
		
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			PreparedStatement preparedstatement=connection.prepareStatement("insert into family values(?,?,?,?,?,?,?,?,?)");
			preparedstatement.setString(1, familybean.getApt_id());
			preparedstatement.setString(2, familybean.getFirst_man());
			preparedstatement.setString(3, familybean.getFirst_woman());
			preparedstatement.setString(4, familybean.getNumber_people());
			preparedstatement.setString(5, familybean.getDate_joining());
			preparedstatement.setString(6, familybean.getPhone());
			preparedstatement.setString(7, familybean.getEmail_id());
			preparedstatement.setString(8, familybean.getUser());
			preparedstatement.setString(9, familybean.getPass());
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
