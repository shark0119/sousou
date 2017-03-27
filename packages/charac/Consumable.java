package com.bdqn.shark.part3.sousou.packages.charac;

import java.util.ArrayList;

public interface Consumable {
	boolean exhausted ();
	/**
	 * @param consume ���ĵ���Դ����
	 * @param description ��������
	 * @return ����Դ�����꣬���ػ��ѵ�Ǯ�����򷵻�0
	 * */
	double consume (double consume, String description);
	/**
	 * ������Դ
	 * */
	void reset ();
	/**
	 * @return ���ؼ�¼�������������
	 * */
	public ArrayList<String> getConsumeDetail();
}