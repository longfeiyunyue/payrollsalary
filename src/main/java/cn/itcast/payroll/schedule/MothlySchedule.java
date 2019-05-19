package cn.itcast.payroll.schedule;

import java.time.LocalDate;

import cn.itcast.payroll.domain.PaymentSchedule;
import cn.itcast.payroll.util.DateUtil;
/*
 * 按月进行支付
 */
public class MothlySchedule implements PaymentSchedule {

	public boolean isPayDate(LocalDate date) {
		// TODO Auto-generated method stub
		return DateUtil.isLastDayOfMonth(date);
	}

	public LocalDate getPayPeriodStartDate(LocalDate date) {
		// TODO Auto-generated method stub
		return DateUtil.getFirstDay(date);
	}

	@Override
	public String toString() {
		return "MothlySchedule [月底支付]";
	}

}
