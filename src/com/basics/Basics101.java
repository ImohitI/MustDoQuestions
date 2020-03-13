package com.basics;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.*;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

public class Basics101 {

    @Test
    public void absoluteOfMostNegativeValue() {
        final int mostNegative = Integer.MIN_VALUE;
        final int negated = Math.abs(mostNegative);

        assertFalse("No positive equivalent of Integer.MIN_VALUE", negated > 0);
    }

    @Test(expected = NullPointerException.class)
    public void expectedNullPointerToBeThrown() {
        final String s = null;
        final int stringLength = s.length();
    }


    /*

     new ArrayList<>(20) requests an area in memory to store the data and list1 points to that memory location.
     several variable can be assigned to the same created object known as an instance, they are pointing to same
     memory location.
     If a reference variable is made final , that reference cannot be changed but the value held within that object can
     change, unless they themselves are final
     */
    @Test
    public void objectMemoryAssignment() {
        List<String> list1 = new ArrayList<>(20);
        list1.add("entry in list1");
        assertTrue(list1.size() == 1);

        List list2 = list1;
        list2.add("entry in list2");
        assertTrue(list1.size() == 2);

    }

    @Test
    public void finalReferenceChanges() {
        final int i = 42;
        //i =43 compile error

        final List<String> list = new ArrayList<>(20);
        //list = new ArrayList<50>; compile error

        list.add("adding a new value into my list");
        assertEquals(1, list.size());

        list.clear();
        assertEquals(0, list.size());

    }

/*
    private     -- visible to instance of the same class not to subtypes
    <none>      -- visible to any class in the same package
    protected   -- visible to any subclass
    public      -- visible anywhere
 */

/*
  Any non-final public or protected method can be overridden
  The implementation of equals on Object compares the memory location of the objects, meaning that if two objects
  have the same memory location, they are actually of the same object, so they must be equal.

  Rule of hashcode is the two equal objects must return the same value. Note that the reverse is not always true.
  Reason is hashcode is represented by int , so  if unequal hashcode meant unequal objects, there would be a maximum of
  2^32 unique variations of a specific instance. This would be quite a limitation for objects like String.

  Hashcode uses memory location to generate the hashcode value on the Object class. This means that two separate instances
  that are logically equal will be in different memory location and therefore will not return the same hashcode.


 */

    @Test
    public void wrongSetBehavior() {
        final Set<Person> people = new HashSet<>();

        final Person person1 = new Person("Alice", 28);
        final Person person2 = new Person("Bob", 30);
        final Person person3 = new Person("Charlie", 22);

        final boolean person1Added = people.add(person1);
        final boolean person2Added = people.add(person2);
        final boolean person3Added = people.add(person3);

        assert (person1Added && person2Added && person3Added);

        //logically equal to personal
        final Person personalAgain = new Person("Alice", 28);
        // should return false , as Alice is already in the set
        final boolean personalAgainAdded = people.add(personalAgain);

        //But will return true as the equals method has not been implemented
        assertTrue(personalAgainAdded);
        assertEquals(4, people.size());


    }
 /*

    Whenever overriding hashcode or equals , you must override both methods.

  */

    @Test
    public void arrayReferences() {

        final int[] myArray = new int[]{0, 2, 4, 6, 7, 5};
        int[] arrayReference2 = myArray;

        arrayReference2[5] = 100;

        assertFalse(myArray[5] == 5);
    }
/*
Arrays are passed by reference , so anything holding a reference to the array
can mutate it in some way.
 */

    @Test
    public void stringCreation() {
        String helloWorld1 = new String("Hello World!");
        String helloWorld2 = "Hello World!";

        assertEquals(helloWorld1, helloWorld2);
    }

    @Test
    public void StringChanges() {
        final String greeting = "Good Morning, Dave";
        final String substring = greeting.substring(4);

        System.out.println(substring);
        assertTrue(substring.equals("Good"));
        assertFalse(greeting.equals(substring));
        assertTrue(greeting.equals("Good Morning, Dave"));

    }

/*
When a class is loaded in JVM , it holds all the literals in a constant pool.
Any repetition of a string a literal can be referenced from the same constant in the pool.
This is known as String interning.

The String intern pool is not just open to compile time String literals, any String
can be added in this pool with intern method. These strings are stored in PremGen space.
 */

/*
(List<? extends A> listOfA)
wildcard tells the compiler to allow any instance of a class extending A.

being reified means being available at runtime. Java generic types are not reified.
This means that all the type information the compiler uses to check that any implementing code is
using generic parameters correctly is not part of the .class file definition.

 */


    /*
    Autoboxing :: automatic transformation from primitive type to its reference type

     */
    @Test
    public void primitiveNullPointer() {
        final Integer intObject = 42;
        assert (intObject == 42);

        try {
            final int newIntValue = methodWhichMayReturnNull(intObject);
            fail("Assignment of null to primitive should throw NPE");
        } catch (NullPointerException e) {
            //do nothing
        }
    }

    private Integer methodWhichMayReturnNull(Integer intValue) {
        return null;
    }

/*
@Override annotation -- useful compile time check

 */


    /*
    A final class with private fields and no setter is still not an immutable class.
    Because with reflection we can set values to the private fields.
    But if we mark the fields as final then it cannot be modified and the class will become immutable.
     */
    @Test
    public void mutateBookRecordState() throws NoSuchFieldException, IllegalAccessException {

        final BookRecord record = new BookRecord("Suzane Collins", "The Hunger Games");
        final Field author = record.getClass().getDeclaredField("author");
        author.setAccessible(true);
        author.set(record, "Catching Fire");

        assertEquals("Catching Fire", record.getAuthor());
    }

    @Test
    public void run(){
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);

        List<Integer> newInts = new ArrayList<>();
        ints.forEach(i ->{newInts.add(i+10);});

        for(int i=0 ; i<ints.size(); i++){
            assert ints.get(i)+10 == newInts.get(i);
        }

        assert ints.size() == newInts.size();
        System.out.println("Validated");
    }

    @Test
    public void customOrdering(){
        final List<Integer> numbers = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
        final List<Integer> expected = Arrays.asList(7, 6, 5, 4, 4, 3, 1);
        Collections.sort(numbers, new ReverseOrdering());
        assertEquals(expected, numbers);
    }

    //Bubble sort
    public void bubbleSort(int[] numbers){
        boolean numberSwitched;
        do{
            numberSwitched = false;
            for(int i=0;i<numbers.length-1;i++){
                if(numbers[i+1]<numbers[i]){
                    int tmp = numbers[i+1];
                    numbers[i+1] = numbers[i];
                    numbers[i] = tmp;
                    numberSwitched = true;
                }
            }
        }while(numberSwitched);
    }

    //insertion sort
    public static List<Integer> insertSort(final List<Integer> numbers){
        final List<Integer> sortedList = new LinkedList<>();

        originalList : for(Integer number:numbers){
            for(int i = 0 ; i < sortedList.size();i++){
                if(number < sortedList.get(i)){
                    sortedList.add(i, number);
                    continue originalList;
                }
            }
            sortedList.add(sortedList.size(), number);
        }
        return sortedList;
    }

    //QuickSort
    public static List<Integer> quickSort(List<Integer> numbers){
        if(numbers.size()<2){
            return numbers;
        }

        final Integer pivot = numbers.get(0);
        final List<Integer> lower = new ArrayList<>();
        final List<Integer> higher = new ArrayList<>();

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < pivot) {
                lower.add(numbers.get(i));
            } else {
                higher.add(numbers.get(i));
            }
        }
        final List<Integer> sorted = quickSort(lower);
        sorted.add(pivot);
        sorted.addAll(quickSort(higher));
        return sorted;
    }

    //MergeSort
    public static List<Integer> mergeSort(final List<Integer> values){
        if(values.size()>2){
            return values;
        }

        final List<Integer> leftHalf = values.subList(0, values.size()/2);
        final List<Integer> rightHalf = values.subList(values.size()/2,values.size());

        return merge(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    private static List<Integer> merge(final List<Integer> left, final List<Integer> right){

        int leftPtr = 0;
        int rightPtr = 0;

        final List<Integer> merged = new ArrayList<>(left.size()+right.size());

        while(leftPtr < left.size() && rightPtr < right.size()){
            if(left.get(leftPtr) < right.get(rightPtr)){
                merged.add(left.get(leftPtr));
                leftPtr++;
            }else{
                merged.add(right.get(leftPtr));
                rightPtr++;
            }
        }

        while (leftPtr < left.size()) {
            merged.add(left.get(leftPtr));
            leftPtr++;
        }
        while (rightPtr < right.size()) {
            merged.add(right.get(rightPtr));
            rightPtr++;
        }
        return merged;
    }

    //BinarySearch
    public static boolean binarySearch(final List<Integer> numbers,final Integer value){
        if(numbers == null || numbers.isEmpty()){
            return false;
        }

        final Integer comparison = numbers.get(numbers.size()/2);
        if(value.equals(comparison)){
            return true;
        }
        if(value<comparison){
            return binarySearch(numbers.subList(0,numbers.size()/2),value);
        }

        if (value < comparison) {
            return binarySearch(
                    numbers.subList(0, numbers.size() / 2),
                    value);
        } else {
            return binarySearch(
                    numbers.subList(numbers.size() / 2 + 1, numbers.size()),
                    value);
        }

    }

}
