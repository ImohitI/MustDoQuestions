package edu.dsa.greedytech;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
    
        int[][] nums = {
            {3, 2, 2, 0, 1, 4},
            {2, 3, 1, 1, 9},
            {4},
            {0},
            {3, 2, 1, 0, 4},//false
            {4, 0, 0, 0, 1}
        };

        for (int i = 0; i < nums.length; i++) {
            System.out.println((i + 1) + "\tInput array: " + Arrays.toString(nums[i]));
            if (jumpGame(nums[i]))
                System.out.println("can reach ");
            else 
                System.out.println("not reach");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }   

    public static boolean jumpGame(int[] nums) {
        int targetIndex = nums.length - 1;

        for (int start = nums.length - 2; start >=0; start--) {

            if (targetIndex <= (start + nums[start])) {
                targetIndex = start;
            }
        }

        if (targetIndex == 0) return true;

        return false;
    }
    public static boolean jumpGameFA(int[] nums) {

        if (nums.length <= 1) return true;
        // start from back , check diff of index i - j <= num[i] - j
        // finding the nearest index from which we can get back to curr index
        int end = nums.length - 1;
        int start = end - 1;

        while (end > start && start >= 0) {
            int posDif = end - start;
            int maxJump = nums[start];
            if (maxJump >= posDif) {
                end = start;
            }
            start--; 
        }

        if (end == 0) return true;
            
        return false;
    }

}
