package edu.dsa.sorts;

public class SelectionSort {

    /*
     * select min and swap
     */
    public static void selectionSort(int[] nums) {

        for(int i = 0; i < nums.length ; i++) {
            int min = i;
            for (int j = i; j < nums.length ; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            //swap
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 2, 7, 4};
        selectionSort(arr);
        for ( int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }
    
}
