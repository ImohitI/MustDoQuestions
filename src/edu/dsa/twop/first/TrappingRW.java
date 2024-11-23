package edu.dsa.twop.first;

import java.util.Arrays;

public class TrappingRW {
       // Driver code
       public static void main(String[] args) {
        int[][] inputList = {
            {4, 1, 1, 6, 1, 1, 5},
            {1, 0, 1, 2, 1, 4, 0, 3, 5},
            {2, 0, 9, 6},
            {3, 1, 2, 0, 2},
            {4, 2, 5, 3},
            {3, 0}
        };

        int index = 1;
        for (int[] heights : inputList) {
            System.out.println(index + ".\tHeights: " + Arrays.toString(heights));
            System.out.println("\tMaximum rainWater: " + rainWater(heights));
            index++;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static int rainWater(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int storedWater = 0;
        int leftMax = 0, rightMax = 0;

        while (left <= right) {
            if (leftMax <= rightMax) {
                storedWater += Math.max(0, leftMax - heights[left]);
                leftMax = Math.max(leftMax, heights[left]);
                left++;
            } else {
                storedWater += Math.max(0, rightMax - heights[right]);
                rightMax = Math.max(rightMax, heights[right]);
                right--;
            }
        }

        return storedWater;
    }
}
