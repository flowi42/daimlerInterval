package com.fdmgroup.daimlerInterval;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.daimlerInterval.model.Interval;

public class Modeltest {
	
	private Interval interval;

	@Before
	public void setUp() throws Exception {
		interval = new Interval(20, 26);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getValue1Test() {
		double intervalue = interval.getValue1();
		assertEquals(20, intervalue, 0.01);
	}
	
	@Test
	public void getValue2Test() {
		double intervalue = interval.getValue2();
		assertEquals(26, intervalue, 0.01);
	}
	
	@Test
	public void setValue1Test() {
		interval.setValue1(24);
		double intervalue = interval.getValue1();
		assertEquals(24, intervalue, 0.01);
	}
	
	@Test
	public void setValue2Test() {
		interval.setValue2(28);
		double intervalue = interval.getValue2();
		assertEquals(28, intervalue, 0.01);
	}
	
	@Test
	public void constructorTest() {
		Interval interval2 = new Interval(12, 56); 
		double intervalue = interval2.getValue2();
		assertEquals(56, intervalue, 0.01);
	}
	
	@Test
	public void constructorEmptyTest() {
		Interval interval2 = new Interval(); 
		interval2.setValue1(12);
		interval2.setValue2(56);
		double intervalue = interval2.getValue2();
		assertEquals(56, intervalue, 0.01);
	}
	
	@Test
	public void toStringTest() {
		Interval interval2 = new Interval(12, 56); 
		String string = interval2.toString();
		assertEquals("Interval [value1=12.0, value2=56.0]", string);
	}
	

	
	

}
