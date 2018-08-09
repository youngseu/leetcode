package Niuke.didi;

import java.util.Scanner;

//数字和为sum的方法
//题目描述
//给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
//当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
//输入描述:
//输入为两行:
// 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
// 第二行为n个正整数A[i](32位整数)，以空格隔开。
//输出描述:
//输出所求的方案数
//示例1
//输入
//5 15 5 5 10 2 3
//输出
//4
public class TargetSumNumDP {
    public static int length;

    //dp[i][j]代表考虑i个数和为j的情况个数
    public static long dp(int[] array, int sum) {
        long dp[][] = new long[length + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= array[i])
                    dp[i][j] = dp[i - 1][j - array[i]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[length][sum];
    }

    //error
    public static long dp2(int[] array, int sum) {
        long dp[] = new long[sum + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= array[i])
                    dp[j] += dp[j - array[i]];
            }
        }
        return dp[sum];
    }

    //error
    public static long mydp(int[] array, int sum) {
        long[] dp = new long[sum + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j + array[i] > sum) break;
                else if (dp[j] != 0) dp[j + array[i]]++;
                else if (j == array[i]) dp[j]++;
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();
        int[] array = new int[length + 1];

        int sum = sc.nextInt();
        for (int i = 1; i <= length; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(dp(array, sum));
        //System.out.println(mydp(array, sum));
        System.out.println(dp2(array,sum));
    }
}
