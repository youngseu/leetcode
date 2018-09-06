package HashTableAndSet;

import java.util.HashMap;
import java.util.Map;

//136 problem
//Single Number
//Given an array of integers, every element appears twice except for one. Find that single one.
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.containsKey(nums[i]) ? 2 : 1);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().toString().equals("1")) {
                res = Integer.parseInt(entry.getKey().toString());
            }
        }
        return res;
    }

    //Bit Manipulation
    //If we take XOR of zero and some bit, it will return that bit
    //a xor 0 = a
    //If we take XOR of two same bits, it will return 0
    //a xor a = 0
    //a xor b xor a = (a xor a) xor b = 0 xor b = b
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++)
            ans = ans ^ nums[i];
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 1, 2}));
    }
}
