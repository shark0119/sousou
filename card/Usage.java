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
	 * @param num 电话号码
	 * @param year	当前日期
	 * @param month 当前日期，一月一结
	 * @param balance 当前可用余额
	 * @param mailCost 短信使用情况
	 * @param dialCost 通话情况
	 * @param inetCost 网络流量使用情况
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
	 * 账单一月一结 存储在TreeSet中为保证账单不会被重复存取
	 * 年 月 手机号码 三个属性构成主键
	 * */
	@Override
	public int compareTo(Usage o) {
		if (num.equals(o.getNum()) && year == o.getYear() && month ==o.getMonth())
			return 0;
		return -1;
	}
}
