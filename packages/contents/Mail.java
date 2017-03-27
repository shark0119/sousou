package com.bdqn.shark.part3.sousou.packages.contents;

public class Mail extends Resource{

	public Mail (double amount, double charge){
		super (amount, charge);
	}
	@Override
	public void printInfo() {
		if (getBalance()>0)
			System.out.println("套餐内短信共"+getLimit()+"条，剩余"+getBalance()+"条。");
		else{
			System.out.println("套餐内短信共"+getLimit()+"条，剩余0条。");
			System.out.println("套餐外使用短信"+Math.abs(getBalance())+"条，产生费用"+getExtraExpanse());
		}
	}
	@Override
	protected String description(double consume, String description) {
		return new String(description+"  共使用"+consume+"条");
	}
}
