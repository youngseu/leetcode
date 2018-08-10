package ArrayorList;

import java.util.Arrays;

//179 problem
//Largest Number
//Given a list of non negative integers, arrange them such that they form the largest number.
//Example 1:
//Input: [10,2]
//Output: "210"
//Example 2:
//Input: [3,30,34,5,9]
//Output: "9534330"
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strings[i] = String.valueOf(nums[i]);

        Arrays.sort(strings, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (strings[0].charAt(0) == '0') return "0";
        StringBuffer sb = new StringBuffer();
        for (String s : strings) sb.append(s);
        return sb.toString();
    }
}
