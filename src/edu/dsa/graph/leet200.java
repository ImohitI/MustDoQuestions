package edu.dsa.graph;

import java.util.*;

public class leet200 {
    
    /*
     * graph traversal problem
     * 
     * Goal is to count the no connected components of 1s
     * Iterate through each grid 
     * when 1 is found , increment island count
     * use dfs/bfs to travese all connected 1s and mark them visited by setting 0
     * continue till all cells are processed
     * 
     * TC O(n x m)
     * 
     * SC 
     * dfs O( n x m) in worst case for recursion stack
     * bfs O(m x n)) for queue size
     * 
     */

     public int numIslandDfs(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;;

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);//mark the island visited
                }
            }
        }

        return count;
     }

     public void dfs(char[][] grid, int row, int col) {
        //check boundary
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0')
            return;
        
        //mark cell as visited
        grid[row][col] = '0';

        //Visited all 4 neighboring cells
        dfs(grid, row - 1, col);//up
        dfs(grid, row + 1, col);//down
        dfs(grid, row, col - 1);//left
        dfs(grid, row, col + 1);//right
     }


     /*
      * instead of dfs recursive traversal , use a queue for iterative traversal 
      * start bfs for every unvisited 1 , marking all as visited 0
      */

      public int numIslandsBfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++; // Found an island
                    bfs(grid, i, j); // Mark the entire island as visited
                }
            }
        }
        
        return numIslands;
    }

      public void bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});
        grid[row][col] = '0';//marked as visited

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//u d l r

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
                int newRow = current[0] + direction[0];
                int newCol = current[1] + direction[1];

                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = '0'; // Mark as visited
                    queue.offer(new int[] {newRow, newCol});
                }                
            }
        }

      }

}
