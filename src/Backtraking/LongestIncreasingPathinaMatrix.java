package Backtraking;

//329 problem
//Longest Increasing Path in a Matrix
public class LongestIncreasingPathinaMatrix {
    public final int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] memo = new int[row][col];
        int max = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int len = dfs(matrix, i, j, row, col, memo);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] martrix, int i, int j, int row, int col, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];
        int max = 1;
        for (int[] ints : dir) {
            int r = i + ints[0], c = j + ints[1];
            if (r < 0 || r >= row || c < 0 || c >= col || martrix[r][c] <= martrix[i][j]) continue;
            int len = 1 + dfs(martrix, r, c, row, col, memo);
            max = Math.max(max, len);
        }
        memo[i][j] = max;
        return max;
    }
}
