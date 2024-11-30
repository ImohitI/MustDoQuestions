package edu.javastuff.java8newedu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import edu.javastuff.java8newedu.util.Person;

/*
 * Stream API
 * more readable faster and concise 
 * 
 * oop : object and classes a function has no meaning outside a scope of a class
 * functional programming : function exist outside scope of an object 
 *                          assign it to a reference variable and pass as parameter
 * 
 * lambda expression : we basically send a function as a method parameter and it directly gets executed
 * functional interface : an interface that contains only one abstract method
 *                          only one functionality to exhibit
 *                          any number of default methods
 * 
 *  43 predefined interfaces , lets look at them in categories
 * java.util.function.Predicate
 * 
 * Predicate functional interface : 
 *      Predicate<T> : returns a Predicate(boolean) of one argument(ref type) 
 *                      boolean test(T t)
 *      DoublePredicate : boolean test(double value)
 *      IntPredicate : accepts one int-value argument
 *      LongPredicate : boolean test(long value)
 *      BiPredicate<T,U> : accepts two arguments(ref types)
 *                      boolean test(T t, U u)
 *      
 *      Predicate default , static , abstract methods in it
 *          and, isEqual, negate, or, test
 * 
 * Supplier Function Interface
 * does not take any argument and produces a value when get() is invoked 
 *      Supplier<T> : T get()
 *      DoubleSuplier<T> : double getAsDouble()
 *      IntSupplier<T> : int getAsInt()
 *      LongSupplier, BooleanSupplier
 * 
 * Consumer Functional Interface
 * Takes a parameter and return nothing
 *      Consumer<T> : void accept(T t)
 *      DoubleConsumer , Int, Long, 
 *      BiConsumer<T, U> : void accept(T t, U u)
 *      ObjDoubleConsumer : object and double value
 *      ObjIntConsumer : void accept(T t, int value)
 *      ObjLongConsumer
 * 
 * default method , andThen(Consumer<? super T> after)
 * 
 * Function Interface
 * accepts an object type and returns an object type
 * 
 * Function<T, R> , R apply(T, t)
 * default methods andThen(Function after) , compose(Function before)
 * static method , identity
 * 
 * BiFunction<T, U, R> ,  R apply(T t, U u)
 * 
 * UnaryOperator<T> subtype of function
 * take T type and return T type ,  T apply(T t)
 * 
 * BinaryOperator<T>
 * inherits from BiFunction<T, T, T>
 * 
 * 
 * Lambda ----------------
 * can capture 3 types of variable
 * static , instance, local
 * 
 * if lambda captures a variable then it should be either final or effectively final
 * 
 * a non final local variable whose value is never changed
 * 
 * reassigned static should work
 * 
 * Why it like this
 * 
 * because lambda makes copy of that variable, scope of lambda expr in onlu until the method is in the stack
 * so lambda need to make a copy, so that variable is not lost after method is removed from stack
 * now if the variable changes the lambda copy is wrong
 * 
 * 
 */
public class Intro {
    public static void main(String[] args) {
        Greeting engGreeting = new EnglishGreeting();
        wish(engGreeting);

        wish(()-> {System.out.println("Good Morning from lambda");});

        // can remove curly brace as well 
        wish(() -> System.out.println("Good mr"));


        // person comparator 

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 34, "USA"));
        persons.add(new Person("Anil", 10, "India"));

        List<Person> sortedPersons = PersonService.getPerson(persons);

        sortedPersons.forEach((e)->System.out.println(e.getName()));

        //Predicate
        Predicate<Person> predicate = p -> p.getAge() > 28;
        Person person = persons.get(0);
        boolean eligible = PredicateDemo.isPersonValid(person, predicate);
        System.out.println(eligible);

        // and, or  --> and or of predicates
        Predicate<Person> lessThan40 = p -> p.getAge() < 40;
        Predicate<Person> gtThan32 = p -> p.getAge() > 32;
        
        Predicate<Person> ageCheck = gtThan32.and(lessThan40);

        eligible = PredicateDemo.isPersonValid(persons.get(0), ageCheck);
        System.out.println(eligible);

        //negate return a negative predicate
        Predicate<Person> ageCheckNegative = ageCheck.negate();
        eligible = PredicateDemo.isPersonValid(person, ageCheckNegative);

        System.out.println(eligible);

        //isEqual, takes an object, use Objects.equal(Object, Object)
        Predicate<String> predicateEq = Predicate.isEqual("Hello");
        System.out.println("Hello".equals("Hello"));
        System.out.println(predicateEq.test("Hello"));

        //BiPredicate, takes two objects and return a boolean value
        BiPredicate<Person, Integer> BiPredicate = (p, minAge) -> (p.getAge() > minAge);
        eligible = PredicateDemo.isPersonValidAge(person, 18, BiPredicate);

        System.out.println(eligible);


        //Supplier demo
        Supplier<Person> supplier = () -> new Person("Alex", 23, "England");
        Predicate<Person> agePredicate = (p) -> p.getAge() > 18;

        eligible = SupplierDemo.isPersonValid(supplier, agePredicate);
        System.out.println(eligible);

        //IntSupplier
        IntSupplier supplierInt = () -> (int)(Math.random() * 10);
        System.out.println(supplierInt.getAsInt());

        //DoubleSupplier 
        DoubleSupplier supplierDouble = () -> (int)(Math.random() * 10);
        System.out.println(supplierDouble.getAsDouble());


        //ConsumerDemo
        Consumer<String> stringConsumer = s -> System.out.println(s);
        stringConsumer.accept("Hello");

        Consumer<Integer> intConsumer = i -> System.out.println(i);
        intConsumer.accept(8);
        
        // andThen for chaining
        Consumer<String> con1 = a -> System.out.println(a + " now in con1 ");
        Consumer<String> con2 = a -> System.out.println(a + " now in con2 ");

        con1.andThen(con2).accept("hello");

        //BiConsumer 
        BiConsumer<String, String> greet = (s1, s2) -> System.out.println(s1 + s2);
        greet.accept("hi ", "there");

        //Function
        // apply
        Function<String, Integer> lengthFun = s -> s.length();
        System.out.println(lengthFun.apply("six"));
        
        //compose ,  what to be done before
        //first apply fun provided as parameter on input then apply the fun on which it is called
        Function<Integer, Integer> increment = x -> x + 10;
        Function<Integer, Integer> multiply = x -> x * 2;

        System.out.println(increment.compose(multiply).apply(3)); // 3 * 2  --> 6 + 10 --> 16

        //andThen , what to be don after
        System.out.println(increment.andThen(multiply).apply(3)); // 3 + 10 --> 13 * 2 --> 26

        //BiFunction <T, U, R>
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(2, 3));

        //UnaryOperator <T>
        Person pem = new Person();
        UnaryOperator<Person> operator = p -> {
            p.setAge(10);
            p.setName("Nim");
            p.setCountry("Spain");
            return p;
        };

        operator.apply(pem);
        System.out.println(pem.getName());

        IntUnaryOperator inop = a -> a * a;
        System.out.println(inop.applyAsInt(4));


        //Binary Operator
        Person pr1 = new Person("p1", 10, "Fiji");
        Person pr2 = new Person("p2", 24, "Nepal");

        BinaryOperator<Person> binop = (p1, p2) -> {
            p1.setAge(p2.getAge());
            return p1;
        };

        binop.apply(pr1, pr2);
        System.out.println(pr1.getAge());


        //Effectively final
        int val = 5;
        UnaryOperator<Integer> op2 = i -> i * val;
        System.out.println(op2.apply(val));


    }

    public static void wish(Greeting greeting) {
        greeting.greet();
    }
}

@FunctionalInterface
interface Greeting {
    void greet();
}

class EnglishGreeting implements Greeting {

    @Override
    public void greet() {
        System.out.println("Good Morning");        
    }
    
}
// Anonymous comparator
class PersonService {

    public static List<Person> getPerson(List<Person> persons) {
        // this sorts the person on the basis of name
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        // lambda expression for comparator
        Collections.sort(persons, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        return persons;
    }
}

class PredicateDemo {
    static boolean isPersonValid(Person person, Predicate<Person> predicate) {
        return predicate.test(person);
    }
    static boolean isPersonValidAge(Person person, Integer minAge, BiPredicate<Person, Integer> predicate) {
        return predicate.test(person, minAge);
    }
}

class SupplierDemo {
    static boolean isPersonValid(Supplier<Person> supplier, Predicate<Person> predicate) {
        return predicate.test(supplier.get());
    }
}
