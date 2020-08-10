package com.Society.automated.report;

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

/*
 * THIS CLASS IS USED FOR AIDING AUTOMATIC REPORT GENERATION FOR MAIL
 */
public class Report {
	
	public String generate(String apt_id)
	{
		Connection connection=null;
		String mon="";
		String year="";
		String sq="select month,year from temp_db where apt_id='"+apt_id+"'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/society?allowPublicKeyRetrieval=true&useSSL=false", "kavin", "admin@123");
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery(sq);
			if(rs.next())
			{
				mon=rs.getString(1);
				year=rs.getString(2);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		String sql="select apt_id,monthlymain,seasoncharge,addcharge,latefee,total,month,year from temp_db where apt_id='"+apt_id+"'";
		String name=apt_id+"_"+mon+"_"+year+".pdf";
		
		JasperReportBuilder report= DynamicReports.report();
		report
			.columns(
					Columns.column("Apartment Id","apt_id",DataTypes.stringType()),
					Columns.column("Monthly Maintenance","monthlymain",DataTypes.stringType()),
					Columns.column("Seasonal Charge","seasoncharge",DataTypes.stringType()),
					Columns.column("Additional Charge","addcharge", DataTypes.stringType()),
					Columns.column("Late Fees","latefee",DataTypes.stringType()),
					Columns.column("Total","total",DataTypes.stringType()),
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
			report.toPdf(new FileOutputStream("d:/scripts/"+name));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return name;
	}
	public static void main(String args[])
	{
		
				
	}

}
