package DynamicProgramming;

//746 problem
//Min Cost Climbing Stairs
//On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
//Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the
//top of the floor, and you can either start from the step with index 0, or the step with index 1.
//Input: cost = [10, 15, 20]
//Output: 15
//Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
public class ClimbingStairsMinCost {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        if (len == 1) return 0;
        dp[0] = cost[0];
        if (len == 2)
            return cost[0] < cost[1] ? cost[0] : cost[1];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }
}
