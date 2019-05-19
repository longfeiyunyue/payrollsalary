package cn.itcast.payroll.transaction;

import java.time.LocalDate;

import cn.itcast.payroll.classification.HourlyClassification;
import cn.itcast.payroll.classification.TimeCard;
import cn.itcast.payroll.dao.PayrollDatabase;
import cn.itcast.payroll.dao.impl.PaymentDatabaseImpl;
import cn.itcast.payroll.domain.Employee;
import cn.itcast.payroll.domain.PaymentClassification;
/*
 * 新增小时员工的工作时间卡
 */
public class TimeCardTransaction {
	private PayrollDatabase payrollDatabase = new PaymentDatabaseImpl();
	
	private String empId;
	private LocalDate date;
	private double hours;
	public TimeCardTransaction(String empId, LocalDate date, double hours) {
		super();
		this.empId = empId;
		this.date = date;
		this.hours = hours;
	}
	public void execute() {
		Employee emp=payrollDatabase.findEmployee(empId);
		if(emp==null) throw new RuntimeException("找不到该员工");
		PaymentClassification pc=emp.getClassification();
		if(pc instanceof HourlyClassification) {
			HourlyClassification hc=(HourlyClassification)pc;
			TimeCard tc=new TimeCard(date, hours);
			hc.addTimeCard(tc);
			payrollDatabase.addTimeCard(empId, tc);
		}
	}
}
