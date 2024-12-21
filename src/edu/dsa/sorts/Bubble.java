package edu.dsa.sorts;

public class Bubble {

    public static void sort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < nums.length - i - 1; j ++) {
                if (nums[j] > nums[j + 1]) {
                    //swap
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            //swapped 
            if (swapped == false) {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 2, 7, 4};
        sort(arr);
        for ( int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }
}
