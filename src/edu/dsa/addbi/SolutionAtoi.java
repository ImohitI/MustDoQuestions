package edu.dsa.addbi;

public class SolutionAtoi {
    public static int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        int i = 0;

        //ignore any leading whitespaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        //check for sign
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            //set sign to negative if a minus sign is found
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            //then move to the next character
            i++;
        }

        // read the digits
        while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
            //convert the current character to an integer
            int digit = s.charAt(i) - '0';

            //check for overflow same expression result* 10 + digit = newresult
            if (result > (Integer.MAX_VALUE - digit) / 10) { 
                // if there is an overflow, return the max or min 32 digit integer value
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // update the result by multiplying it by 10 and add current digit
            result = result * 10 + digit;

            //move to next character
            i++;
        }
        // return final result, adjusted with sign
        return sign * result;

    }
    public static void main(String[] args) {
        String[] inputStrings = {"25", "   -25", "999 with words", "words and 567", "-91283472332", "91283472332"};

        for (int i = 0; i < inputStrings.length; i++) {
            System.out.println((i + 1) + ".\tInput string     : \"" + inputStrings[i] + "\"");
            int stoi = myAtoi(inputStrings[i]);
            System.out.println("\tConverted integer: " + stoi);
            System.out.println("-------------------------------------------------------");
        }
    }   
}
