package edu.javastuff.java8newedu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.javastuff.java8newedu.util.Person;

/*
 * 
 * Stream sequence of elements from a source that supports aggregate operations on them
 * source here is collections or arrays that provide data to a stream
 * 
 * streams do'nt change original data
 * 0 or more intermediate operations to transform the stream
 * each intermediate is lazily executed 
 * terminal operations produces the result of the stream
 * 
 * 
 * 
 */
public class streamIntro {
    public static void main(String[] args) {
        
        Stream<Integer> stream = Stream.of(2,4,6,8);
        stream.forEach(p-> System.out.println(p));

        //List.stream()
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Stream<String> s = list.stream();
        s.forEach(p-> System.out.println(p));

        //filter takes predicate
        list.stream().filter(x -> x.equals("1")).forEach(System.out::println);

        List<Person> plist = new ArrayList<>();
        plist.add(new Person("Dave", 23, "AM"));
        plist.add(new Person("Joe", 18, "IN"));
        plist.add(new Person("Ryan", 54, "AM"));
        plist.add(new Person("Iyan", 5, "IN"));
        plist.add(new Person("Ray", 63, "IN"));

        //filter chain
        plist.stream().filter(p -> p.getAge() > 20).filter(p -> p.getName() != null).forEach(System.out::println);

        //mapping R (function<T> mapper)
        //map method does not modify the original list


        List<String> namelist = new ArrayList<>();
        namelist.add("Dave");
        namelist.add("Joe");
        namelist.add("Ryan");
        namelist.add("Iyan");
        namelist.add("Ray");
        namelist.stream()
                .map(name -> name.toUpperCase()) 
                .forEach(System.out::println);  

        System.out.println(namelist.get(0));

        namelist.stream().mapToInt(name -> name.length()).forEach(System.out::println);

        //flatmap 
        // flatten the stream of collections to stream of elements combing all elements 
        List<List<String>> slist = new ArrayList<>();
        slist.add(Arrays.asList("a","b","c"));
        slist.add(Arrays.asList("d","e","f"));
        slist.add(Arrays.asList("g","h","i"));
        slist.add(Arrays.asList("j","k","l"));

        Stream<List<String>> stream1 = slist.stream();
        Stream<String> stream2 = stream1.flatMap(sd -> sd.stream());

        Stream<String> stream3 = stream2.filter(x -> "a".equals(x));
        stream3.forEach(System.out::println);

        //Method reference
        //reference to method, similar to object reference
        //shortened version of lambda expressions
        Function<Person, Integer>  functionld = p  -> p.getAge();
        Function<Person, Integer> functionmr = Person::getAge;

        //4 kinds
        // static , ClassNam::MethodName
        // instance method, RefVar::MethodName
        // instance method of arbitrary object, , use classname
        // constructor ref, Classname::new


        //optional Optional<T>
        // wrapper class stores an object of type T, object may or may not be present
        // final class
        // Optional.ofNullable(empMap.get(empId))
        // check value isPresent

        Optional<Person> op = Optional.empty();
        Person pp = new Person();
        Optional<Person> optional = Optional.of(pp); // not null sure then only use of
        Optional<Person> opnullable = Optional.ofNullable(pp); // if not sure null or not

        if (optional.isPresent()) System.out.println();

        //ifPresent takes a consumer action
        optional.ifPresent(System.out::println);

        //get , returns a value if it is present in Optional
        // else throws NoSuchElementException
        System.out.println(optional.get());
        //orElse with default val
        System.out.println(optional.orElse(new Person()));
        //orElseGet supplier
        System.out.println(optional.orElseGet(()-> new Person()));
        //orElseThrow
        try {
            System.out.println(optional.orElseThrow(()-> new Exception("not found")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //optional filter with predicate
        System.out.println(op.filter(k -> k.getAge() > 20));

        //map with function mapper
        op.map( e -> e.getAge()).filter( j -> j > 10).ifPresent(System.out::println);
        //flat map also similar

        //slicing operation
        //distinct , according to Objects.equals(Object)
        //limit, max size
        //skip. skipping first n

        //match
        //anymatch , ture if atleast one , false if empty
        //allmatch , true if all mathch or true if empty
        //noneMatch , true if no match, true if empty

        //find
        //findFirst, returns an optional with first element
        //findAny, some element returned as optional obj

        //Mutable reduction reduce()
        // reduces to a single value , single valued immutable variable
        /*
         * Identity : element initial value, default value in case of stream empty
         * Accumulator : function takes 2 parameter, a partial result of reduction and next element of stream
         * Combiner : function to combine partial result of reduction operation when reduction is parallelized
         * 
         */

        // plist person list defined earlier
        //Optional reduce(BinaryOperator accumulator)
        Optional<Integer> totalAge = plist.stream().map(p -> p.getAge()).reduce((p, q)-> p + q);
        if (totalAge.isPresent()) System.out.println(totalAge.get());

        //can use sum operation in Instream as well
        int totalAgeInt = plist.stream().mapToInt(p->p.getAge()).sum();
        System.out.println(totalAgeInt);

        //T reduce(T identity, BinaryOperator accumulator)
        //identity initial value, in case of empty default value
        int totalSum = plist.stream().map(p->p.getAge())
        .reduce(100, (partialSum, num) -> partialSum + num);
        System.out.println(totalSum);

        //U reduce(U identity, BiFunction accumulator, BinaryOperator combiner)
        //when parallel stream, runtime splits stream into substreams
        // then we need a function to combine results of substreams into a single one
        int totalSum2 = plist.parallelStream().map(p->p.getAge())
        .reduce(0, (partialSum, num) -> partialSum + num, Integer::sum);
        System.out.println(totalSum2);

        //max and min
        Optional<String> max = namelist.stream().max(Comparator.naturalOrder());
        
        System.out.println(max.get());

        Optional<String> min = namelist.stream().min(Comparator.naturalOrder());

        System.out.println(min.get());


        //immutable reductions 
        /*collect desired results into a mutable container object
         * it is achieved through collect() method
         * 2 overloaded methods
         * collect(Collector<T, A, R) collector)
         * R collect(Supplier sup, BiConsumer acc, BiConsumer combiner)
         * 
         * Collector 
         * A final class extends object class, provide most common mutable reduction operations 
         * toList, toSet, toMap, collectingAndThen
         * summingLong, summingLong, summingInt
         * reducing
         * partitioningBy
         * counting
         * mapping
         * joining
         * minBy, maxBy
         * 
         */

        
         //Collectors.toList
        List<String> pname = plist.stream().map(o -> o.getName()).collect(Collectors.toList());
        System.out.println(pname);

        //Collectors.toSet
        Set<String> sname = plist.stream().map(o -> o.getName()).collect(Collectors.toSet());
        System.out.println(sname);

        //Collectors.toCollection
        //collect all of the imput elements into a new Collection, this method takes a supplier
        //supplier give collection of your choice
        LinkedList<String> ename = plist.stream().map(o -> o.getName()).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(ename);

        //Collectors.toMap
        // collect stream instance into a map instance
        //keyMapper, valueMapper
        Map<String, Integer> nameMap = namelist.stream().collect(Collectors.toMap(sd-> sd, sd -> sd.length()));
        System.out.println(nameMap);

        // incase of duplicate key can throw error
        // this one takes the firs element incase of duplicate
        Map<Integer, String> nameMap2 = namelist.stream().collect(Collectors.toMap(sd -> sd.length(), sd -> sd, (sd1, sd2) -> sd1));
        System.out.println(nameMap2);

        // this one provide the map implementation you want
        Map<String, Integer> nameMap3 = namelist.stream().collect(Collectors.toMap(sd -> sd, sd -> sd.length(), (sd1, sd2)-> sd1, HashMap::new));
        System.out.println(nameMap3);

        //collectingAndThen 
        // method returns a collector that accumulates the input element into a given collector and then perform
        // an additional finishing function

        List<String> unmod = namelist.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println(unmod);

        //Aggregation operators 
        //counting , returns a collector that counts the number of the input elements
        long count = plist.stream().filter(e -> e.getAge() > 30).collect(Collectors.counting());
        System.out.println(count);


        //Collectors.summingInt
        // returns a collector that produces the sum of an integer-valued function to the input elements
        int count2 = plist.stream().collect(Collectors.summingInt(e-> e.getAge()));
        System.out.println(count2);
        //Collectors.averagingInt
        //Collectors.minBy, maxBy
        Optional<Person> pmin = plist.stream().collect(Collectors.minBy(Comparator.comparing(Person::getAge)));
        System.out.println(pmin.get());
        Optional<Person> pmax = plist.stream().collect(Collectors.maxBy(Comparator.comparing(Person::getAge)));
        System.out.println(pmax.get());

        //intproducing map
        IntSummaryStatistics summaryStatistics = Stream.of("1", "2", "3").collect(Collectors.summarizingInt(Integer::parseInt));

        System.out.println(summaryStatistics);
        //joining , concatenates input  
        String jstring = Stream.of("a", "b").collect(Collectors.joining());
        System.out.println(jstring);

        //Grouping operations
        //Collectors.groupingBy()
        Map<String, List<Person>> prMap = plist.stream().collect(Collectors.groupingBy(Person::getCountry));
        System.out.println(prMap);

        // with additional second collector to apply to the result of first
        Map<String, Set<Person>> prMap2 = plist.stream().collect(Collectors.groupingBy(Person::getCountry, Collectors.toSet()));
        System.out.println(prMap2);

        Map<String, Integer> prMap3 = plist.stream().collect(Collectors.groupingBy(Person::getCountry, Collectors.summingInt(Person::getAge)));
        System.out.println(prMap3);

        Map<String, Optional<Person>> prMap4 = plist.stream().collect(Collectors.groupingBy(Person::getCountry, Collectors.maxBy(Comparator.comparingInt(Person::getAge))));
        System.out.println(prMap4);

        Map<String, Set<Person>> prMap5 = plist.stream().collect(Collectors.groupingBy(Person::getCountry, HashMap::new, Collectors.toSet()));
        System.out.println(prMap5);

        ConcurrentMap<String,List<Person>> prMap6 = plist.parallelStream().collect(Collectors.groupingByConcurrent(Person::getCountry));
        System.out.println(prMap6);

        Map<Boolean, List<Person>> prMap7 = plist.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));
        System.out.println(prMap7);

        ParallelStreamDemo.demo();

        //Lazy evaluation of stream
        /*
         * intermediate operation are not evaluated until terminal operation is invoked
         * 
         */
    }
}
class ParallelStreamDemo {

    public static void demo() {
        System.out.println("------------------------------- Serial Stream  ---------------------------------");
        Stream.of(1, 2, 3, 4, 5, 6, 7)
                .forEach(num -> System.out.println(num + " " + Thread.currentThread().getName()));

                
        System.out.println("-------------------------------- Parallel Stream -----------------------------");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
                .parallel()
                .forEach(num -> System.out.println(num + " " + Thread.currentThread().getName()));
    }
}
