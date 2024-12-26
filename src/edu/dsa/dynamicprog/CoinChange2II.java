package edu.dsa.dynamicprog;

import java.util.Arrays;

/*
 * Memoization soln for coin change 2 
 * 2D array dp[index][amount] stores the number of comninations to make amount using coins starting from index 
 * 
 * Recursive fn
 * if result for dp[index][amount] has been computed return it
 * otherwise compute it by recursively including and exluding the current coin
 * 
 * Base case
 * if amount == 0, return 1 
 * amoutn < 0 or index > coins.length, return 0
 * 
 * TC no of subproblems n x amount
 * O(n x amount)
 * 
 * SC 2d array C(n x amount), recursion stack max depth is n + amount
 * SC O(n x amount)
 * 
 * 
 */
public class CoinChange2II {
    
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countCombinations(coins, amount, 0, dp);
    }

    public int countCombinations(int[] coins, int amount, int index, int[][] dp) {

        //Base case , if amount is 0, one valid combination is found
        if (amount == 0) return 1;

        if (amount < 0 || index >= coins.length) return 0;

        if (dp[index][amount] != -1) return dp[index][amount];

        //Recurisve calls
        int includeCurrCoin = countCombinations(coins, amount - coins[index], index, dp);

        int excludeCurrCoin = countCombinations(coins, amount, index + 1, dp);

        dp[index][amount] = includeCurrCoin + excludeCurrCoin;

        return dp[index][amount];
 
    }


    // Main method to test the solution
    public static void main(String[] args) {
        CoinChange2II cc = new CoinChange2II();
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(cc.change(amount, coins)); // Output: 4
    }    
}
