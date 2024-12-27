package edu.dsa.twop.first;

public class leet977 {
    
    public int[] sortedSquare(int[] nums) {

        int[] result = new int[nums.length];

        // tow pointer
        int left = 0;
        int right = nums.length - 1;

        // fill result start from the end
        int pos = nums.length - 1;


        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[pos] = leftSquare;
                left++;
            } else {
                result[pos] = rightSquare;
                right--;
            }
            pos--;
        }

        return result;
    }
}
