package cn.itcast.payroll.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * 员工类
 */
public class Employee {

	private String id;
	private String name;
	private String address;
	private List<Affiliation> affiliations=new ArrayList<Affiliation>();
	
	private PaymentClassification classification;
	private PaymentMethod paymentMethod;
	private PaymentSchedule schedule;
	public Employee(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Affiliation> getAffiliations() {
		return affiliations;
	}
	public void addAffiliations(Affiliation affiliation) {
		this.affiliations.add(affiliation);
	}
	public PaymentClassification getClassification() {
		return classification;
	}
	public void setClassification(PaymentClassification classification) {
		this.classification = classification;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public PaymentSchedule getSchedule() {
		return schedule;
	}
	public void setSchedule(PaymentSchedule schedule) {
		this.schedule = schedule;
	}
	
	public boolean isPayDay(LocalDate d) {
		return this.schedule.isPayDate(d);
	}
	
	public LocalDate getPayPeriodStartDate(LocalDate d) {
		return this.schedule.getPayPeriodStartDate(d);
	}
	
	public void payDay(Paycheck pc) {//发放薪水
		double grossPay=classification.calculatePay(pc);
		double deductions=calculateDeductions(pc);
		double netPay=grossPay-deductions;
		pc.setDeductions(deductions);
		pc.setEmpId(id);
		pc.setGrossPay(grossPay);
		pc.setNetPay(netPay);
		paymentMethod.pay(pc);
	}
	
	protected double calculateDeductions(Paycheck pc) {
		double deductions=0;
		for(Affiliation affiliation:affiliations) {
			deductions+=affiliation.calculateDecutions(pc);
		}
		return deductions;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", affiliations=" + affiliations
				+ ", classification=" + classification + ", paymentMethod=" + paymentMethod + ", schedule=" + schedule
				+ "]";
	}
		
}
