package DFSAndBFS;

import java.util.LinkedList;
import java.util.Queue;

//542 problem
//01 Matrix
//Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
//The distance between two adjacent cells is 1.
//Example 1:
//Input:
//0 0 0
//0 1 0
//1 1 1
//Output:
//0 0 0
//0 1 0
//1 2 1
public class ZeroOneMatrix {
    public int row = 0;
    public int col = 0;
    public final int[][] dir = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public void bfs(int[][] matrix, int r, int c) {
        int tr = 0, tc = 0, dis = 1;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < dir.length; i++) {
            tr = r + dir[i][0];
            tc = r + dir[i][1];
            if (r < 0 || r >= row || c < 0 || c >= col) continue;
        }
        while (!queue.isEmpty()) {

        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

            }
        }
        return matrix;
    }
}
