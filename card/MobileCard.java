package com.bdqn.shark.part3.sousou.card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import com.bdqn.shark.part3.sousou.card.server.Server;
import com.bdqn.shark.part3.sousou.card.services.Service;
import com.bdqn.shark.part3.sousou.client.Client;
import com.bdqn.shark.part3.sousou.packages.PhonePackage;
import com.bdqn.shark.part3.sousou.packages.charac.Consumable;

public class MobileCard implements Consumable , Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4364659610739695984L;
	protected double balance;
	protected PhonePackage pp;
	protected String num;
	protected Client client;
	protected Server server;
	protected Usage usage;
	protected ArrayList <String> consumeDetail;

	public MobileCard(Server server, Client client, String num) {
		this.server = server;
		this.client = client;
		this.num = num;
		consumeDetail = new ArrayList <String>();
	}
	/**
	 * ���ش˿�Ŀǰ�ײ͵�ʹ�����
	 * */
	public Usage getUsage (){
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		double mailCost = pp.getMail().getLimit()-pp.getMail().getBalance();
		double dailCost = pp.getDail().getLimit()-pp.getDail().getBalance();
		double inetCost = pp.getData().getLimit()-pp.getData().getBalance();
		return new Usage(num, year, month, balance, mailCost, dailCost, inetCost);
	}
	public Client getClient() {
		return client;
	}
	public Server getServer() {
		return server;
	}
	public String getNum() {
		return num;
	}
	@Override
	public boolean exhausted() {
		if (balance>0)
			return false;
		return true;
	}
	
	@Override
	public double consume(double consume,String description) {
		if (consume == 0)
			return 0;
		consumeDetail.add(description+"������"+consume);
		if (balance > 0){
			balance -= consume;
			if (balance > 0)
				return 0;
			else
				return Math.abs(balance);
		}
		balance -= consume;
		return consume;
	}
	public void recharge (double money){
		balance += money;
	}
	public double getBalance() {
		return balance;
	}
	public PhonePackage getPp() {
		return pp;
	}
	public void setPp(PhonePackage pp) {
		this.pp = pp;
	}
	public void server (Service service) throws Exception{
		server.server (service , this);
	}
	/**
	 * ɾ���ײ�
	 * ɾ���ͻ�
	 * ɾ��������Ϣ
	 * ɾ������
	 * ɾ�����
	 * �����������
	 * */
	@Override
	public void reset() {
		pp= null;
		client =null;
		num = null;
		server = null;
		balance =0;
		for (int i=consumeDetail.size(); i>0 ; i--){
			consumeDetail.remove(i-1);
		}
	}
	public void reset (Server server, Client client, String num){
		this.server = server;
		this.client = client;
		this.num = num;
	}
	/**
	 * �鿴��ǰ�ײ�ʹ�����
	 * */
	public void printInfo (){
		pp.printInfo();
	}
	@Override
	public ArrayList<String> getConsumeDetail() {
		return consumeDetail;
	}
}
