package com.interviewprep.javaConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

// static method
interface Vehicle {
    static String producer() {
        return "N&F Vehicles";
    }

    default String getOverview() {
        return "ATV made by " + producer();
    }
}

class VehicleImpl implements Vehicle {

}

class User {
    int id;
    String name;

    User() {
        this.name = "default";
    }

    User(String name) {
        this.id = -1;
        this.name = name;
    }

    User(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static boolean isRealUser(User user) {
        return true;
    }

    public boolean isLegalName(String string) {
        return true;
    }
}

public class java8changes {
    public static void main(String[] args) {
        // default and static methods in interface
        // It was not possible to add new functionality in
        // existing interface without forcing all implementing
        // class to create implementation of the new method
        String producer = Vehicle.producer();
        Vehicle vehicle = new VehicleImpl();
        String overview = vehicle.getOverview();

        (new java8changes()).learn();
        (new java8changes()).learn2();
        (new java8changes()).learn3();
    }

    public void learn() {
        List<User> list = new ArrayList<>();
        list.add(new User("A"));
        list.add(new User("B"));

        // static method reference
        // ContainingClass :: methodName
        boolean isReal = list.stream().anyMatch(u -> User.isRealUser(u));

        System.out.println(isReal);

        boolean isReal2 = list.stream().anyMatch(User::isRealUser);
        System.out.println(isReal2);

        // reference to an instance method
        List<String> a = new ArrayList<>();
        a.add("abc");
        a.add("yando");
        a.add("");
        User user = new User("C");
        boolean isLegalName = a.stream().anyMatch(user::isLegalName);

        // reference to an instance method of an object of a particular type

        long count = a.stream().filter(String::isEmpty).count();
        System.out.println(count);

        // reference to a constructor

        List<String> b = Arrays.asList("Rrr", "brr", "cprr");
        // Stream<User> stream = b.stream().map(User::new);
        Stream<User> stream = b.stream().map(s -> new User(s, 100));

        stream.forEach(s -> System.out.println(s.name + ", " + s.id));

        // Optional<T>
        // handle situations where there is a possibility of getting the NPE.
        // It works as a container of object of type T.
        // when value inside the container is null, it allows doing some predefined
        // actions instead of throwing NPE

        Optional<String> optional = Optional.empty();
        String str = "value";
        optional = Optional.of(str);

        // optional = Optional.ofNullable(getString());

        String name = Optional.of("mohit").orElse("");
        name = Optional.of("mohit").orElseGet(() -> (""));
    }

    private long counter;

    private void wasCalled() {
        counter++;
    }

    public void learn2() {
        String[] arr = new String[] { "a", "b", "c" };
        Stream<String> stream = Arrays.stream(arr);
        stream = Stream.of("a", "b", "c");

        List<User> users = new ArrayList<>();
        users.add(new User("A"));
        users.add(new User("B"));
        users.add(new User("C"));
        users.add(new User("D"));
        users.add(new User("E"));

        users.parallelStream().forEach(e -> System.out.println(e.name));

        // stream builder
        Stream<String> steamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();

        // stream generate
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(4);

        streamGenerated.forEach(e -> System.out.println(e));

        // Stream iterate
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(3);

        streamIterated.forEach(e -> System.out.println(e));

        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        intStream.forEach(e -> System.out.println(e));
        longStream.forEach(e -> System.out.println(e));

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");

        long ss = list.stream().skip(1).map(element -> element.substring(0, 3)).sorted().count();

        System.out.println(ss);

        // lazy invocation
        counter = 0;
        Stream<String> streamS = list.stream().filter(element -> {
            wasCalled();
            return element.contains("2");
        });

        // streamS.forEach(e -> System.out.println(e));
        System.out.println(counter);

        Optional<String> streamO = list.stream().filter(element -> {
            System.out.println("filter() was called");
            return element.contains("2");
        }).map(element -> {
            System.out.println("map() was called");
            return element.toUpperCase();
        }).findFirst();

        // rule : Intermediate operations which reduce the size the stream should be
        // placed
        // before operations which are applying to each element
        // so keep methods such as skip(), filter(), and distinct() at top of our stream
        // pipeline

        // reduce and collect
        // Stream has many terminal operations which aggregate a stream to a type
        // or to a primitive--> count(), max(), min(), sum()
        // to customize stream reduction mechanism , we have tow methods reduce(),
        // collect()

        // reduce
        // identity - initial value of an accumulator
        // accumulator - function specify logic of aggregation of elements
        // combiner - function which aggregates the results of the accumulator, we only
        // combiner in parallel mode

        OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);

        System.out.println(reduced);

        int reducedParams = Stream.of(1, 2, 3).reduce(10, (a, b) -> a + b, (a, b) -> {
            System.out.println(" combiner called");
            return a + b;
        });
        System.out.println(reducedParams);

        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream().reduce(10, (a, b) -> a + b, (a, b) -> {
            System.out.println(" combiner called");
            return a + b;
        });

        // 10 + 1 = 11, 10 + 2 = 12, 10 + 3 = 13
        // 12 + 13 = 25 , 25 + 11 = 36

        System.out.println(reducedParallel);

        // collect
        List<User> uList = Arrays.asList(new User("A", 4), new User("B", 2), new User("C", 4), new User("D", 4));

        List<String> collectorCollection = uList.stream().map(User::getName).collect(Collectors.toList());

        collectorCollection.forEach(e -> System.out.println(e));

        String listString = uList.stream().map(User::getName).collect(Collectors.joining(", ", "[", "]"));

        System.out.println(listString);

        int ids = uList.stream().collect(Collectors.summingInt(User::getId));
        System.out.println(ids);

        Map<Integer, List<User>> collectMapofLists = uList.stream().collect(Collectors.groupingBy(User::getId));

        for (Map.Entry<Integer, List<User>> e : collectMapofLists.entrySet()) {
            System.out.println(e.getKey());
            e.getValue().forEach(i -> System.out.println(i.name));

        }

        // dividing by some predicate
        Map<Boolean, List<User>> mapPartioned = uList.stream().collect(Collectors.partitioningBy(e -> e.getId() > 3));

        for (Map.Entry<Boolean, List<User>> e : mapPartioned.entrySet()) {
            System.out.println(e.getKey());
            e.getValue().forEach(i -> System.out.println(i.name));

        }

        // Custom Collector
        Collector<User, ?, LinkedList<User>> toLinkedList = Collector.of(LinkedList::new, LinkedList::add,
                (first, second) -> {
                    first.addAll(second);
                    return first;
                });

        LinkedList<User> linkedListOfPersons = uList.stream().collect(toLinkedList);

        for (User u : linkedListOfPersons) {
            System.out.println(u.name);

        }

    }

    public String add(String string, Foo foo) {
        return foo.method(string);
    }

    public void learn3() {
        Foo foo = parameter -> parameter + " from lambda";
        String result = new java8changes().add("Message", foo);
        System.out.println(result);
    }

}
