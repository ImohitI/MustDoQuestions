package edu.javastuff.collectionedu;

import java.util.Arrays;

public class ArraysCollectionsCls {
    public static void main(String[] args) {
        /*
         * Arrays class in java.util
         * binarySearch , with array and target
         * binarySearch , with array start index end index and target
         * 
         * 
         */

         int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

         int index = Arrays.binarySearch(numbers, 5, 9, 4);
 
         System.out.println("The index of element 4 in the array is " + index);
 
         index = Arrays.binarySearch(numbers, 1, 5, 4);
 
         System.out.println("The index of element 4 in the array is " + index);

         Integer[] numbers2 = { 10, 2, 32, 12, 15, 76, 17, 48, 79, 9 };
         Arrays.sort(numbers2);
 
         for (int i : numbers2) {
             System.out.print(i + " ");
         }
    }
    
}
