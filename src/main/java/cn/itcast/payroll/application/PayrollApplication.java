package cn.itcast.payroll.application;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import cn.itcast.payroll.dao.PayrollDatabase;
import cn.itcast.payroll.dao.impl.PaymentDatabaseImpl;
import cn.itcast.payroll.domain.Employee;
import cn.itcast.payroll.domain.Paycheck;
/*
 * 支付程序入口
 */
public class PayrollApplication {
	static PayrollDatabase payrollDatabase = new PaymentDatabaseImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.of(2018, Month.JULY, 20);
		 List<Employee> emps=payrollDatabase.findAllEmpByInit();
		 for(Employee emp:emps) {
			 if(emp.isPayDay(date)) {
				 Paycheck pc= new Paycheck(emp.getPayPeriodStartDate(date), date);
				 emp.payDay(pc);
				 payrollDatabase.savePaycheck(pc);
			 }
		 }
		 plintPaycheck(emps);
	}
	private static void plintPaycheck(List<Employee> emps) {
		for (Employee emp : emps) {
			System.out.println();
			System.out.println(emp);
			List<Paycheck> paychecks = payrollDatabase.findPaychecks(emp.getId());
			if (paychecks != null) {
				for(Paycheck payCheck:paychecks) System.out.println(payCheck);
			}
		}
	}
}
