package edu.javastuff.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Java collection API 
 * two group collection and map
 * Iterable iterator() --> Collection size() --> List , Set --> SortedSet --> NavigableSet, Queue --> Deque
 * Map keyset(), valueset() --> SortedMap --> NavigableMap
 * 
 * Iterator interface for objects capable of iterating
 * obtain an iterator instance form the collection of objects 
 * If you modify while iterating, it will detect it and throw exception when u try to obtain next element
 * 
 * Iterator methods 
 * hasNext , return true if more elements
 * next , return next
 * remove, removes last element returned from next 
 * forEachRemaining , iterate over all remaining elements in the iterator
 * 
 * Iterable performance
 * for each loop slower than iterating the list via for loop
 * In for each call List iterator() method, which will create a new Iterator object
 * 
 * Collection standard methods
 * add, add element and return true if collection changed, like for example set may not change if an element added twice
 * remove, remove element and return true if removed else false
 * addAll, removeAll
 * contains
 * containsAll
 * size
 * 
 * Collections utility class
 * addAll, binarySearch, copy, reverse, shuffle, sort, min, max, replaceAll, unmodifiableSet --> creates an immutable set
 * 
 * List vs Set 
 * order of insertion, repeated elements , can insert null , inserting at specific index
 * finding elements , indexOf, lastIndexOf , remove(object), remove(index)  , clear, subList(start, end)
 * 
 * Set 
 * of creates unmodifiable immutableSet 
 * Set , EnumSet, HashSet, LinkedHashSet, TreeSet
 * HashSet backed by HashMap, order not guarantee
 * LinkedHashSet, order 
 * TreeSet, order is the sorting order similar to Collections.sort
 * SortedSet interface for sorted set like treeset
 * first, last , headSet, tailSet, subset
 * NavigableSet is subtype of SortedSet
 * ceiling , greater than equal
 * floor, less than or equal
 * higher, lower
 * pollFirst, return and remove first or null if set is empty
 * pollLst, last element
 * 
 * Map
 * HashMap, Hashtable, EnumMap, IndentityHashMap, LinkedHashMap, Properties, TreeMap, WeakHashMap
 * HashMap no order, TreeMap order
 * Null key possible , null value also allowed
 * getOrDefault , containsKey, containsValue, for- each loop keySet, values
 * 
 * Java properties
 * map of key value string , can write the key value pairs to a properties file on disk and read it back again
 * 
 * Java Queue interface 
 * LinkedList : traditional linkedlist, fast insert at the tail, remove from the head
 * PriorityQueue : store in natural order if comparable implemented or comparator passed
 * 
 * Java Deque a double ended queue
 * LinkedList 
 * ArrayDeque : stores internally as array 
 */
public class Intro {
    public void example1() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()) {
            Object nextObject = iterator.next();
            System.out.println(nextObject);
        }
    }
    
    public void example2() {
        System.out.println("In in example2");
        /*
         * concurrentModificationeException
         */
        List<String> list = new ArrayList<>();

        list.add("123");
        list.add("456");
        list.add("789");
        
        Iterator<String> iterator = list.iterator();
        
        //iterator gets out of sync
        // while(iterator.hasNext()) {
        //     String value = iterator.next();
        
        //     if(value.equals("456")){
        //         list.add("999");
        //     }
        // }

        //remove does not cause the exception
        while(iterator.hasNext()) {
            String value = iterator.next();
        
            if(value.equals("456")){
                iterator.remove();
            }
        }
        iterator = list.iterator();
        iterator.forEachRemaining((element) -> {
            System.out.println(element);
        });        

        list.forEach((element) -> {System.out.println(element);});
    }

    public void example3() {
        List<String> list      = new ArrayList<>();

        list.add("element 1");
        list.add("element 2");
        list.add("element 3");
        list.add("element 3");

        Object[] objects = list.toArray();

        //convert a list to an array of a specific type
        String[] objects1 = list.toArray(new String[0]);

        //convert array to list
        String[] values = new String[]{ "one", "two", "three" };

        List<String> list1 = (List<String>) Arrays.asList(values);        

    }
    public void example4() {
        // of static factory method take zero of more parameters
        Set set = Set.of();
        Set<String> set1 = Set.<String>of("val1", "val2");
        set1.forEach(e -> System.out.println(e));
        System.out.println(set1.getClass());
        //Stream
        Stream<String> stream = set1.stream();

        stream.forEach((e) -> System.out.println(e));
        Set<Integer> set2 = Set.<Integer>of(1,2,3,4,5, 6, 7, 8, 9, 10, 11);
        // immutable set from of , UnsportedOperationException
        //set2.add(12);

        //retainAll intersection
        //isEmpty()
        //contains(element) // iternally it compares equals method for comparison
        // can add null and check contain null
        // convert list to set , list.addAll(set)
    }

    public void example5() {
        Map<String, String> map = new HashMap<>();

        map.put("one", "first");
        map.put("two", "second");
        map.put("three", "third");
        
        System.out.println(map.keySet().getClass());
        System.out.println(map.values().getClass());

      

        //compute
        map.compute("one", (key, value) -> 
        value == null ? null : value.toString().toUpperCase());

        map.computeIfAbsent("four", (key) -> "fourth");     

        map.computeIfPresent("two", (key, value) -> 
        value == null ? null : value.toString().toUpperCase());

        for(Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key +" "+value);
        }          

    }
    public void example6() {
        NavigableMap original = new TreeMap();
        original.put("1", "1");
        original.put("2", "2");
        original.put("3", "3");
        
        //this headmap1 will contain "1" and "2"
        SortedMap headmap1 = original.headMap("3");
        
        //this headmap2 will contain "1", "2", and "3" because "inclusive"=true
        NavigableMap headmap2 = original.headMap("3", true);

        Properties properties = new Properties();
        properties.setProperty("key1", "value1");
        properties.setProperty("key2", "value2");
        properties.setProperty("key3", "value3");
        
        Iterator keyIterator = properties.keySet().iterator();
        
        while(keyIterator.hasNext()){
            String key   = (String) keyIterator.next();
            String value = properties.getProperty(key);
            System.out.println(key + " = " + value );
        }
        //properties.store(output, "the properties")
        //properties.load(filereader)
        //properties.storeXML(output, "the properties")

        Properties systemProp = System.getProperties();
        for (Object k : systemProp.keySet()) {
            System.out.println(systemProp.get(k));
        }

    }
    public void example7(){
        Queue<String> queue = new LinkedList<>();
        System.out.println(queue.size());
        //add and offer
        queue.add("element 1"); // if queue is full , give exception
        queue.offer("element 2");// return false if unable to add

        //remove , poll
        String element2 = queue.remove();// remove return exception        
        String element1 = queue.poll();// poll return null if empty

        // element , peek
        //System.out.println(queue.element());//if empty throws NoSuchElementException
        //System.out.println(queue.peek());//no exception it returns null

        //contains

        Deque dequeL = new LinkedList();
        Deque dequeA = new ArrayDeque();

        // addLast, addFirst, offerLast, offerFirst
        // push add an element to the beginning  head 
        // peek peekFirst peekLast getFirst getLast
        // removeLast removeFirst pollLast pollFirst pop --> remove from head
        
        
        Stack<String> stack = new Stack<String>();

        stack.push("1");
        stack.push("2");
        stack.push("3");

        String topElement = stack.pop();
        String topElement1 = stack.peek();
        int index = stack.search("3");     //index = 3


    }

    public void example8(){
        List<String> items = new ArrayList<String>();

        items.add("one");
        items.add("two");
        items.add("three");
        
        Stream<String> stream = items.stream();
        
        //Processing in stream , configuration and processing
        stream.filter( item -> item.startsWith("o") );
        items.stream().map( item -> item.toUpperCase() );

        List<String> filtered = items.stream()
        .filter( item -> item.startsWith("o") )
        .collect(Collectors.toList());

        System.out.println(filtered);

        String shortest = items.stream()
        .min(Comparator.comparing(item -> item.length()))
        .get();

        System.out.println(shortest);

        long count = items.stream()
        .filter( item -> item.startsWith("t"))
        .count();
        
        System.out.println(count);

        String reduced1 = items.stream()
        .reduce((acc, item) -> acc + " " + item)
        .get();

        System.out.println(reduced1);

        
        String reduced2 = items.stream()
        .reduce("", (acc, item) -> acc + " " + item);
        
        System.out.println(reduced2);

        String reduced3 = items.stream()
        .filter( item -> item.startsWith("o"))
        .reduce("", (acc, item) -> acc + " " + item);      
        
        System.out.println(reduced3);
        
    }
    public static void main(String[] args) {
        Intro intro = new Intro();
        intro.example1();
        intro.example2();
        intro.example3();
        intro.example4();
        intro.example5();
        intro.example6();
        intro.example7();
        intro.example8();

    }
}

/*
 * if object1 and object2 are equal with equals() method, they must have same hashcode
 * object1 and object2 have same hashcode , they do not have to be equal
 */
class Employee {
    long employeeId;
    String firstName;
    String lastName;
    
    public long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int hashCode(){
        return (int) employeeId *
                    firstName.hashCode() *
                    lastName.hashCode();
    }

    public Employee(long empId, String fn, String ln) {
        this.employeeId = empId;
        this.firstName = fn;
        this.lastName = ln;
    }
    public boolean equals(Object o){
        if(o == null)                return false;

        if (!(o instanceof Employee)) return false;
    
        Employee other = (Employee) o;
        if(this.employeeId != other.employeeId)      return false;
        if(! this.firstName.equals(other.firstName)) return false;
        if(! this.lastName.equals(other.lastName))   return false;
    
        return true;
      }    
}

// class MyComparator<Employee> implements Comparator<Employee> {

//     public int compare(Employee emp1, Employee emp2){

//        if(emp1.getEmployeeId() <  emp2.getEmployeeId()) return -1;
//        if(emp1.getEmployeeId() == emp2.getEmployeeId()) return 0;
//        return 1;
//     }
// }
