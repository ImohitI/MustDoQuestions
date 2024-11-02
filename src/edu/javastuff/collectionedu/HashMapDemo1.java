package edu.javastuff.collectionedu;
import java.util.*;
import java.util.Map.Entry;

public class HashMapDemo1 {

    public static void main(String args[]) {
		
		Map<String, Integer> stockPrice = new HashMap<>();
		
		stockPrice.put("Oracle", 56); //Inserting share price of Oracle in the Map.
		System.out.println(stockPrice);
		
		stockPrice.put("Oracle", 60); //Inserting share price of Oracle again. This will update the value.
		System.out.println(stockPrice);
		
		stockPrice.putIfAbsent("Oracle", 70); //Inserting share price of Oracle again using putIfAbsent() method. This will not update the value.
		System.out.println(stockPrice);

        System.out.println(stockPrice.getOrDefault("Google", 100));

        example1();
        example2();
        example3();
	}
	public static void example1() {

		Map<String, Integer> stockPrice = new HashMap<>();

		stockPrice.put("Oracle", 56);
		stockPrice.put("Fiserv", 117);
		stockPrice.put("BMW", 73);
		stockPrice.put("Microsoft", 213);
		
		System.out.println("HashMap Keys");
		Set<String> keyset = stockPrice.keySet();
		for(String key : keyset) {
			System.out.println(key);
		}
		
		System.out.println("HashMap Values");
		Collection<Integer> values = stockPrice.values();
		for(Integer value : values) {
			System.out.println(value);
		}
		
	}
	public static void example2() {

		Map<String, Integer> map = new HashMap<>();
		map.put("India", 5);
		map.put("USA", 3);
		map.put("China", 5);
		map.put("Russia", 6);
		
		// This will increment the value of India by 1 as it is present in the Map
		map.compute("India", (k, v) -> v == null ? 10 : v + 1);

		// This will insert Vietnam in the Map with default value of 10.
		map.compute("Vietnam", (k, v) -> v == null ? 10 : v + 1);

        map.computeIfAbsent("Japan", k -> k.length());

        map.computeIfPresent("India", (k, v) -> v == null ? 10 : v + 1);

		System.out.println(map);

	}

    public static void example3() {

		Map<String, Integer> map1 = new HashMap<>();
		map1.put("Jay", 5000);
		map1.put("Rahul", 3000);
		map1.put("Nidhi", 4500);
		map1.put("Amol", 60000);
		
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("Jay", 7000);
		map2.put("Rahul", 4500);
		map2.put("Nidhi", 1200);
		map2.put("Saurav", 25000);
		
		map1.forEach((key,value) -> map2.merge(key, value, (v1, v2) -> v1 + v2));
		
		System.out.println(map2);

		Set<Entry<String, Integer>> entrySet = map1.entrySet(); // Returns a Set of Entries
		
		Iterator<Entry<String, Integer>> itr = entrySet.iterator(); //Getting the iterator

		while (itr.hasNext()) {
			Entry<String,Integer> entry = itr.next();
			System.out.println(" Name: " + entry.getKey() + " Price: " + entry.getValue());
			
			if(entry.getKey().equals("Nidhi")) {
				itr.remove();
			}
		}
		System.out.println(map1);
		map1.forEach((key, value) -> System.out
		.println(" Name: " + key + "  Price: " + value));

	}

    public static void example4() {
		
		Employee emp1 = new Employee(123, "Jane");
		Employee emp2 = new Employee(123, "Jane");

		Map<Employee, Integer> employeeMap = new HashMap<>();

		employeeMap.put(emp1, 56000);
		employeeMap.put(emp2, 45000);
		
		for(Entry<Employee, Integer> entry : employeeMap.entrySet()) {
			System.out.println("Employee Id: " + entry.getKey().empId + " Employee Name: " + entry.getKey().empName);
		}
	

	}


}
class Employee {

	int empId;
	String empName;

	public Employee(int empId, String empName) {
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
		Employee emp = (Employee) obj;
		return this.empId == emp.empId;
	}

}
