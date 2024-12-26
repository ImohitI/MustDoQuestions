package edu.dsa.dynamicprog;

import java.util.Arrays;

/*
 * Coin change memoization
 * helper fn that takes rem amount as input
 * for each recursive call check if result for given amount has already been computed
 * if not compute and store in memoization table
 * 
 * Base cases:
 * if amount is 0, return 0 , no coins needed
 * if amount is negative, return INF, invalid case
 * 
 * Recursive rel:
 * For each coin, calculate the result for amount - coin, and take the minimum of these results
 * Add 1 to include the current coin in the count
 * 
 * Memoization table:
 * dp array where dp[i] stores the min number of coins needed to make the amount i,
 * Initialize all entries to -1 (uncomputed)
 * 
 * Time complexity
 * recursive fn is called for each unique amount from 0 to amount exactly once, due to memoization
 * for each amount, we iterate through all n coins
 * TC O(amount x n)
 * SC
 * memoization an array of size amount + 1
 * recursion stack max depth of stack is amount
 * SC O(amount)
 * 
 * 
 */
public class CoinChangeIII {
    
    public int coinChangeHelper(int[] coins, int amount, int[] dp) {
        //Base changes 
        if (amount == 0) return 0; // No coins needed for amount 0
        if (amount < 0) return Integer.MAX_VALUE; // impossible case

        if (dp[amount] != -1) return dp[amount]; // if result is already computed, return it

        int minCoins = Integer.MAX_VALUE;
        //try each coin and compute the result recursively
        for (int coin : coins) {
            int result = coinChangeHelper(coins, amount - coin, dp);

            //if the result is valid, update minCoins
            if (result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }

        //Store the result in the memoizations array and return it
        dp[amount] = minCoins;
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        //Memoization array to store results for subproblems
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        //Call the helper finction with initial amount
        int result = coinChangeHelper(coins, amount, dp);

        //if result in infinity, return -1(not possible)
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main( String args[] ) {
        int [][] coins = {{2, 3, 4, 5}, 
            {1, 4, 6, 9}, 
            {6, 7, 8}, 
            {1, 2, 3, 4, 5}, 
            {14, 15, 18, 20}};
        int [] total = {7, 11, 27, 41, 52};
        for (int i = 0; i < total.length; i++)
        {
            System.out.println(i + 1 + ".\tThe minimum number of coins required to find " + 
            total[i] + " from " + Arrays.toString(coins[i]) + " is: "+ new CoinChangeIII().coinChange(coins[i], total[i]));
            System.out.println("------------------------------------");
        }
        
    }
}
