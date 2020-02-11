package com.interviewprep.arrayQuestions;

public class MaximumArithmeticSEQ {

    public static void main(String[] args) {
        int[]arr={2,5,3,6,9,12,15,34,23};
        //int[]arr={9, 4, 7, 2, 10};
        int answer =findMaxArithmeticSeq(arr);
        System.out.println(">> "+answer);
    }


    static int findMaxArithmeticSeq(int[] arr){

        int maxCount =0;
        int count =0;
        int difference = 0;

        if(arr.length<=2){
            return arr.length;
        }else{
            if(arr[0]<arr[1]){
                difference = arr[1]-arr[0];
            }else if(arr[0]> arr[1]){
                difference = arr[1]-arr[0];
            }
            maxCount= 2;
            count =2;
        }

        for(int i=2; i< arr.length; i++) {

            if (arr[i - 1] < arr[i]) {

                if (difference == (arr[i] - arr[i - 1])) {
                    count = count + 1;
                } else {
                    count = 2;
                    difference = (arr[i] - arr[i - 1]);
                }

                maxCount = Math.max(count, maxCount);

            }
        }
        return maxCount;
    }

    //longest increasing or desreasing subarray length
    static int findMaxIncDecSeq(int[] arr){

        int maxCount =0;
        int count =0;
        boolean ascending = true;

        if(arr.length<=2){
            return arr.length;
        }else{
            if(arr[0]<arr[1]){
                ascending = true;
            }else if(arr[0]> arr[1]){
                ascending = false;
            }
            maxCount= 2;
            count =2;
        }

        for(int i=2; i< arr.length; i++){

            if(arr[i-1]<arr[i]){

                if(ascending) {
                    count = count+1;
                }else{
                    count = 2;
                    ascending = true;
                }

            }else{

                if(!ascending){
                    count = count+1;
                }else{
                    count = 2;
                    ascending = false;
                }
            }
            maxCount= Math.max(count, maxCount);

        }
        return maxCount;
    }
}
