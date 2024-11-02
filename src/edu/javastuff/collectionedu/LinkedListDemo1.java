package edu.javastuff.collectionedu;

import java.util.*;

public class LinkedListDemo1 {

	public static void main(String args[]) {
		LinkedList<Integer> linkedList = new LinkedList<>();

		linkedList.add(1); // Adds 1 to the list.
		linkedList.add(2); // Adds 2 to the end of the list.
		linkedList.addLast(3); // Adds 3 to the end of the list.
		System.out.println(linkedList);

		linkedList.addFirst(10); // Adds 10 to the start of the list.
		System.out.println(linkedList);

		linkedList.add(2, 20); // Adds 20 to second position in the list.
		System.out.println(linkedList);

		List<Integer> list = new ArrayList<>();
		list.add(101);
		list.add(102);
		list.add(103);

		linkedList.addAll(3, list); // Adds the collection of elements at third position in the list.
		System.out.println(linkedList);

		System.out.println(linkedList.getFirst()); //Fetching the first element.

		System.out.println(linkedList.getLast()); //Fetching the last element.
		
		System.out.println(linkedList.get(2)); //Fetching the element at second index.        
	}    
}
