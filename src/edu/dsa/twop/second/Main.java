package edu.dsa.twop.second;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome("RACECAR"));

        int[] colors = {2, 1, 1, 0, 1, 0, 2};
        int[] sorted = sortColors(colors);

        for (int i : sorted) {
            System.out.print(i+ ", ");
        }
        System.out.println();

        String stringToReverse = "a   string   with   multiple   spaces";
        System.out.println(reverseWords(stringToReverse));

        String num = "609";
        System.out.println(isStrobogrammatic(num));

        String moveplaindrome = "eggeekgbbeg";
        System.out.println(minMovesPalindrome(moveplaindrome));

        System.out.println(minMovesPalindrome2(moveplaindrome));

        System.out.println(minMovesPalindrome3(moveplaindrome));


        // System.out.println("-------");
        // int ii = 3;
        // int aa = ii++;
        // System.out.println(aa + " "+ ii);
        // int bb = ++ii;
        // System.out.println(bb + " "+ ii);
        // System.out.println("-------");

    }

    public static boolean isPalindrome(String s) {

        if (s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(right) != s.charAt(left)) {
                return false;
            }
            left = left + 1;
            right = right - 1; 
        }

        return true;
    }

    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        int low, high, triples;

        for (int i = 0; i < nums.length - 2; i++) {
            low  = i + 1;
            high = nums.length - 1;

            while (low < high) {
                triples = nums[i] + nums[low] + nums[high];

                if (triples == target) {
                    return true;
                } else if (triples < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return false;
    }

    public static int[] sortColors(int[] colors) {

        int start = 0, current = 0, end = colors.length - 1;

        while (current <= end) {

            if (colors[current] == 0) {
                int temp = colors[start];
                colors[start] = colors[current];
                colors[current] = temp;

                current++;
                start++;
            } else if (colors[current] == 1) {
                current++;
            } else {
                int temp = colors[current];
                colors[current] = colors[end];
                colors[end] = temp;

                end--;
            }

        }

        return colors;
    }

    // A function that reverses characters from startRev to endRev in place
    private static void strRev(char[] str, int startRev, int endRev) {
        while (startRev < endRev) {
            char temp = str[startRev];
            str[startRev] = str[endRev];
            str[endRev] = temp;
            startRev++;
            endRev--;
        }
    }
    public static String reverseWords(String sentence) {
        sentence = sentence.replaceAll("\\s+", " ").trim();

        char[] charArray = sentence.toCharArray();
        int strLen = charArray.length - 1;

        strRev(charArray, 0, strLen);

        for (int start = 0, end = 0; end <= strLen; end++) {
            if (end == strLen || charArray[end] == ' ') {
                int endIdx = (end == strLen) ? end : end - 1;
                strRev(charArray, start, endIdx);
                start = end + 1;
            }
        }
        return new String(charArray);
    }

    public static boolean validWordAbbreviation(String word, String abbr) {

        int wordIndex = 0, abbrIndex = 0;

        while (abbrIndex < abbr.length()) {
            if (Character.isDigit(abbr.charAt(abbrIndex))) {
                if (abbr.charAt(abbrIndex) == '0') {
                    return false;
                }
                int num = 0;
                while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    num = num * 10 + (abbr.charAt(abbrIndex) - '0');
                    abbrIndex++;
                }

                wordIndex += num;
            } else {
                if (wordIndex >= word.length() || word.charAt(wordIndex) != abbr.charAt(abbrIndex)) {
                    return false;
                }

                wordIndex++;
                abbrIndex++;
            }

        }

        return wordIndex == word.length() && abbrIndex == abbr.length();
    }

    public static boolean isStrobogrammatic(String num) {
        Map<Character, Character> dict = new HashMap<>();
        dict.put('0', '0');
        dict.put('1', '1');
        dict.put('8', '8');
        dict.put('6', '9');
        dict.put('9', '6');

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            if (!dict.containsKey(num.charAt(left)) 
            || dict.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static int minMovesPalindrome(String s) {
        char[] chars = s.toCharArray();

        int moves = 0;

        // find a char from right s[j] that
        // matches a character from left s[i]
        for (int i = 0, j = chars.length - 1; i < j; i++) {
            int k = j;
            for(; k > i; --k) {
                // if a match is found
                if (chars[i] == chars[k]) {
                    // move the match to correct position
                    for(; k < j; ++k) {
                    char temp = chars[k];
                    chars[k] = chars[k + 1];
                    chars[k + 1] = temp;
                    ++moves;
                    }
                    --j;
                    break;
                }
            }
            if (k == i) {
                moves += chars.length / 2 - i;
            }
        }


        return moves;
    }

    public static int minMovesPalindrome2(String s) {
        int moves = 0;

        char[] arr = s.toCharArray();
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            int left = i;
            int right = n - i - 1;

            while (left < right && arr[left] != arr[right]) {
                right--;
            }
            if (left == right) {
                // handle case for odd length where one char to be moved to center
                swap(arr, left, left + 1);
                moves++;
                i--;
            } else {
                for (int j = right; j < n - i - 1; j++) {
                    swap(arr, j, j + 1);
                    moves++;
                }
            }
        }

        return moves;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int minMovesPalindrome3(String str) {
        int n = str.length();
        char[] s = str.toCharArray();
        int lt = 0, rt = n - 1, moves = 0;

        while (lt < rt) {
            int l = lt, r = rt;
            while (s[l] != s[r]) {
                r--;
            }
            if (l == r) {
                swap(s, r, r + 1);
                moves++;
                continue;

            } else {
                while (r < rt) {
                    swap(s, r, r + 1);
                    moves++;
                    r++;
                }
            }
            lt++;
            rt--;

        }

        return moves;
    }
}
