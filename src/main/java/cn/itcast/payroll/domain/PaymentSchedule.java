package cn.itcast.payroll.domain;

import java.time.LocalDate;

/*
 * 抽象出支付时间
 */
public interface PaymentSchedule {

	boolean isPayDate(LocalDate date);
	
	LocalDate getPayPeriodStartDate(LocalDate date);
}
