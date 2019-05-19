package cn.itcast.payroll.method;

import cn.itcast.payroll.domain.Paycheck;
import cn.itcast.payroll.domain.PaymentMethod;
/*
 * 银行卡支付方式实现类
 */
public class BankMethod implements PaymentMethod {
	private String bank;//银行卡
	private double account;//应支付的工资
	
	public BankMethod(String bank, double account) {
		super();
		this.bank = bank;
		this.account = account;
	}

	public void pay(Paycheck payCheck) {
		// TODO Auto-generated method stub
        System.out.println("向银行卡"+bank+"支付"+payCheck.getNetPay()+"元钱");
	}

	@Override
	public String toString() {
		return "BankMethod [bank=" + bank + ", account=" + account + "]";
	}

}
