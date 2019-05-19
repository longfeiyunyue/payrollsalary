package cn.itcast.payroll.affiliation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.itcast.payroll.domain.Affiliation;
import cn.itcast.payroll.domain.Paycheck;
import cn.itcast.payroll.util.DateUtil;

/*
 * 具体协会实现类,负责计算应扣除项
 */
public class UnionAffiliation implements Affiliation {

	private String memberId;
	private double weeklyBue;//每周固定应付款字段
	private List<ServiceChange> serviceChanges=new ArrayList<ServiceChange>();//不定时收的服务费
	public UnionAffiliation(String memberId, double weeklyBue) {
		super();
		this.memberId = memberId;
		this.weeklyBue = weeklyBue;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public double getWeeklyBue() {
		return weeklyBue;
	}
	public void setWeeklyBue(double weeklyBue) {
		this.weeklyBue = weeklyBue;
	}
	public void addServiceChanges(ServiceChange sc) {
		this.serviceChanges.add(sc);
	}
	public double calculateDecutions(Paycheck paycheck) {
		// TODO Auto-generated method stub
		int fridays=NumberOfFridaysInPayPeriod(paycheck.getPayPeriodStart(),paycheck.getPayPeriodend());
		double totalDue=fridays*weeklyBue;
		double totalChange=0;
		for(ServiceChange sc:serviceChanges) {
			if(DateUtil.between(sc.getDate(), paycheck.getPayPeriodStart(), paycheck.getPayPeriodend()))
				totalChange+=sc.getAmount();
		}
		return totalDue+totalChange;
	}
	private int NumberOfFridaysInPayPeriod(LocalDate start,
			LocalDate end) {
		ZonedDateTime zonedDatestart = start.atStartOfDay(ZoneId.systemDefault());
		ZonedDateTime zonedDateend = end.atStartOfDay(ZoneId.systemDefault());
		Date payPeriodStart=Date.from(zonedDatestart.toInstant());
		Date payPeriodEnd=Date.from(zonedDateend.toInstant());
		Calendar dayCa = Calendar.getInstance();
		dayCa.setTime(payPeriodStart);
		Calendar payPeriodEndCa = Calendar.getInstance();
		dayCa.setTime(payPeriodEnd);

		int fridays = 0;
		while (dayCa.before(payPeriodEndCa)) {
			if (dayCa.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
				fridays++;
			}
			dayCa.add(Calendar.DATE, 1);
		}

		return fridays;
	}
	@Override
	public String toString() {
		return "UnionAffiliation [memberId=" + memberId + ", weeklyBue=" + weeklyBue + "]";
	}
	
}
