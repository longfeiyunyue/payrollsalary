package cn.itcast.payroll.transaction;

import java.time.LocalDate;

import cn.itcast.payroll.classification.CommissionedClassification;
import cn.itcast.payroll.classification.SalesReceipt;
import cn.itcast.payroll.dao.PayrollDatabase;
import cn.itcast.payroll.dao.impl.PaymentDatabaseImpl;
import cn.itcast.payroll.domain.Employee;
import cn.itcast.payroll.domain.PaymentClassification;
/*
 * 新增销售凭条业务层
 */
public class SalesReceiptTransaction {

	private PayrollDatabase payrollDatabase = new PaymentDatabaseImpl();
	private String empId;
	private LocalDate date;
	private double amount;
	public SalesReceiptTransaction(String empId, LocalDate date, double amount) {
		super();
		this.empId = empId;
		this.date = date;
		this.amount = amount;
	}
	
	public void execute() {
		Employee emp=payrollDatabase.findEmployee(empId);
		if(emp==null) throw new RuntimeException("该员工不存在");
		PaymentClassification pc=emp.getClassification();
		if(pc instanceof CommissionedClassification) {
			CommissionedClassification cc=(CommissionedClassification)pc;
			SalesReceipt sr=new SalesReceipt(date, amount);
			cc.addSalesReceipt(sr);
			payrollDatabase.addSalesReceipt(empId, sr);
		}
	}
}
