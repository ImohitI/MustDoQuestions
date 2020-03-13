package com.algoexpert.arraysproblems;

import java.util.Arrays;

public class SmallestAbsoluteDiff {
    public static void main(String[] arg) {
        int[] arr1 = {0, 10, 20, 25, 2200};//{-1 , 3 , 5, 10, 20};
        int[] arr2 = {1005, 1006, 1014, 1031, 1032};//{15, 17 , 26 , 134, 135};

        int[] ans = smallestAbsDiff(arr1, arr2);

        for (int x : ans) {
            System.out.println(" " + x);
        }
    }

    public static int[] smallestAbsDiff(int[] arr1, int[] arr2) {

        int l = 0;
        int r = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int min = Integer.MAX_VALUE;
        int[] arr = new int[2];

        while (l < arr1.length && r < arr2.length) {
            System.out.println(" arr1[l] >>  " + arr1[l] + " arr2[r] >> " + arr2[r] + " min " + min);
            int newMin = Math.abs(arr1[l] - arr2[r]);

            if (newMin < min) {
                System.out.println("new min is awesome");
                arr[0] = arr1[l];
                arr[1] = arr2[r];
                min = newMin;
            }

            if (arr1[l] < arr2[r]) {
                System.out.println("increasing left array pointer ");
                l++;
            } else if (arr1[l] > arr2[r]) {
                System.out.println("increasing right array pointer");
                r++;
            }else{
                System.out.println("both equal so");
                break;
            }
            System.out.println("l " + l + " r " + r);
        }

        return arr;
    }
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo){
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int indexOne =0;
        int indexTwo =0;

        int smallest = Integer.MAX_VALUE;
        int current = Integer.MAX_VALUE;

        int[] smallestPair = new int[2];

        while(indexOne< arrayOne.length && indexTwo < arrayTwo.length){
            int firstNum = arrayOne[indexOne];
            int secondNum = arrayTwo[indexTwo];
            if(firstNum < secondNum){
                current = secondNum - firstNum;
                indexOne++;
            }else if(secondNum < firstNum){
                current = firstNum - secondNum;
                indexTwo++;
            }else{
                return new int[]{firstNum, secondNum};
            }
            if(smallest > current){
                smallest = current;
                smallestPair = new int[]{firstNum, secondNum};
            }
        }
        return smallestPair;

    }




}


























