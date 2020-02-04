package com.company;

public class SmallestSubArrayWithSum {
    public static void main(String[] args) {

        int[] arr = {1,2,1,1,1,1,4, 3 ,1,1};
        smallestSubArray(arr, 5);
    }
    public static void smallestSubArray(int[] array, int sum){

        int currSum = array[0] ;
        int start = 0;
        int end =-1;
        int min =Integer.MAX_VALUE;

        for(int i=1;i<array.length;i++){
            currSum += array[i];

            while(currSum>sum && start <=i){
                currSum -= array[start++];
            }

            if(currSum == sum){
                end = i;
                if(end-start<min) {
                    min = end - start +1;
                    System.out.println("min "+min+ "start "+start+" end "+end);
                    end = -1;
                }
            }
            System.out.println("currSum "+currSum);

        }
        System.out.println( ">>> min "+min);

    }
}
