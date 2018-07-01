package ArrayorList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//268 problem
//Missing Number
//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is
//missing from the array.
//Input: [3,0,1]
//Output: 2
//Input: [9,6,4,2,3,5,7,0,1]
//Output: 8
//Your algorithm should run in linear runtime complexity. Could you implement it using only
//constant extra space complexity?
public class MissingNumber {
    //sort
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        } else if (nums[0] != 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i - 1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }
        return -1;
    }

    //set
    public int missingNumber2(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        for (int num : nums) numset.add(num);
        for (int number = 0; number < nums.length + 1; number++) {
            if (!numset.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    //Bit Manipulation
    public int missingNumber3(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
