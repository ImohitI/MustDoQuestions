package edu.javastuff.collectionedu;

import java.util.*;

public class TreeSetDemo {
    	public static void main(String args[]) {
		
        TreeSet<Integer> set = new TreeSet<>();
        set.add(21);
		set.add(32);
		set.add(44);
		set.add(11);
		set.add(54);
		set.add(3);
		set.add(9);
		set.add(41);
		
		System.out.println("TreeSet elements in ascending order " + set);

		System.out.println("Fetching the first element in TreeSet " + set.first());
		System.out.println("Fetching the last element in TreeSet " + set.last());
		System.out.println("Fetching all the elements less than 40 " + set.headSet(41));
		System.out.println("Fetching all the elements greater than 40 " + set.tailSet(41));        
		
        greaterthan50();
	}
	public static void greaterthan50() {

		int[] numbers = { 1, 4, 5, 2, 34, 66, 5, 4, 33, 45, 6, 8, 56, 76, 78, 98, 34, 37, 12, 12, 23, 43, 54, 56 };

		TreeSet<Integer> set = new TreeSet<>();
		
		for(int num : numbers) {
			set.add(num);
		}
		
		System.out.println("All the elements greater than 50 are " + set.tailSet(new Integer(50)));
	}

}
