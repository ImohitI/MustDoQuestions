package edu.dsa.backtracking;

import java.util.Arrays;
import java.util.List;

public class Nqueen4 {
    static int ans;
    
    public static int totalNQueens(int N) {
        ans = 0;
        place(0,0,0,0,N);
        return ans;
    }
    
    private static void place(int i, int vert, int ldiag, int rdiag, int N) {
        if (i == N) ans++;
        else for (int j = 0; j < N; j++) {
            int vmask = 1 << j, lmask = 1 << (i+j), rmask = 1 << (N-i-1+j);
            if ((vert & vmask) + (ldiag & lmask) + (rdiag & rmask) > 0) continue;
            place(i+1, vert | vmask, ldiag | lmask, rdiag | rmask, N);
        }
    }

    public static void main(String args[]) {
		List<Integer> n = Arrays.asList(4, 5, 6, 7, 8);
		for (int i = 0; i<n.size(); i++) {
			System.out.println(i + 1 + ".\tQueens: " + n.get(i) + ", Chessboard: (" + n.get(i) + "x" + n.get(i) + ")");
			int res = totalNQueens(n.get(i));
			System.out.println("\n\tTotal solutions count for " + n.get(i) + " queens on a (" + n.get(i) + "x" + n.get(i) + ") chessboard: " + res);
			System.out.println("--------------------------------------------------");
		}
	}
    
}
