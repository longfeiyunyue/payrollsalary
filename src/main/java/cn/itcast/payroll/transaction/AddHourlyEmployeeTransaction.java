package cn.itcast.payroll.transaction;

import cn.itcast.payroll.classification.HourlyClassification;
import cn.itcast.payroll.domain.PaymentClassification;
import cn.itcast.payroll.domain.PaymentMethod;
import cn.itcast.payroll.domain.PaymentSchedule;
import cn.itcast.payroll.method.HoldMethod;
import cn.itcast.payroll.schedule.WeeklySchedule;
/*
 * 新增小时员工业务层
 */
public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction {
	private double rate;

	public AddHourlyEmployeeTransaction(String empId, String name, String address,double rate) {
		super(empId, name, address);
		// TODO Auto-generated constructor stub
		this.rate=rate;
	}

	@Override
	public PaymentClassification getClassification() {
		// TODO Auto-generated method stub
		return new HourlyClassification(rate);
	}

	@Override
	public PaymentSchedule getSchedule() {
		// TODO Auto-generated method stub
		return new WeeklySchedule();
	}

	@Override
	public PaymentMethod getMthod() {
		// TODO Auto-generated method stub
		return new HoldMethod();
	}

}
