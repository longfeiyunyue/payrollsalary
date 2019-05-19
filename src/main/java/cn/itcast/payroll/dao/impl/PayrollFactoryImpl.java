package cn.itcast.payroll.dao.impl;

import java.time.LocalDate;
import java.time.Month;

import cn.itcast.payroll.dao.PayrollFactory;
import cn.itcast.payroll.transaction.AddCommissionedEmployeeTransaction;
import cn.itcast.payroll.transaction.AddEmployeeTransaction;
import cn.itcast.payroll.transaction.AddHourlyEmployeeTransaction;
import cn.itcast.payroll.transaction.AddSalariedEmployeeTransaction;
import cn.itcast.payroll.transaction.AffiliationTransaction;
import cn.itcast.payroll.transaction.SalesReceiptTransaction;
import cn.itcast.payroll.transaction.ServiceChangeTransaction;
import cn.itcast.payroll.transaction.TimeCardTransaction;

public class PayrollFactoryImpl implements PayrollFactory {

	public void createEmployee() {
		// TODO Auto-generated method stub
		// 增加小时工
				String empId1 = "1";
				AddEmployeeTransaction addEmp = new AddHourlyEmployeeTransaction(empId1, "张三", "上海", 10);
				addEmp.execute();

				// 给小时工增加工时卡
				TimeCardTransaction timeCardTransaction = new TimeCardTransaction(empId1, LocalDate.of(2018, Month.JULY, 18), 100);
				timeCardTransaction.execute();

				// 给小时工增加会费
				String memberId1 = "1";
				AffiliationTransaction affiliationTransaction = new AffiliationTransaction(empId1, memberId1, 10);
				affiliationTransaction.execute();

				ServiceChangeTransaction serviceChangeTransaction = new ServiceChangeTransaction(memberId1, LocalDate.of(2018, Month.JULY, 18), 20);
				serviceChangeTransaction.execute();

				// 增加销售
				String empId2 = "2";
				addEmp = new AddCommissionedEmployeeTransaction(empId2, "李四", "上海", 1000, 0.5);
				addEmp.execute();

				// 增加销售凭条
				SalesReceiptTransaction salesReceiptTransaction = new SalesReceiptTransaction(empId2, LocalDate.of(2018, Month.JULY, 18), 100);
				salesReceiptTransaction.execute();

				// 增加销售凭条
				salesReceiptTransaction = new SalesReceiptTransaction(empId2, LocalDate.of(2018, Month.JULY, 19), 50);
				salesReceiptTransaction.execute();

				String empId3 = "3";
				// 增加固定工资员工
				addEmp = new AddSalariedEmployeeTransaction(empId3, "王五", "上海", 1000);
				addEmp.execute();
	}

}
