package edu.dsa.greedytech;

import java.util.Arrays;

public class CanFlower {
    
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length ; i++) {

            if (flowerbed[i] == 0) {
                boolean left = (i == 0 || flowerbed[i-1] == 0);
                boolean right = (i == flowerbed.length - 1 || flowerbed[i+1] == 0);

                if (left && right) {
                    flowerbed[i] = 1;
                    count++;

                    if (count == n)
                        return true;
                }
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        int[][] flowerbeds = {
          {0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
          {1, 0, 1, 0, 1, 0, 0, 1},
          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
          {0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
          {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}
        };
        
        int[] n = {2, 1, 6, 2, 3};
    
        for (int i = 0; i < flowerbeds.length; i++) {
          System.out.println((i + 1) + ".\tFlower bed: " + Arrays.toString(flowerbeds[i]));
          System.out.println("\tn: " + n[i]);
          System.out.println("\n\tFlowers planted: " + canPlaceFlowers(flowerbeds[i], n[i]));
          System.out.println(new String(new char[100]).replace('\0', '-'));
        }
      }    
}
