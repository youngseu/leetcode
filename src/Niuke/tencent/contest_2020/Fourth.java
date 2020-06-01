package Niuke.tencent.contest_2020;

import java.util.Scanner;

// 休假
//由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息。他有个奇怪的习惯：
// 不会连续两天工作或锻炼。只有当公司营业时，小Q才能去工作，只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。
// 给出假期中公司，健身房的营业情况，求小Q最少需要休息几天。
//输入描述:
//第一行一个整数  表示放假天数
//第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业
//第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业
//（1为营业 0为不营业）
//
//输出描述:
//一个整数，表示小Q休息的最少天数
//
//输入例子1:
//4
//1 1 0 0
//0 1 1 0
//
//输出例子1:
//2
public class Fourth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] works = new int[num];
        int[] exes = new int[num];
        for (int i = 0; i < num; i++) {
            works[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            exes[i] = sc.nextInt();
        }

        // 0 rest; 1 work; 2 exe
        int[][] dp = new int[2][3];

        for (int i = 0; i < num; i++) {
            if (works[i] == 1) dp[1][1] = Math.min(dp[0][0], dp[0][2]);
            else dp[1][1] = Integer.MAX_VALUE;

            if (exes[i] == 1) dp[1][2] = Math.min(dp[0][0], dp[0][1]);
            else dp[1][2] = Integer.MAX_VALUE;

            dp[1][0] = Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][1]);

            for (int j = 0; j < 3; j++) {
                dp[0][j] = dp[1][j];
            }
        }
        System.out.println(Math.min(Math.min(dp[1][0], dp[1][1]), dp[1][2]));
    }
}
