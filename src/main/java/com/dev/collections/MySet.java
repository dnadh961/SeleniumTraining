package com.dev.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MySet {

	public static void main(String[] args) {
		//Set<String> names = new HashSet<>();
		Set<String> names = new LinkedHashSet<>();
		//Set<String> names = new TreeSet<>();
		names.add("Sirisha");
		names.add("Divya");
		names.add("Chandra");
		names.add("Supriya");
		System.out.println(names);
		
		// [Chandra, Sirisha, Divya, Supriya] - HashSet
		// [Sirisha, Divya, Chandra, Supriya] - LinkedHashSet
		// [Chandra, Divya, Sirisha, Supriya] - TreeSet
	}
}
