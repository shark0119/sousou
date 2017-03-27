package com.bdqn.shark.part3.sousou.packages.charac;

import java.util.ArrayList;

public interface Consumable {
	boolean exhausted ();
	/**
	 * @param consume 消耗的资源数量
	 * @param description 消费描述
	 * @return 若资源已用完，返回花费的钱，否则返回0
	 * */
	double consume (double consume, String description);
	/**
	 * 重置资源
	 * */
	void reset ();
	/**
	 * @return 返回记录消费详情的链表
	 * */
	public ArrayList<String> getConsumeDetail();
}