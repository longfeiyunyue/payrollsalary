package cn.itcast.payroll.method;

import cn.itcast.payroll.domain.Paycheck;
import cn.itcast.payroll.domain.PaymentMethod;
/*
 * 邮寄支付工资方式实现类
 */
public class MailMethod implements PaymentMethod {
	
	private String address;
	public MailMethod(String address) {
		super();
		this.address = address;
	}


	public void pay(Paycheck payCheck) {
		// TODO Auto-generated method stub
        System.out.println("给"+address+"邮寄工资");
	}


	@Override
	public String toString() {
		return "MailMethod [address=" + address + "]";
	}

}
