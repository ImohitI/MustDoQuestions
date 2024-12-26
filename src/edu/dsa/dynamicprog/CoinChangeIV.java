package edu.dsa.dynamicprog;

import java.util.Arrays;

/*
 * Tabulation is a bottom up approach 
 * we iteratively store all subproblems, starting from the smallest and use their solution to build up the final result
 * 
 * DP table
 * 1D array dp of size amount + 1
 * dp[i] represents the min no of coins required to make up the amount i
 * Initialize dp[0] = 0, ) coins are needed to make amount 0
 * All other values to Integer.MAX
 * 
 * Iterative Sol
 * For each coin c in coins
 * update the DP for all amounts from c to amount, using 
 * dp[i] = min(dp[j], dp[j - c] + 1);
 * This means that if we make amoutn j - c with dp[j - c] coins, we can make j by adding one more c coin
 * 
 * Final result 
 * if dp[amount] remanins INF, it means not possible to form, return -1
 * other wise return dp[amount]
 * 
 * TC 
 * outer loop iterates over n coins 
 * inner loop iterates over all amounts up to amount
 * TC O(n x amount)
 * 
 * SC dominated by DP array of size amount + 1 
 * O(amount)
 * 
 */

public class CoinChangeIV {
    
    public int coinChange(int[] coins, int amount) {
        //create a DP array to store the min coin need for each amount
        int[] dp = new int[amount + 1];

        //Initialize DP with INF
        Arrays.fill(dp, Integer.MAX_VALUE);

        //Base case
        dp[0] = 0;

        //Iterate over each coin
        for (int coin : coins) {
            //Update the DP table for amounts that can include this coin
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
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
            total[i] + " from " + Arrays.toString(coins[i]) + " is: "+ new CoinChangeIV().coinChange(coins[i], total[i]));
            System.out.println("------------------------------------");
        }
        
    }    
}
