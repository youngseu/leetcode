package Niuke.netease.leihuo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//最大和
//在一个N*N的数组中寻找所有横，竖，左上到右下，右上到左下，四种方向的直线连续D个数字的和里面最大的值
//输入描述:
//每个测试输入包含1个测试用例，第一行包括两个整数 N 和 D :
//3 <= N <= 100
//1 <= D <= N
//接下来有N行，每行N个数字d:
//0 <= d <= 100
//输出描述:
//输出一个整数，表示找到的和的最大值
//输入例子1:
//4 2
//87 98 79 61
//10 27 95 70
//20 64 73 29
//71 65 15 0
//输出例子1:
//193
public class MaxSumInArray {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = bf.readLine().trim().split(" ");
        int n = Integer.parseInt(arg[0]);
        int d = Integer.parseInt(arg[1]);
        int[][] arrays = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = bf.readLine().trim().split(" ");
            for (int j = 0; j < n; j++) {
                arrays[i][j] = Integer.parseInt(line[j]);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (i + d <= n) {
                    int tmp = 0;
                    for (int k = 0; k < d; k++) {
                        tmp += arrays[i + k][j];
                    }
                    max = Math.max(max, tmp);
                    count++;
                }
                if (j + d <= n) {
                    int tmp = 0;
                    for (int k = 0; k < d; k++) {
                        tmp += arrays[i][j + k];
                    }
                    max = Math.max(max, tmp);
                    count++;
                }
                if (count == 2) {
                    int tmp = 0;
                    for (int k = 0; k < d; k++) {
                        tmp += arrays[i + k][j + k];
                    }
                    max = Math.max(max, tmp);
                }
                if (i + 1 - d >= 0 && j + 1 - d >= 0) {
                    int tmp = 0;
                    for (int k = 0; k < d; k++) {
                        tmp += arrays[i - k][j - k];
                    }
                    max = Math.max(max, tmp);
                }
            }
        }
        System.out.println(max);
    }
}
