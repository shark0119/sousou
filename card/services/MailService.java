package com.bdqn.shark.part3.sousou.card.services;

import com.bdqn.shark.part3.sousou.packages.contents.Mail;

public class MailService implements Service {
	
	protected Mail mail;
	protected String from, rece, mess;

	/**
	 * @param dial resource
	 * @param from sender
	 * @param rece receiver
	 * @param mess message to send
	 * */
	public MailService(Mail mail,String from, String rece, String mess) {
		this.mail = mail;
		this.from = from; 
		this.rece = rece;
		this.mess = mess;
	}
	@Override
	public double doService()throws Exception{
		if (!workable())
			throw new Exception ("服务信息不全");
		/**
		 * 进行收件人分析（群发）
		 * */
		int count = 1;
		String description= "通知大家每天不上课";
		return mail.consume(count, description);
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
		return "短信";
	}

}
