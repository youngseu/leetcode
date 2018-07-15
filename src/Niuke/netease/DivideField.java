package Niuke.netease;

import java.util.Scanner;

//分田地
//题目描述
//牛牛和 15 个朋友来玩打土豪分田地的游戏，牛牛决定让你来分田地，地主的田地可以看成是一个矩形，每个位置有一个价值。分割田地
// 的方法是横竖各切三刀，分成 16 份，作为领导干部，牛牛总是会选择其中总价值最小的一份田地， 作为牛牛最好的朋友，你希望牛牛
// 取得的田地的价值和尽可能大，你知道这个值最大可以是多少吗？
//输入描述:
//每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 75），表示田地的大小，接下来的 n 行，
// 每行包含 m 个 0-9 之间的数字，表示每块位置的价值。
//输出描述:
//输出一行表示牛牛所能取得的最大的价值。
//输入
//4 4
//3332
//3233
//3332
//2323
//输出
//2
public class DivideField {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            int rows = Integer.parseInt(line.split(" ")[0]);
            int cols = Integer.parseInt(line.split(" ")[1]);
            int[][] A = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                String temp = in.nextLine();
                for (int j = 0; j < cols; j++) {
                    A[i][j] = Integer.parseInt(temp.substring(j, j + 1));
                }
            }
            System.out.println(maxValue(A));
        }
    }

    private static int calc(int[][] sum, int x, int y, int i, int j) {
        return sum[x][y] - sum[x][j] - sum[i][y] + sum[i][j];
    }

    private static boolean judge(int[][] sum, int x) {
        int m = sum.length - 1;
        int n = sum[0].length - 1;

        //横着切三刀
        for (int i = 1; i <= m - 3; i++) {
            for (int j = i + 1; j <= m - 2; j++) {
                for (int k = j + 1; k <= m - 1; k++) {
                    int last = 0, cnt = 0;
                    //竖着每次切一刀，进行贪心
                    for (int r = 1; r <= n; r++) {
                        int s1 = calc(sum, i, r, 0, last);
                        int s2 = calc(sum, j, r, i, last);
                        int s3 = calc(sum, k, r, j, last);
                        int s4 = calc(sum, m, r, k, last);
                        if (s1 >= x && s2 >= x && s3 >= x && s4 >= x) {
                            last = r;
                            cnt++;
                        }
                    }
                    //切割次数大于等于4则满足条件
                    if (cnt >= 4) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    private static int maxValue(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int[][] sum = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + A[i - 1][j - 1] - sum[i - 1][j - 1];
            }
        }

        int left = 0, right = sum[rows][cols], res = 0;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (judge(sum, m)) {
                left = m + 1;
                res = m;
            } else {
                right = m - 1;
            }
        }
        return res;
    }
}
