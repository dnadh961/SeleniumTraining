package com.dev.java;

import java.util.ArrayList;
import java.util.List;

public class ListFilter {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("a");
		names.add("b");
		names.add("c");
		names.add("d");
		names.add("e");
		names.add("f");
		names.add("g");
		names.add("h");
		List<String> updatedNames = removeEvenIndexes(names, 5);
		System.out.println(updatedNames);
	}
	
	/**
	 * This method is used to remove the objects of a list at given index
	 * @param names list of objects
	 * @param index index number
	 * @return filtered list of objects by removing objects which are multiples of given number
	 */
	private static List<String> removeEvenIndexes(List<String> names, int index) {
		int len = names.size();
		int counter = 0;
		/*
		 * for(int i=0; i<len; i++) { if(i%index == 0) { names.remove(i-counter++); } }
		 */
		for(int i=0; i<len; i = i+index) {
			names.remove(i-counter++);
		}
		return names;
	}
	
	//[a, b, c, d, e, f, g , h] - input
	// number - 2
	
	//[b, d, f, h] - output 
}
