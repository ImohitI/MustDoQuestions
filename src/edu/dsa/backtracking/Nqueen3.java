package edu.dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Place queen in first colum
 * Use stack to keep track of current solution
 * Place a queen wherever permissible in the next row
 * Backtrack by popping from the stack to find the next solution
 * 
 * Time complexity O(n!) where n is the dimension of the chessboard
 * Space complexity O(n) where n is the dimension of the chessboard
 * 
 */
public class Nqueen3 {

	public static void solveNQueensRec(int n, List<Integer> solution, int row, List<List<Integer>> results) {
		if (row == n) {
			results.add(solution);
			return;
		}

		for (int i = 0; i<n; i++) {
			boolean valid = isValidMove(row, i, solution);
			if (valid) {
				solution.set(row, i);
				solveNQueensRec(n, solution, row + 1, results);
			} 
		}
	}

	// Function to solve N-Queens problem
	public static int solveNQueens(int n) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> solution = new ArrayList<Integer> (Collections.nCopies(n, -1));
		solveNQueensRec(n, solution, 0, results);
		return results.size();
	}
	
	// this method determines if a queen can be placed at proposed_row, proposed_col
	// with current solution i.e. this move is valid only if no queen in current
	// solution may attack the square at proposed_row and proposed_col
	public static boolean isValidMove(int proposedRow, int proposedCol, List<Integer> solution) {
		int oldRow =0, oldCol = 0, diagonalOffset = 0;
		for (int i = 0; i<proposedRow; i++) {
			oldRow = i;
			oldCol = solution.get(i);
			diagonalOffset = proposedRow - oldRow;

			if (oldCol == proposedCol || oldCol == proposedCol - diagonalOffset || oldCol == proposedCol + diagonalOffset) {
				return false;
			}
		}

		return true;
	}
  
	public static void main(String args[]) {
		List<Integer> n = Arrays.asList(4, 5, 6, 7, 8);
		for (int i = 0; i<n.size(); i++) {
			System.out.println(i + 1 + ".\tQueens: " + n.get(i) + ", Chessboard: (" + n.get(i) + "x" + n.get(i) + ")");
			int res = solveNQueens(n.get(i));
			System.out.println("\n\tTotal solutions count for " + n.get(i) + " queens on a (" + n.get(i) + "x" + n.get(i) + ") chessboard: " + res);
			System.out.println("--------------------------------------------------");
		}
	}
}
