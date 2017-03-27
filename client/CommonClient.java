package com.bdqn.shark.part3.sousou.client;

public class CommonClient extends Client {

	/**
	 * 
	 */
	private static final long serialVersionUID = -410126851290955785L;

	public CommonClient(String name, String pwd, String iD) {
		super(name, pwd, iD);
	}
	public CommonClient (String name, String pwd){
		super (name, pwd, null);
	}

}
