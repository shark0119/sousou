package com.bdqn.shark.part3.sousou.packages.contents;

import java.io.Serializable;
import java.util.ArrayList;

import com.bdqn.shark.part3.sousou.packages.charac.Consumable;
import com.bdqn.shark.part3.sousou.packages.charac.ExtraCharge;

public abstract class Resource implements Consumable, ExtraCharge ,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1217732796349959304L;
	protected double limit;
	protected double extraCharge;
	protected double balance;
	protected ArrayList <String>consumeDetail;
	/**
	 * @param limit 预设资源数量
	 * @param charge 超出部分的收费标准
	 * */
	public Resource(double limit, double charge){
		this.limit = limit;
		this.balance = limit;
		this.extraCharge = charge;
		consumeDetail = new ArrayList<String>();
	}
	@Override
	public boolean exhausted() {
		if (balance > 0)
			return false;
		return true;
	}
	@Override
	public double consume(double consume, String description) {
		if (balance>0){
			balance -= consume;
			consumeDetail.add(description(consume, description));
			if (balance > 0)
				return 0f;
			return Math.abs (balance)*getExtraCharge();
		}
		balance -= consume;
		consumeDetail.add(description(consume, description));
		return consume*getExtraCharge();
	}
	/**
	 * 重置可用余额为预设数量
	 * 清空消费详情描述
	 * */
	public void reset (){
		balance = limit;
		for (int i=consumeDetail.size(); i>0 ; i--){
			consumeDetail.remove(i-1);
		}
	}
	@Override
	public double getExtraCharge() {
		return extraCharge;
	}
	@Override
	public void setExtraCharge(double charge) {
		this.extraCharge = charge;
	}
	public double getBalance() {
		return balance;
	}
	public double getExtraExpanse (){
		return balance<0?(Math.abs(balance)*extraCharge):0;
	}
	public double getLimit() {
		return limit;
	}
	@Override
	public ArrayList<String> getConsumeDetail() {
		return consumeDetail;
	}
	/**
	 * @param consume 所消耗资源数量
	 * @param description 对应消费详情描述
	 * @return 根据不同的资源生成不同的消费描述
	 * */
	protected abstract String description(double consume, String description);
	public abstract void printInfo ();
}
