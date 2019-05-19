package cn.itcast.payroll.classification;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.payroll.domain.Paycheck;
import cn.itcast.payroll.domain.PaymentClassification;
import cn.itcast.payroll.util.DateUtil;

/*
 * 销售员工薪资计算
 */
public class CommissionedClassification implements PaymentClassification {
	
	private double rate;//每笔销售单提成
	private double salary;//底薪
	private List<SalesReceipt> salesReceipt=new ArrayList<SalesReceipt>();
	
	public CommissionedClassification(double rate, double salary) {
		super();
		this.rate = rate;
		this.salary = salary;
	}

    public void addSalesReceipt(SalesReceipt sr) {
    	this.salesReceipt.add(sr);
    }

	public double calculatePay(Paycheck payCheck) {
		// TODO Auto-generated method stub
		double commission=0;
		for(SalesReceipt sr:salesReceipt) {
			if(DateUtil.between(sr.getDate(), payCheck.getPayPeriodStart(), payCheck.getPayPeriodend()))
				commission+=sr.getAmount()*rate;
		}
		return commission+salary;
	}

	@Override
	public String toString() {
		return "CommissionedClassification [rate=" + rate + ", salary=" + salary + ", salesReceipt=" + salesReceipt
				+ "]";
	}

}
