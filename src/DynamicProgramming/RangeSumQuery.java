package DynamicProgramming;

//303 problem
//Range Sum Query
//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//Given nums = [-2, 0, 3, -5, 2, -1]
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3
public class RangeSumQuery {
    private int[] sum;

    // sum[0] = 0;sum[i] is sum of length[0~i-1]
    public RangeSumQuery(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
