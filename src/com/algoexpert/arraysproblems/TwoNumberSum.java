package com.algoexpert.arraysproblems;

import java.util.Hashtable;

public class TwoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        //Solution1
/*        int[] answer =new int[2];
        for(int i=0;i<array.length;i++){
            for(int j=1;j<array.length;j++){
                // System.out.println(" "+i+" "+j);
                if(i!=j && ((array[i]+array[j])==targetSum)){
                    answer[0]=array[i];
                    answer[1]=array[j];
                    return answer;
                    // break;
                }
            }
        }*/

   /*
   //Solution 2
   Arrays.sort(array);
        for(int h :array){
            System.out.print(h+" ");
        }
        boolean breakLoop = false;
        int mid=0;
        int[] arr = new int[2];
        for(int i=0; i<array.length;i++){
            System.out.println("searching for index "+i);
            int x = targetSum-array[i];
            int start = i;
            int end = array.length-1;

            breakLoop=false;
            while(end>=start && !breakLoop){
                mid = (start+ (end-start)/2);
                System.out.println(" start "+start+" end "+end+" mid "+mid);
                if(array[mid]==x){
                    System.out.println("found it");
                    breakLoop= true;
                }else if(array[mid]>x){
                    System.out.println("decreasing end");
                    end = mid-1;
                }else{
                    System.out.println("increasing start");
                    start = mid+1;
                }
            }

            if(breakLoop){
                arr[0]=array[i];
                arr[1]=array[mid];

                return arr;
            }
        }

        int[] ans={};
        return ans;
*/

   //Solution 3
        /*        Arrays.sort(array);
         *//*        for(int h :array){
            System.out.print(h+" ");
        }*//*
       // System.out.println();
        int[] arr = new int[2];
        int l =0 ;
        int h = array.length -1;

        while(l<h){
           // System.out.println(" i "+i+" L "+l+" H "+h);
            if(array[h]== (targetSum-array[l])){
                arr[0]=array[l];
                arr[1]=array[h];
                return arr;
            }else if(array[h]>(targetSum-array[l])){
                h--;
            }else if(array[h]<(targetSum-array[l])){
                l++;
            }
        }
        int[] ans={};
        return ans;*/

        // int[] arr = new int[2];

        //Solution 4
        Hashtable<Integer, Boolean> htable = new Hashtable<>();
        int i = 0;
        while (i < array.length) {
            if (htable.containsKey(targetSum - array[i])) {

                return new int[]{array[i], targetSum - array[i]};
            } else {
                htable.put(array[i], true);
            }
            i++;
        }
        //int[] ans={};
        return new int[0];

    }
}
