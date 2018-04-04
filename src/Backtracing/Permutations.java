package Backtracing;

import java.util.ArrayList;
import java.util.List;

//46 problem
//Permutations
//Given a collection of distinct numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracing(res, new ArrayList<Integer>(), nums);
        return res;
    }

    public static void backtracing(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length)
            res.add(new ArrayList<>(list));
        else for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtracing(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
