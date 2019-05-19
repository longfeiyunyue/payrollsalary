package cn.itcast.payroll.domain;

import java.time.LocalDate;

public class Paycheck {//封装应支付薪水类

	private LocalDate payPeriodStart;//薪水起始计算时间
	private LocalDate payPeriodend;//薪水结束计算时间
	private double grossPay;//应付
	private double deductions;//扣除
	private double netPay;//实付
	private String empId;
	
	
	public Paycheck(LocalDate payperiodStart,LocalDate payPeriodend) {
		this.payPeriodStart=payperiodStart;
		this.payPeriodend=payPeriodend;
	}


	public LocalDate getPayPeriodStart() {
		return payPeriodStart;
	}


	public void setPayPeriodStart(LocalDate payPeriodStart) {
		this.payPeriodStart = payPeriodStart;
	}


	public LocalDate getPayPeriodend() {
		return payPeriodend;
	}


	public void setPayPeriodend(LocalDate payPeriodend) {
		this.payPeriodend = payPeriodend;
	}


	public double getGrossPay() {
		return grossPay;
	}


	public void setGrossPay(double grossPay) {
		this.grossPay = grossPay;
	}


	public double getDeductions() {
		return deductions;
	}


	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}


	public double getNetPay() {
		return netPay;
	}


	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	@Override
	public String toString() {
		return "Paycheck [payPeriodStart=" + payPeriodStart + ", payPeriodend=" + payPeriodend + ", grossPay="
				+ grossPay + ", deductions=" + deductions + ", netPay=" + netPay + ", empId=" + empId + "]";
	}
	
	}
