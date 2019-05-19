package cn.itcast.payroll.dao;

import java.util.List;

import cn.itcast.payroll.affiliation.ServiceChange;
import cn.itcast.payroll.classification.SalesReceipt;
import cn.itcast.payroll.classification.TimeCard;
import cn.itcast.payroll.domain.Affiliation;
import cn.itcast.payroll.domain.Employee;
import cn.itcast.payroll.domain.Paycheck;

public interface PayrollDatabase {//模拟DAO层，操作数据的接口
	void addEmployee(String empId, Employee emp);

	Employee findEmployee(String empId);

	List<Employee> findAllEmpByInit();

	List<Employee> findAllEmp();

	void addAffiliation(String memberId, Affiliation affiliation);

	Affiliation findAffiliation(String memberId);

	void addTimeCard(String empId, TimeCard timeCard);

	List<TimeCard> findTimeCards(String empId);

	void addSalesReceipt(String empId, SalesReceipt salesReceipt);

	List<SalesReceipt> findSalesReceipts(String empId);

	void addMember(String memberId, Employee emp);

	List<Employee> findMembers(String memberId);

	void savePaycheck(Paycheck paycheck);

	List<Paycheck> findPaychecks(String empId);

	void addServiceChange(String memberId, ServiceChange serviceChange);

	List<ServiceChange> findServiceChange(String memberId);
}
