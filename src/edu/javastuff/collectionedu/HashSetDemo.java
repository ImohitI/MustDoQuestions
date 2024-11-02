package edu.javastuff.collectionedu;
import java.util.*;

public class HashSetDemo {
    public static void main(String args[]) {
		Set<Integer> set = new HashSet<>();
		
		System.out.println("Inserting 23 in the HashSet:  " + set.add(23));
		System.out.println("Inserting 34 in the HashSet:  " + set.add(34));
		System.out.println("Inserting 23 in the HashSet:  " + set.add(23));
		
		System.out.println(set);
		
        System.out.println(set.contains(23));

        set.remove(23);

        System.out.println(set.isEmpty());

        // Creating an ArrayList from existing set.
		List<Integer> list = new ArrayList<>(set);
		// Sorting the list.
		Collections.sort(list);
		
		list.forEach(System.out::println);

        printDup();

	}

    public static void printDup() {
        Set<Integer> set = new HashSet<>();
		int[] data = {12, 34, 1, 56, 43, 34, 65};
        int duplicate = 0;
        for(int i : data){
			if(!set.add(i)){
				duplicate = i;
				break;
			}
		}
        System.out.println(duplicate);
    }
}
