package com.bdqn.shark.part3.sousou.card.services;

import com.bdqn.shark.part3.sousou.packages.contents.Dial;

public class DialService implements Service {

	protected Dial dial;
	protected String from, rece, mess;
	
	/**
	 * @param dial resource
	 * @param from sender
	 * @param rece receiver
	 * @param mess message to send
	 * */
	public DialService(Dial dial,String from, String rece, String mess) {
		this.dial = dial;
		this.from = from; 
		this.rece = rece;
		this.mess = mess;
	}
	@Override
	public double doService()throws Exception{
		if (!workable())
			throw new Exception ("������Ϣ��ȫ");
		/**
		 * ����ͨ��ʱ��
		 * */
		int time =10 ;
		String description= "����һ�������ĵ绰";
		return dial.consume(time, description);
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
		return "����";
	}

}
