package Niuke.netease;

import java.io.*;
//合唱团
//思路：
//一般的动态规划题目，中间使用的表的最后一个元素，dp[N][K]就是所求的结果。但这个题目不能这样，因为如果那样建表，
//子问题就成了“在前n个学生中，取k个，使乘积最大”——然而，本题目有额外的限制条件“相邻两个学生的位置编号的差不超
//过d”就没有办法代入递推公式了，因为子问题中本身并不包含位置信息。
//因此将子问题定为：在前n个学生中，取k个，第n个必取，使乘积最大。这样的话，最终的结果就不是dp[N][K]，而是dp[..][K]
//这一列中最大的那个值。其次，求最大乘积比求最大和的问题要复杂许多。求最大和的话，子问题中也只需要求最大和就行了。
//但求最大乘积的时候，在子问题中，每一步需要求最大正积和最小负积。因为如果某学生的能力值为负数，乘以前面求得的最小负
//积，结果才是最大乘积。再次，这个问题最后算的数据比较大，已经不是int型能够包含的了，需要用long long。
public class Choir {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            //学生数
            int n = Integer.parseInt(line.trim());
            //能力值
            int[] nums = new int[n];
            String[] s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            //选取学生数和距离
            String[] s1 = br.readLine().trim().split(" ");
            int k = Integer.parseInt(s1[0]);
            int d = Integer.parseInt(s1[1]);

            //dp table
            long[][] max = new long[k][n];
            long[][] min = new long[k][n];
            //init
            for (int i = 0; i < n; i++) {
                max[0][i] = nums[i];
                min[0][i] = nums[i];
            }

            for (int i = 1; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    for (int m = 1; m <= d; m++) {
                        if (j - m >= 0) {
                            if (nums[j] > 0) {
                                max[i][j] = Math.max(max[i][j], max[i - 1][j - m] * nums[j]);
                                min[i][j] = Math.min(min[i][j], min[i - 1][j - m] * nums[j]);
                            } else {
                                max[i][j] = Math.max(max[i][j], min[i - 1][j - m] * nums[j]);
                                min[i][j] = Math.min(min[i][j], max[i - 1][j - m] * nums[j]);
                            }
                        }
                    }
                }

            }
            long res = 0;
            for (int i = 0; i < n; i++) {
                if (i >= k - 1) {
                    res = Math.max(res, max[k - 1][i]);
                }
            }
            System.out.println(res);
        }
    }
}
