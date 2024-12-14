package edu.dsa.greedytech;

import java.util.*;

public class BInarytoone {
    public static int numSteps(String str) {
        int length = str.length();
        int steps = 0;
        int c = 0;

        for (int i = length - 1; i > 0; --i) {     
            int digit = (str.charAt(i) - '0') + c;
            
            if (digit % 2 == 1) {
                
                steps += 2;
                
                c = 1;
            } 
            else {
                
                steps += 1;
            }
        }
        
        return steps + c;
    }
    
    public static void main(String[] args) {
                List<String> strings = Arrays.asList(
            "1011",
            "111",
            "100",
            "1",
            "10"
        );

        for (int i = 0; i < strings.size(); ++i) {
            System.out.println((i + 1) + ".\tstr: " + strings.get(i));
            System.out.println();
            System.out.println("\tsteps: " + numSteps(strings.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}
