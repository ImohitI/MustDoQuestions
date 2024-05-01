package edu.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Stacks {
    public static String removeAdjDups(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (!st.isEmpty() && st.peek() == str.charAt(i)) {
                st.pop();
            } else {
                st.push(str.charAt(i));
            }
        }

        StringBuilder s = new StringBuilder();
        for (Character c : st) {
            s.append(c);
        }
        return s.toString();
    }

    // Time complexity O n
    // space complexity O n
    public static String removeAdjDupsBetter(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    public static String minRemoveParentheses(String s) {

        Stack<int[]> stack = new Stack<>();
        char[] sArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);

            if (!stack.isEmpty() && stack.peek()[0] == '(' && val == ')') {
                stack.pop();
            } else if (val == '(' || val == ')') {
                stack.push(new int[] { val, i });
            }
        }

        while (!stack.isEmpty()) {
            sArray[stack.pop()[1]] = ' ';
        }

        StringBuilder result = new StringBuilder();
        for (char c : sArray) {
            if (c != ' ') {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // testadjdup();
        testrempar();
    }

    public static void testadjdup() {
        String[] inputs = {
                "g",
                "ggaabcdeb",
                "abbddaccaaabcd",
                "aannkwwwkkkwna",
                "abbabccblkklu"
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tRemove duplicates from string: '" + inputs[i] + "'");
            String resultingString = removeAdjDupsBetter(inputs[i]);
            System.out.println("\tString after removing duplicates: " + resultingString);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

    public static void testrempar() {
        List<String> inputs = Arrays.asList("ar)ab(abc)abd(", "a)rt)lm(ikgh)", "aq)xy())qf(a(ba)q)",
                "(aw))kk())(w(aa)(bv(wt)r)", "(qi)(kl)((y(yt))(r(q(g)s)");
        for (int i = 0; i < inputs.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ". Input: " + inputs.get(i));
            System.out.println("   Valid parentheses, after minimum removal: "
                    + minRemoveParentheses(inputs.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
