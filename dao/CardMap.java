package com.bdqn.shark.part3.sousou.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import com.bdqn.shark.part3.sousou.card.MobileCard;
import com.bdqn.shark.part3.sousou.util.ProduceNum;

public class CardMap {
	private static HashMap<String, MobileCard> cardMap = new HashMap<>();
	private static TreeSet<String> numSet = new TreeSet<>();

	private CardMap() {	}
	@SuppressWarnings("unchecked")
	public static void importFromFile (String path){
		File file;
		ObjectInputStream ois= null;
		
		file= new File (path);
		try {
			ois= new ObjectInputStream (new FileInputStream (file));
			cardMap= ((HashMap<String, MobileCard>) ois.readObject());
		} catch (Exception e) {
			System.out.println("目前文件中无存储记录");
			return;
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void save (String path){
		File file; 
		FileOutputStream os= null;
		ObjectOutputStream oos = null;
		
		file =new File(path);
		try {
			os= new FileOutputStream(file);
			oos = new ObjectOutputStream(os);
			oos.writeObject(cardMap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				oos.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static boolean exists(String num) {
		return cardMap.containsKey(num);
	}
	public static boolean add(MobileCard mc) {
		String num =mc.getNum();
		if (num == null || num.equals(""))
			return false;
		if (exists(num))
			return false;
		cardMap.put(num, mc);
		return true;
	}

	public static boolean delete(String num) {
		if (null == cardMap.remove(num)) {
			return false;
		}
		return true;
	}
	public static HashMap<String, MobileCard> getCardMap() {
		return cardMap;
	}
	/**
	 * 
	 * */
	public static String[] getAvailableNum(int n) {
		String[] avai = new String[n];
		if (numSet.size() == n) {

		} else if (numSet.size() < n) {
			addNum(n - numSet.size());
		}
		Iterator<String> it = numSet.iterator();
		for (int i = 0; i < n; i++) {
			avai[i] = it.next();
		}
		return avai;
	}
	private static void addNum(int size) {
		String num;
		for (int i = 0; i < size; i++) {
			while (true) {
				num = ProduceNum.getNum();
				if (!cardMap.containsKey(num) && !numSet.contains(num))
					break;
			}
			numSet.add(num);
		}
	}
	public static MobileCard getCard(String num) {
		return cardMap.get(num);
	}
}
