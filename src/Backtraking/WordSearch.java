package Backtraking;

//79 problem
//Word Search
//Given a 2D board and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//For example,
//Given board =
//
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
public class WordSearch {
    public static boolean myexist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        System.out.println(row);
        System.out.println(col);
        boolean[][] table = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    table[i][j] = true;
                    if (search(board, row, col, i, j, word.substring(1), table))
                        return true;
                    else
                        table[i][j] = false;
                }
            }
        }
        return false;
    }

    public static boolean search(char[][] board, int row_len, int col_len, int row, int col, String word, boolean[][] table) {
        if (word.length() == 0) return true;
        System.out.println(word);
        if (row - 1 >= 0 && board[row - 1][col] == word.charAt(0) && !table[row - 1][col]) {
            table[row - 1][col] = true;
            if (search(board, row_len, col_len, row - 1, col, word.substring(1), table))
                return true;
            else table[row - 1][col] = false;
        }
        if (row + 1 < row_len && board[row + 1][col] == word.charAt(0) && !table[row + 1][col]) {
            table[row + 1][col] = true;
            if (search(board, row_len, col_len, row + 1, col, word.substring(1), table))
                return true;
            else table[row + 1][col] = false;
        }
        if (col - 1 >= 0 && board[row][col - 1] == word.charAt(0) && !table[row][col - 1]) {
            table[row][col - 1] = true;
            if (search(board, row_len, col_len, row, col - 1, word.substring(1), table))
                return true;
            else table[row][col - 1] = false;
        }
        if (col + 1 < col_len && board[row][col + 1] == word.charAt(0) && !table[row][col + 1]) {
            table[row][col + 1] = true;
            if (search(board, row_len, col_len, row, col + 1, word.substring(1), table))
                return true;
            else table[row][col + 1] = false;
        }
        return false;
    }

    //参考答案
    public static class Reference {
        public boolean exist(char[][] board, String word) {
            char[] w = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (exist(board, i, j, w, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        //直接修改原有字母表，无需增加标记
        private boolean exist(char[][] board, int row, int col, char[] word, int i) {
            if (i == word.length) return true;
            if (row < 0 || col < 0 || row == board.length || col == board[0].length) return false;
            if (board[row][col] != word[i]) return false;
            board[row][col] ^= 256;
            boolean exist = exist(board, row, col + 1, word, i + 1)
                    || exist(board, row, col - 1, word, i + 1)
                    || exist(board, row + 1, col, word, i + 1)
                    || exist(board, row - 1, col, word, i + 1);
            board[row][col] ^= 256;
            return exist;
        }

    }


    public static void main(String[] args) {
        if (myexist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                "ABCESEEDAS"))
            System.out.println("yes");
        Reference rf = new Reference();
        System.out.println(rf.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                "ABCESEEDAS"));
    }
}
