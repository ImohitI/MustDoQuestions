package edu.dsa.maps;

import java.util.*;

public class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        String result = "";
        HashMap<Integer, Integer> remainderMap = new HashMap<Integer, Integer>();
        System.out.println("\n\tnumerator: " + numerator);
        System.out.println("\tdenominator: " + denominator);

        // if numerator is 0, then return 0 in the string
        if (numerator == 0) {
            System.out.println("\tAs numerator is 0, so return 0.");
            return "0";
        }

        // If numerator or denominator is negative, then append "-" to the result
        if (numerator < 0 ^ denominator < 0) {
            System.out.println("\tAs numerator or denominator is negative. Appending - to the result");
            result += '-';
        }

        // Make numerator and denominator positive after adding "-" to the result
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        // Calculate the quotient
        int quotient = numerator / denominator;
        System.out.println("\n\tquotient: " + quotient);
        int remainder = (numerator % denominator) * 10;
        System.out.println("\tremainder: " + remainder);

        // Append the quotient part in the result
        result += Integer.toString(quotient);
        System.out.println("\tresult: " + result);

        if (remainder == 0)
            return result;
        else {
            System.out.println("\tAs remainder is not zero. Append . to the result.");
            // Append . before the right part
            result += ".";
            System.out.println("\tNow result is: " + result);

            // Right side of the decimal point
            while (remainder != 0) {
                System.out.println("\tremainder: " + remainder);

                // if digits are repeating, it means the remainder is already present in the
                // hashmap
                if (remainderMap.containsKey(remainder)) {
                    int beginning = remainderMap.get(remainder);
                    String left = result.substring(0, beginning);
                    String right = result.substring(beginning, result.length());
                    result = left + "(" + right + ")";
                    System.out.println("\n\tAs remainder " + remainder + " is in hashmap " + remainderMap
                            + "\n\tbeginning: " + beginning + "\tleft: " + left + "\tright: " + right + "\tresult: "
                            + result);
                    return result;
                } else {
                    // Otherwise put the remainder in the hashmap
                    System.out.println("\tPutting remainder in hashmap...");
                    remainderMap.put(remainder, result.length());
                    quotient = remainder / denominator;
                    result += String.valueOf(quotient);
                    remainder = (remainder % denominator) * 10;
                }
            }
            return result;
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] inputs = { { 0, 4 }, { 4, 2 }, { 5, 333 }, { 2, 3 }, { 47, 18 }, { 93, 7 }, { -5, 333 }, { 47, -18 },
                { -4, -2 } };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1 + ".\tInput: fraction_to_decimal(");
            for (int j = 0; j < inputs[i].length - 1; j++) {
                System.out.print(inputs[i][j]);
                System.out.print(", ");
            }
            System.out.println(inputs[i][inputs[i].length - 1] + ")");
            String result = fractionToDecimal(inputs[i][0], inputs[i][1]);
            System.out.println("\n\tOutput: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}