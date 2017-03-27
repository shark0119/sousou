package com.bdqn.shark.part3.sousou.card.services;

public interface Service {
	/**
	 * 提供服务，服务详情由此函数获取
	 * @return 返回此次套餐外服务的花费 若套餐内返回0
	 * @throws 服务信息不全则抛出异常
	 * */
	public double doService () throws Exception;
	/**
	 * 测试服务是否可用
	 * 失败的可能原因：1.无始方 2.无终方 3.无服务内容
	 * */
	public boolean workable ();
	/**
	 * @return service name
	 * */
	public String getDescription ();
}
