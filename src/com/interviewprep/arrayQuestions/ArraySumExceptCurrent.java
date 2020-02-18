package com.interviewprep.arrayQuestions;

public class ArraySumExceptCurrent {

    public static void main(String[] args) {
        int[]arr={3,1,4,5,3,4,12,3};
        int[]result=new int[arr.length];
        int i=0;
        int sum=0;
        while(i < arr.length){
            int temp=arr[i];
            result[i++]=sum;
            sum+=temp;
        }
        for(int j=0; j < result.length; ++j){
            System.out.print(result[j]+", ");
        }
        System.out.println();
        i--;
        sum=0;
        while(i>=0){
            int temp=arr[i];
            result[i--]+=sum;
            sum+=temp;
        }

        for(int j=0; j < result.length; ++j){
            System.out.print(result[j]+", ");
        }
    }
}
