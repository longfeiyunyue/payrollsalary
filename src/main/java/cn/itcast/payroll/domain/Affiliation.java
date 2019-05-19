package cn.itcast.payroll.domain;
/*
 * 抽象会费计算，协会对象
 */
public interface Affiliation {

	double calculateDecutions(Paycheck paycheck);
}
