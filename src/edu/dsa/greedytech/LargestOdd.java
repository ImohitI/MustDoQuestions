package edu.dsa.greedytech;

import java.util.ArrayList;
import java.util.List;

public class LargestOdd {

    public static String largestOddNumber(String s) {

        for (int i=0; i < s.length(); i++) {
            if (Character.getNumericValue(s.charAt(i)) % 2 == 1) {
                return s.substring(0, i + 1);
            }
        }

        return "";
    }
    public static void main(String[] args) {
        List<String> testCases = new ArrayList<>();
        testCases.add("345679"); // Example with multiple odd digits
        testCases.add("357"); // Example with all odd digits
        testCases.add("2468"); // Example with no odd digit
        testCases.add("5"); // Example with a single odd digit
        testCases.add("74"); // Example with one odd and one even digit
        testCases.add("4597680"); // Example with even digits at the end

        for (int i = 0; i < testCases.size(); i++) {
            String testCase = testCases.get(i);
            String result = largestOddNumber(testCase);

            System.out.println((i + 1) + ".\tnum: " + testCase);
            System.out.println("\tResult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
