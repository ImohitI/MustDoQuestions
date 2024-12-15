package edu.dsa.backtracking;

public class SudokuSolver2 {
    
    public static boolean solveSudoku(char[][] board) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (board[i][j] == '.') {
  
            for (char c = '1'; c <= '9'; c++) {
              if (isValid(board, i, j, c)) {
                board[i][j] = c;
  
                if (solveSudoku(board))
                  return true;
                else
                  board[i][j] = '.';
              }
            }
  
            return false;
          }
        }
      }
      return true;
    }
  
    public static boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;

            if (board[row][i] == c)
                return false;

                /*
                 * checking in 3 x 3 , 
                 * finding start r,c for row, col -------> row/3, col/3
                 * i have to check r, r + 1, r + 2 
                 * 3 * (row/3) + i/3,  3 * (col/3) + i % 3
                 */
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }

        // check in box 
        // int startRow = 3 * (row / 3);
        // int startCol = 3 * (col / 3);

        // for (int i = startRow; i < startRow + 3; i++ )
        //     for (int j = startCol; j < startCol + 3; j++) 
        //         if (board[i][j] == c)
        //             return false;



        return true;
    }
  
    public static void main(String[] args) {
  
     char[][] board= {
                      {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                      {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                      {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                      {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                      {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                      {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                      {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                      {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                      {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
                      };

        solveSudoku(board);
  
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
            System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}