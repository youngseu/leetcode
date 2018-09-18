package Niuke.netease.interview;

//最长公共子序列（Longest Common Subsequence, LCS）
//题目描述：
//给定两个字符串str1和str2，返回两个字符串的最长公共子序列的长度。
//例如：str1="1A2C3D4B56" ，str2="B1D23CA4B6A"，则"123456"和"12C4B6"都是最长公共子序列。

//注意最长公共子序列与最长公共子串的区别，串要求是连续的，而序列不一定是连续的。

//分析：
//用一个二维数组来作动态规划表，假设str1长度为m，str2长度为n，则二维数组大小为dp[m][n];
//dp[i][j]：表示str1[ 0.....i ]和str2[ 0......j ]的最长公共子序列的长度；
//如何生成dp[][]:
//<1>对于矩阵的第一行：
//dp[0][j]，即str1的第一个字符与str2的最长公共子序列。从前往后遍历str2，如果碰到与str1[0]相同的字符，则将对应的dp[0][j]置为1，一旦有dp[0][j]=1，则后面的dp[0][j+1.....n-1]全为1。
//
//<2>对于矩阵的第一列：
//dp[i][0]，即str2的第一个字符与str1的最长公共子序列。
//与第一行同理，一旦有dp[i][0]=1，则后面的dp[i+1.....m-1][0]全为1。
//
//<3>对于一般的dp[i][j]：
//
//其值只可能来自三种情况dp[i][j-1]， dp[i-1][j]， dp[i-1][j-1]+1（str1[i]和str2[j]表示的字符相同），取这三种情况中的最大值。
//则str1和str2的最长公共子序列的长度为dp[m-1][n-1]，时间复杂度为O(MN)，空间复杂度为O(MN)。
public class LongestCommonSubsequence {
    public int findLCS(String A, int n, String B, int m) {
        if (A == null || n == 0 || B == null || m == 0) return 0;
        char[] cha = A.toCharArray();
        char[] chb = B.toCharArray();
        int[][] dp = new int[n][m];
        dp[0][0] = cha[0] == chb[0] ? 1 : 0;
        //dp 第一行
        for (int i = 1; i < m; i++) {
            dp[0][i] = cha[0] == chb[i] ? 1 : dp[0][i - 1];
        }
        //dp 第一列
        for (int i = 1; i < n; i++) {
            dp[i][0] = chb[0] == cha[i] ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (cha[i] == chb[j])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp[n - 1][m - 1];
    }
}
