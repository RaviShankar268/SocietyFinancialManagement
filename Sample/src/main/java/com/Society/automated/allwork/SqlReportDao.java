package com.Society.automated.allwork;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.jasperreports.view.JasperViewer;

/*
 * THIS CLASS AIDS IN DATABASE SUPPORT FOR GENERATING REPORTS
 */
public class SqlReportDao {
	public String createReport(String sql)
	{
		Connection connection=null;
		int num=0;
		String date=java.time.LocalDate.now().toString();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			stmt.executeUpdate("insert into report(date) values("+date+")");
			ResultSet rs=stmt.executeQuery("select num from report order by num desc limit 1");
			if(rs.next())
				num=rs.getInt(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String name="report"+String.valueOf(num)+".pdf";
		
		JasperReportBuilder report= DynamicReports.report();
		report
			.columns(
					Columns.column("Apartment Id","apt_id",DataTypes.stringType()),
					Columns.column("Monthly Maintenance","monthlymain",DataTypes.stringType()),
					Columns.column("Seasonal Charge","seasoncharge",DataTypes.stringType()),
					Columns.column("Additional Charge","addcharge", DataTypes.stringType()),
					Columns.column("Late Fees","latefee",DataTypes.stringType()),
					Columns.column("Total","total",DataTypes.stringType()),
					Columns.column("Date paid","date_paid",DataTypes.stringType()),
					Columns.column("Month","month",DataTypes.stringType()),
					Columns.column("Year","year",DataTypes.stringType())
					)
			.title(
					Components.text("Automated Report")
						.setHorizontalAlignment(HorizontalAlignment.CENTER)
					)
			.pageFooter(Components.pageXofY())
			.setDataSource(sql, connection);
		try {
			report.toPdf(new FileOutputStream("d:/normal/"+name));
			//System.out.println("REPORT GENERATED");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return name;
	}
	
	public String createOutward(String sql)
	{
		Connection connection=null;
		int num=0;
		String date=java.time.LocalDate.now().toString();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			stmt.executeUpdate("insert into report(date) values("+date+")");
			ResultSet rs=stmt.executeQuery("select num from report order by num desc limit 1");
			if(rs.next())
				num=rs.getInt(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String name="report"+String.valueOf(num)+".pdf";
		
		JasperReportBuilder report= DynamicReports.report();
		report
			.columns(
					Columns.column("Type","type",DataTypes.stringType()),
					Columns.column("To","tot",DataTypes.stringType()),
					Columns.column("Date","date",DataTypes.stringType()),
					Columns.column("Amount","amount",DataTypes.stringType())
					)
			.title(
					Components.text("Automated Report")
						.setHorizontalAlignment(HorizontalAlignment.CENTER)
					)
			.pageFooter(Components.pageXofY())
			.setDataSource(sql, connection);
		try {
			report.toPdf(new FileOutputStream("d:/normal/"+name));
			//System.out.println("REPORT GENERATED");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return name;
	}
	
	public String createAllPayment(String sql)
	{
		Connection connection=null;
		int num=0;
		String date=java.time.LocalDate.now().toString();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			stmt.executeUpdate("insert into report(date) values("+date+")");
			ResultSet rs=stmt.executeQuery("select num from report order by num desc limit 1");
			if(rs.next())
				num=rs.getInt(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String name="report"+String.valueOf(num)+".pdf";
		
		JasperReportBuilder report= DynamicReports.report();
		report
			.columns(
					Columns.column("Name","apt_id",DataTypes.stringType()),
					Columns.column("Date","date",DataTypes.stringType()),
					Columns.column("Time","time",DataTypes.stringType()),
					Columns.column("Amount","amount",DataTypes.stringType())
					)
			.title(
					Components.text("Automated Report")
						.setHorizontalAlignment(HorizontalAlignment.CENTER)
					)
			.pageFooter(Components.pageXofY())
			.setDataSource(sql, connection);
		try {
			report.toPdf(new FileOutputStream("d:/normal/"+name));
			//System.out.println("REPORT GENERATED");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return name;
		
	}
	public String createAggregate(String sql)
	{
		Connection connection=null;
		int num=0;
		String date=java.time.LocalDate.now().toString();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			stmt.executeUpdate("insert into report(date) values("+date+")");
			ResultSet rs=stmt.executeQuery("select num from report order by num desc limit 1");
			if(rs.next())
				num=rs.getInt(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String name="report"+String.valueOf(num)+".pdf";
		
		JasperReportBuilder report= DynamicReports.report();
		report
			.columns(
					Columns.column("Month","month",DataTypes.stringType()),
					Columns.column("Year","year",DataTypes.stringType()),
					Columns.column("Amount","amount",DataTypes.stringType())
					)
			.title(
					Components.text("Automated Report")
						.setHorizontalAlignment(HorizontalAlignment.CENTER)
					)
			.pageFooter(Components.pageXofY())
			.setDataSource(sql, connection);
		try {
			report.toPdf(new FileOutputStream("d:/normal/"+name));
			//System.out.println("REPORT GENERATED");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return name;
	}
}
