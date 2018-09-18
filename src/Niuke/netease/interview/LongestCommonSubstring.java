package Niuke.netease.interview;

//最长公共子串（Longest Common Substring）
//题目描述：
//给定两个字符串str1和str2，返回两个字符串的最长公共子串的长度。
//分析：
//用二维数组dp[][]来保存动态规划表，假设str1长度为m，str2长度为n，则dp[][]大小为m*n；

//dp[i][j]表示把str1[i]和str2[j]当成最长公共子串最后一个字符的情况下，最长公共子串能有多长
// （即以str1[i]和str2[j]结尾的最长公共子串长度）。

//如何生成dp[][]:
//1.求矩阵第一行dp[0][j]
//
//如果str1[0]=str2[j]，则dp[0][j]=1，否则为0；
//
//2.求矩阵第一列dp[i][0]
//
//如果str1[i]=str2[0]，则dp[i][0]=1，否则为0；
//
//3.求普通dp[i][j]
//
//如果str1[i]=str2[j]，则dp[i][j]=dp[i-1][j-1]+1；否则为0；
//
//根据dp[][]求最长公共子串及其长度：
//
//遍历一遍dp[][]找出最大值即为最长公共子串长度，得到dp[][]最大值dp[i][j]，则最长公共子串以str1[i]或者str2[j]结尾，往前数dp[i][j]个字符即可。假设结尾字符位置是end，长度为len，则java中子串为str1.substring(end-len+1,end+1)。
//
//算法时间复杂度为O(MN)，空间复杂度为O(MN)。
public class LongestCommonSubstring {
    public int findLongest(String A, int n, String B, int m) {
        if (A ==null || n == 0||B==null||m==0) return 0;
        char[] cha = A.toCharArray();
        char[] chb = B.toCharArray();
        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (cha[0] == chb[i]) {
                dp[0][i] = 1;
                max = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (chb[0] == cha[i]) {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (cha[i] == chb[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}
