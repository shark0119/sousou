package com.bdqn.shark.part3.sousou.client;

import java.io.Serializable;

public abstract class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3010866883994642995L;
	private String name, pwd, ID;

	public Client(String name, String pwd, String iD) {
		super();
		this.name = name;
		this.pwd = pwd;
		ID = iD;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public String getID() {
		return ID;
	}
	
	
}
