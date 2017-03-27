package com.bdqn.shark.part3.sousou.card.services;

import com.bdqn.shark.part3.sousou.packages.contents.Data;

public class NetService implements Service {

	protected Data data;
	protected String from, rece, mess;
	/**
	 * @param dial resource
	 * @param from sender
	 * @param rece receiver
	 * @param mess message to send
	 * */
	public NetService (Data data,String from, String rece, String mess){
		this.data = data;
		this.from = from; 
		this.rece = rece;
		this.mess = mess;
	}
	@Override
	public double doService() throws Exception{
		if (!workable())
			throw new Exception ("服务信息不全");
		int cost = mess.length();
		/**
		 * 计算流量
		 * */
		String description= "网络学习java不小心用的流量";
		return data.consume(cost, description);
	}
	@Override
	public boolean workable() {
		if (from == null || from.equals(""))
			return false;
		if (rece == null || rece.equals(""))
			return false;
		if (mess == null || mess.equals(""))
			return false;
		return true;
	}
	@Override
	public String getDescription() {
		return "数据流量";
	}

}
