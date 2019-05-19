package cn.itcast.payroll.classification;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.payroll.domain.Paycheck;
import cn.itcast.payroll.domain.PaymentClassification;
import cn.itcast.payroll.util.DateUtil;
/*
 * 小时工即按小时支付，把按小时支付计算单独拿出来实现
 */
public class HourlyClassification implements PaymentClassification {
	
	private double hourlyRate;//每小时工钱
	private List<TimeCard> timeCards=new ArrayList<TimeCard>();//记录员工的工作时间卡
	
	public HourlyClassification(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double calculatePay(Paycheck payCheck) {
		// TODO Auto-generated method stub
		double totalPay=0;
		for(TimeCard card:timeCards) {
			if(DateUtil.between(card.getDate(), payCheck.getPayPeriodStart(), payCheck.getPayPeriodend()))
				totalPay+=calculatePayForTimeCard(card);
		}
		return totalPay;
	}
	
	public void addTimeCard(TimeCard timeCard) {
		this.timeCards.add(timeCard);
	}
	
	public double calculatePayForTimeCard(TimeCard timeCard) {
		double hours=timeCard.getHours();
		if(hours>8) {
			return (8*hourlyRate+(hours-8)*hourlyRate*1.5);
		}else {
			return hours*hourlyRate;
		}
	}

	@Override
	public String toString() {
		return "HourlyClassification [hourlyRate=" + hourlyRate + ", timeCards=" + timeCards + "]";
	}

}
