package cn.itcast.payroll.method;

import cn.itcast.payroll.domain.Paycheck;
import cn.itcast.payroll.domain.PaymentMethod;

public class HoldMethod implements PaymentMethod {

	public void pay(Paycheck payCheck) {
		// TODO Auto-generated method stub
        System.out.println("到财务自取");
	}

	@Override
	public String toString() {
		return "HoldMethod [到财务自取]";
	}

}
