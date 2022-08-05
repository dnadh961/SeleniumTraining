package com.dev.oops;

public class Maths {

	public void add(int a, int b) {
		System.out.println(a+b);
	}
	
	public void add(int a, int b, int c) {
		System.out.println(a+b+c);
	}
	
	public void add(double a, double b) {
		System.out.println(a+b);
	}
	
	public static void main(String[] args) {
		Maths m = new Maths();
		m.add(2, 3);
		m.add(2, 3, 4);
		m.add(2.3, 3.4);
	}
}
