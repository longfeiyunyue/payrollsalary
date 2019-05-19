package cn.itcast.payroll.transaction;

import java.time.LocalDate;
import java.util.List;

import cn.itcast.payroll.affiliation.ServiceChange;
import cn.itcast.payroll.affiliation.UnionAffiliation;
import cn.itcast.payroll.dao.PayrollDatabase;
import cn.itcast.payroll.dao.impl.PaymentDatabaseImpl;
import cn.itcast.payroll.domain.Affiliation;
import cn.itcast.payroll.domain.Employee;
/*
 * 不定时会费扣费记录
 */
public class ServiceChangeTransaction {

	private  PayrollDatabase payrollDatabase = new PaymentDatabaseImpl();
	private String memberId;
	private LocalDate date;
	private double amount;
	public ServiceChangeTransaction(String memberId, LocalDate date, double amount) {
		super();
		this.memberId = memberId;
		this.date = date;
		this.amount = amount;
	}
	public void execute() {
		List<Employee> emps=payrollDatabase.findMembers(memberId);
		for(Employee emp:emps) {
			List<Affiliation> affs=emp.getAffiliations();
			for(Affiliation aff:affs) {
				if(aff instanceof UnionAffiliation) {
					UnionAffiliation uaf=(UnionAffiliation)aff;
					ServiceChange sc=new ServiceChange(date, amount);
					uaf.addServiceChanges(sc);
					payrollDatabase.addServiceChange(memberId, sc);
				}
			}
		}
	}
}
