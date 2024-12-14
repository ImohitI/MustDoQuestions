package edu.dsa.greedytech;

import java.util.*;

public class AssignCookie {
    
    public static int findContentChildren(int[] gf, int[] cs) {
        int result = 0;
        Arrays.sort(gf);
        Arrays.sort(cs);

        int currentChild = 0, currentCookie = 0;

        while (currentChild < gf.length && currentCookie < cs.length) {
            if (cs[currentCookie] >= gf[currentChild]) {
                result++;
                currentChild++;
            }
            currentCookie++;
        }

        return result;
    }
    public static void main(String[] args) {
                
        int[][] greedFactors = {
            {1, 2, 3},
            {10, 20, 30, 40 ,50 ,60 ,70, 80},
            {3, 4, 5, 6, 7, 8},
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
            {10, 9, 8, 7},
            {1000, 996, 867, 345, 23, 12}
        };
        
        int[][] cookieSizes = {
            {1, 1},
            {10, 20, 30, 40 ,50 ,60 ,70, 80, 90, 100},
            {1, 2},
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
            {5, 6, 7, 8},
            {}
        };
        
        for (int i = 0; i < greedFactors.length; i++) {
            int result = findContentChildren(greedFactors[i], cookieSizes[i]);
            System.out.println((i + 1) + ".\tGreed factors: " + Arrays.toString(greedFactors[i]));
            System.out.println("\tCookie sizes: " + Arrays.toString(cookieSizes[i]));
            System.out.println("\n\tResult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
