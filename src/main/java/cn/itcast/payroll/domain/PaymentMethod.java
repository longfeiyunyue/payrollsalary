package cn.itcast.payroll.domain;
/*
 * 抽象支付薪资方式
 */
public interface PaymentMethod {

	void pay(Paycheck payCheck);
}
