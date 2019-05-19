package cn.itcast.payroll.transaction;

import cn.itcast.payroll.classification.SalariedClassification;
import cn.itcast.payroll.domain.PaymentClassification;
import cn.itcast.payroll.domain.PaymentMethod;
import cn.itcast.payroll.domain.PaymentSchedule;
import cn.itcast.payroll.method.HoldMethod;
import cn.itcast.payroll.schedule.MothlySchedule;
/*
 * 新增固定薪资员工业务层
 */
public class AddSalariedEmployeeTransaction extends AddEmployeeTransaction {
	private double salary;

	public AddSalariedEmployeeTransaction(String empId, String name, String address,double salary) {
		super(empId, name, address);
		this.salary=salary;
	}

	@Override
	public PaymentClassification getClassification() {
		// TODO Auto-generated method stub
		return new SalariedClassification(salary);
	}

	@Override
	public PaymentSchedule getSchedule() {
		// TODO Auto-generated method stub
		return new MothlySchedule();
	}

	@Override
	public PaymentMethod getMthod() {
		// TODO Auto-generated method stub
		return new HoldMethod();
	}

}
