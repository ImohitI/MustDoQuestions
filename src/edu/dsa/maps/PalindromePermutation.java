package edu.dsa.maps;

import java.util.*;

public class PalindromePermutation {

    public static String printArrayWithMarkers(String arr, int pvalue) {
        String out = "";
        for (int i = 0; i < pvalue; i++) {
            out += arr.charAt(i);
        }
        out += "«" + arr.charAt(pvalue) + "»";
        for (int i = pvalue + 1; i < arr.length(); i++) {
            out += arr.charAt(i);
        }
        return out;
    }

    public static boolean permutePalindrome(String st) {
        // Create a hashmap to keep track of the characters and their occurrences
        System.out.println("\n\tPopulating the hashmap");
        HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();
        int index = 0;
        for (int i = 0; i < st.length(); i++) {
            System.out.println("\t\t" + printArrayWithMarkers(st, index));
            index += 1;
            System.out.println("\t\tCharacter: " + st.charAt(i));
            System.out.println("\t\tHashmap: " + frequencies);
            if (frequencies.containsKey(st.charAt(i))) {
                System.out.println("\t\t\t" + st.charAt(i) + " is already present in the hashmap");
                System.out.print("\t\t\tUpdating its frequency  ⟶ ");
                frequencies.put(st.charAt(i), frequencies.get(st.charAt(i)) + 1);
                System.out.println(frequencies + "\n");
            } else {
                System.out.println("\t\t\t" + st.charAt(i) + " is not present in the hashmap");
                System.out.print("\t\t\tSetting its frequency = 1  ⟶ ");
                frequencies.put(st.charAt(i), 1);
                System.out.println(frequencies + "\n");
            }
        }
        // Traverse the hashmap and update the count by 1, whenever a
        // character with odd number of occurences is found.
        int count = 0;
        System.out.println("\n\tCounting the characters with odd frequencies");
        System.out.println("\t\tHash map: " + frequencies);
        System.out.println("\t\tCount = " + count);
        for (Character ch : frequencies.keySet()) {
            System.out.println("\t\tFrequency of '" + ch + "' = " + frequencies.get(ch));
            if (frequencies.get(ch) % 2 != 0) {
                System.out.println("\t\t\tIncrementing count: " + count + " + 1 = " + (count + 1));
                count += 1;
            } else
                System.out.println("\t\t\tFrequency is not odd, moving to the next character\n");
        }
        // If the count is smaller than or equal to 1 then the permutation exists,
        // otherwise does not
        System.out.println("\n\tCount: " + count);
        if (count <= 1) {
            System.out.println("\tCount is <= 1, return TRUE");
            return true;
        } else {
            System.out.println("\tCount > 1, returning FALSE");
            return false;
        }
    }

    public static void main(String args[]) {
        List<String> strArray = Arrays.asList("baefeab", "abc", "xzz", "jjadd", "kllk");
        for (int i = 0; i < strArray.size(); i++) {
            System.out.println(i + 1 + ".\tInput string: " + strArray.get(i));
            boolean result = permutePalindrome(strArray.get(i));
            if (result)
                System.out.println("\n\tInput string has permutations that are palindromes");
            else
                System.out.println("\n\tInput string does not have a permutation that's a palindrome");
            System.out.println(PrintHyphens.repeat('-', 100));
        }
    }
}

class PrintHyphens {
    public static String repeat(char hyphen, int n) {
        if (n <= 0) {
            System.out.println("Invalid input. Please provide a positive value for n.");
            return "";
        }

        StringBuilder hyphenString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            hyphenString.append(hyphen);
        }

        return hyphenString.toString();
    }
}
