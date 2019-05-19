package cn.itcast.payroll.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.payroll.affiliation.ServiceChange;
import cn.itcast.payroll.classification.SalesReceipt;
import cn.itcast.payroll.classification.TimeCard;
import cn.itcast.payroll.dao.PayrollDatabase;
import cn.itcast.payroll.dao.PayrollFactory;
import cn.itcast.payroll.domain.Affiliation;
import cn.itcast.payroll.domain.Employee;
import cn.itcast.payroll.domain.Paycheck;

public class PaymentDatabaseImpl implements PayrollDatabase {
	
	private DB db=DB.newInstance();
	private PayrollFactory payrollFactory=new PayrollFactoryImpl();

	public void addEmployee(String empId, Employee emp) {
		// TODO Auto-generated method stub
        db.id2Emp.put(empId, emp);
	}

	public Employee findEmployee(String empId) {
		// TODO Auto-generated method stub
		return db.id2Emp.get(empId);
	}

	public List<Employee> findAllEmpByInit() {
		// TODO Auto-generated method stub
		payrollFactory.createEmployee();
		return findAllEmp();
	}

	public List<Employee> findAllEmp() {
		// TODO Auto-generated method stub
		return new ArrayList<Employee>(db.id2Emp.values());
	}

	public void addAffiliation(String memberId, Affiliation affiliation) {
		// TODO Auto-generated method stub
        db.memberId2Affiliation.put(memberId, affiliation);
	}

	public Affiliation findAffiliation(String memberId) {
		// TODO Auto-generated method stub
		return db.memberId2Affiliation.get(memberId);
	}

	public void addTimeCard(String empId, TimeCard timeCard) {
		// TODO Auto-generated method stub
        if(!db.empId2TimeCards.containsKey(empId)) {
        	db.empId2TimeCards.put(empId, new ArrayList<TimeCard>());
        }
        db.empId2TimeCards.get(empId).add(timeCard);
	}

	public List<TimeCard> findTimeCards(String empId) {
		// TODO Auto-generated method stub
		return db.empId2TimeCards.get(empId);
	}

	public void addSalesReceipt(String empId, SalesReceipt salesReceipt) {
		// TODO Auto-generated method stub
        if(!db.empId2SalesReceipts.containsKey(empId)) {
        	db.empId2SalesReceipts.put(empId, new ArrayList<SalesReceipt>());
        }
        db.empId2SalesReceipts.get(empId).add(salesReceipt);
	}

	public List<SalesReceipt> findSalesReceipts(String empId) {
		// TODO Auto-generated method stub
		return db.empId2SalesReceipts.get(empId);
	}

	public void addMember(String memberId, Employee emp) {
		// TODO Auto-generated method stub
        if(!db.memberId2Emps.containsKey(memberId)) {
        	db.memberId2Emps.put(memberId, new ArrayList<Employee>());
        }
        db.memberId2Emps.get(memberId).add(emp);
	}

	public List<Employee> findMembers(String memberId) {
		// TODO Auto-generated method stub
		return db.memberId2Emps.get(memberId);
	}

	public void savePaycheck(Paycheck paycheck) {
		// TODO Auto-generated method stub
        if(!db.empId2Paycheck.containsKey(paycheck.getEmpId())) {
        	db.empId2Paycheck.put(paycheck.getEmpId(), new ArrayList<Paycheck>());
        }
        db.empId2Paycheck.get(paycheck.getEmpId()).add(paycheck);
	}

	public List<Paycheck> findPaychecks(String empId) {
		// TODO Auto-generated method stub
		return db.empId2Paycheck.get(empId);
	}

	public void addServiceChange(String memberId, ServiceChange serviceChange) {
		// TODO Auto-generated method stub
        if(!db.memberId2Sc.containsKey(memberId)) {
        	db.memberId2Sc.put(memberId, new ArrayList<ServiceChange>());
        }
        db.memberId2Sc.get(memberId).add(serviceChange);
	}

	public List<ServiceChange> findServiceChange(String memberId) {
		// TODO Auto-generated method stub
		return db.memberId2Sc.get(memberId);
	}

}
