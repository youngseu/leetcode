package ArrayorList;

//287 problem
//Find the Duplicate Number
//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
//prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
//find the duplicate one.
//You must not modify the array (assume the array is read only).
//You must use only constant, O(1) extra space.
//Your runtime complexity should be less than O(n2).
//There is only one duplicate number in the array, but it could be repeated more than once.
public class FindtheDuplicateNumber {
    //same as LinkedListCycleII
    //a jump is value = nums[value],0 <= value <= nums.lemgth
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) {
            return -1;
        } else {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            int cur = -1;
            while (cur != slow) {
                cur = nums[cur == -1 ? 0 : cur];
                slow = nums[slow];
            }
            return cur;
        }
    }
}
