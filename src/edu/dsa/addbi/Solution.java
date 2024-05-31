package edu.dsa.addbi;

public class Solution {
    public static String addBinary(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        int ptr1 = str1.length() - 1;
        int ptr2 = str2.length() - 1;

        while (ptr1 >= 0 || ptr2 >= 0) {
            int digit1 = (ptr1 >= 0) ? Character.getNumericValue(str1.charAt(ptr1)) : 0;
            int digit2 = (ptr2 >= 0) ? Character.getNumericValue(str2.charAt(ptr2)) : 0;

            int totalSum = digit1 + digit2 + carry;
            int currentDigit = totalSum % 2;
            carry = totalSum / 2;
            result.append(currentDigit);
            ptr1--;
            ptr2--;
        }

        if (carry != 0) {
            result.append(carry);
        }
        
        result.reverse();

        return result.toString();
    }
    public static void main(String[] args) {
        String[] str1List = {"1100", "1010100", "10101", "1111", "10101100110010101"};
        String[] str2List = {"0011", "0100011", "01010", "11111", "1011001010110010100"};

        for (int i = 0; i < str1List.length; i++) {
            System.out.println((i + 1) + ".\tFirst input string:  " + str1List[i]);
            System.out.println("\tSecond input string: " + str2List[i]);
            System.out.println("\tBinary Sum:          " + addBinary(str1List[i], str2List[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }   
}
