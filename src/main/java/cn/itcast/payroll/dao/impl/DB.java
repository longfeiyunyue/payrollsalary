package cn.itcast.payroll.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.itcast.payroll.affiliation.ServiceChange;
import cn.itcast.payroll.classification.SalesReceipt;
import cn.itcast.payroll.classification.TimeCard;
import cn.itcast.payroll.domain.Affiliation;
import cn.itcast.payroll.domain.Employee;
import cn.itcast.payroll.domain.Paycheck;
/*
 * 模拟数据库的类
 */
public class DB {

	public Map<String,Employee> id2Emp=new HashMap<String,Employee>();
	public Map<String,Affiliation> memberId2Affiliation=new HashMap<String,Affiliation>();
	public Map<String,List<Employee>> memberId2Emps=new HashMap<String,List<Employee>>();
	public Map<String,List<TimeCard>> empId2TimeCards=new HashMap<String,List<TimeCard>>();
	public Map<String,List<SalesReceipt>> empId2SalesReceipts=new HashMap<String,List<SalesReceipt>>();
	public Map<String,List<Paycheck>> empId2Paycheck=new HashMap<String,List<Paycheck>>();
	public Map<String,List<ServiceChange>> memberId2Sc=new HashMap<String,List<ServiceChange>>();
	private static DB db=new DB();
	private DB() {
		
	}
	
	public static DB newInstance() {
		return db;
	}
}
