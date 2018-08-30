package Greedy;

import java.util.Arrays;

//45 problem
//Jump Game II
//Given an array of non-negative integers, you are initially positioned at the first index of
//the array.
//Each element in the array represents your maximum jump length at that position.
//Your goal is to reach the last index in the minimum number of jumps.
//Example:
//Input: [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index.
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int left = 0;
        int right = nums[0];
        int step = 1;
        while (left <= right) {
            if (right >= nums.length - 1) return step;
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                max = Math.max(max, i + nums[i]);
            }
            if (max > right) {
                left = right;
                right = max;
                step++;
            }
        }
        return -1;
    }

    //bfs
    public int jump1(int[] nums) {
        if (nums == null ||nums.length <2) return 0;
        int level = 0, curMax = 0, i = 0, nextMax = 0;
        while (curMax - i + 1 > 0) {
            level++;
            for (; i <= curMax; i++) {
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= nums.length -1) return level;
            }
            curMax = nextMax;
        }
        return 0;
    }


    //dp
    //out of time
    public int jump2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i)
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}
