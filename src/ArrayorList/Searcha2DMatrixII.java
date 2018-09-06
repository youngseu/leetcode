package ArrayorList;

//240 problem
//Search a 2D Matrix II
//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix
//has the following properties:
//Integers in each row are sorted in ascending from left to right.
//Integers in each column are sorted in ascending from top to bottom.
//Example:
//Consider the following matrix:
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//Given target = 5, return true.
//Given target = 20, return false.
public class Searcha2DMatrixII {
    //每次可以排除一行或者一列 可理论证明
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int tRow = row;
        int tCol = 0;
        while (tRow > 0 && tCol <= col) {
            if (matrix[tRow][tCol] == target) return true;
            else if (matrix[tRow][tCol] > target) tRow--;
            else if (matrix[tRow][tCol] < target) tCol++;
        }
        return false;
    }
}
