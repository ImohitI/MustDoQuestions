package edu.dsa.dynamicprog;

/*
 * Tabulation , bottom up , iterative
 * TC O(n x amount)
 * SC 
 * 2d array O(n x amount)
 * optimized 1D sol --> O(amount)
 * 
 */
public class CoinChange3III {
    
    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];


        // Base case, there is one way to make amount 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                //Exclude the current coin
                dp[i][j] = dp[i - 1][j];

                //Include current coin if possible
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];

                }
            }
        }

        return dp[n][amount];

    }

    public int change1d(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        //base case 
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }

    // Main method to test the solution
    public static void main(String[] args) {
        CoinChange3III cc = new CoinChange3III();
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(cc.change(amount, coins)); // Output: 4
    }    
}
