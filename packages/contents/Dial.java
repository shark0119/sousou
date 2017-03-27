package com.bdqn.shark.part3.sousou.packages.contents;

public class Dial extends Resource {
	public Dial(double amount, double charge){
		super (amount, charge);
	}
	@Override
	public void printInfo() {
		if (getBalance()>0)
			System.out.println("�ײ���ͨ����"+getLimit()+"���ӣ�ʣ��"+getBalance()+"���ӡ�");
		else{
			System.out.println("�ײ���ͨ����"+getLimit()+"���ӣ�ʣ��0���ӡ�");
			System.out.println("�ײ���ʹ��ͨ��"+Math.abs(getBalance())+"���ӣ���������"+getExtraExpanse());
		}
	}
	@Override
	protected String description(double consume, String description) {
		return new String(description+"  ��ʹ��"+consume+"����");
	}
}
