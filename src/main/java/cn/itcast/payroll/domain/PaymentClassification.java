package cn.itcast.payroll.domain;

public interface PaymentClassification {//抽象出支付策略类

	double calculatePay(Paycheck payCheck);
}
