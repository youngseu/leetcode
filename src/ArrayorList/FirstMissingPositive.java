package ArrayorList;

//41 problem
//First Missing Positive
//Given an unsorted integer array, find the smallest missing positive integer.
//Input: [1,2,0]
//Output: 3
//Input: [3,4,-1,1]
//Output: 2
//Input: [7,8,9,11,12]
//Output: 1
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i+1||nums[i]<=0||nums[i] > nums.length) i++;
            else if (nums[nums[i]-1] !=nums[i]) swap(nums, i, nums[i] - 1);
            else i++;
        }
        i = 0;
        while (i<nums.length && nums[i]==i+1) i++;
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
