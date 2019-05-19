package cn.itcast.payroll.classification;

import cn.itcast.payroll.domain.Paycheck;
import cn.itcast.payroll.domain.PaymentClassification;
/*
 * 固定薪资支付
 */
public class SalariedClassification implements PaymentClassification {
	
	private double salary;
	
	public SalariedClassification(double salary) {
		this.salary=salary;
	}	

	public double calculatePay(Paycheck payCheck) {
		// TODO Auto-generated method stub
		return salary;
	}

	@Override
	public String toString() {
		return "SalariedClassification [salary=" + salary + "]";
	}
	
	

}
