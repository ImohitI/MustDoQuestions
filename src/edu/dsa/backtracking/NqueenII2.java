package edu.dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 * Time complexity O(n!)
 * spcae complexity O(n)
 * 
 */
public class NqueenII2 {
	// This solution uses a stack to store the solution.
	// Stack will hold only the column values and one solution
	// will be stored in the stack at a time.
	static boolean isValidMove(int proposedRow, int proposedCol, List<Integer> solution) {
		// we need to check with all queens
		// in current solution
		int oldRow =0, oldCol = 0, diagonalOffset = 0;
		for (int i = 0; i<proposedRow; ++i) {
			oldRow = i;
			oldCol = solution.get(i);
			diagonalOffset = proposedRow - oldRow;
			// oldCol == proposedCol --> Checks if there are any queens in the proposed column
			// oldCol == proposedCol - diagonalOffset --> Checks if there are any queens on the bottom left diagonal to the proposed place
			// oldCol == proposedCol + diagonalOffset --> Checks if there are any queens on the bottom right diagonal to the proposed place
			if (oldCol == proposedCol || oldCol == proposedCol - diagonalOffset || oldCol == proposedCol + diagonalOffset) {
				return false;
			}
		}
		return true;
	}

	// This solution uses stack to store the solution.
	// Stack will hold only the column values and one solution
	// will be stored in the stack at a time.
	static int solveNQueens(int n) {
		List<List<Integer>> results = new ArrayList<List<Integer>> ();
		List<Integer> solution = new ArrayList<Integer> (Collections.nCopies(n, -1));
		Stack<Integer> solStack = new Stack<Integer> ();
		//
		// for (int i = 0; i<n; ++i) {
		// solution.add(-1);
		// }
		int row = 0;
		int col = 0;
		while (row<n) {
			// For the current state of the solution, check if a queen can be placed in any
			// column of this row
			while (col<n) {
				if (isValidMove(row, col, solution)) {
					// If this is a safe position for a queen (a valid move), save
					// it to the current solution on the stack...
					solStack.push(col);
					solution.set(row, col);
					row++;
					col = 0;
					// ... and move on to checking the next row (breaking out of the inner loop)
					break;
				}
				col++;
			}
			// If we have checked all the columns
			if (col == n) {
				// If we are working on a solution
				if (!solStack.empty()) {
					// Backtracking, as current row does not offer a safe spot given the previous
					// move
					// So, get set up to check the previous row with the next column
					col = solStack.peek() + 1;
					solStack.pop();
					row--;
				} else {
					// If we have backtracked all the way and found this to be a dead-end,
					// break out of the inner loop as no more solutions exist
					break;
				}
			}
			// If we have found a safe spot for a queen in each of the rows
			if (row == n) {
				// Add the solution into results
				results.add(new ArrayList<Integer> (solution));

				// Backtrack to find the next solution
				row--;
				col = solStack.peek() + 1;
				solStack.pop();
			}
		}
		return results.size();
	}
	
	public static void main(String args[]) {

		List<Integer> n = Arrays.asList(4, 5, 6, 7);
		for (int i = 0; i<n.size(); i++) {
			int res = solveNQueens(n.get(i));
			System.out.println((i + 1) + ".  Total solutions count for " + n.get(i) + " queens on the chessboard (" + n.get(i) + "x" + n.get(i) + "): " + res);
			System.out.println("-------------------------------------------------------------------------------------\n");
		}
	}    
}
