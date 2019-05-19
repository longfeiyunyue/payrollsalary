package cn.itcast.payroll.transaction;

import cn.itcast.payroll.dao.PayrollDatabase;
import cn.itcast.payroll.dao.impl.PaymentDatabaseImpl;
import cn.itcast.payroll.domain.Employee;
import cn.itcast.payroll.domain.PaymentClassification;
import cn.itcast.payroll.domain.PaymentMethod;
import cn.itcast.payroll.domain.PaymentSchedule;
/*
 * 新增员工业务层
 */
public abstract class AddEmployeeTransaction {

	protected PayrollDatabase payrollDatabase=new PaymentDatabaseImpl();
	private String empId;
	private String name;
	private String address;
	
	public AddEmployeeTransaction(String empId, String name, String address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	
	public abstract PaymentClassification getClassification();
	public abstract PaymentSchedule getSchedule();
	public abstract PaymentMethod getMthod();
	
	public void execute() {
		Employee e =new Employee(empId,name,address);
		e.setClassification(getClassification());
		e.setPaymentMethod(getMthod());
		e.setSchedule(getSchedule());
		payrollDatabase.addEmployee(empId, e);
	}
}
