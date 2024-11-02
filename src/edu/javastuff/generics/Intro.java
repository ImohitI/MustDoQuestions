package edu.javastuff.generics;

import java.util.*;
/**
 * Java Generics enables type safety where cl and mt are working with any type instead of object instance
 * Adds type parameter with cl mt it 
 */
class GenericClass<T> {
    Class theClass = null;

    public GenericClass(Class theClass) {
        this.theClass = theClass;
    }

    public T createInstance() throws IllegalAccessException, InstantiationException {
        return (T) this.theClass.newInstance();
    }
}
public class Intro {
    public static void main(String[] args) {
        Intro intro = new Intro();
        intro.genericexamples1();
        intro.genericExample2();
        intro.genericExample3();
        
    }

    // generic examples
    void genericexamples1() {
        // List is a list of object instance
        List list = new ArrayList();
        list.add(new Integer(2));
        list.add("a string");
        // because any object is adde u need to cast to retrieve any obj
        Integer  i = (Integer) list.get(0);
        System.out.println(i);
        
        // use of generics
        List<String> strings = new ArrayList<>();
        strings.add("aa");
        String aa = strings.get(0);
        
        // generic for loops AKA for each loop , do not need iterator.next()
        List<String> list1 = new ArrayList<>();
        Iterator<String> iterator = list1.iterator();
        while(iterator.hasNext()){
            String aString = iterator.next();
        }
        // also use for each
        for(String aString : list1) {
            System.out.println(aString);    
        }
        System.out.println();

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "One");
        map.put(2, "Two");

        for (Integer akey :  map.keySet()) {
            String aValue = map.get(akey);
            System.out.println(akey +" "+aValue);
        }
        for (String aValue : map.values()) {
            System.out.println(aValue);
        }
    }

    public <T> T addAndReturn(T element, Collection<T> collection) {
        collection.add(element);
        return element;
    }
    void genericExample2() {
        GenericClass<String> gc = new GenericClass<String>(String.class);

        try {
            String a = gc.createInstance();
            System.out.println(a);

        } catch (IllegalAccessException | InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String stringElement = "ss";
        List<String> stringList = new ArrayList<>();
        String element = addAndReturn(stringElement, stringList);
        for (String a : stringList) {
            System.out.println(a);
        }
        // Advanced type inference 
        // if string object and an object list is sent to addAndReturn
        // T is inferred as the most specific object , it will be Object

        // But the inverse will not be valid
        // Object object and a String list sent to addAndReturn
        // Object o = new Object();
        // List<String> sList = new ArrayList<>();
        // Object e = addAndReturn(o, sList);


    }    
    
    void genericExample3() {
        //Generic wildcard
        // reading from a generic collection
        // inserting into a generic collection
        // 3 ways
        // List<?> listUnknown = new ArrayList<A>();
        // it can be any type, so we can only treat the objects read as being Object instances
        // List<? extends A> listUnknown = new ArrayList<A>();
        // This is list of objects that are instances of A or subclasses of A, we can safely cast them into A
        // List<? super A> listUnknown = new ArrayList<A>();
        // list type is either A or a superclass of A, so safe to insert instances of A or subclasses of A

    }
    public void processElements(List<?> elements){
        for(Object o : elements) {
           System.out.println(o);
        }
    }

}
