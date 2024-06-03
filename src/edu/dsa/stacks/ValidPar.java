package edu.dsa.stacks;

import java.util.HashMap;
import java.util.Stack;

public class ValidPar {
    

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashmap = new HashMap<>();
        hashmap.put(')', '(');
        hashmap.put('}', '{');
        hashmap.put(']', '[');

        for (char ch : s.toCharArray()) {
            if (!hashmap.containsKey(ch)) {
                stack.push(ch);
            } else {
                char poppedElement = (stack.isEmpty()) ? '*' : stack.pop();

                if (hashmap.get(ch) != poppedElement) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    // Driver code
    public static void main(String[] args) {
        String[] inputs = {")))(((","({[]})","(){}[]", "{}[]{}[{}])", "(){[{()}]}", "))){{}}}]]", "{[()}"};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ". Input string = " + inputs[i]);
            System.out.println("   Valid parentheses = " + isValid(inputs[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


}
