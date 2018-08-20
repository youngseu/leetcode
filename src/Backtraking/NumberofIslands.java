package Backtraking;

//200 problem
//Number of Islands
//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded
//by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four
//edges of the grid are all surrounded by water.
//Example 1:
//Input:
//11110
//11010
//11000
//00000
//Output: 1
//Example 2:
//Input:
//11000
//11000
//00100
//00011
//Output: 3
public class NumberofIslands {

    public void backtrack(char[][] arrays, int row, int col) {
        if (row < 0 || col < 0 || row >= arrays.length || col >= arrays[0].length || arrays[row][col] == '0') {
            return;
        } else {
            arrays[row][col] = '0';
            backtrack(arrays, row, col + 1);
            backtrack(arrays, row, col - 1);
            backtrack(arrays, row - 1, col);
            backtrack(arrays, row + 1, col);
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0') {
                    backtrack(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
