package DynamicProgramming;

//70 problem
//Climbing Stairs
//You are climbing a stair case. It takes n steps to reach to the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//Note: Given n will be a positive integer.
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        if (n == 1) return 1;
        dp[0] = 1;
        if (n == 2) return 2;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
