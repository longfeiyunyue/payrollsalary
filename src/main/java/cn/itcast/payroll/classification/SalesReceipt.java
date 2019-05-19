package cn.itcast.payroll.classification;

import java.time.LocalDate;
/*
 * 销售凭条
 */
public class SalesReceipt {
	private LocalDate date;//日期
	private double amount;//卖了多少
	public SalesReceipt(LocalDate date, double amount) {
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
		return "SalesReceipt [date=" + date + ", amount=" + amount + "]";
	}
	

}
