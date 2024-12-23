package edu.dsa.backtracking;

import java.util.*;

public class MinMoveStones9 {

    private static int minMoves;

    public static int minimumMoves(int[][] grid) {

        // Arrays to store coordinates of zeros (empty cells) and extras more than 1
        List<int[]> zeros = new ArrayList<>();
        List<int[]> extras = new ArrayList<>();

        // Initialize minimum moves to a very large number
        minMoves = Integer.MAX_VALUE;

        // Calculate the total number of stones
        int totalStones = 0;
        for (int[] row: grid) {
            for (int cell : row) {
                totalStones += cell;
            }
        }

        if (totalStones != 9) return -1;

        // Populate zeros and extras

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (grid[x][y] == 0) {

                    zeros.add(new int[]{x, y});
                } else if (grid[x][y] > 1) {
                    extras.add(new int[]{x, y, grid[x][y] - 1});
                }
            }
        }

        if (zeros.size() == 0) {
            return 0;
        }

        solve(zeros, extras, 0, 0);
        return minMoves;
    }

    public static void solve(List<int[]> zeros, List<int[]> extras, int i, int count) {

        // if all zeros have been processed
        if (i >= zeros.size()) {
            //update the minimum moves if a better solution is found
            minMoves = Math.min(minMoves, count);
            return;
        }

        // try to move stones from all extra cells to current zero cell
        for (int k = 0; k < extras.size(); k++) {
            // check if there are stones to move
            if (extras.get(k)[2] != 0) {
                // move one stone from extra to empty zero cell
                extras.get(k)[2]--;

                solve(zeros, extras, i + 1, Math.abs(extras.get(k)[0] - zeros.get(i)[0] + Math.abs(extras.get(k)[1] - zeros.get(i)[1]) + count));
                // undo move
                extras.get(k)[2]++;
            }
        }
    }

    public static void main(String[] args) {
        int[][][] grids = {
            {
                {1, 1, 1}, 
                {1, 2, 3}, 
                {0, 0, 0}
            },
            {   
                {8, 1, 0}, 
                {0, 0, 0}, 
                {0, 0, 0}
            },
            {   
                {2, 2, 2}, 
                {1, 1, 1}, 
                {0, 0, 0}
            },
            {   
                {3, 0, 0}, 
                {3, 0, 0}, 
                {3, 0, 0}
            },
            {   
                {1, 0, 1}, 
                {3, 0, 0}, 
                {0, 4, 0}
            }
        };

        for (int i = 0; i < grids.length; i++) {
            System.out.println((i + 1) + ".\tInput grid: ");
            draw2DArray(grids[i]);
            System.out.println("\n\tMinimum number of moves: " + minimumMoves(grids[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static void draw2DArray(int[][] grid) {
        for (int[] row : grid) {
            System.out.print("\t| ");
            for (int cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println();
        }
    }
}
