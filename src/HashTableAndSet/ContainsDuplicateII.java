package HashTableAndSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//219 problem
//Contains Duplicate II
//Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the
//array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
//Example 2:
//Input: nums = [1,0,1,1], k = 1
//Output: true
//Example 3:
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
public class ContainsDuplicateII {
    //map
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    //set
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}