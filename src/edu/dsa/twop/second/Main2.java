package edu.dsa.twop.second;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        String[] testCases = {"1221", "54345", "999", "12321", "89798", "51432732415"};
        for (int i = 0; i < testCases.length; i++) {
            System.out.println(i + 1 + ".\t Original palindrome: '" + testCases[i] + "'");
            String nextPalindrome = findNextPalindrome(testCases[i]);
            System.out.println("\t Next greater palindrome: '" + nextPalindrome + "'");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static boolean findNextPermutation(List<Character> digits) {
        // Step 1 find the first digit taht is smaller than the digit after it
        int i = digits.size() - 2;
        while (i >= 0 && digits.get(i) >= digits.get(i + 1)) {
            i--;
        }
        if (i == -1) {
            return false;
        }

        // Step 2 find the next larget digit to swap with digit[i]
        int j = digits.size() - 1;
        while (digits.get(j) <= digits.get(i)) {
            j--;
        }

        // Step 3 swap and reverse the rest to get the smallest next permutation
        Collections.swap(digits, i, j);
        Collections.reverse(digits.subList(i + 1, digits.size()));

        return true;
    }
    public static String findNextPalindrome(String numStr) {

        int n = numStr.length();

        if (n == 1) {
            return "";
        }

        int halfLen = n / 2;
        List<Character> leftHalf = new ArrayList<>();
        for (int i = 0; i < halfLen; i++) {
            leftHalf.add(numStr.charAt(i));
        }

        //Step1 : Get the next permutation for the left half
        if (!findNextPermutation(leftHalf)) {
            return "";
        }
        //Step 2: Form the next palindrome by mirror the left
        StringBuilder nextPalindrome = new StringBuilder();
        for (char c : leftHalf) {
            nextPalindrome.append(c);
        }

        if (n % 2 == 0) {
            nextPalindrome.append(new StringBuilder(nextPalindrome).reverse());

        } else {
            nextPalindrome.append(numStr.charAt(halfLen));
            nextPalindrome.append(new StringBuilder(nextPalindrome.substring(0, halfLen)).reverse());
        }

        // Step 3: Ensure the result is larger than the original number
        if (nextPalindrome.toString().compareTo(numStr) > 0) {
            return nextPalindrome.toString();
        }     
        return "";
    }


}
