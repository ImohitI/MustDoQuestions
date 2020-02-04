package com.interviewprep.String;

public class HopToBig {
    public static void main(String[] args) {
        int[] arr = {30, 34, 31,21,20,32,44,99,45};
       // int[] arr = {70, 60, 58,53,45,40,39,32,24};
        int min = 20;
        int max = 100;

        System.out.println(">> "+hopToBig(arr,min,max));
        int[] sol = hopToBig(arr,min,max);
        for(int i=0;i< sol.length;i++){
            System.out.print(sol[i]+"|");
        }

    }
    public static int[] hopToBig(int[] arr, int min, int max){

        int[] solution = new int[arr.length];

        int count;
        int k ;
        for(int i=0; i<arr.length;i++){
            k=i+1;
            count=0;

            if(i == arr.length-1) {
                solution[i] = 0;
                continue;
            }

            if(arr[i]==min && i<arr.length-1) {
                solution[i] = 1;
                continue;
            }

            if(arr[i]<arr[k]) {
                solution[i] = 1;
                continue;
            }

            while(k<arr.length && arr[i] < max && arr[i] > arr[k] ){
                count++;
                k++;
            }

            System.out.println("::k "+k);
            if(k==arr.length ){
                solution[i] = 0;
            }else {
                solution[i] = count + 1;
            }

        }
        return solution;
    }

}
