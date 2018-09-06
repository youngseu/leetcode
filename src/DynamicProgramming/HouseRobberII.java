package DynamicProgramming;

//213 problem
//House Robber II
//You are a professional robber planning to rob houses along a street. Each house has a certain amount
//of money stashed. All houses at this place are arranged in a circle. That means the firstExtended house is the
//neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will
//automatically contact the police if two adjacent houses were broken into on the same night.
public class HouseRobberII {
    //start must be robbed
    private int helper(int[] nums, int start, int end) {
        int curr = 0, prev = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            curr = Math.max(prev2 + nums[i], prev);
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }
}
