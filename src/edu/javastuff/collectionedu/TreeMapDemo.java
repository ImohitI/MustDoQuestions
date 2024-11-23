package edu.javastuff.collectionedu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMapDemo {
    
    	public static void main(String args[]) {
		
		// Creating a TreeMap which will store all the elements in reverse order.
		TreeMap<String, Integer> reverseMap = new TreeMap<>(Comparator.reverseOrder());		
		reverseMap.put("Oracle", 43);
		reverseMap.put("Microsoft", 56);
		reverseMap.put("Apple", 43);
		reverseMap.put("Novartis", 87); 		
		System.out.println("Elements are stored in reverse order: " + reverseMap);
		
		// Creating a HashMap which will store all the elements in random order.
		Map<String, Integer> hashMap = new HashMap<>();		
		hashMap.put("Oracle", 43);
		hashMap.put("Microsoft", 56);
		hashMap.put("Apple", 43);
		hashMap.put("Novartis", 87);
		System.out.println("Elements are stored in random order: " + hashMap);
		
		// Creating a TreeMap using existing HashMap. This will store the elements in ascending order.
		TreeMap<String, Integer> treeMap1 = new TreeMap<>(hashMap);
		System.out.println("Elements are stored in ascending order: " + treeMap1);
		
		// Creating a TreeMap using existing TreeMap. This will store the elements in the same order as it was in the passed Map.
		TreeMap<String, Integer> treeMap2 = new TreeMap<>(reverseMap);
		System.out.println("Elements are stored in descending order: " + treeMap2);

        example1();
        hashMapSorting();
	}

    public static void example1() {
		TreeMap<String, Integer> map = new TreeMap<>();
		
		map.put("Oracle", 43);
		map.put("Microsoft", 56);
		map.put("Apple", 43);
		map.put("Novartis", 87);
		
		System.out.println(map);
		
		TreeMap<String, Integer> finalMap = new TreeMap<>();
		
		map.put("Google", 65);
		map.put("Audi", 32);
		finalMap.putAll(map);
		
		System.out.println(finalMap);


        		//Fetching the first entry in the Map.
		Entry<String, Integer> firstEntry = map.firstEntry();
		
		
		System.out.println("Smallest key: " + firstEntry.getKey() + ", Value: " + firstEntry.getValue());
		
		//Fetching the last entry in the Map.
		Entry<String, Integer> lastEntry = map.lastEntry();
		System.out.println("Largest key: " + lastEntry.getKey() + ", Value: " + lastEntry.getValue());

		System.out.println(sortByValues(map));


	}

    public static TreeMap<String, Integer> sortByValues(TreeMap<String, Integer> map) {

		Comparator<String> valueComparatorAnn = new Comparator<String>() { 
            
            // return comparison results of values of two keys 
            public int compare(String k1, String k2) 
            { 
                int comp = map.get(k1).compareTo( 
                    map.get(k2)); 
                if (comp == 0) 
                    return 1; 
                else
                    return comp; 
            } 
      
        };

        Comparator<String> valueComparator = (k1, k2) -> {

			int comp = map.get(k1).compareTo(map.get(k2));
			if (comp == 0)
				return 1;
			else
				return comp;
		};

		TreeMap<String, Integer> mapSortedByValues = new TreeMap<>(valueComparator);

		mapSortedByValues.putAll(map);
		return mapSortedByValues;

	}

    public static void hashMapSorting() {

		Map<Integer, String> employeeMap = new HashMap<>();
		employeeMap.put(123, "Alex");
		employeeMap.put(342, "Ryan");
		employeeMap.put(143, "Joe");
		employeeMap.put(234, "Allen");
		employeeMap.put(432, "Roy");
		
        TreeMap<Integer, String> sortedMap = new TreeMap<>();
		sortedMap.putAll(employeeMap);
        System.out.println("Sorted map " + sortedMap);

		List<Integer> keyList = new ArrayList<>(employeeMap.keySet());
		Collections.sort(keyList);
		System.out.println(keyList);
		
		
		List<String> valuesList = new ArrayList<>(employeeMap.values());
		Collections.sort(valuesList);
		System.out.println(valuesList);    
        
        //using lambda and stream
        System.out.println("Sorting by key");
        employeeMap
        .entrySet()
        .stream().
        sorted(Map.Entry.<Integer, String>comparingByKey())
        .forEach(System.out::println);

        System.out.println("Sorting by value");
		employeeMap.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue())
		.forEach(System.out::println);
    }
}
