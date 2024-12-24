package edu.dsa.backtracking;

import java.util.*;

public class OptimalAccBalance {
    
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balanceMap = new HashMap<>();

        for (int[] transaction : transactions) {
            int a = transaction[0];
            int b = transaction[1];
            int amount = transaction[2];

            //increase balance for giver
            balanceMap.put(a, balanceMap.getOrDefault(a,0) + amount);

            //decreaes balance for receiver
            balanceMap.put(b, balanceMap.getOrDefault(b, 0) - amount);
        }

        // filter out people with zero balance to only consider unsettled balances
         // Filter out people with zero balance to only consider unsettled balances
         List<Integer> balanceList = new ArrayList<>();
         for (int amount : balanceMap.values()) {
             if (amount != 0) {
                 balanceList.add(amount);
             }
         }
         
         // Convert the balanceList to an array for easier handling in DFS
         int[] balance = new int[balanceList.size()];
         for (int i = 0; i < balanceList.size(); i++) {
             balance[i] = balanceList.get(i);
         }
        // Total number of unsettled balances
        int n = balance.length;

        // Use DFS to calculate minimum transactions needed
        return dfs(0, n, balance);          
    }
    // Helper function using DFS to calculate minimum transactions
    public static int dfs(int current, int n, int[] balance) {
        
        // Move to the next person with a non-zero balance
        while (current < n && balance[current] == 0) {
            current++;
        }
        
        // If all balances are settled, no more transactions are needed
        if (current == n) {
            return 0;
        }
        
        int cost = Integer.MAX_VALUE;
        
        // Try settling the current person’s balance with each remaining person’s balance
        for (int next = current + 1; next < n; next++) {
            
            // Only attempt to settle with opposite sign balances
            if (balance[next] * balance[current] < 0) {
                
                // Settle current balance with next person
                balance[next] += balance[current];
                
                // Recursively calculate the cost with the next person and update minimum cost
                cost = Math.min(cost, 1 + dfs(current + 1, n, balance));
                
                // Backtrack to restore original balance
                balance[next] -= balance[current];
            }
        }
        
        // Return the minimum cost to settle all balances        
        return cost;
    }

    
    public static void main(String[] args) {
        OptimalAccBalance solution = new OptimalAccBalance();
        
        int[][][] transactionsList = {
            {{0, 1, 40}, {1, 2, 15}, {0, 3, 30}, {4, 5, 10}, {2, 5, 10}},
            {{1, 0, 10}, {2, 0, 30}, {3, 0, 40}, {2, 0, 15}},
            {{0, 1, 10}, {1, 2, 20}, {2, 3, 30}, {3, 4, 40}, {4, 5, 50}, {5, 6, 60}},
            {{0, 1, 10}, {0, 2, 20}, {0, 3, 30}, {0, 4, 40}, {5, 0, 100}},
            {{0, 1, 10}, {1, 0, 10}}
        };
        
        for (int i = 0; i < transactionsList.length; i++) {
            System.out.print(i + 1 + ".\tTransactions: ");
            //Print.print2DArray(transactionsList[i]);
            System.out.println("\n\tMinimum number of transactions to settle all debts: " + solution.minTransfers(transactionsList[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }    
}
