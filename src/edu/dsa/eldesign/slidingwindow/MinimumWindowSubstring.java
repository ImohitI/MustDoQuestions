package edu.dsa.eldesign.slidingwindow;

import java.util.*;

class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        // empty string scenario
        if (t.equals("")) {
            return "";
        }

        // creating the two hash maps
        Map<Character, Integer> reqCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // populating reqCount hash map
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            reqCount.put(c, 1 + reqCount.getOrDefault(c, 0));
        }

        // populating window hash map
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            window.put(c, 0);
        }

        // setting up the conditional variables
        int current = 0;
        int required = reqCount.size();

        // setting up a variable containing the result's starting and ending point
        // with default values and a length variable
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        // setting up the sliding window pointers
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // if the current character also occurs in t, update its frequency in window hash map
            if (t.indexOf(c) != -1) {
                window.put(c, 1 + window.getOrDefault(c, 0));
            }

            // updating the current variable
            if (reqCount.containsKey(c) && window.get(c).equals(reqCount.get(c))) {
                current += 1;
            }
            // while adjusting sliding
            while (current == required) {
                // update result
                if ((right - left + 1) < resLen) {
                    res[0] = left;
                    res[1] = right;
                    resLen = right - left + 1;
                }
                // pop from left
                char leftChar = s.charAt(left);
                if (t.indexOf(leftChar) != -1) {
                    window.put(leftChar, window.get(leftChar) - 1);
                }

                // if the popped character was among the required characters and
                // removing it has reduced its frequency below its frequency in t, decrement current
                if (reqCount.containsKey(leftChar) && window.get(leftChar) < reqCount.get(leftChar)) {
                    current -= 1;
                }
                left += 1;                
            }

        }
        // return the minimum window substring
        int leftIndex = res[0];
        int rightIndex = res[1];
        return resLen != Integer.MAX_VALUE ? s.substring(leftIndex, rightIndex + 1) : "";

    }

    // Driver code
    public static void main(String[] args) {
        String[] s = {"PATTERN", "LIFE", "ABRACADABRA", "STRIKER", "DFFDFDFVD"};
        String[] t = {"TN", "I", "ABC", "RK", "VDD"};
        for (int i = 0; i < s.length; i++) {
            System.out.println((i + 1) + ".\ts: " + s[i] + "\n\tt: " + t[i] + "\n\tThe minimum substring containing " + t[i] + " is: " + minWindow(s[i], t[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}