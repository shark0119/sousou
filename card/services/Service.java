package com.bdqn.shark.part3.sousou.card.services;

public interface Service {
	/**
	 * �ṩ���񣬷��������ɴ˺�����ȡ
	 * @return ���ش˴��ײ������Ļ��� ���ײ��ڷ���0
	 * @throws ������Ϣ��ȫ���׳��쳣
	 * */
	public double doService () throws Exception;
	/**
	 * ���Է����Ƿ����
	 * ʧ�ܵĿ���ԭ��1.��ʼ�� 2.���շ� 3.�޷�������
	 * */
	public boolean workable ();
	/**
	 * @return service name
	 * */
	public String getDescription ();
}
