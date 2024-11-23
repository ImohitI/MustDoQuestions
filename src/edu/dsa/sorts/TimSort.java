package edu.dsa.sorts;

import java.util.Arrays;

/*
 * 
 * Timsort a hybrid algorithm derived from merge and insertion
 * divide array into runs : a run is a sequence of consecutive
 * elements with are in order
 * sort the run : if run is smaller than certain size, timsort uses
 * insertion osrt to sort these runs
 * merge the runs
 * 
 */
public class TimSort {
    private static final int MIN_RUN = 32;

    public static void timSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i += MIN_RUN) {
            insertionSort(array, i, Math.min(i + MIN_RUN - 1, n - 1));
        }

        for (int size = MIN_RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                
                merge(array, left, mid, right);
            }
        }
    }

    private static void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i ++) {
            int key = array[i];
            int j = i - 1;
            while (j >= left && array[i] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] leftArray = new int[len1];
        int[] rightArray = new int[len2];

        System.arraycopy(array, left, leftArray, 0, len1);
        System.arraycopy(array, mid + 1, rightArray, 0, len2);

        int i = 0, j = 0, k = left;

        while (i < len1 && j < len2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < len1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < len2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 21, 7, 23, 19};
        System.out.println("Original array: " + Arrays.toString(array)); 
        timSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
