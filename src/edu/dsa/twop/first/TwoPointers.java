package edu.dsa.twop.first;

public class TwoPointers {
    /**
     * Time complexity is On, where n is the no of charactes in the string
     * this algo runs n/2 times, since two pointers are traversing towards the end
     * 
     * Space complexity is O1, since we use constant space to store two indexes
     * 
     */
    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left = left + 1;
            right = right - 1;
        }

        return true;
    }

    public static void main(String[] arg) {
        String[] testCase = {
                "RACEACAR",
                "A",
                "ABCDEFGFEDCBA",
                "ABC",
                "ABCBA",
                "ABBA",
                "RACEACAR"
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
}
