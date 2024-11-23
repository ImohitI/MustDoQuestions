package edu.javastuff.collectionedu;

import java.util.*;

public class LinkedHashMapDejmo {
 	public static void main(String args[]) {
		
		HashMap<String, Integer> stocks = new LinkedHashMap<>();
		
		stocks.put("Apple", 123);
		stocks.put("BMW", 54);
		stocks.put("Google", 87);
		stocks.put("Microsoft", 232);
		stocks.put("Oracle", 76);
		
		HashMap<String, Integer> stocks2 = new LinkedHashMap<>(16, 0.75f, true);
		// stocks2.put("Apple", 123);
		// stocks2.put("BMW", 54);
		// stocks2.put("Google", 87);
		// stocks2.put("Microsoft", 232);
		// stocks2.put("Oracle", 76);
		stocks2.putAll(stocks);

		System.out.println(stocks2);	
		stocks2.get("Google");
		System.out.println(stocks2);	

	}   
}
