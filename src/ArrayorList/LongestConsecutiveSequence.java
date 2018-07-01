package ArrayorList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//128 problem
//Longest Consecutive Sequence
//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//Your algorithm should run in O(n) complexity.
//Input: [100, 4, 200, 1, 3, 2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
public class LongestConsecutiveSequence {
    //hash set
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            //great!!!
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }

    //sort
    public int longestConsecutive1(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    curLen++;
                } else {
                    res = Math.max(res, curLen);
                    curLen = 1;
                }
            }
        }
        return Math.max(res, curLen);
    }
}
