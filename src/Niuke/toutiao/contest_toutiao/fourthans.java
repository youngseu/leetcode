package Niuke.toutiao.contest_toutiao;

import java.util.Scanner;

//第四题：满足条件的区间数
//要求：给定两个长度相同的数组a b，对应区间内，a的最大值小于b的最小值。
//思路：开始用暴力dp，dp1[i][j]表示a的i～j区间的最大值，dp2[i][j]表示b的i～j区间的最小值，然后逐次比较，结果
//空间复杂度过高，过了20%.
//优化1：对于双重循环，i这个变量在dp中没有起到作用，因此改成一维数组，过了30%.
//优化2:  dp1[j]=max(dp[j-1], a[j]),可以看到， dp1[j]用了一次之后就不需要再用了，因此可以继续优化到O（1），
//即dp1 = max(dp1, a[i])，过了70%
public class fourthans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] num1 = new int[len];
        int[] num2 = new int[len];
        for (int i = 0; i < len; i++) num1[i] = sc.nextInt();
        for (int i = 0; i < len; i++) num2[i] = sc.nextInt();
        int dp1max = 0, dp2min = 0, res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp1max = num1[i];
                    dp2min = num2[j];
                } else {
                    dp1max = Math.max(dp1max, num1[j]);
                    dp2min = Math.min(dp2min, num2[j]);
                    if (dp1max < dp2min) res++;
                }
            }
        }
        System.out.println(res);
    }
}
