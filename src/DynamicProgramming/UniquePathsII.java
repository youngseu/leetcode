package DynamicProgramming;

//63 problem
//Unique Paths II
//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
//corner of the grid (marked 'Finish' in the diagram below).
//Now consider if some obstacles are added to the grids. How many unique paths would there be?
//Input:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//Output: 2
//Explanation:
//There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1 - obstacleGrid[i][j];
                    continue;
                }
                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else if (i == 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                else if (j == 0)
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                else obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[n - 1][m - 1];
    }
}
