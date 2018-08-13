package Niuke.toutiao.contest_toutiao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//找出一个矩阵中有多少个连通域，最大的连通域包含多少个元素
/*
10,10
0,0,0,0,0,0,0,0,0,0
0,0,0,1,1,0,1,0,0,0
0,1,0,0,0,0,0,1,0,1
1,0,0,0,0,0,0,0,1,1
0,0,0,1,1,1,0,0,0,1
0,0,0,0,0,0,1,0,1,1
0,1,1,0,0,0,0,0,0,0
0,0,0,1,0,1,0,0,0,0
0,0,1,0,0,1,0,0,0,0
0,1,0,0,0,0,0,0,0,0
 */
public class first {
    static int count;
    static int max;
    static int m;
    static int n;
    static int tmp = 0;

    public static void backtrace(int[][] arrays, int row, int col) {
        if (col < 0 || row < 0 || col >= m || row >= n || arrays[row][col] == 0) return;
        else {
            if (arrays[row][col] == 1) {
                tmp++;
                arrays[row][col] = 0;
            }
            backtrace(arrays, row - 1, col - 1);
            backtrace(arrays, row - 1, col);
            backtrace(arrays, row - 1, col + 1);
            backtrace(arrays, row, col - 1);
            backtrace(arrays, row, col + 1);
            backtrace(arrays, row + 1, col - 1);
            backtrace(arrays, row + 1, col);
            backtrace(arrays, row + 1, col + 1);

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = bf.readLine().trim().split(",");
        m = Integer.parseInt(arg[0]);
        n = Integer.parseInt(arg[1]);

        int[][] arrays = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] arg1 = bf.readLine().trim().split(",");
            for (int j = 0; j < n; j++) {
                arrays[i][j] = Integer.parseInt(arg1[j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp = 0;
                backtrace(arrays, i, j);
                if (tmp != 0) {
                    count++;
                    max = Math.max(max, tmp);
                }
            }
        }
        System.out.println(count + "," + max);
    }
}
