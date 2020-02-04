package com.company;

import java.util.HashMap;

public class SubArrayCountWithSum {
    public static void main(String[] args) {
        int[] arr = {5,0,2,2,1,4};
        subArrayCountSum(arr,5);
    }
    public static int subArrayCountSum(int[] nums, int k){

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count=0;
        int sum=0;
        hashMap.put(0,1);
        for(int i=0; i<nums.length;i++){
            sum+= nums[i];
            System.out.println("sum is "+sum+" sum -k is "+(sum-k));
            if(hashMap.containsKey(sum-k)){
                System.out.println("count"+count);
                count+= hashMap.get(sum-k);
            }
            hashMap.put(sum,hashMap.getOrDefault(sum,0)+1);
        }
        System.out.println("Count is "+count);
        return count;

        /*
sum is 1 sum -k is -4
sum is 3 sum -k is -2
sum is 5 sum -k is 0
count0
sum is 7 sum -k is 2
sum is 8 sum -k is 3
count1
sum is 12 sum -k is 7
count2
Count is 3



sum is 1 sum -k is -4
sum is 3 sum -k is -2
sum is 5 sum -k is 0
sum is 7 sum -k is 2
sum is 8 sum -k is 3
count0
sum is 12 sum -k is 7
count1
Count is 2
         */
    }
}
