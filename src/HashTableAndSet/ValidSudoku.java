package HashTableAndSet;

import java.util.HashSet;
import java.util.Set;

//36 problem
//Valid Sudoku
//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//The Sudoku board could be partially filled, where empty cells are filled with the character '.'
public class ValidSudoku {
    //Collect the set of things we see, encoded as strings. For example:
    //
    //'4' in row 7 is encoded as "(4)7". 4 row 7
    //'4' in column 7 is encoded as "7(4)". 7 row 4
    //'4' in the top-right block is encoded as "0(4)2". 4 block 0-2
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " row " + i) ||
                            !seen.add(number + " col " + j) ||
                            !seen.add(number + " block " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
