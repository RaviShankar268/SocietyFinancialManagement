package com.Society.family.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.Society.family.bean.FamilyRemoveBean;

/*
 * THIS AIDS IN DATABASE SUPPORT FOR REMOVING FAMILY
 */
public class FamilyRemoveDao {
	public boolean remove(FamilyRemoveBean familyremovebean)
	{
		boolean status=false;
		int len=familyremovebean.getApt_id().length();
		if(len>4)
		{
			String[] s=familyremovebean.getApt_id().split(",");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
				for(int i=0;i<s.length;i++)
				{
					PreparedStatement preparedstatement=connection.prepareStatement("delete from family where apt_id=?");
					preparedstatement.setString(1, s[i]);
					preparedstatement.executeUpdate();
				}
				status=true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
				PreparedStatement preparedstatement=connection.prepareStatement("delete from family where apt_id=?");
				preparedstatement.setString(1, familyremovebean.getApt_id());
				preparedstatement.executeUpdate();
				status=true;
			}
			catch(Exception e)
			{
				e.printStackTrace();	
			}	
		}
		return status;
	}

}
