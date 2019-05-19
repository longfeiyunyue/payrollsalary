package cn.itcast.payroll.transaction;

import cn.itcast.payroll.affiliation.UnionAffiliation;
import cn.itcast.payroll.dao.PayrollDatabase;
import cn.itcast.payroll.dao.impl.PaymentDatabaseImpl;
import cn.itcast.payroll.domain.Employee;

/*
 * 给员工加入协会
 */
public class AffiliationTransaction {

	private PayrollDatabase payrollDatabase=new PaymentDatabaseImpl();
	
	private String empId;
	private String memberId;
	private double weeklyBue;
	public AffiliationTransaction(String empId, String memberId, double weeklyBue) {
		super();
		this.empId = empId;
		this.memberId = memberId;
		this.weeklyBue = weeklyBue;
	}
	
	public void execute() {
		 Employee emp=payrollDatabase.findEmployee(empId);
		 UnionAffiliation af=new UnionAffiliation(memberId, weeklyBue);
		 emp.addAffiliations(af);
		 payrollDatabase.addAffiliation(memberId, af);
		 payrollDatabase.addMember(memberId, emp);
	}
}
