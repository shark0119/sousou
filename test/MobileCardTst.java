package com.bdqn.shark.part3.sousou.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.bdqn.shark.part3.sousou.card.MobileCard;
import com.bdqn.shark.part3.sousou.card.server.Server;
import com.bdqn.shark.part3.sousou.card.server.Sousou;
import com.bdqn.shark.part3.sousou.card.services.DialService;
import com.bdqn.shark.part3.sousou.card.services.MailService;
import com.bdqn.shark.part3.sousou.card.services.NetService;
import com.bdqn.shark.part3.sousou.card.services.Service;
import com.bdqn.shark.part3.sousou.client.Client;
import com.bdqn.shark.part3.sousou.client.CommonClient;
import com.bdqn.shark.part3.sousou.dao.CardMap;
import com.bdqn.shark.part3.sousou.packages.ChatterFactory;
import com.bdqn.shark.part3.sousou.packages.NetterFactory;
import com.bdqn.shark.part3.sousou.packages.PackageFactory;
import com.bdqn.shark.part3.sousou.packages.SuperFactory;

public class MobileCardTst {

	@Test
	public void test() {
		String name= null, pwd=null, num = null;

		name= "zhangsan";
		pwd="123";
		num= CardMap.getAvailableNum(1)[0];
		Server server = new Sousou ();
		Client client = new CommonClient(name, pwd);
		MobileCard mc = new MobileCard(server, client, num);
		mc.recharge(58);
		PackageFactory []pf = {
				new ChatterFactory(),
				new NetterFactory(),
				new SuperFactory(),
			};
		
		mc.setPp(pf[2].getPhonePackage());
		
		String from = "abc", rece ="abc", mess= "abc";
		Service []service ={
				new MailService(mc.getPp().getMail(), from, rece, mess),
				new DialService(mc.getPp().getDail(), from, rece, mess),
				new NetService (mc.getPp().getData(), from, rece, mess)
		};
		
		CardMap.add(mc);
		try {
			mc.server(service[0]);
			mc.server(service[1]);
			mc.server(service[2]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mc = CardMap.getCard(num);
		
		mc.printInfo();
	
		ArrayList al= mc.getPp().getDail().getConsumeDetail();
		for (int i=0; i<al.size(); i++){
			System.out.println(al.get(i));
		}
		al= mc.getPp().getData().getConsumeDetail();
		for (int i=0; i<al.size(); i++){
			System.out.println(al.get(i));
		}
		al= mc.getPp().getMail().getConsumeDetail();
		for (int i=0; i<al.size(); i++){
			System.out.println(al.get(i));
		}
	}
	

}
