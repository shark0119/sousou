package com.bdqn.shark.part3.sousou.test.packages;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.bdqn.shark.part3.sousou.packages.contents.Data;
import com.bdqn.shark.part3.sousou.packages.contents.Dial;
import com.bdqn.shark.part3.sousou.packages.contents.Mail;
import com.bdqn.shark.part3.sousou.packages.contents.Resource;

public class ResourceTest {

	public Resource init() {
		Resource resource = new Dial(8, 0.1);

		return resource;
	}

	@Test
	public void testExhausted() {
		Resource re = init();
		re.consume(1, "给同事发短信借钱");
		assertFalse(re.exhausted());
		re.consume(1, "给同事发短信借钱");
		assertFalse(re.exhausted());
		re.consume(1, "给同事发短信借钱");
		assertFalse(re.exhausted());
		re.consume(4, "给同事发短信借钱");
		assertTrue(re.exhausted());
		re.consume(1, "给同事发短信借钱");
		assertTrue(re.exhausted());
		re.consume(1, "给同事发短信借钱");
		assertTrue(re.exhausted());
	}

	@Test
	public void testConsume() {
		Resource re = init();
		double cost = re.consume(3, "打算把钱还给你");
		assertEquals(0, cost, 0.0001);
		cost = re.consume(3, "打算把钱还给你");
		assertEquals(0.1, cost, 0.0001);
		cost = re.consume(3, "打算把钱还给你");
		assertEquals(0.3, cost, 0.0001);
	}

	@Test
	public void testGetBalance() {
		Resource re = init();
		re.consume(6, "aaa");
		System.out.println(re.getBalance());
	}

	@Test
	public void testGetLimit() {
		Resource re = init();
		double cost = re.consume(3, "打算把钱还给你");
		assertEquals(0, cost, 0.0001);
		cost = re.consume(3, "打算把钱还给你");
		assertEquals(0.1, cost, 0.0001);
		cost = re.consume(3, "打算把钱还给你");
		assertEquals(0.3, cost, 0.0001);
		assertEquals(5, 5, 0.00001);
	}

	@Test
	public void testReset() {
		Resource re = init();
		double cost;
		cost = re.consume(3, "打算把钱还给你");
		assertEquals(re.getExtraExpanse(), cost, 0.0001);
		cost = re.consume(3, "are you there");
		assertEquals(re.getExtraExpanse(), cost, 0.0001);
		re.printInfo();
		cost = re.consume(3, "or I'll redraw my money");
		assertEquals(re.getExtraExpanse(), cost, 0.0001);
		
		ArrayList <String> al = re.getConsumeDetail();
		for (int i=0; i<al.size(); i++){
			System.out.println(al.get(i));
		}
		
		assertEquals (re.getBalance(), -1, 0.00001);
		assertEquals (re.getLimit(), 8, 0.000000001);
		re.printInfo();
		re.reset();
		System.out.println("reset.....  success!");
		re.printInfo();
	}

}
