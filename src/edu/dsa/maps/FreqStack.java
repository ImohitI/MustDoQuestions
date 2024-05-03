package edu.dsa.maps;

import java.util.*;

public // Declare a FreqStack class containing frequency and group hashmaps
// and maxFrequency integer
class FreqStack {
    Map<Integer, Integer> frequency;
    Map<Integer, Stack<Integer>> group;
    int maxFrequency;

    // Use constructor to initialize the FreqStack object
    public FreqStack() {
        frequency = new HashMap<>();
        group = new HashMap<>();
        maxFrequency = 0;
    }

    // Use push function to push the value into the FreqStack
    public void push(int value) {
        int freq = frequency.getOrDefault(value, 0) + 1;
        frequency.put(value, freq);

        if (freq > maxFrequency)
            maxFrequency = freq;

        group.computeIfAbsent(freq, z -> new Stack<>()).push(value);
    }

    // Use the pop function to pop the showName from the FreqStack
    public int pop() {
        int show = 0;
        if (maxFrequency > 0) {
            show = group.get(maxFrequency).pop();
            frequency.put(show, frequency.get(show) - 1);

            if (group.get(maxFrequency).size() == 0)
                maxFrequency--;
        } else {
            return -1;
        }
        return show;
    }
}

// Driver code
class Solution {
    public static void main(String[] args) {
        int[] inputs = { 5, 7, 7, 7, 7, 4, 5, 3 };
        FreqStack obj = new FreqStack();
        for (int i = 0; i < inputs.length; i++) {
            obj.push(inputs[i]);
        }

        System.out.println("\tInput Stack: " + Arrays.toString(inputs) + "\n");

        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tPopping out the most frequent value...");
            System.out.println("\tValue removed from stack is: " + obj.pop());
            System.out.println(" ");
        }
    }
}