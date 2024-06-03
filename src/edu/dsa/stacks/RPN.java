package edu.dsa.stacks;

import java.util.Arrays;
import java.util.Stack;

public class RPN {
    //RPN every operator flows all its operands
    public static int rpn(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int number2 = stack.pop();
                int number1 = stack.pop();

                int result;
                if (token.equals("+")) {
                    result = number1 + number2;
                } else if (token.equals("-")) {
                    result = number1 - number2;
                } else if (token.equals("*")) {
                    result = number1 * number2;
                } else {  
                    result = number1 / number2;
                }

                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
      // Driver code
    public static void main(String[] args) {
        String[][] inputs = {
                {"2", "1", "+", "3", "*"},           // (2 + 1) * 3 = 9
                {"4", "13", "5", "/", "+"},          // 4 + (13 / 5) = 6
                {"10", "6", "9", "3", "/", "-", "*"},// (10 * (6 - (9 / 3))) = 30
                {"1", "1", "+", "2", "*"},           // (1 + 1) * 2 = 4
                {"3", "5", "8", "*", "+", "13", "-"} // (3 + (5 * 8)) - 13 = 30
        };

        for (int i = 0; i < inputs.length; ++i) {
            System.out.println(i + 1 + ". Input tokens = " + Arrays.toString(inputs[i])); 
            System.out.println("   Result = " + rpn(inputs[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }  
}
