package cn.itcast.payroll.affiliation;

import java.time.LocalDate;
/*
 * 不定时收的服务费
 */
public class ServiceChange {
	
	private LocalDate date;
	private double amount;
	public ServiceChange(LocalDate date, double amount) {
		super();
		this.date = date;
		this.amount = amount;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ServiceChange [date=" + date + ", amount=" + amount + "]";
	}
	

}
