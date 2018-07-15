package Niuke.netease;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//买苹果
//小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。 可是小易现在只想购
//买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
//输入描述:
//输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果
//输出描述:
//输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
//输入
//20
//输出
//3
public class BuyApple {
    private int judge(int num) {
        if (num % 2 == 1) return -1;
        int num_3 = num / 24;
        int left = num % 24;
        if (left == 0) return num_3 * 3;
        else if (left == 6 || left == 8) return num_3 * 3 + 1;
        else if (left == 12 || left == 14 || left == 16) return num_3 * 3 + 2;
        else if (left == 18 || left == 20 || left == 22) return num_3 * 3 + 3;
        else return -1;
    }

    private int dp(int num) {
        if (num % 2 == 1) return -1;
        int[] dp = new int[num + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[6] = 1;
        dp[8] = 1;
        for (int i = 6; i <= num; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            else {
                if (i + 6 <= num) dp[i + 6] = Math.min(dp[i] + 1, dp[i + 6]);
                if (i + 8 <= num) dp[i + 8] = Math.min(dp[i] + 1, dp[i + 8]);
            }
        }
        if (dp[num] == Integer.MAX_VALUE) return -1;
        else return dp[num];
    }

    public static void main(String[] args) throws Exception {
        BuyApple ba = new BuyApple();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        System.out.println(ba.judge(n));
        System.out.println(ba.dp(n));
    }
}
