package edu.dsa.greedytech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestPalindrome {
    
    public static String largestPalindrome(String num) {

        Map<Character, Integer> freq = new HashMap<>();

        for (char digit : num.toCharArray()) {
            freq.put(digit, freq.getOrDefault(digit, 0) + 1);
        }

        List<String> firstHalf = new ArrayList<>();
        String middle = "";


        for (char digit = '9'; digit >= '0'; digit--) {
            if (freq.containsKey(digit)) {
                int count = freq.get(digit);
                int numPairs = count/2;

                if (numPairs > 0) {
                    if (firstHalf.isEmpty() && digit == '0') {
                        freq.put('0', 1);
                    }
                    else {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < numPairs; i++) {
                            sb.append(digit);
                        }
                        firstHalf.add(sb.toString());
                    }
                }
                //checking for a middle
                if (count % 2 == 1 && middle.isEmpty()) {
                    middle = Character.toString(digit);
                }
            }
        }

        if (middle.isEmpty() && firstHalf.isEmpty()) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String part : firstHalf) {
            result.append(part);
        }

        String secondHalf = result.toString();
        result.append(middle).append(new StringBuilder(secondHalf).reverse().toString());

        return result.toString();
    }

    public static void main(String[] args) {
        
        String[] numbers = {"00001", "1234287", "9876545367282", "000000", "146"};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println((i + 1) + ".\tGiven number: \"" + numbers[i] + "\"");
            String result = largestPalindrome(numbers[i]);
            System.out.println("\n\tThe largest palindromic number: \"" + result + "\"");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
