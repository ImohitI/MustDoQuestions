package com.basics;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        // gadbadMethod();

        int[] array = {12, 3, 1, 2, -6, 5, 0, -8, -1, 6, -5};
        int targetSum = 0;
       /* int[] ans = twoNumberSum(array,targetSum);
        for(int h :ans){
            System.out.print(h+" ");
        }*/

        threeNumberSum(array, targetSum);
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        List<Integer[]> ans = new ArrayList<Integer[]>();
        List<Integer[]> temp = new ArrayList<>();
        boolean skip = false;
        for (int i = 0; i < array.length; i++) {
            System.out.println(">> for number " + array[i]);
            int x = targetSum - array[i];
            twoNumberSum(array, x, i, temp);
        }
        System.out.println(" temp size is "+temp.size()+" ans size is "+ans.size());
        for (Integer[] a : temp) {

            Arrays.sort(a);
            System.out.println(" ----------->" + a[0] + " " + a[1] + " " + a[2]);
            for (int j = 0; j < ans.size(); j++) {
                if (ans.get(j).length > 0) {
                    if ((ans.get(j)[0] == a[0])
                            && (ans.get(j)[1] == a[1])
                            && (ans.get(j)[2] == a[2])) {
                        System.out.println(" skip");
                        skip = true;
                        break;
                    }
                    Integer[] tmp = new Integer[3];
                    if (ans.get(j)[0] > a[0]) {
                        tmp = ans.get(j);
                        System.out.println("1...added a at index j " + j);
                        ans.add(j, a);
                        a = tmp;
                    } else if (ans.get(j)[0] == a[0]) {
                        if (ans.get(j)[1] > a[1]) {
                            tmp = ans.get(j);
                            System.out.println("2...added a at index j " + j);
                            ans.add(j, a);
                            a = tmp;
                        }
                    }

                }
            }
            if (!skip) {
                  System.out.println("add");
                ans.add(a);
            }
            skip = false;

        }
        //  }

        for (Integer[] s : ans) {
            for (int x = 0; x < s.length; x++) {
                System.out.print(" " + s[x]);
            }
            System.out.println();
        }


        return ans;

    }

    public static void twoNumberSum(int[] array, int targetSum, int skipIndex, List<Integer[]> list) {
        Hashtable<Integer, Boolean> htable = new Hashtable<>();
        //List<Integer[]> list = new ArrayList<>();
        int i = 0;
        while (i < array.length) {
            if (i != skipIndex) {
                if (htable.containsKey(targetSum - array[i])) {

                    list.add(new Integer[]{array[skipIndex], array[i], (targetSum - array[i])});
                    //return new Integer[]{array[skipIndex],array[i], targetSum - array[i]};
                } else {
                    htable.put(array[i], true);
                }
            }
            i++;
        }
        //int[] ans={};
        //return list;
        return;

    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
/*        int[] answer =new int[2];
        for(int i=0;i<array.length;i++){
            for(int j=1;j<array.length;j++){
                // System.out.println(" "+i+" "+j);
                if(i!=j && ((array[i]+array[j])==targetSum)){
                    answer[0]=array[i];
                    answer[1]=array[j];
                    return answer;
                    // break;
                }
            }
        }*/

   /*     Arrays.sort(array);
        for(int h :array){
            System.out.print(h+" ");
        }
        boolean breakLoop = false;
        int mid=0;
        int[] arr = new int[2];
        for(int i=0; i<array.length;i++){
            System.out.println("searching for index "+i);
            int x = targetSum-array[i];
            int start = i;
            int end = array.length-1;

            breakLoop=false;
            while(end>=start && !breakLoop){
                mid = (start+ (end-start)/2);
                System.out.println(" start "+start+" end "+end+" mid "+mid);
                if(array[mid]==x){
                    System.out.println("found it");
                    breakLoop= true;
                }else if(array[mid]>x){
                    System.out.println("decreasing end");
                    end = mid-1;
                }else{
                    System.out.println("increasing start");
                    start = mid+1;
                }
            }

            if(breakLoop){
                arr[0]=array[i];
                arr[1]=array[mid];

                return arr;
            }
        }

        int[] ans={};
        return ans;
*/
        /*        Arrays.sort(array);
         *//*        for(int h :array){
            System.out.print(h+" ");
        }*//*
       // System.out.println();
        int[] arr = new int[2];
        int l =0 ;
        int h = array.length -1;

        while(l<h){
           // System.out.println(" i "+i+" L "+l+" H "+h);
            if(array[h]== (targetSum-array[l])){
                arr[0]=array[l];
                arr[1]=array[h];
                return arr;
            }else if(array[h]>(targetSum-array[l])){
                h--;
            }else if(array[h]<(targetSum-array[l])){
                l++;
            }
        }
        int[] ans={};
        return ans;*/

        // int[] arr = new int[2];

        Hashtable<Integer, Boolean> htable = new Hashtable<>();
        int i = 0;
        while (i < array.length) {
            if (htable.containsKey(targetSum - array[i])) {

                return new int[]{array[i], targetSum - array[i]};
            } else {
                htable.put(array[i], true);
            }
            i++;
        }
        //int[] ans={};
        return new int[0];

    }

    public static void gadbadMethod() {
        System.out.println("start");


/*

        Person p = new GoodPerson();
        p.doSomething();

        Executors ee;
        Executor ed;
        //Iterator
        Collections ccc;
*/

        Collections ccc;

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        Collections.sort(list);

        int index = Collections.binarySearch(list, "five");
        System.out.println(index);


        List<Person> list1 = new ArrayList<>();

        list1.add(new Person("Volvo V40", 5));
        list1.add(new Person("Citroen C1", 4));
        list1.add(new Person("Dodge Ram", 2));

 /*       Comparator<Person> personAgeComparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.age > p2.age ? 1:-1;
            }
        };

        */

        Comparator<Person> personAgeComparator =
                (p1, p2) -> p1.age > p2.age ? 1 : -1;

        Collections.sort(list1, personAgeComparator);
        for (Person p : list1) {
            System.out.println(">> " + p.age);
        }

        SortedSet<String> ss;
        Set<String> hh = new TreeSet<String>();
        NavigableSet<String> ns;

        Properties pp;
        HashMap hhh;
        LinkedList ll;
        Stack sd;
        HashSet fg;
        Locale jj;

        int n = 5;
        while (n-- != 0) {
            System.out.println(">><<< " + n);
        }
        HashMap mm;
        Hashtable tt;

        String sss = null;
        String ttt = "A";
/*        if(ttt.equals(sss)){
            System.out.println("null equate krta h ");
        }*/

        int table[] = {1, 2, 3};
        int tab[] = table;

        if ((tab = table) == null || (n = tab.length) == 0) {

        }

        int hy = (10 >>> 16);
        int hashcode = 122121560;
        int h;
        h = 1 == 1 ? (h = hashcode) ^ (h >>> 16) : 0;

        System.out.println(">> " + h + " " + hy);

/*        Exception exception;
        try {
            if (1 == 1) {
                throw new StackOverflowError("memory khatam hogya dhondu");
                // throw new FileNotFoundException("memory khatam hogya dhondu");
            }
        }catch (StackOverflowError e){
            System.out.println("caught an error using catch");
           // e.printStackTrace();
        }
        System.out.println("end");
*/
    }
}
