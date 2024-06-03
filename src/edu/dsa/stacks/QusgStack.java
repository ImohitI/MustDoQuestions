package edu.dsa.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QusgStack {
    public static void main(String[] args) {
        List<List<List<String>>> inputQueues = new ArrayList<>();

        // Input Queue 1
        List<List<String>> queue1 = new ArrayList<>();
        queue1.add(new ArrayList<>(Arrays.asList("9", "3", "1", "", "", "")));
        queue1.add(new ArrayList<>(Arrays.asList("push", "push", "push", "pop", "peek", "empty")));
        inputQueues.add(queue1);

        // Input Queue 2
        List<List<String>> queue2 = new ArrayList<>();
        queue2.add(new ArrayList<>(Arrays.asList("10", "6", "", "", "")));
        queue2.add(new ArrayList<>(Arrays.asList("push", "push", "pop", "empty", "peek")));
        inputQueues.add(queue2);

        // Input Queue 3
        List<List<String>> queue3 = new ArrayList<>();
        queue3.add(new ArrayList<>(Arrays.asList("1", "2", "3", "", "", "", "", "")));
        queue3.add(new ArrayList<>(Arrays.asList("push", "push", "push", "peek", "pop", "pop", "pop", "empty")));
        inputQueues.add(queue3);

        // Input Queue 4
        List<List<String>> queue4 = new ArrayList<>();
        queue4.add(new ArrayList<>(Arrays.asList("14", "", "66", "")));
        queue4.add(new ArrayList<>(Arrays.asList("push", "pop", "push", "pop")));
        inputQueues.add(queue4);

        // Input Queue 5
        List<List<String>> queue5 = new ArrayList<>();
        queue5.add(new ArrayList<>(Arrays.asList("4", "")));
        queue5.add(new ArrayList<>(Arrays.asList("push", "peek")));
        inputQueues.add(queue5);

        for (int i = 0; i < inputQueues.size(); i++) {
            System.out.println((i + 1) + ".\t Starting operations:");

            // Initialize a queue
            MyQueue queueObj = new MyQueue();

            // Loop over all the commands
            for (int j = 0; j < inputQueues.get(i).get(1).size(); j++) {
                if (inputQueues.get(i).get(1).get(j).equals("push")) {
                    String inputStr = inputQueues.get(i).get(1).get(j) + "(" + inputQueues.get(i).get(0).get(j) + ")";
                    System.out.println("\t\t" + inputStr);
                    queueObj.push(Integer.parseInt(inputQueues.get(i).get(0).get(j)));
                } else if (inputQueues.get(i).get(1).get(j).equals("pop")) {
                    String inputStr = inputQueues.get(i).get(1).get(j) + "(" + inputQueues.get(i).get(0).get(j) + ")";
                    System.out.println("\t\t" + inputStr + "   returns " + queueObj.pop());
                } else if (inputQueues.get(i).get(1).get(j).equals("empty")) {
                    String inputStr = inputQueues.get(i).get(1).get(j) + "(" + inputQueues.get(i).get(0).get(j) + ")";
                    System.out.println("\t\t" + inputStr + " returns " + (queueObj.empty() ? "true" : "false"));
                } else if (inputQueues.get(i).get(1).get(j).equals("peek")) {
                    String inputStr = inputQueues.get(i).get(1).get(j) + "(" + inputQueues.get(i).get(0).get(j) + ")";
                    System.out.println("\t\t" + inputStr + "  returns " + queueObj.peek());
                }
            }

            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}

class MyQueue {
    private Stack stack1;
    private Stack stack2;

    // constructor to initialize two stacks
    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(x);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.top();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
class Stack {
    private List<Integer> stackList;

    public Stack() {
        stackList = new ArrayList<>();
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return stackList.get(stackList.size() - 1);
    }

    public int size() {
        return stackList.size();
    }

    public void push(int value) {
        stackList.add(value);
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int topValue = stackList.get(stackList.size() - 1);
        stackList.remove(stackList.size() - 1);
        return topValue;
    }
}