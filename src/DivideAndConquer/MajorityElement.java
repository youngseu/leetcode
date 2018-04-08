package DivideAndConquer;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

//169 problem
//Majority Element
//Given an array of size n, find the majority element. The majority element is the element that
//appears more than ⌊ n/2 ⌋ times.
//You may assume that the array is non-empty and the majority element always exist in the array.
public class MajorityElement {
    //divide and conquer
    public int count(int[] nums, int num, int lo, int hi) {
        int sum = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) sum++;
        }
        return sum;
    }

    public int divandcon(int[] nums, int lo, int hi) {
        //only one
        if (lo == hi) return nums[lo];
        int mid = (hi - lo) / 2 + lo;
        int left = divandcon(nums, lo, mid);
        int right = divandcon(nums, mid + 1, hi);

        if (left == right) return left;

        int leftCount = count(nums, left, lo, hi);
        int rightCount = count(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }
    public int majorityElement(int[] nums) {
        return divandcon(nums, 0, nums.length - 1);
    }

    //hashmap
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        Map.Entry<Integer, Integer> res = null;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (res == null || entry.getValue()>res.getValue())
                res = entry;
        }
        return res.getKey();
    }

    //Boyer-Moore Voting Algorithm
}
