package com.Society.adwork.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.Society.adwork.bean.RetryCheckedBean;

/*
 * THIS CLASS IS FOR CHANGING CHECKED STATUS TO REQUESTED FOR RETRYING INWARD PAYMENT REQUEST
 */
public class RetryCheckedDao {
	public boolean change(RetryCheckedBean retrycheckedbean)
	{
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			String sql="update temp_db set checked='requested' where apt_id='"+retrycheckedbean.getApt_id()+"';";
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
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
