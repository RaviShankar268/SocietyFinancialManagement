package com.Society.adwork.bean;

public class AddPaymentBean {
	private String month;
	private String year;
	private String monthlymain;
	private String seasoncharge;
	private String addcharge;
	private String total;
	private String checked="requested";
	private String mail_sent="no";
	private String pay_status="unpaid";
	
	public String getPaystatus() {
		return pay_status;
	}
//	public void setPaystatus(String pay_status) {
//		this.paystatus = pay_status;
//	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonthlymain() {
		return monthlymain;
	}
	public void setMonthlymain(String monthlymain) {
		this.monthlymain = monthlymain;
	}
	public String getSeasoncharge() {
		return seasoncharge;
	}
	public void setSeasoncharge(String seasoncharge) {
		this.seasoncharge = seasoncharge;
	}
	public String getAddcharge() {
		return addcharge;
	}
	public void setAddcharge(String addcharge) {
		this.addcharge = addcharge;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getChecked() {
		return checked;
	}
//	public void setChecked(String checked) {
//		this.checked = checked;
//	}
	public String getMail_sent() {
		return mail_sent;
	}
//	public void setMail_sent(String mail_sent) {
//		this.mail_sent = mail_sent;
//	}
	

}
