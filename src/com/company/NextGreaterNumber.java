package com.company;

import java.util.Stack;

public class NextGreaterNumber {

	public static void main(String[] arg) {

		int[] arr = { 34, 32, 41, 35, 31, 39, 78 };
		int[] arr1 = { 80, 79, 78, 77, 76, 75, 81 };
		int[] arr2 = { 80, 81, 82, 83, 84, 85, 86 };	
		int[] arr3 = { 80, 79, 78, 77, 76, 75, 81 };			
		
		int min = 30;
		int max = 100;
		
		int [] sol = nextGreaterNumber(arr3,30 , 100);
		
		for(int j =0 ; j<sol.length;j++){
			System.out.print(sol[j]+"|");
		}
	}


	public static int[] nextGreaterNumber(int[] arr, int min, int max) {
		
		int[] solution = new int[arr.length];

		Stack<MyInteger> stack = new Stack<MyInteger>();
		
		for (int i = arr.length - 1; i >= 0; i--) {


			while (!stack.isEmpty() && stack.peek().getNumber() <= arr[i]) {
				System.out.println("poping for "+ i + " element");
				stack.pop();
			}
			
			if(stack.isEmpty()){
				solution[i] = 0;
			}else{
				solution[i] = stack.peek().getIndex()-i;
			}
			
			
			MyInteger myInteger = new MyInteger(arr[i], i);

			stack.push(myInteger);
		}

		return solution;
	}
}

class MyInteger {
	int number;
	int index;

	public MyInteger(int number, int index) {
		this.number = number;
		this.index = index;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}