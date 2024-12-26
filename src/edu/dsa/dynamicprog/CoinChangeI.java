package edu.dsa.dynamicprog;

import java.util.Arrays;

/* 
 * Edu solution
 * total is the target amount
 * coins has distinct denominations and infinite supply of coins
 * Find the minimum no of coins to make up the total amount, if not possible return -1
 * Naive approach
 * generate all possible combinations so the sum of coins equal total, choose one with minimum no of coins
 * In worst case the time complexity increases exponentially with total amount 
 * O(n ^ total)
 * Space complexity is O total, because max depth of recursion tree grows up to total
 * 
 * Improving on TC using DP , top down approach
 * Edu solution
 * The problem needs to be broken down into subproblems and an optimal solution can be reached
 * Assuming we Know no of coins required for some total value and last coin denomination is C
 * Min(total) Min(total - C) + 1
 * But we do not know what is the value of C so we compute for each element of the coins arrau
 * Min(total) = min i= 0 .. n - 1 ( Min(total - Ci) + 1)
 * Min(total) = 0, for total = 0
 * Min(total) = -1, for no = 0
 * 
 * counter array
 * stores the min no of coins required to make each specific amount of money up to the given total
 * 
 * TC O(total * n) , 
 * SC O(total) size of counter array of size total
 * 
 */
public class CoinChangeI {
    

    public static int calculateMinimumCoins(int [] coins, int remainingAmount, int [] counter)
    {
        int result = 0;
        if (remainingAmount < 0) return -1;
        if (remainingAmount == 0) return 0;
        if (counter[remainingAmount - 1] != Integer.MAX_VALUE) 
            return counter[remainingAmount - 1];
        
        int minimum = Integer.MAX_VALUE;

        for (int j = 0; j < coins.length; j++) {
            result = calculateMinimumCoins(coins, remainingAmount - coins[j], counter);
            if (result >= 0 && result < minimum) 
                minimum = 1 + result;
        }

        if (minimum != Integer.MAX_VALUE) 
            counter[remainingAmount - 1] = minimum;
        else
            counter[remainingAmount - 1] = -1;
        
        return counter[remainingAmount - 1];

    }
    public static int coinChange(int [] coins, int total)  // main function
    {
        if (total < 1) {
            return 0;
        }
        int[] l = new int[total];
        Arrays.fill(l, Integer.MAX_VALUE);
        return calculateMinimumCoins(coins, total, l);

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
            System.out.println(i + 1 + ".\tThe minimum number of coins required to find " + total[i] + " from " + Arrays.toString(coins[i]) + " is: "+ coinChange(coins[i], total[i]));
            System.out.println("------------------------------------");
        }
        
    }
}