package edu.dsa.sorts;

public class InsertionSort {
    
    /*
     * select an element from unsorted part of the array
     * place it in correct position
     * use inner loop to shift
     * continue till sorted
     */
    public static void sort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
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
