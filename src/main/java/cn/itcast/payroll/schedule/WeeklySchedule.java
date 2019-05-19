package cn.itcast.payroll.schedule;

import java.time.LocalDate;

import cn.itcast.payroll.domain.PaymentSchedule;
import cn.itcast.payroll.util.DateUtil;
/*
 * 按每周周五进行支付实现类
 */
public class WeeklySchedule implements PaymentSchedule {

	public boolean isPayDate(LocalDate date) {
		// TODO Auto-generated method stub
		return DateUtil.isFriday(date);
	}

	public LocalDate getPayPeriodStartDate(LocalDate date) {
		// TODO Auto-generated method stub
		return DateUtil.add(date, -6);
	}

	@Override
	public String toString() {
		return "WeeklySchedule [每周五支付]";
	}

}
