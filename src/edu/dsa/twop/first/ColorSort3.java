package edu.dsa.twop.first;

import java.util.Arrays;

public class ColorSort3 {
    


    public static void main(String[] args) {
        int[][] inputs = {
            {0, 1, 0},
            {1, 1, 0, 2},
            {2, 1, 1, 0, 0},
            {2, 2, 2, 0, 1, 0},
            {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tcolors: " + Arrays.toString(inputs[i]));

            int[] sortedColors = sortColors(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + Arrays.toString(sortedColors));

            System.out.println("---------------------------------");
        }
    }

    private static int[] sortColors(int[] colors) {

        int start = 0, current = 0, end = colors.length - 1;

        while (current <= end) {
            if (colors[current] == 0) {
                if (colors[start] != 0) {
                int temp = colors[start];
                colors[start] = colors[current];
                colors[current] = temp;
                }
                start++;
                current++;
            } else if (colors[current] == 1) {
                current++;
            } else {
                if (colors[end] != 2) {
                    int temp = colors[current];
                    colors[current] = colors[end];
                    colors[end] = temp;
                }
                end--;
            }
        }
        return colors;
    }
}
