package com.bdqn.shark.part3.sousou.util;

import java.util.ArrayList;
import java.util.Scanner;

import com.bdqn.shark.part3.sousou.card.MobileCard;
import com.bdqn.shark.part3.sousou.card.server.Server;
import com.bdqn.shark.part3.sousou.card.server.Sousou;
import com.bdqn.shark.part3.sousou.card.services.DialService;
import com.bdqn.shark.part3.sousou.card.services.MailService;
import com.bdqn.shark.part3.sousou.card.services.NetService;
import com.bdqn.shark.part3.sousou.card.services.Service;
import com.bdqn.shark.part3.sousou.client.CommonClient;
import com.bdqn.shark.part3.sousou.dao.CardMap;
import com.bdqn.shark.part3.sousou.packages.ChatterFactory;
import com.bdqn.shark.part3.sousou.packages.NetterFactory;
import com.bdqn.shark.part3.sousou.packages.PackageFactory;
import com.bdqn.shark.part3.sousou.packages.PhonePackage;
import com.bdqn.shark.part3.sousou.packages.SuperFactory;

public class CardUtil {

	private PackageFactory []pf;
	private Server server;
	private String num;
	
	public CardUtil() {
		pf = new PackageFactory[]{
				new ChatterFactory(),
				new NetterFactory(),
				new SuperFactory()
		};
		server = new Sousou();
		CardMap.importFromFile("F:\\CardMap.txt");
	}
	public boolean login (String num, String pwd){
		if (CardMap.exists(num)){
			if (CardMap.getCard(num).getClient().getPwd().equals(pwd)){
				this.num = num;
				return true;
			}
			System.out.println("pwd error");
		}
		System.out.println("no user exists");
		return false;
	}
	public void packageInfo() {
		System.out.print("1.");
		pf[0].getPhonePackage().printBasePInfo();
		System.out.print("2.");
		pf[1].getPhonePackage().printBasePInfo();
		System.out.print("3.");
		pf[2].getPhonePackage().printBasePInfo();
	}
	public boolean charge(String num, int money) {
		if (CardMap.exists(num)){
			CardMap.getCard(num).recharge(money);
			return true;
		}
		System.out.println("no such num");
		return false;
	}
	public void register(String name, String pwd, String num, int order) {
		MobileCard mc = new MobileCard(server, new CommonClient(name, pwd), num);
		mc.setPp(pf[order-1].getPhonePackage());
		CardMap.add(mc);
	}
	
	/**
	 * 办卡时检查余额是否足够
	 * */
	public boolean cardAvai(String num) {
		if (!CardMap.exists(num)){
			return false;
		}
		MobileCard mc = CardMap.getCard(num);
		if (0 == mc.consume(mc.getPp().getCost(), "月租"))
			return true;
		CardMap.delete(num);
		return false;
	}
	/**提供嗖嗖服务*/
	public void serve(int type) throws Exception {
		if (num == null){
			System.out.println("请先登录");
			return ;
		}
		Service []service ={
				new DialService(CardMap.getCard(num).getPp().getDail(), num, "10086", "还钱还钱电话"),
				new MailService(CardMap.getCard(num).getPp().getMail(), num, "10086da", "还钱还钱短信"),
				new NetService(CardMap.getCard(num).getPp().getData(), num, "10086小", "还钱还钱数据"),
				};
		switch (type){
			case 1:CardMap.getCard(num).server(service[0]); break;
			case 2:CardMap.getCard(num).server(service[1]); break;
			case 3:CardMap.getCard(num).server(service[2]); break;
			default:
				System.out.println("无此服务");
		}
	}
	/**保存用户信息至文件*/
	public void save() {
		CardMap.save("F:\\CardMap.txt");		
	}
	/**
	 * 消费详单查询
	 * */
	public void checkBill(String num) {
		CardMap.getCard(num).getPp().printInfo();
		ArrayList<String> al;
		al = CardMap.getCard(num).getPp().getDail().getConsumeDetail();
		print (al);
		al = CardMap.getCard(num).getPp().getData().getConsumeDetail();
		print (al);
		al = CardMap.getCard(num).getPp().getMail().getConsumeDetail();
		print (al);
	}
	private void print (ArrayList al){
		for (int i=0; i<al.size(); i++){
			System.out.println(al.get(i));
		}
	}
	/**更换套餐*/
	public void changePp(String num2) {
		packageInfo();
		Scanner scan = new Scanner (System.in);
		int i = scan.nextInt();
		PhonePackage pp =pf[i-1].getPhonePackage();
		pp.printBasePInfo();
		System.out.println("更换成功，从下个月开始生效");
		//CardMap.getCard(num2).setPp();
	}
	/**办理退网手续*/
	public void closeAccount(String num2) {
		if (!CardMap.delete(num2))
			System.out.println("退网失败");
		System.out.println("退网手续办理成功");
		
	}
	/**打印消费详单
	 * @throws Exception */
	public void saveBillDetail(String num) throws Exception {
		String path ="F:\\info.txt";
		CardMap.getCard(num).getPp().saveInfo(path);
	}
}
