package com.bdqn.shark.part3.sousou.packages;

import com.bdqn.shark.part3.sousou.packages.contents.Dial;

import java.io.Serializable;

import com.bdqn.shark.part3.sousou.packages.contents.Data;
import com.bdqn.shark.part3.sousou.packages.contents.Mail;

public abstract class PackageFactory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3449702697788763026L;
	protected PhonePackage pp;
	public abstract PhonePackage getPhonePackage();

	protected void initMail (double amount, double charge){
		pp.setMail(new Mail(amount, charge));
	}
	protected void initData (double amount, double charge){
		pp.setData(new Data(amount, charge));
	}
	protected void initDail (double amount , double charge){
		pp.setDail(new Dial(amount, charge));
	}
}
