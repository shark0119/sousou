package com.bdqn.shark.part3.sousou.biz;

import java.util.Scanner;

import com.bdqn.shark.part3.sousou.dao.CardMap;
import com.bdqn.shark.part3.sousou.util.CardUtil;

public class SosoMgr {

	protected Scanner scan;
	protected int choice;
	protected CardUtil cu;

	public SosoMgr() {
		scan = new Scanner(System.in);
		cu = new CardUtil();
	}

	public static void main(String[] args) throws Exception {
		SosoMgr sm = new SosoMgr();
		sm.nonName();
	}

	/**
	 * *************欢迎使用嗖嗖移动业务大厅*************** 1.用户登录 2.用户注册 3.话费充值 4.资费说明
	 * 5.退出系统 请选择： 1. login() 2. userRegister() 3.recharge() 4. packageInfo()
	 * @throws Exception 
	 */
	public void nonName() throws Exception {
		int choice;
		while (true) {
			choice = showMainMenu();
			switch (choice) {
			case 5:
				cu.save();
				System.out.println("SOUSOU已成功退出");
				return;
			case 1:
				login();
				continue;
			case 2:
				userRegister();
				continue;
			case 3:
				recharge(null);
				continue;
			case 4:
				//13916662359
				packageInfo();
				continue;
			default:
				System.out.println("无效输入！");
			}
		}
	}

	// 主菜单显示
	private int showMainMenu() {
		System.out.println("*************欢迎使用嗖嗖移动业务大厅***************");
		System.out.println("1.用户登录   2.用户注册   3.话费充值  4.资费说明  5.退出系统");
		System.out.print("请选择：");
		choice = scan.nextInt();
		return choice;
	}

	// 1
	private void login() throws Exception {
		scan = new Scanner(System.in);
		System.out.print("请输入用户名：");
		String num = scan.nextLine();
		System.out.print("请输入密码：");
		String pwd = scan.nextLine();
		if (!cu.login(num, pwd)) {
			System.out.println("登录失败");
			return;
		}
		System.out.println("登录成功");
		userMenu(num);
	}

	/**
	 * 
	 * 
	 ***** 嗖嗖移动用户菜单***** 1.本月账单查询 2.套餐余量查询 3.打印消费详单 4.套餐变更 5.办理退网 其余键返回上一层
	 * @throws Exception 
	 * 
	 */
	private void userMenu(String num) throws Exception {
		String line;
		while (true) {
			scan = new Scanner(System.in);
			System.out.println("*****嗖嗖移动用户菜单*****\n" + 
					"1.使用嗖嗖\n" + 
					"2.消费详单查询\n" + 
					"3.打印消费详单\n" + 
					"4.套餐变更\n"+ 
					"5.办理退网\n" + 
					"其余键返回上一层");
			line = scan.nextLine();
			if (line.equals("1")) {
				try {
					userSousou();
				} catch (Exception e) {
					System.out.println("服务失败");
				}
				continue;
			} else if (line.equals("2")) {
				cu.checkBill(num);
			} else if (line.equals("3")) {
				cu.saveBillDetail(num);
			} else if (line.equals("4")) {
				cu.changePp(num);
			} else if (line.equals("5")) {
				cu.closeAccount(num);
				return;
			} else
				return;
		}
	}

	// 1.6
	private void userSousou() throws Exception {
		System.out.print("请选择服务：1.电话 2.短信 3.网络 4.退出：");
		switch (scan.nextInt()) {
		/**
		 * 调用电话服务
		 */
		case 1:
			cu.serve(1);
			break;
		/**
		 * 调用短信服务
		 */
		case 2:
			cu.serve(2);
			break;
		/**
		 * 调用网络服务
		 */
		case 3:
			cu.serve(3);
			break;
		/**
		 * 退出服务
		 */
		case 4:
			break;
		default:
			System.out.println("无此服务!");
		}
		System.out.println("服务结束");
	}

	// 2
	private void userRegister() {
		scan = new Scanner(System.in);
		System.out.print("请输入用户名：");
		String name = scan.nextLine();
		System.out.print("请输入密码：");
		String pwd = scan.nextLine();
		/**
		 * 展示可选号码
		 */
		String[] avaiNum = CardMap.getAvailableNum(9);
		for (int i = 1; i < avaiNum.length + 1; i++) {
			System.out.print(i + "." + avaiNum[i - 1] + "\t");
			if (i % 3 == 0)
				System.out.println();
		}
		System.out.print("请选择号码：");
		/**
		 * */
		int order = scan.nextInt();
		String num;
		if (order > 0 && order < avaiNum.length) {
			num = avaiNum[order - 1];
			cu.packageInfo();
			System.out.println("你想要订购哪个包：");
			order = scan.nextInt();
			cu.register(name, pwd, num, order);
			recharge(num);
			if (cu.cardAvai(num)) {
				System.out.println("注册成功");
				return;
			}
			System.out.println("余额不足，注册失败");
		}
	}

	// 3
	private void recharge(String num) {
		String regex = "\\d{11}";
		scan = new Scanner(System.in);
		if (num == null) {
			while (true) {
				System.out.print("请输入充值号码：");
				num = scan.nextLine();
				if (num.matches(regex))
					break;
				else
					System.out.println("号码格式错误");
			}
		}
		if (!num.matches(regex)) {
			System.out.println("号码格式错误");
			return;
		}
		System.out.print("请输入充值数目：");
		int money = scan.nextInt();
		/**
		 * 充值代码
		 */
		if (cu.charge(num, money)) {
			System.out.println("充值成功");
			return;
		}
		System.out.println("充值失败");
	}

	// 4
	private void packageInfo() {
		/**
		 * 打印套餐资费说明
		 */
		cu.packageInfo();
	}
}
