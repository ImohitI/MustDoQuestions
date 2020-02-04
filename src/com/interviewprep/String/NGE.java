package com.interviewprep.String;

import java.util.Stack;

public class NGE
{
    static class stack
    {
        int top;
        int items[] = new int[100];

        // Stack functions to be used by printNGE
        void push(int x)
        {
            if (top == 99)
            {
                System.out.println("Stack full");
            }
            else
            {
                items[++top] = x;
            }
        }

        int pop()
        {
            if (top == -1)
            {
                System.out.println("Underflow error");
                return -1;
            }
            else
            {
                int element = items[top];
                top--;
                return element;
            }
        }

        boolean isEmpty()
        {
            return (top == -1) ? true : false;
        }
    }

    /* prints element and NGE pair for
       all elements of arr[] of size n */
    static void printNGE(int arr[], int n)
    {
        int i = 0;
        stack s = new stack();
        s.top = -1;
        int element, next;

        /* push the first element to stack */
        s.push(arr[0]);

        // iterate for rest of the elements
        for (i = 1; i < n; i++)
        {
            next = arr[i];

            if (s.isEmpty() == false)
            {

                // if stack is not empty, then
                // pop an element from stack
                element = s.pop();

                /* If the popped element is smaller than
                   next, then a) print the pair b) keep
                   popping while elements are smaller and
                   stack is not empty */
                while (element < next)
                {
                    System.out.println(element + " --> " + next);
                    if (s.isEmpty() == true)
                        break;
                    element = s.pop();
                }

                /* If element is greater than next, then
                   push the element back */
                if (element > next)
                    s.push(element);
            }

            /* push next to stack so that we can find next
               greater for it */
            s.push(next);
        }

        /* After iterating over the loop, the remaining
           elements in stack do not have the next greater
           element, so print -1 for them */
        while (s.isEmpty() == false)
        {
            element = s.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }
    }

    static void printNGE2(int arr[], int n)
    {
        Stack<Integer> s = new Stack<Integer>();

        int arr1[] = new int[n];

        // iterating from n-1 to 0
        for (int i = n - 1; i >= 0; i--)
        {
            System.out.println("process starts for index "+i);
        /*We will pop till we get the
        greater element on top or stack gets empty*/
            while (!s.isEmpty() && s.peek() <= arr[i]) {
                System.out.print("[]-");
                s.pop();
            }
            System.out.println();
        /*if stack gots empty means there
        is no element on right which is greater
        than the current element.
        if not empty then the next greater
        element is on top of stack*/
            if (s.empty())
                arr1[i] = -1;
            else
                arr1[i] = s.peek();

            s.push(arr[i]);
        }

        for (int i = 0; i < n; i++)
            System.out.println(arr[i] + " ---> " + arr1[i]);
    }


    public static void main(String[] args)
    {
        int[] arr2 = {70, 60, 58,53,45,40,39,32,24};
        int arr[] = {30, 34, 31,21,20,32,44,99,45};
        int n = arr.length;
        printNGE2(arr, n);
        System.out.println("---------------------------------");
        printNGE2(arr2,arr2.length);
    }
}