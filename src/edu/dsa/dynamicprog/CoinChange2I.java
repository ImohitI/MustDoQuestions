package edu.dsa.dynamicprog;
/*
 * coins array of denominations and amount 
 * Return the number of combinations that make up the amount
 * If the amount cannot be made return 0
 * 
 * Recursive approach
 * Include the current coin and reduce the amount by the coins value
 * exclude the curr coin and move to the next one
 * 
 * recursive fn
 * base case
 * amount == 0, return 1 
 * amount < 0 or no coins are left , index >= coins.length , return 0
 * 
 * recursive calls
 * include the coin: call the function with the same index and reduced amount
 * exclude the coin : call the function with next index and the same amount
 * 
 * Time Complexity
 * Each recursive call can branch into 2 more calls, leading to exponential complexity
 * worst case O 2^ (n + amount)
 * 
 * Space Complexity
 * recursion stack : max depth of the recursion stack is amount + n
 * SC propotional to recursion depth , O(amount)
 * 
 * 
 * 
 */
public class CoinChange2I {
    
    public int change(int amount, int[] coins) {
        return countCombinations(coins, amount, 0);
    }

    public int countCombinations(int[] coins, int amount, int index) {
        //Base case : if amount is 0, one valid combination found
        if (amount == 0) return 1;

        // Base case if the amount becomes negative or no coins are left
        if (amount < 0 || index >= coins.length) return 0;

        // recursive calls
        // 1. Include current coin
        int includeCurrCoin = countCombinations(coins, amount - coins[index], index);

        // 2. Exclude current coin and move to the next
        int excludeCurrCoin = countCombinations(coins, amount, index + 1);

        //Return the total number of combinations
        return includeCurrCoin + excludeCurrCoin;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        CoinChange2I cc = new CoinChange2I();
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(cc.change(amount, coins)); // Output: 4
    }    
}
