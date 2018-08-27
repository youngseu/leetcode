package DivideAndConquer;

//59 problem
//Spiral Matrix II
//Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//Example:
//Input: 3
//Output:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, up = 0;
        int right = n - 1, bottom = n - 1;
        int count = 1;
        while (left <= right) {
            for (int i = left; i <= right; i++) {
                res[up][i] = count++;
            }
            up++;

            for (int i = up; i <= bottom; i++) {
                res[i][right] = count++;
            }
            right--;

            for (int i = right; i >= left ; i--) {
                res[bottom][i] =count++;
            }
            bottom--;

            for (int i = bottom; i >= up ; i--) {
                res[i][left] = count++;
            }
            left++;
        }
        return res;
    }
}
