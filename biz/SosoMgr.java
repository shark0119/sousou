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
	 * *************��ӭʹ�����ƶ�ҵ�����*************** 1.�û���¼ 2.�û�ע�� 3.���ѳ�ֵ 4.�ʷ�˵��
	 * 5.�˳�ϵͳ ��ѡ�� 1. login() 2. userRegister() 3.recharge() 4. packageInfo()
	 * @throws Exception 
	 */
	public void nonName() throws Exception {
		int choice;
		while (true) {
			choice = showMainMenu();
			switch (choice) {
			case 5:
				cu.save();
				System.out.println("SOUSOU�ѳɹ��˳�");
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
				System.out.println("��Ч���룡");
			}
		}
	}

	// ���˵���ʾ
	private int showMainMenu() {
		System.out.println("*************��ӭʹ�����ƶ�ҵ�����***************");
		System.out.println("1.�û���¼   2.�û�ע��   3.���ѳ�ֵ  4.�ʷ�˵��  5.�˳�ϵͳ");
		System.out.print("��ѡ��");
		choice = scan.nextInt();
		return choice;
	}

	// 1
	private void login() throws Exception {
		scan = new Scanner(System.in);
		System.out.print("�������û�����");
		String num = scan.nextLine();
		System.out.print("���������룺");
		String pwd = scan.nextLine();
		if (!cu.login(num, pwd)) {
			System.out.println("��¼ʧ��");
			return;
		}
		System.out.println("��¼�ɹ�");
		userMenu(num);
	}

	/**
	 * 
	 * 
	 ***** ���ƶ��û��˵�***** 1.�����˵���ѯ 2.�ײ�������ѯ 3.��ӡ�����굥 4.�ײͱ�� 5.�������� �����������һ��
	 * @throws Exception 
	 * 
	 */
	private void userMenu(String num) throws Exception {
		String line;
		while (true) {
			scan = new Scanner(System.in);
			System.out.println("*****���ƶ��û��˵�*****\n" + 
					"1.ʹ����\n" + 
					"2.�����굥��ѯ\n" + 
					"3.��ӡ�����굥\n" + 
					"4.�ײͱ��\n"+ 
					"5.��������\n" + 
					"�����������һ��");
			line = scan.nextLine();
			if (line.equals("1")) {
				try {
					userSousou();
				} catch (Exception e) {
					System.out.println("����ʧ��");
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
		System.out.print("��ѡ�����1.�绰 2.���� 3.���� 4.�˳���");
		switch (scan.nextInt()) {
		/**
		 * ���õ绰����
		 */
		case 1:
			cu.serve(1);
			break;
		/**
		 * ���ö��ŷ���
		 */
		case 2:
			cu.serve(2);
			break;
		/**
		 * �����������
		 */
		case 3:
			cu.serve(3);
			break;
		/**
		 * �˳�����
		 */
		case 4:
			break;
		default:
			System.out.println("�޴˷���!");
		}
		System.out.println("�������");
	}

	// 2
	private void userRegister() {
		scan = new Scanner(System.in);
		System.out.print("�������û�����");
		String name = scan.nextLine();
		System.out.print("���������룺");
		String pwd = scan.nextLine();
		/**
		 * չʾ��ѡ����
		 */
		String[] avaiNum = CardMap.getAvailableNum(9);
		for (int i = 1; i < avaiNum.length + 1; i++) {
			System.out.print(i + "." + avaiNum[i - 1] + "\t");
			if (i % 3 == 0)
				System.out.println();
		}
		System.out.print("��ѡ����룺");
		/**
		 * */
		int order = scan.nextInt();
		String num;
		if (order > 0 && order < avaiNum.length) {
			num = avaiNum[order - 1];
			cu.packageInfo();
			System.out.println("����Ҫ�����ĸ�����");
			order = scan.nextInt();
			cu.register(name, pwd, num, order);
			recharge(num);
			if (cu.cardAvai(num)) {
				System.out.println("ע��ɹ�");
				return;
			}
			System.out.println("���㣬ע��ʧ��");
		}
	}

	// 3
	private void recharge(String num) {
		String regex = "\\d{11}";
		scan = new Scanner(System.in);
		if (num == null) {
			while (true) {
				System.out.print("�������ֵ���룺");
				num = scan.nextLine();
				if (num.matches(regex))
					break;
				else
					System.out.println("�����ʽ����");
			}
		}
		if (!num.matches(regex)) {
			System.out.println("�����ʽ����");
			return;
		}
		System.out.print("�������ֵ��Ŀ��");
		int money = scan.nextInt();
		/**
		 * ��ֵ����
		 */
		if (cu.charge(num, money)) {
			System.out.println("��ֵ�ɹ�");
			return;
		}
		System.out.println("��ֵʧ��");
	}

	// 4
	private void packageInfo() {
		/**
		 * ��ӡ�ײ��ʷ�˵��
		 */
		cu.packageInfo();
	}
}
