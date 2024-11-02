package edu.javastuff.collectionedu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo3 {
	
	public static void main(String args[]) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Alex", 23, "USA"));
		list.add(new Employee("Dave", 34, "India"));
		list.add(new Employee("Carl", 21, "USA"));
		list.add(new Employee("Joe", 56, "Russia"));
		list.add(new Employee("Amit", 64, "China"));
		list.add(new Employee("Ryan", 19, "Brazil"));
		
		System.out.println("Name of employees with age more than 50");
		for(Employee emp : list) {
			if(emp.age > 50) {
				System.out.println(emp.name);
			}
		}

		//Solution using streams.
		System.out.println("Solution using streams");
		list.stream().filter(emp -> emp.age > 50).map(emp -> emp.name).forEach(System.out::println);

		// sort by country
		Collections.sort(list, (e1, e2) -> e1.country.compareTo(e2.country));
		for (Employee emp : list) {
			System.out.println("Employee Name: " + emp.name + ", Employee Country: " + emp.country);
		}

	}

}

class Employee {
	String name;
	String country;
	int age;
	public Employee(String name, int age, String country) {
		this.name = name;
		this.country = country;
		this.age = age;
	}
	
}