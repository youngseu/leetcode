package Niuke.didi;

import java.util.Scanner;

public class TargetSumNumDP {
    public static int num;

    public static long dp(int[] array, int sum) {
        long dp[][] = new long[num + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= array[i])
                    dp[i][j] = dp[i - 1][j - array[i]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[num][sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        int[] array = new int[num + 1];

        int sum = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(dp(array, sum));
    }
}
