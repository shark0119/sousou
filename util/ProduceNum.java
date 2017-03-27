package com.bdqn.shark.part3.sousou.util;

import java.util.Calendar;
import java.util.Random;

public class ProduceNum{
	private static Random rand= new Random(Calendar.getInstance().getTimeInMillis());
	
	public static String getNum (){
		return "139"+Integer.toString(rand.nextInt(90000000)+10000000);
	}
	
	public static void main(String []args){
		System.out.println(getNum());
		System.out.println(getNum());
		System.out.println(getNum());
		System.out.println(getNum());
	}
}
