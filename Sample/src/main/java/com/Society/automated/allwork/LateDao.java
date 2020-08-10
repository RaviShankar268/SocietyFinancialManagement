package com.Society.automated.allwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * THIS CLASS IS RESPONSIBLE FOR UPDATING LATE FEE FUNCTIONS
 */
public class LateDao {
	public void updateLate()
	{
		String cp="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			int i=stmt.executeUpdate("update temp_db set latefee='100' where checked='requested'");
			System.out.println(i+" rows affected");
			ResultSet rs=stmt.executeQuery("select total from temp_db where checked='requested'"); // LIMIT 1 VACHI IRUNDHEN
			if(rs.next())
			{
				cp=rs.getString(1);
				int change=Integer.parseInt(cp);
				change=change+100;
				cp=String.valueOf(change);
				//System.out.println(cp);
				String sql="update temp_db set total='"+cp+"' where checked='requested'";
				//System.out.println(sql);
				i=stmt.executeUpdate(sql);
				System.out.println(i+" rows affected");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public boolean ul()
	{
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			String date=java.time.LocalDate.now().toString();
			Statement stmt=connection.createStatement();
			String sql="select * from ul where date='"+date+"'";
			ResultSet rs=stmt.executeQuery(sql);
			status=rs.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public void insertul()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			String date=java.time.LocalDate.now().toString();
			Statement stmt=connection.createStatement();
			String sql="insert into ul values('"+date+"')";
			stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		//LateDao ld=new LateDao();
		//ld.updateLate();
	}

}
