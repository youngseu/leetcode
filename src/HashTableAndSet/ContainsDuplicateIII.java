package HashTableAndSet;

import java.util.TreeSet;

//220 problem
//Contains Duplicate III
//Given an array of integers, find out whether there are two distinct indices i and j in the array such that
//the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and
//j is at most k.
//Example 2:
//Input: nums = [1,0,1,1], k = 1, t = 2
//Output: true
//Example 3:
//Input: nums = [1,5,9,1,5,9], k = 2, t = 3
//Output: false
public class ContainsDuplicateIII {
    //O(N lg K)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) return false;
        final TreeSet<Integer> values = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = values.floor(nums[i] + t);
            Integer ceil = values.ceiling(nums[i] - t);
            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) return true;
            values.add(nums[i]);
            if (i >= k) values.remove(nums[i - k]);
        }
        return false;
    }
}
