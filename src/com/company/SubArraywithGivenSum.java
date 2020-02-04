package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

        Input:
        The first line of input contains an integer T denoting the number of test cases.
        Then T test cases follow. Each test case consists of two lines.
        The first line of each test case is N and S, where N is the size of array and S is the sum.
        The second line of each test case contains N space separated integers denoting the array elements.

        Output:
        For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

        Constraints:
        1 <= T <= 100
        1 <= N <= 107
        1 <= Ai <= 1010

        Example:
        Input:
        2
        5 12
        1 2 3 7 5
        10 15
        1 2 3 4 5 6 7 8 9 10
        Output:
        2 4
        1 5
*/
public class SubArraywithGivenSum {

    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);

        int noOfCases = scanner.nextInt();
        //scanner.nextLine();

      //  int[][] answer = new int[noOfCases][2];
        for(int k=0; k<noOfCases;k++){

            int length = scanner.nextInt();
            int sum = scanner.nextInt();

            int[] ls = new int[length];


            for(int l=0; l<length;l++){
                ls[l] = scanner.nextInt();
            }

            int currSum = ls[0] ;
            int start =0;
            int end =-1;

            for(int i=1;i<length;i++){
                currSum += ls[i];

                while(currSum>sum && start <=i){
                    currSum -= ls[start++];
                }

                if(currSum == sum){
                    end = i;
                   break;
                }

            }
            System.out.println( end == -1 ? -1 : (start + 1) + " " + (end + 1) );

        }

    }

}
