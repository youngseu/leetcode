package DynamicProgramming;

//312 problem
//Burst Balloons
//Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
//Find the maximum coins you can collect by bursting the balloons wisely.
//Note:
//(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
//(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
//Example:
//Given [3, 1, 5, 8]
//Return 167
//    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
public class BurstBalloons {
    //Java D&C with Memoization
    int[][] memory;

    public int maxCoins(int[] nums) {
        int[] array = new int[nums.length + 2];
        array[0] = 1;
        array[array.length - 1] = 1;
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = nums[i - 1];
        }
        memory = new int[array.length][array.length];
        return maxCoins(array, 1, array.length - 2);
    }

    private int maxCoins(int[] nums, int i, int j) {
        if (i > j) return 0;
        if (memory[i][j] != 0) return memory[i][j];
        int max = 0;
        for (int k = i; k <= j; k++) {
            int left = maxCoins(nums, i, k - 1);
            int right = maxCoins(nums, k + 1, j);
            max = Math.max(max, left + right + nums[i - 1] * nums[k] * nums[j + 1]);
        }
        memory[i][j] = max;
        return max;
    }

    //DP
    public int maxCoins2(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int distance = 2; distance < n; ++distance)
            for (int left = 0; left < n - distance; ++left) {
                int right = left + distance;
                for (int lastBrust = left + 1; lastBrust < right; ++lastBrust)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[lastBrust] * nums[right] + dp[left][lastBrust] + dp[lastBrust][right]);
            }

        return dp[0][n - 1];
    }
}
