package cn.itcast.payroll.transaction;

import cn.itcast.payroll.classification.CommissionedClassification;
import cn.itcast.payroll.domain.PaymentClassification;
import cn.itcast.payroll.domain.PaymentMethod;
import cn.itcast.payroll.domain.PaymentSchedule;
import cn.itcast.payroll.method.HoldMethod;
import cn.itcast.payroll.schedule.BiweeklySchedule;
/*
 * 新增销售员工业务层
 */
public class AddCommissionedEmployeeTransaction extends AddEmployeeTransaction {
	private double salary;
	private double rate;
	

	public AddCommissionedEmployeeTransaction(String empId, String name, String address,double salary,double rate) {
		super(empId, name, address);
		this.salary=salary;
		this.rate=rate;
	}

	@Override
	public PaymentClassification getClassification() {
		// TODO Auto-generated method stub
		return new CommissionedClassification(rate, salary);
	}

	@Override
	public PaymentSchedule getSchedule() {
		// TODO Auto-generated method stub
		return new BiweeklySchedule();
	}

	@Override
	public PaymentMethod getMthod() {
		// TODO Auto-generated method stub
		return new HoldMethod();
	}

}
