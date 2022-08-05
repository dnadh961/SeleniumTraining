package com.dev.exceptions;

public class ExceptionHandling {

	public static void main(String[] args) {
		int num = 58;
		int divide = 1;
		try {
			System.out.println(num / divide);
		} catch (Exception e) {
			if(e.getMessage().contains("by zero")) {
				divide++;
				System.out.println(num / divide);
			}
		} finally {
			System.out.println("common code");
		}
		//System.out.println("End of the program");
	}
}
