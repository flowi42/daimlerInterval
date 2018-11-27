package com.fdmgroup.daimlerInterval.model;

/**Interval is the class that combines two values to form an interval*/

public class Interval {

	private double value1;
	private double value2;
	
	public Interval() {
		super();
	}

	public Interval(double value1, double value2) {
		super();
		this.value1 = value1;
		this.value2 = value2;
	}

	public double getValue1() {
		return value1;
	}

	public void setValue1(double value1) {
		this.value1 = value1;
	}

	public double getValue2() {
		return value2;
	}

	public void setValue2(double value2) {
		this.value2 = value2;
	}

	@Override
	public String toString() {
		return "Interval [value1=" + value1 + ", value2=" + value2 + "]";
	}
	
}
