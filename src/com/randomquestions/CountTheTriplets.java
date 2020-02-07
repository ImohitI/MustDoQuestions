package com.randomquestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountTheTriplets {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        int[] solutions = new int[cases];
        for(int i =0; i<cases;i++){

            int n = scanner.nextInt();
            int[] arr = new int[n];

            for(int j = 0 ; j < n; j++){
                arr[j] = scanner.nextInt();
            }
            System.out.println(">> "+arr.length);
           solutions[i]= findTripletsCount(arr);
        }

        for(int l=0; l<solutions.length;l++){
            System.out.println(solutions[l]);
        }

    }
    public static int findTripletsCount(int[] arr){
        Map< Integer,Integer> map =
                new HashMap< Integer,Integer>();
        for(int m = 0;m < arr.length ; m++){
            map.put(arr[m],m);
        }
        int count = 0;
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                if(map.containsKey(arr[i]+arr[j]))
                    count++;
            }
        }

        return count>0 ? count:-1;
    }
}
