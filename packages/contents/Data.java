package com.bdqn.shark.part3.sousou.packages.contents;

public class Data extends Resource{

	public Data (double amount, double charge){
		super (amount, charge);
	}
	@Override
	public void printInfo() {
		if (getBalance()>0)
			System.out.println("�ײ���������"+getLimit()+"M��ʣ��"+getBalance()+"M��");
		else{
			System.out.println("�ײ���������"+getLimit()+"M��ʣ��0M��");
			System.out.println("�ײ���ʹ������"+Math.abs(getBalance())+"M����������"+getExtraExpanse());
		}
	}
	@Override
	protected String description(double consume, String description) {
		return new String(description+"  ��ʹ��"+consume+"M");
	}
}