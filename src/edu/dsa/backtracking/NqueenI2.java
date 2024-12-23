package edu.dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.zip.CRC32;

/*
 * 51. N-Queens
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * 
 * Time Complexity: Exponential in nature since we are trying out all ways, to be precise its O(N! * N).
 * Space Complexity: O(N)
 * 
 */
public class NqueenI2 {
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                board[i][j] = '.';
            }
        }

        Set<Integer> col = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        List<List<String>> res = new ArrayList<>();

        bactrack(board, n, 0, col, posDiag, negDiag, res);

        return res;
    }

    public static void bactrack(char[][] board, int n, int r,Set<Integer> col, Set<Integer> posDiag, Set<Integer> negDiag, List<List<String>> res) {
        if (r == n) {
            
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                ans.add(new String(board[i]));
            }
            res.add(ans);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || posDiag.contains(c + r) || negDiag.contains(c - r)) {
                continue;
            }

            board[r][c] = 'Q';
            col.add(c);
            posDiag.add(c+r);
            negDiag.add(c-r);

            bactrack(board, n, r + 1, col, posDiag, negDiag, res);

            board[r][c] = '.';
            col.remove(c);
            posDiag.remove(c+r);
            negDiag.remove(c-r);

        }

    }

    public static void main(String args[]) {
        int N = 4;
        List < List < String >> queen = solveNQueens(N);
        int i = 1;
        for (List < String > it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }

    }
}
