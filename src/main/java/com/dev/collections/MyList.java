package com.dev.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyList {
	
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Sirisha");
		names.add("Divya");
		names.add("Chandra");
		names.add("Supriya");
		/*
		 * for(int i=0; i<names.size(); i++) { System.out.println((i+1) + ". " +
		 * names.get(i)); }
		 */
		/*
		 * int i = 0; while(i<names.size()) { System.out.println((i+1) + ". " +
		 * names.get(i)); i++; }
		 */
		/*
		 * Iterator<String> namesI = names.iterator(); while(namesI.hasNext()) {
		 * System.out.println(namesI.next()); }
		 */
		int i = 11;
		do {
			System.out.println( i + ". some value");
			i++;
		}while(i<10);
		
		while(i<10) {
			System.out.println( i + ". some value");
		}
	}
}
