package com.dev.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyMap {

	public static void main(String[] args) {
		//Map<Integer, String> stuIdWithName = new HashMap<>();
		//Map<Integer, String> stuIdWithName = new LinkedHashMap<>();
		Map<Integer, String> stuIdWithName = new TreeMap<>();
		stuIdWithName.put(302, "Supriya");
		stuIdWithName.put(78, "Divya");
		stuIdWithName.put(201, "Chandra");
		stuIdWithName.put(23, "Sirisha");
	}
}
