package Niuke.netease.contest_huyu;

import ArrayorList.NextPermutation;

import java.util.Scanner;

public class thirdans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= m; i++) dp[0][i] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        StringBuffer sb = new StringBuffer();
        if (k > dp[n][m]) {
            System.out.println(-1);
        } else {
            int n1 = n;
            int m1 = m;
            for (int i = 0; i < n + m; i++) {
                if (n1 > 0 && k <= dp[n1 - 1][m1]) {
                    sb.append("a");
                    n1--;
                } else {
                    if (n1 > 0)
                        k -= dp[n1 - 1][m1];
                    sb.append("z");
                    m1--;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
