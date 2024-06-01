package edu.dsa.twop;

import java.util.Arrays;

public class ArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        Arrays.fill(res, 1);

        int leftProduct = 1, rightProduct = 1;
        int l = 0, r = n - 1;

        while (l < n && r > -1) {
            res[l] *= leftProduct;
            res[r] *= rightProduct;
            
            
            leftProduct *= nums[l];
            rightProduct *= nums[r];
            System.out.println( "l "+ l + " r "+ r + " LP "+ leftProduct +" RP "+ rightProduct);
            System.out.println(Arrays.toString(res));
            System.out.println("+++++++++++++++++++++++");
            l++;
            r--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] inputList = {
            {1, 5, 10},
            {3, 5, 0, -3, 1},
            {7, 8, 9, 10, 11},
            {2, -4, -8, -11, 11},
            {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 3, 4, 5}
        };

        for (int i = 0; i < inputList.length; i++) {
            System.out.print((i + 1) + ".\tnums: " + Arrays.toString(inputList[i]) +
                                       "\n\tres: " + Arrays.toString(productExceptSelf(inputList[i])) + "\n");
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    
    }
}
