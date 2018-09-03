package ArrayorList;

//209 problem
//Minimum Size Subarray Sum
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (res != Integer.MAX_VALUE ? res : 0);
    }
}
