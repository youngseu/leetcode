package Niuke.netease.interview;

//最小编辑代价
//题目描述：
//给定两个字符串str1和str2，再给定三个整数ic，dc，rc，分别代表插入、删除、替换一个字符的代价，返回将str1
//编辑成str2的最小代价。
//举例：
//str1="abc"   str2="adc"  ic=5    dc=3   rc=2，从"abc"编辑到"adc"把b替换成d代价最小，为2；
//str1="abc"   str2="adc"  ic=5    dc=3   rc=10，从"abc"编辑到"adc"，先删除b再插入d代价最小，为8；
//分析：
//经典动态规划方法，利用二维数组dp[][]保存动态规划表；
//假设str1长度为M[0.....M-1]，str2长度为N[0.......N-1]，dp大小为(M+1)*(N+1)；
//dp[i][j]表示str1[0......i-1]编辑成str2[0......j-1]的最小编辑代价，dp大小为(M+1)*(N+1)是为了从空串
//开始计算，即dp[0][0]表示空串编辑到空串的最小编辑代价。
//
//如何生成dp[][]:
//1.dp[0][0]表示空串编辑成空串，故dp[0][0]=0;
//2.求第一行dp[0][j]，空串编辑成str2[0....j-1]，则dp[0][j]=ic*j;
//3.求第一列dp[i][0]，str1[0......i-1]编辑成空串，则dp[i][0]=dc*i;
//4.求dp[i][j]，即str1[0....i-1]编辑成str2[0.....j-1]，四种可能的途径：
//<1>str1[0....i-1]先编辑成str2[0.....j-2]，再由str2[0.....j-2]到str2[0.....j-1]，即dp[i][j-1]+ic;
//
//<2>str1[0....i-1]先编辑成str1[0.....i-2]，再由str1[0.....i-2]到str2[0.....j-1]，即dc+dp[i-1][j];
//
//<3>如果str1[i-1]==str2[j-1],则dp[i][j]=dp[i-1][j-1];
//
//       如果str1[i-1]!=str2[j-1],则dp[i][j]=dp[i-1][j-1]+rc;
//
//选择上面四个中最小的值作为dp[i][j]，时间复杂度O(MN)，空间复杂度O(MN)。最小编辑距离为dp[M][N]。
public class MinEditCost {
    public int finMinCost(String A, int n, String B, int m, int ic, int dc, int rc) {
        if (A == null || B == null) return 0;
        if (n == 0) return m * ic;
        if (m == 0) return n * ic;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = ic * i;
        }
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = dc * i;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
            }
        }
        return dp[n][m];
    }
}
