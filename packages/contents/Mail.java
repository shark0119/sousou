package com.bdqn.shark.part3.sousou.packages.contents;

public class Mail extends Resource{

	public Mail (double amount, double charge){
		super (amount, charge);
	}
	@Override
	public void printInfo() {
		if (getBalance()>0)
			System.out.println("�ײ��ڶ��Ź�"+getLimit()+"����ʣ��"+getBalance()+"����");
		else{
			System.out.println("�ײ��ڶ��Ź�"+getLimit()+"����ʣ��0����");
			System.out.println("�ײ���ʹ�ö���"+Math.abs(getBalance())+"������������"+getExtraExpanse());
		}
	}
	@Override
	protected String description(double consume, String description) {
		return new String(description+"  ��ʹ��"+consume+"��");
	}
}
