package com.bdqn.shark.part3.sousou.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import org.junit.Test;

import com.bdqn.shark.part3.sousou.card.MobileCard;
import com.bdqn.shark.part3.sousou.card.server.Server;
import com.bdqn.shark.part3.sousou.card.server.Sousou;
import com.bdqn.shark.part3.sousou.client.Client;
import com.bdqn.shark.part3.sousou.client.CommonClient;
import com.bdqn.shark.part3.sousou.dao.CardMap;
import com.bdqn.shark.part3.sousou.util.ProduceNum;

class A implements Serializable{
	String mess;
	public A(String mess) {
		this.mess  =mess;
	}
	public void print(){
		System.out.println(mess);
	}
}
public class CardMapTest {

	//@Test
	public void test() {

		String num[]= CardMap.getAvailableNum(9);
		for (int i=0; i<9; i++){
			System.out.println(num[i]);
		}
	}
	
	@Test
	public void testCardMap (){
//		Server server = new Sousou ();
//		Client client = new CommonClient("wangwu", "123");
//		String num=ProduceNum.getNum();
//		System.out.println(num);
//		CardMap.add(num, new MobileCard(server, client, num));
//		CardMap.save("F:\\abc.txt");
		CardMap.importFromFile("F:\\abc.txt");
		System.out.println(CardMap.exists("13961285839"));
	}
	
//	public static void main(String args[]) throws FileNotFoundException, IOException, Exception{
//		HashMap <String , A> hm = new HashMap<>();
//
//		hm.put("abc", new A("cde"));
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File ("F:\\abc.txt")));
//		oos.writeObject(hm);
//		oos.flush();
//		oos.close();
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("F:\\abc.txt")));
//		hm= (HashMap)ois.readObject();
//		hm.get("abc").print();
//		ois.close();
//	}

}
