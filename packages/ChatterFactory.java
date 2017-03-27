package com.bdqn.shark.part3.sousou.packages;

public class ChatterFactory extends PackageFactory {

	@Override
	public PhonePackage getPhonePackage() {
		pp= new PhonePackage(58, "»°ßëÌ×²Í") {
			private static final long serialVersionUID = -1673236235793638849L;	
			};
		initDail(500, 0.2);
		initData(0, 0.1);
		initMail(30, 0.1);
		return pp;
	}

}
