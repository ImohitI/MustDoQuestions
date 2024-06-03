package edu.dsa.stacks;

import java.util.Arrays;
import java.util.Stack;

public class LargestHist {
    
        // Function to find the largest rectangle area formed by given heights.
        public static int largestRectangle(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
    
            int maxArea = 0;
    
            for (int i = 0; i < heights.length; i++) {
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                    int currentHeight = heights[stack.pop()];
    
                    int rightBoundary = i;
                    int leftBoundary = stack.peek();
                    int currentWidth = rightBoundary - leftBoundary - 1;
    
                    int currentArea = currentHeight * currentWidth;
    
                    maxArea = Math.max(maxArea, currentArea);
                }
    
                stack.push(i);
            }
    
            int n = heights.length;
    
            while (stack.peek() != -1) {
                int currentHeight = heights[stack.pop()];
    
                int leftBoundary = stack.peek();
                int currentWidth = n - leftBoundary - 1;
    
                int currentArea = currentHeight * currentWidth;
    
                maxArea = Math.max(maxArea, currentArea);
            }
    
            return maxArea;
        }
    

        // Driver code
        public static void main(String[] args) {
            int[][] inputList = {
                {2, 4, 5, 7, 3, 9},
                {1, 3, 4, 2, 2},
                {2, 1, 5, 6, 2, 3},
                {1, 2, 3, 4, 5},
                {3, 1, 3, 4, 2, 1, 5, 4, 2, 3, 1, 2, 3, 2, 4, 1, 2, 2, 5, 3},
                {1, 2, 3, 2, 5, 6, 2, 1, 4, 3, 2, 3, 4, 1, 3, 2, 3, 4, 5, 1}
            };
    
            for (int i = 0; i < inputList.length; i++) {
                System.out.println((i + 1) + ".\tHeights: " + Arrays.toString(inputList[i]) + 
                                             "\n\tArea of the largest rectangle: " + largestRectangle(inputList[i]));
                System.out.println(new String(new char[100]).replace("\0", "-"));
            }
        }
}
