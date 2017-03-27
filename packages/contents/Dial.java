package com.bdqn.shark.part3.sousou.packages.contents;

public class Dial extends Resource {
	public Dial(double amount, double charge){
		super (amount, charge);
	}
	@Override
	public void printInfo() {
		if (getBalance()>0)
			System.out.println("套餐内通话共"+getLimit()+"分钟，剩余"+getBalance()+"分钟。");
		else{
			System.out.println("套餐内通话共"+getLimit()+"分钟，剩余0分钟。");
			System.out.println("套餐外使用通话"+Math.abs(getBalance())+"分钟，产生费用"+getExtraExpanse());
		}
	}
	@Override
	protected String description(double consume, String description) {
		return new String(description+"  共使用"+consume+"分钟");
	}
}
