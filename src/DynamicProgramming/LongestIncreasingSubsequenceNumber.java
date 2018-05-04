package DynamicProgramming;

import java.util.Arrays;

//673 problem
//Number of Longest Increasing Subsequence
//Given an unsorted array of integers, find the number of longest increasing subsequence.
//Example 1:
//Input: [1,3,5,4,7]
//Output: 2
//Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
public class LongestIncreasingSubsequenceNumber {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] lengths = new int[N];//length of longest ending at nums[i]
        int[] counts = new int[N];//number of longest ending at nums[i]
        Arrays.fill(counts, 1);

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    } else if (lengths[i] + 1 == lengths[j]) {
                        counts[j] += counts[i];
                    }
                }
            }
        }
        //handle longest
        int longset = 0, ans = 0;
        for (int length : lengths) {
            longset = Math.max(longset, length);
        }
        //handle seq
        for (int i = 0; i < N; i++) {
            if (lengths[i] == longset) {
                ans += counts[i];
            }
        }
        return ans;
    }
}
