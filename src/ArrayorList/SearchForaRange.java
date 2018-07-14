package ArrayorList;

//34 problem
//Search for a Range
//Given an array of integers nums sorted in ascending order, find the starting and ending position
// of a given target value.
//Your algorithm's runtime complexity must be in the order of O(log n).
//If the target is not found in the array, return [-1, -1].
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
public class SearchForaRange {
    //linear scan
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                range[0] = i;
                break;
            }
        }
        if (range[0] == -1) return range;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == target) {
                range[1] = i;
                break;
            }
        }
        return range;
    }

    //binary search
    //returns leftmost (or rightmost) index at which `target` should be
    //inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            //left control when mid equals target
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public int[] searchRange1(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }
}
