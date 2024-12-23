package edu.dsa.backtracking;

import java.util.*;

public class WordSearch {
    
    public boolean exist(char[][] board, String word) {
        //Set<String> loc = new HashSet<>();

        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];

        for (int i=0; i < board.length; i++) {
            for (int j=0; j<board[0].length; j++) {

                if (visit(board, word, i, j, visited, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean visit(char[][] board, String word, int r, int c, 
    //Set<String> loc, 
    boolean[][] visited,
    int wi) {

        if (wi == word.length())
            return true;
        
        if (r < 0 || c < 0 || r >= board.length || c >=board[0].length 
            //|| loc.contains(r+","+c) 
            || visited[r][c]
            || word.charAt(wi) != board[r][c]) {
                return false;
        }

        //loc.add(r+","+c);
        visited[r][c] = true;
        // boolean res = (visit(board, word, r + 1, c, loc, wi + 1)
        // || visit(board, word, r - 1, c, loc, wi + 1)
        // || visit(board, word, r, c + 1, loc, wi + 1)
        // || visit(board, word, r, c - 1, loc, wi + 1));

        boolean res = (visit(board, word, r + 1, c, visited, wi + 1)
        || visit(board, word, r - 1, c, visited, wi + 1)
        || visit(board, word, r, c + 1, visited, wi + 1)
        || visit(board, word, r, c - 1, visited, wi + 1));

        //loc.remove(r+","+c);
        visited[r][c] = false;
        return res;

    }

    
    public static void printGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.print("\t\t[");
            for (int j = 0; j < grid[0].length; j++) {
                if (j < grid[0].length - 1)
                    System.out.print("'" + grid[i][j] + "', ");
                else
                    System.out.print("'" + grid[i][j] + "'");
            }
            System.out.println("]");
        }
            System.out.println("\n");
    }

    public static void main( String args[] ) {

        char[][][] grids = {
                    {{'E', 'D', 'X', 'I', 'W'},
                    {'P', 'U', 'F', 'M', 'Q'},
                    {'I', 'C', 'Q', 'R', 'F'},
                    {'M', 'A', 'L', 'C', 'A'},
                    {'J', 'T', 'I', 'V', 'E'}},

                    {{'E', 'D', 'X', 'I', 'W'},
                    {'P', 'A', 'F', 'M', 'Q'},
                    {'I', 'C', 'A', 'S', 'F'},
                    {'M', 'A', 'L', 'C', 'A'},
                    {'J', 'T', 'I', 'V', 'E'}},

                    {{'h', 'e', 'c', 'm', 'l'},
                    {'w', 'l', 'i', 'e', 'u'},
                    {'a', 'r', 'r', 's', 'n'},
                    {'s', 'i', 'i', 'o', 'r'}},

                    {{'C', 'Q', 'N', 'A'},
                    {'P', 'S', 'E', 'I'},
                    {'Z', 'A', 'P', 'E'},
                    {'J', 'V', 'T', 'K'}},

                    {{'O', 'Y', 'O', 'I'},
                    {'B', 'Y', 'N', 'M'},
                    {'K', 'D', 'A', 'R'},
                    {'C', 'I', 'M', 'I'},
                    {'Z', 'I', 'T', 'O'}}
                };

        String[] words = {"EDUCATIVE", "PACANS", "warrior", "SAVE", "DYNAMIC"};
        for(int i=0;i<words.length;i++){
          System.out.print(i+1);
          System.out.println(".\tGrid = ");
          printGrid(grids[i]);
          System.out.println("\tWord = "+ words[i]);

          Boolean result = new WordSearch().exist(grids[i], words[i]);
          if(result == true){
              System.out.println("\n\tSearch result = Found Word");
          }
          else{
              System.out.println("\n\tSearch result = Word could not be found");
          }
          System.out.println(new String(new char[100]).replace('\0', '-'));
        } 
    }    
}
