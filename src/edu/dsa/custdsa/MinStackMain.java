package edu.dsa.custdsa;

import java.util.*;

class MinStack {
	int maxSize;
	static MainStack<Integer> mainStack;

	MainStack<Integer> minStack;

	// constructor
	public MinStack() {
		this.maxSize = 1000;
		mainStack = new MainStack<>(maxSize);
		minStack = new MainStack<>(maxSize);
	}

	// Pop() removes and returns value from minStack
	public int pop() {
		minStack.pop();
		// Returns the popped value from mainStack
		return mainStack.pop();
	}

	// Pushes values into minStack
	public void push(Integer value) {
		mainStack.push(value);
		// If the minStack is empty, or the value being pushed is less than
		// the minimum (top) value of minStack
		if (!minStack.isEmpty() && minStack.top()<value) {
			minStack.push(minStack.top());
		} else {
			// Push this new value to the minStack
			minStack.push(value);
		}
	}

	// returns minimum value in O(1)
	public int minNumber() {
		return minStack.top();
	}

	public static void main(String args[]) {
		int[][][] inputStacks = {
			{
				{9, 3, 1, 4, 2, 5}, 
                {1, 1, 0, 1, 0, 1}
			}, 
            {
				{5, 10, 6, 23, 2},
                {1, 1, 0, 1, 0}
			}, 
            {
				{1, 2, 3, 4, 5, 6, -3, -8}, 
                {0, 1, 0, 1, 0, 1, 1, 0}
			}, 
            {
				{14, 32, 66, 71, 22, 50, 35}, 
                {1, 0, 1, 1, 0, 1, 0}
			}, 
            {
				{-2, 4, 5, 0, 1, -3}, 
                {1, 1, 1, 1, 1, 1}
			}
		};

		for (int i = 0; i<inputStacks.length; i++) {
			System.out.println((i + 1) + ".\tStarting operation:");
			MinStack stack = new MinStack();
			for (int j = 0; j<inputStacks[i][1].length; j++) {
				// 1 denotes push, 0 denotes pop
				if (inputStacks[i][1][j] == 1) {
					if (inputStacks[i][0] == null) {
						continue;
					} else {
						System.out.println("\t\t Push(" + inputStacks[i][0][j] + ")");
						stack.push(inputStacks[i][0][j]);
					}
				}

				if (inputStacks[i][1][j] == 0) {
					if (!mainStack.isEmpty())
						System.out.println("\t\t Pop() returns " + stack.pop());
				}
			}

			System.out.println("\t Minimum number in the stack is: " +
				stack.minNumber());
			System.out.println(new String(new char[100]).replace('\0', '-'));
		}
	}
}