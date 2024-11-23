package edu.javastuff.collectionedu;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdditonalMapDemo {
	public static void main(String args[]) {
		
		ConcurrentHashMap<String, Integer> stocks = new ConcurrentHashMap<>();
		
		stocks.put("Google", 123);
		stocks.put("Microsoft", 654);
		stocks.put("Apple", 345);
		stocks.put("Tesla", 999);
		
		System.out.println(stocks);
		
		// Since we are using putIfAbsent(), and Apple is already in the Map, the value will not be added.
		stocks.putIfAbsent("Apple", 1000);
		
		System.out.println(stocks);
        

        example1();
        example2();
	}
    public static void example1() {
        Emp emp1 = new Emp(123, "Saurav");
		Emp emp2 = new Emp(123, "Saurav");
		
		
		Map<Emp, String> hashMap = new HashMap<>();
		hashMap.put(emp1, "emp1");
		hashMap.put(emp2, "emp2");
		
		
		Map<Emp, String> identityHashMap = new IdentityHashMap<>();
		identityHashMap.put(emp1, "emp1");
		identityHashMap.put(emp2, "emp2");
		
		System.out.println("The employee objects in HashMap are:");
		System.out.println(hashMap);

		System.out.println();
		System.out.println("The employee objects in IdentityHashMap are:");
		System.out.println(identityHashMap);
    }

    public static void example2() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
		
		// Putting records in EnumMap
		enumMap.put(DayOfWeek.MONDAY, 5);
		enumMap.put(DayOfWeek.WEDNESDAY, 23);
		
		// Fetching the value from MONDAY
		System.out.println(enumMap.get(DayOfWeek.MONDAY));
		
		// Removing MONDAY from the Map
		enumMap.remove(DayOfWeek.MONDAY);
    }
}

 class Emp {

	int empId;
	String empName;

	public Emp(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Emp other = (Emp) obj;
		if (empId != other.empId)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		return true;
	}

}
