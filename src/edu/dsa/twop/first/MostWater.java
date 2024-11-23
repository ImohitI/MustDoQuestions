package edu.dsa.twop.first;

public class MostWater {

    public static int containerWithMostWater(int[] height) {
        
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
      
            int width = end - start;      
            maxArea = Math.max(maxArea, Math.min(height[start], height[end]) * width);

            if (height[start] <= height[end]) {
                start++;
            }
            else {
                end--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
                int[][] heights = {
            {1, 8, 6, 2, 5, 4, 8, 3, 7},
            {20, 30, 9, 69},
            {13, 18, 12, 8},
            {45, 32, 56, 99},
            {23, 20}
        };

        int index = 1;
        for (int[] i : heights) {
            System.out.print(index + ".\tHeights: [");
            for (int j = 0; j < i.length; j++) {
                System.out.print(i[j]);
                if (j < i.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            System.out.println("\n\tMaximum Area: " + containerWithMostWater(i));
            index++;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
