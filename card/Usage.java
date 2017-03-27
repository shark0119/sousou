package com.bdqn.shark.part3.sousou.card;

import java.io.Serializable;

public class Usage implements Comparable<Usage>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -315446836731131542L;
	protected double mailCost=0, dialCost=0, inetCost=0, balance=0;
	protected int year, month;
	protected String num;
	/**
	 * @param num �绰����
	 * @param year	��ǰ����
	 * @param month ��ǰ���ڣ�һ��һ��
	 * @param balance ��ǰ�������
	 * @param mailCost ����ʹ�����
	 * @param dialCost ͨ�����
	 * @param inetCost ��������ʹ�����
	 * */
	public Usage(String num, int year, int month,double balance, double mailCost, double dialCost, double inetCost) {
		this.num = num;
		this.year= year;
		this.month = month;
		this.balance = balance;
		this.mailCost = mailCost;
		this.dialCost = dialCost;
		this.inetCost = inetCost;
	}	
	public String getNum (){
		return num;
	}
	public double getInetCost() {
		return inetCost;
	}
	public double getDialCost() {
		return dialCost;
	}
	public double getMailCost() {
		return mailCost;
	}
	public int getYear(){
		return year;
	}
	public int getMonth (){
		return month;
	}
	public double getBalance (){
		return balance;
	}
	/**
	 * �˵�һ��һ�� �洢��TreeSet��Ϊ��֤�˵����ᱻ�ظ���ȡ
	 * �� �� �ֻ����� �������Թ�������
	 * */
	@Override
	public int compareTo(Usage o) {
		if (num.equals(o.getNum()) && year == o.getYear() && month ==o.getMonth())
			return 0;
		return -1;
	}
}
