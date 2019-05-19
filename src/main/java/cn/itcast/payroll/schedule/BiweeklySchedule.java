package cn.itcast.payroll.schedule;

import java.time.LocalDate;

import cn.itcast.payroll.domain.PaymentSchedule;
import cn.itcast.payroll.util.DateUtil;
/*
 * 隔周周五进行支付
 */
public class BiweeklySchedule implements PaymentSchedule {
	LocalDate firstPayableFriday = LocalDate.of(2019, 1, 4);

	public boolean isPayDate(LocalDate date) {
		// TODO Auto-generated method stub
		return DateUtil.isAfterFirday(date);
	}

	public LocalDate getPayPeriodStartDate(LocalDate date) {
		// TODO Auto-generated method stub
		return DateUtil.add(date, -13);
	}

	@Override
	public String toString() {
		return "BiweeklySchedule [隔周周五支付]";
	}

}
