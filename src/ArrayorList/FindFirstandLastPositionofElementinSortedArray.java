package ArrayorList;

//34 problem
//Find First and Last Position of Element in Sorted Array
//Given an array of integers nums sorted in ascending order, find the starting and ending position
//of a given target value.
//Your algorithm's runtime complexity must be in the order of O(log n).
//If the target is not found in the array, return [-1, -1].
//Example 1:
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//Example 2:
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
public class FindFirstandLastPositionofElementinSortedArray {
    public int extremeIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int left = extremeIndex(nums, target, true);
        if (left == nums.length || nums[left] != target) return targetRange;
        targetRange[0] = left;
        targetRange[1] = extremeIndex(nums, target, false) - 1;
        return targetRange;
    }
}
