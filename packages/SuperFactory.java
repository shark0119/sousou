package com.bdqn.shark.part3.sousou.packages;

import com.bdqn.shark.part3.sousou.packages.PackageFactory;
import com.bdqn.shark.part3.sousou.packages.PhonePackage;

public class SuperFactory extends PackageFactory {

	@Override
	public PhonePackage getPhonePackage() {
		pp = new PhonePackage(78 ,"³¬ÈËÌ×²Í") {
			private static final long serialVersionUID = 7991186955944079811L;
			};
		initDail(200, 0.2);
		initData(1024, 0.1);
		initMail(50, 0.1);
		return pp;
	}

}
