package DynamicProgramming;


import java.util.Arrays;

//300 problem
//Longest Increasing Subsequence
//Given an unsorted array of integers, find the length of longest increasing subsequence.
//For example,Given [10, 9, 2, 5, 3, 7, 101, 18],
//The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than
//one LIS combination, it is only necessary for you to return the length.
public class LongestIncreasingSubsequence {

    //brute force
    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }

    public int lengthOfLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) return 0;
        int taken = 0;
        if (nums[curpos] > prev)
            taken = 1 + lengthOfLIS(nums, nums[curpos], curpos + 1);
        int nottaken = lengthOfLIS(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }


    //recursive + mem
    public int lengthOfLIS1(int[] nums) {
        int memo[][] = new int[nums.length + 1][nums.length];
        for (int[] l : memo) Arrays.fill(l, -1);
        return lengthOfLIS(nums, -1, 0, memo);
    }

    public int lengthOfLIS(int[] nums, int preindex, int curpos, int[][] mem) {
        if (curpos == nums.length) return 0;
        if (mem[preindex + 1][curpos] >= 0)
            return mem[preindex + 1][curpos];
        int taken = 0;
        if (preindex < 0 || nums[curpos] > nums[preindex]) {
            taken = 1 + lengthOfLIS(nums, curpos, curpos + 1, mem);
        }
        int nottaken = lengthOfLIS(nums, preindex, curpos + 1, mem);
        mem[preindex + 1][curpos] = Math.max(taken, nottaken);
        return mem[preindex + 1][curpos];
    }

    //dp
    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j])
                    maxval = Math.max(maxval, dp[j]);
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}