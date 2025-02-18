package problems.medium;
/*
Valid Sudoku
You are given a a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:

Each row must contain the digits 1-9 without duplicates.
Each column must contain the digits 1-9 without duplicates.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
Return true if the Sudoku board is valid, otherwise return false

Note: A board does not need to be full or be solvable to be valid*/

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean validSudoku = isValidSudoku(board);

        System.out.println(validSudoku);

    }

    static boolean isValidSudoku(char[][] board) {

        boolean[] used = new boolean[9];

        //sprawdzenie wierszy
        for (int i = 0; i < 9; i++) {
            used = new boolean[9];

            for(int j = 0; j < 9; j++) {
                      if(board[i][j] != '.') {
                          if(used[board[i][j]-'1']) {
                              return false;
                          }else{
                              used[board[i][j]-'1'] = true;
                          }
                      }
            }
        }

        //sprawdzenie kolumn
        for (int i = 0; i < 9; i++) {
            used = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.') {
                    if(used[board[j][i]-'1']) {
                        return false;
                    }else{
                        used[board[j][i]-'1'] = true;
                    }
                }
            }
        }

        //sprawdzenie kwadratów 3x3
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                used = new boolean[9];
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        if(board[k][l] != '.') {
                            if(used[board[k][l] - '1']) {
                                return false;
                            }else{
                                used[board[k][l] - '1'] = true;
                            }
                        }
                    }
                }
            }


        }


        return true;
    }
}