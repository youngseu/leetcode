package Backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//47 problem
//Permutations II
//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracing(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }

    public static void backtracing(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                //避免相邻两个相同的数，后面的数先选，再选前面的数，导致相同结果
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                list.add(nums[i]);
                backtracing(res, list, nums, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
