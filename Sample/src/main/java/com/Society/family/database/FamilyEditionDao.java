package com.Society.family.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.Society.family.bean.FamilyEditionBean;

/*
 * THIS AIDS IN DATABASE SUPPORT FOR EDITING FAMILY
 */
public class FamilyEditionDao {
	public boolean edit(FamilyEditionBean familyeditionbean)
	{
		boolean status=false;
		String sql="update family set "+familyeditionbean.getSyntax()+"='"+familyeditionbean.getData()+"' where apt_id ='"+familyeditionbean.getId()+"';";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
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
