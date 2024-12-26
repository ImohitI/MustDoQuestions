package edu.dsa.dynamicprog;

import java.util.*;

/*
 * coin change , n no of coins and amount be target
 * determine the min no of coins required to make up a given amount
 * coins 1, 2, 5, amount 11 ---> output 3 --> 5 + 5 + 1
 * 
 * Recursive solution 
 * each recursion call reduces the amount by one of coin denominations
 * the recursion tree has O amount ^ n branches because for each amount , we try every coin
 * TC O n ^ amount
 * SC O amount --> depth of the recursion stack is proportional to the amount
 * 
 * Explanation
 * Try every coin denomination to see if it contributes to the solution
 * For each coin, subtract its value from the amount and recursively solve for the remaining amount
 * Keep track of the minimum no of coins required
 * 
 * There are problems with recursive approach
 * Exponential time complexity : 
 * No optimization
 * 
 */
public class CoinChangeII {
    
    public static int helper(int[] coins, int rem) {
        //Base case
        if (rem == 0) return 0; // no coins needed for 0 amount
        if (rem < 0) return Integer.MAX_VALUE; // Impossible to make up this amount

        // try every coin and find the min no of coins
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = helper(coins, rem - coin);
            if (result != Integer.MAX_VALUE) {
                min = Math.min(min, result + 1);
            }
        }

        return min;

    }
    public static int coinChange(int[] coins, int amount) {
        int result = helper(coins, amount);

        if (result != Integer.MAX_VALUE)
            return result;
        else 
            return -1;
    }

    public static void main( String args[] ) {
        int [][] coins = {{2, 3, 4, 5}, 
            {1, 4, 6, 9}, 
            {6, 7, 8}};
        int [] total = {7, 11, 27};
        for (int i = 0; i < total.length; i++)
        {
            System.out.println(i + 1 + ".\tThe minimum number of coins required to find " 
            + total[i] + " from " + Arrays.toString(coins[i]) + " is: "+ coinChange(coins[i], total[i]));
            System.out.println("------------------------------------");
        }
        
    }
}
