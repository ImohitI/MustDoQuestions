package edu.dsa.backtracking;

import java.util.*;

/*
 * some regex to convert 3 to '3' and 0 to '.'
 * \b0\b -- '.'
 * \b(\d+)\b -- '$1' -- first capture group
 */
public class SudokuValid {
    public boolean isValidSudoku(char[][] board) {
        
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.')
                    continue;
                
                String squareKey = (r/3) + "," + (c/3);

                if (rows.computeIfAbsent(r, k -> new HashSet<>()). contains(board[r][c])
                    || cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c])
                    || squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {

                        return false;
                }

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);

            }
        }

        return true;
    }

    public boolean isValidSudoku2(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.')
                    continue;
                
                if (!seen.add(board[i][j] + " in row " + i)
                    || !seen.add(board[i][j] + " in col "+ j)
                    || !seen.add(board[i][j] + " in box "+ (i/3) + (j/3))    
                ) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char grid[][] = { { '3', '.', '6', '5', '.', '8', '4', '.', '.' },
                        { '5', '2', '.', '.', '.', '.', '.', '.', '.' },
                        { '.', '8', '7', '.', '.', '.', '.', '3', '1' },
                        { '.', '.', '3', '.', '1', '.', '.', '8', '.' },
                        { '9', '.', '.', '8', '6', '3', '.', '.', '5' },
                        { '.', '5', '.', '.', '9', '.', '6', '.', '.' },
                        { '1', '3', '.', '.', '.', '.', '2', '5', '.' },
                        { '.', '.', '.', '.', '.', '.', '.', '7', '4' },
                        { '.', '.', '5', '2', '.', '6', '3', '.', '.' } };

        if (new SudokuValid().isValidSudoku2(grid))
            System.out.println("valid sudoku");
        else
            System.out.println("No Solution exists");    
    }
}
