package com.bdqn.shark.part3.sousou.packages.contents;

public class Data extends Resource{

	public Data (double amount, double charge){
		super (amount, charge);
	}
	@Override
	public void printInfo() {
		if (getBalance()>0)
			System.out.println("套餐内流量共"+getLimit()+"M，剩余"+getBalance()+"M。");
		else{
			System.out.println("套餐内流量共"+getLimit()+"M，剩余0M。");
			System.out.println("套餐外使用流量"+Math.abs(getBalance())+"M，产生费用"+getExtraExpanse());
		}
	}
	@Override
	protected String description(double consume, String description) {
		return new String(description+"  共使用"+consume+"M");
	}
}