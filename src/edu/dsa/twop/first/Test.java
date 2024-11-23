package edu.dsa.twop.first;

import java.util.Arrays;

public class Test {

    private static boolean isPalindrome(String string) {
        int p1 = 0;
        int p2 = string.length() - 1;
        while (p1 < p2) {
            if (string.charAt(p1) != string.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }

    private static boolean findSumOfThree(int[] nums, int target) {

        if (nums.length < 3) {
            return false;
        }

        Arrays.sort(nums);

        // n1 , n2 , n3
        for (int i = 0; i < nums.length - 2; i++) {
            int n1 = i;
            int n2 = i + 1;
            int n3 = nums.length - 1;

            while (n2 < n3) {
                int cs = nums[n1] + nums[n2] + nums[n3];
                if (cs < target) {
                    n2++;
                } else if (cs > target) {
                    n3--;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // testPalinedrome();

        testSOT();
    }

    public static void testPalinedrome() {
        String[] testCase = {
                "RACEACAR", // false
                "A", // true
                "ABCDEFGFEDCBA", // true
                "ABC", // false
                "ABCBA", // true
                "ABBA", // true
                "RACEACAR" // false
        };
        for (int k = 0; k < testCase.length; k++) {
            System.out.println("Test Case #" + (k + 1));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println("The input string is " + testCase[k] + "' and the length of the string is "
                    + testCase[k].length() + ".");
            System.out.println("\nIs it a palindrome?..... " + isPalindrome(testCase[k]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static void testSOT() {
        int[][] numsList = { { 3, 7, 1, 2, 8, 4, 5 }, // true
                { -1, 2, 1, -4, 5, -3 }, // false
                { 2, 3, 4, 1, 7, 9 }, // true
                { 1, -1, 0 }, // false
                { 2, 4, 2, 7, 6, 3, 1 } }; // true

        int[] testList = { 10, 7, 20, -1, 8 };

        for (int i = 0; i < testList.length; i++) {
            System.out.print(i + 1);
            // if (i != 1) {
            // continue;
            // }
            System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));

            if (findSumOfThree(numsList[i], testList[i])) {
                System.out.println("\tSum for " + testList[i] + " exists ");
            } else {
                System.out.println("\tSum for " + testList[i] + " does not exist ");
            }

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
