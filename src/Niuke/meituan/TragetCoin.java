package Niuke.meituan;

import java.util.Scanner;

//拼凑面额
//题目描述
//给你六种面额1、5、10、20、50、100元的纸币，假设每种币值的数量都足够多，编写程序求组成N元（N为0-10000的非负整数）的
//不同组合的个数。
//输入描述:
//输入为一个数字N，即需要拼凑的面额
//输出描述:
//输出也是一个数字，为组成N的组合个数。
//示例1
//输入
//5
//输出
//2
public class TragetCoin {
    public static int sum = 0;
    public static int[] table = {1, 5, 10, 20, 50, 100};//无限硬币
//    public static int[] table = {5, 5, 10, 2, 3};//有限硬币

    //out of time
    public static void backtracing(int target, int start, int[] arrays) {
        if (target == 0) sum++;
        else if (target < 0) return;
        else {
            for (int i = start; i < arrays.length; i++) {
                backtracing(target - arrays[i], i, arrays);
            }
        }
    }

    //dp[j]的值是面额为j的组合个数
    public static long dp(int target) {
        long[] dp = new long[target + 1];
        dp[0] = 1;
        for (int i = 0; i < table.length; i++) {
            for (int j = table[i]; j < dp.length; j++) {
                dp[j] += dp[j - table[i]];
            }
        }
        return dp[target];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
//        backtracing(length, 0, table);
//        System.out.println(sum);
        System.out.println(dp(num));
    }
}
