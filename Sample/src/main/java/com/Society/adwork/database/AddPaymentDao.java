package com.Society.adwork.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Society.adwork.bean.AddPaymentBean;

/*
 * THIS CLASS IS FOR ADDING INWARD PAYMENT REQUEST TO TEMP DB
 */

public class AddPaymentDao {
	public boolean insert(AddPaymentBean addpaymentbean)
	{
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select apt_id,mail_id from family");
			String apt_id="";
			String mail_id="";
			while(rs.next())
			{
				apt_id=rs.getString(1);
				mail_id=rs.getString(2);
				PreparedStatement preparedstatement=connection.prepareStatement("insert into temp_db(apt_id,month,year,monthlymain,seasoncharge,addcharge,total,checked,pay_status,mail_sent,mail_id) values(?,?,?,?,?,?,?,?,?,?,?)");
				preparedstatement.setString(1, apt_id);
				preparedstatement.setString(2, addpaymentbean.getMonth());
				preparedstatement.setString(3, addpaymentbean.getYear());
				preparedstatement.setString(4, addpaymentbean.getMonthlymain());
				preparedstatement.setString(5, addpaymentbean.getSeasoncharge());
				preparedstatement.setString(6, addpaymentbean.getAddcharge());
				preparedstatement.setString(7, addpaymentbean.getTotal());
				preparedstatement.setString(8, addpaymentbean.getChecked());
				preparedstatement.setString(9, addpaymentbean.getPaystatus());
				preparedstatement.setString(10, addpaymentbean.getMail_sent());
				preparedstatement.setString(11, mail_id);
				int i=preparedstatement.executeUpdate();
				System.out.println(i+" records inserted");
			}
			status=true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}

}
