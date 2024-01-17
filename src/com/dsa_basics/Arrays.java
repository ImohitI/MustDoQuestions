package com.dsa_basics;

public class Arrays {
    public static void main(String[] args) {
        // reverse an array
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        reverseArray(arr, 0, 5);
        System.out.println(java.util.Arrays.toString(arr));

        int arr1[] = { 1, 2, 3, 4, 5, 6 };
        rotateArray(arr1);
        System.out.println(java.util.Arrays.toString(arr1));

        // find maximum contiguous subarray
        int[] arr2 = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Maximum contiguous sum is "
                + maxSubArraySum(arr2));
        int arr3[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int arr_size = arr3.length;
        sort012(arr3, arr_size);
        System.out.println(java.util.Arrays.toString(arr3));
    }

    public static void sort012(int a[], int size) {
        int low = 0;
        int high = size - 1;
        int mid = 0, temp = 0;
        // Iterate till all the elements are sorted
        while (mid < high) {
            switch (a[mid]) {
                // if element is 0
                case 0: {
                    temp = a[low];
                    a[low] = a[mid];
                    a[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                // if element is 1
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a[mid];
                    a[mid] = a[high];
                    a[high] = temp;
                    high--;
                    break;
                }

            }
        }
    }

    // kadane algorithm
    private static int maxSubArraySum(int[] arr) {
        int size = arr.length;
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + arr[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }

    // cyclic rotation
    private static void rotateArray(int[] arr) {
        int end = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = end;
    }

    // TC O(n) AS O(1)
    private static void reverseArray(int[] arr, int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }

}
