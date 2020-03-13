package com.algoexpert.arraysproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] args) {

        // gadbadMethod();

        int[] array = {12, 3, 1, 2, -6, 5, 0, -8, -1, 6, -5};
        int targetSum = 0;
       /* int[] ans = twoNumberSum(array,targetSum);
        for(int h :ans){
            System.out.print(h+" ");
        }*/

        //threeNumberSum(array, targetSum);
        threeNumberSum2(array, targetSum);

    }

    //Solution 1
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        List<Integer[]> ans = new ArrayList<Integer[]>();
        List<Integer[]> temp = new ArrayList<>();
        boolean skip = false;
        for (int i = 0; i < array.length; i++) {
            System.out.println(">> for number " + array[i]);
            int x = targetSum - array[i];
            twoNumberSum(array, x, i, temp);
        }
        System.out.println(" temp size is " + temp.size() + " ans size is " + ans.size());
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

    public static void threeNumberSum2(int[] array, int targetSum) {

        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            System.out.println("Start index "+i+ " number "+array[i]);
            int L = i+1;
            int R = array.length-1;

            //int twoSumTarget = targetSum-array[i];
            Arrays.sort(array);
            System.out.println("L "+L+" R "+R);
            while (L < R ) {
                //System.out.println("Inside while loop");
                if(L!= i && R!=i) {
                    if ((array[L] + array[R] + array[i]) > targetSum) {
                        System.out.println("decreasing R "+R);
                        R--;
                    } else if ((array[L] + array[R] + array[i]) < targetSum) {
                        System.out.println("Increasing L " +L);
                        L++;
                    } else {
                        System.out.println("Adding to list array[L] "+ array[L]+" array[R] "+array[R]+" array[i] "+array[i]);
                        Integer[] arr = new Integer[]{array[L], array[R], array[i]};
                        Arrays.sort(arr);
                        list.add(arr);
                        L ++;
                        R --;
                    }
                }
            }

        }
        System.out.println(" list size is "+list.size());
        for (Integer[] s : list) {
            for (int x = 0; x < s.length; x++) {
                System.out.print(" " + s[x]);
            }
            System.out.println();
        }
        return;
    }

}
