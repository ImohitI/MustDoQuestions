package com.company;

import java.util.ArrayList;
import java.util.List;

public class MaxSumofSubArray {
    public static void main(String[] args) {

        //int[] arr = {4, -1, 6, -100, 5};

        int[] arr = {-1, 2, -3, 4, 5};

        int count = maxSumSubArray(arr);
        int answer = maxSumSubArray(arr, 0, arr.length-1, count);
        int answer2 = maxSubArrayLinearSol(arr);
        System.out.println("Max sum "+answer+" linear sol ans "+answer2);

    }
    public static int maxSumSubArray(int[] arrsdfsfsfsfs){
        int count = 0;
        //Find out sum of all numbers
        for(int i=0; i< arrsdfsfsfsfs.length;i++){
            count+= arrsdfsfsfsfs[i];
        }
        return count;


    }

    public static int maxSumSubArray(int[] arr , int left , int right , int count){
        if(left >= right){
            return  count;
        }

        //Get value without the last element
        int withOutFirst = maxSumSubArray(arr, left +1 ,right , count-arr[left]);

        //Get value without the last element
        int withOutLast = maxSumSubArray(arr, left , right-1, count-arr[right]);

        //Return the max between sum and the two previously computed values
        return Math.max(count, Math.max(withOutFirst, withOutLast));
    }

    public static int maxSubArrayLinearSol(int[] arr){
        int max = Integer.MIN_VALUE;

        int sum = 0;

        for(int i=0; i<arr.length;i++){
            sum+= arr[i];

            if(sum> max){
                max = sum;
            }

            if(sum<0){
                sum = 0;
            }
        }
        return sum;
    }

}
