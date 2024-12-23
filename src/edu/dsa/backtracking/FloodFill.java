package edu.dsa.backtracking;

import java.util.*;

public class FloodFill {
    
    public static int[][] floodFill(int[][] grid, int sr, int sc, int target) {
    
        if (grid[sr][sc] == target) {
            return grid;
        } else {
            int oldTarget = grid[sr][sc];
            grid[sr][sc] = target;
            dfs(grid, sr, sc, oldTarget, target);
            return grid;
        }

    }

    public static void dfs(int[][] grid, int row, int col, int oldTarget, int newTarget) {
        int RR = grid.length;
        int CC = grid[0].length;

        int[][] adjacentcells = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        for (int[] cells : adjacentcells) {
            int r = row + cells[0];
            int c = col + cells[1];

        try {
            if (r < RR && r >= 0 && c < CC && c >= 0 && grid[r][c] == oldTarget) {
                grid[r][c] = newTarget;
                dfs(grid, r, c, oldTarget, newTarget);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        }        
    }

    public static void main(String[] args){
        int[][][] grids = {
                {{1, 1, 0, 1, 0}, 
                {0, 0, 0, 0, 1}, 
                {0, 0, 0, 1, 1}, 
                {1, 1, 1, 1, 0}, 
                {1, 0, 0, 0, 0}},

                {{1, 1, 0, 1}, 
                {0, 0, 0, 0}, 
                {0, 0, 0, 1}, 
                {1, 1, 1, 1}},

                {{9, 9, 6, 9}, 
                {6, 9, 9, 6}, 
                {6, 9, 9, 9}, 
                {9, 9, 9, 9}},

                {{1, 1, 0, 1}, 
                {0, 1, 0, 0}, 
                {0, 1, 1, 0}, 
                {1, 0, 1, 1}},
        
                {{1, 2, 0, 0}, 
                {3, 1, 3, 6}, 
                {7, 2, 1, 5}, 
                {1, 9, 2, 1}},

                {{1, 1, 1}, 
                {1, 1, 0}, 
                {1, 0, 1}},                
        };

        int[] sr = {4, 2, 2, 2, 1, 1};
        int[] sc = {3, 3, 1, 3, 1, 1};
        int[] target = {3, 2, 1, 0, 4, 2};

        for (int i = 0; i < grids.length; i++) {
            System.out.println((i + 1) + ".\t Grid before flood fill: " + Arrays.deepToString(grids[i]));
            System.out.println("\t Starting row and column are: (" + sr[i] + ", " + sc[i] + ")");
            System.out.println("\t Target value: " + target[i]);
            
            int[][] result = floodFill(grids[i], sr[i], sc[i], target[i]);
            System.out.println("\t After perform flood fill: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }    
}
