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
			throw new Exception ("������Ϣ��ȫ");
		int cost = mess.length();
		/**
		 * ��������
		 * */
		String description= "����ѧϰjava��С���õ�����";
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
		return "��������";
	}

}
