package edu.javastuff.collectionedu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Iterator;


public class ArrayListDemo1 {
    	public static void main(String args[]) {
		List list = new ArrayList();
		list.add(1);
        list.add(2);
        list.add(3);

		System.out.println(list);
		
		list.add(4);  // This will add 4 at the end of the List.
		System.out.println(list);
		
		list.add(1, 50); // This will add 50 at index 1. All the other elements will be shifted to right.
		System.out.println(list);

		List newList = new ArrayList(); // Creating a new List which will be added to original list.
		newList.add(150);
		newList.add(160);

		list.addAll(newList); // This will add all the elements present in newList to list.
		System.out.println(list);

        System.out.println(list.size());

        System.out.println(list.get(3));

        list.remove(0);

        list.remove(Integer.valueOf(50)); // integer constructor deprecated from 9 , use valueOf
        System.out.println(list);

        List<String> listarr = new ArrayList<>();
        listarr.add("apple");
        listarr.add("boat");

        listarr.replaceAll((e) -> e.toUpperCase()); // take a unary operator, functional interface with single abstract method
        System.out.println(listarr);

        listarr.set(1, "ball");
        System.out.println(listarr);

        if (listarr.contains("ball")) System.out.println("ball is present");

        System.out.println(listarr.indexOf("APPLE"));
        System.out.println(listarr.lastIndexOf("APPLE"));

		List<Integer> listint = new ArrayList<>();
		listint.add(10);
		listint.add(20);
		listint.add(30);
		listint.add(40);
		listint.add(10);

		Iterator<Integer> itr = listint.iterator();

		// while(itr.hasNext()) {
		// 	System.out.println(itr.next());
		// }

        // iterating for each
        itr.forEachRemaining(element -> System.out.print(element));

        itr = listint.iterator(); // iterator object can be iterated only once, so need to create another

        while(itr.hasNext()) {
			int next = itr.next();
			if(next == 30) {
				itr.remove();
			}
		}
		System.out.println(listint);

        itr = listint.iterator();
		//listint.add(54); causes ConcurrentModificationException below if add after iterator object created

		while(itr.hasNext()) {
			System.out.println(itr.next());	
		}

        Collections.sort(listint);
        System.out.println(listint);

        List<Integer> sortedListint = listint.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedListint);

        Collections.sort(listint, Collections.reverseOrder());
        System.out.println(listint);

        sortedListint = listint.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedListint);

	}
}

