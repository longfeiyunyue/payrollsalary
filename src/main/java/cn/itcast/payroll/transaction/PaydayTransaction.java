package cn.itcast.payroll.transaction;

import java.time.LocalDate;
import java.util.List;

import cn.itcast.payroll.dao.PayrollDatabase;
import cn.itcast.payroll.dao.impl.PaymentDatabaseImpl;
import cn.itcast.payroll.domain.Employee;
import cn.itcast.payroll.domain.Paycheck;
/*
 * 为每一位员工支付薪水业务层
 */
public class PaydayTransaction {
	
	private PayrollDatabase payrollDatabase=new PaymentDatabaseImpl();
	private LocalDate date;
	public PaydayTransaction(LocalDate date) {
		this.date=date;
	}
	
	public void execute() {
		List<Employee> emps = payrollDatabase.findAllEmpByInit();
		for(Employee emp:emps) {
			if(emp.isPayDay(date)) {
				Paycheck pc=new Paycheck(emp.getPayPeriodStartDate(date), date);
				emp.payDay(pc);
				payrollDatabase.savePaycheck(pc);
			}
		}
	}

}
