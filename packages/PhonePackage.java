package com.bdqn.shark.part3.sousou.packages;

import com.bdqn.shark.part3.sousou.packages.contents.Dial;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Serializable;

import com.bdqn.shark.part3.sousou.packages.contents.Data;
import com.bdqn.shark.part3.sousou.packages.contents.Mail;

public abstract class PhonePackage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3656159994211174569L;
	private Dial dial;
	private Data data; 
	private Mail mail;
	private double cost;
	private String name=null;
	
	public PhonePackage(double cost, String name){
		this.cost= cost;
		this.name = name;
	}
	public void printInfo (){
		if (name == null)
			return;
		System.out.println(name+"����"+cost+"Ԫ");
		System.out.println("ͨ��"+getDail().getLimit()+
							"����,����"+getMail().getLimit()+"��,����"+getData().getLimit()+"M");
		System.out.println("�������֣�����"+getMail().getExtraCharge()+"/��,ͨ��"+getDail().getExtraCharge()
				+"/����,����"+getData().getExtraCharge()+"/M");
		getDail().printInfo();
		getMail().printInfo();
		getData().printInfo();		
	}
	public void printBasePInfo (){
		if (name == null)
			return;
		System.out.println(name+cost+"Ԫ");
		System.out.println("ͨ��"+getDail().getLimit()+
							"����,����"+getMail().getLimit()+"��,����"+getData().getLimit()+"M");
		System.out.println("�������֣�����"+getMail().getExtraCharge()+"/��,ͨ��"+getDail().getExtraCharge()
				+"/����,����"+getData().getExtraCharge()+"/M");
	}
	public void saveInfo (String path) throws Exception{
		File file = new File (path);
		FileWriter fw = new FileWriter (file);
		fw.write(name+cost+"Ԫ");
		fw.write("ͨ��"+getDail().getLimit()+
							"����,����"+getMail().getLimit()+"��,����"+getData().getLimit()+"M");
		fw.write("�������֣�����"+getMail().getExtraCharge()+"/��,ͨ��"+getDail().getExtraCharge()
				+"/����,����"+getData().getExtraCharge()+"/M");	
		fw.close();
	}
	/**
	 * @return ����
	 * */
	public double getCost (){
		return cost;
	}
	public void setCost (double cost){
		this.cost= cost;
	}
	public Dial getDail() {
		return dial;
	}
	public void setDail(Dial dial) {
		this.dial = dial;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public Mail getMail() {
		return mail;
	}
	public void setMail(Mail mail) {
		this.mail = mail;
	}
	public void reset (){
		mail.reset();
		data.reset();
		dial.reset();
	}
}
