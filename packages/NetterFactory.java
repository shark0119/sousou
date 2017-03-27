package com.bdqn.shark.part3.sousou.packages;

public class NetterFactory extends PackageFactory {

	@Override
	public PhonePackage getPhonePackage() {
		pp = new PhonePackage(68, "Íø³æÌ×²Í") {private static final long serialVersionUID = 952245233004190548L;};
		initDail(0, 0.2);
		initData(3*1024, 0.1);
		initMail(0, 0.1);
		return pp;
	}

}
