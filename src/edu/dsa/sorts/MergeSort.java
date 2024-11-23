package edu.dsa.sorts;

import java.util.Arrays;

/*
 * divide : divide and conquer
 * O(1) 
 * conquer : recursively sort each half
 * we recursively solve each sub problem of size n/2
 * T(n) = 2T(n/2) + O(n)
 * combine : merge two sorted values into a single sorted array
 * O(n)
 * 
 * time complexity : O(nlogn)
 * space complexity : O(n)
 */
public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;

            //split into 2
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];

            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, array.length - mid);

            //Recursively sort each half
            mergeSort(left);
            mergeSort(right);

            //Merge the sorted value
            merge(array, left, right);

        }
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        { int[] array = {12, 11, 13, 5, 6, 7}; 
        mergeSort(array); 
        System.out.println("Sorted array: " + Arrays.toString(array));    }

    }
}
